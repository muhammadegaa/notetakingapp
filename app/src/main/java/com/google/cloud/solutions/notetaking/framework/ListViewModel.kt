package com.google.cloud.solutions.notetaking.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

class ListViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases:  UseCases

    init {
        DaggerViewModelComponent.builder()
                .applicationModule(ApplicationModule((getApplication())))
                .build()
                .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach{
                it.wordCount = useCases.getWordCount.invoke(it)
            }
            notes.postValue(noteList)
        }
    }
}