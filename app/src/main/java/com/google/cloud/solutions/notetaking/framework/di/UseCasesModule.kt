package com.google.cloud.solutions.notetaking.framework.di

import com.google.cloud.solutions.core.repository.NoteRepository
import com.google.cloud.solutions.core.usecase.*
import com.google.cloud.solutions.notetaking.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
            AddNote(repository),
            GetAllNotes(repository),
            GetNote(repository),
            RemoveNote(repository),
            GetWordCount()
    )
}