package com.google.cloud.solutions.notetaking.framework.di

import android.app.Application
import com.google.cloud.solutions.core.repository.NoteRepository
import com.google.cloud.solutions.notetaking.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}