package com.google.cloud.solutions.notetaking.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.cloud.solutions.core.data.Note
import com.google.cloud.solutions.core.repository.NoteRepository
import com.google.cloud.solutions.core.usecase.AddNote
import com.google.cloud.solutions.core.usecase.GetAllNotes
import com.google.cloud.solutions.core.usecase.GetNote
import com.google.cloud.solutions.core.usecase.RemoveNote
import com.google.cloud.solutions.notetaking.framework.di.ApplicationModule
import com.google.cloud.solutions.notetaking.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
                .applicationModule(ApplicationModule((getApplication())))
                .build()
                .inject(this)
    }

    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun saveNote(note: Note){
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id: Long){
        coroutineScope.launch {
            val note = useCases.getNote(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note){
        coroutineScope.launch {
            useCases.removeNote(note)
            saved.postValue(true)
        }
    }
}