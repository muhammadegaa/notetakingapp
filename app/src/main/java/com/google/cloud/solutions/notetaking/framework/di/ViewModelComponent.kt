package com.google.cloud.solutions.notetaking.framework.di

import com.google.cloud.solutions.notetaking.framework.ListViewModel
import com.google.cloud.solutions.notetaking.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}