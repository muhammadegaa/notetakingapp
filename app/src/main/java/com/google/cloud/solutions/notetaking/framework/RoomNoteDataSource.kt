package com.google.cloud.solutions.notetaking.framework

import android.content.Context
import com.google.cloud.solutions.core.data.Note
import com.google.cloud.solutions.core.repository.NoteDataSource
import com.google.cloud.solutions.notetaking.framework.db.DatabaseService
import com.google.cloud.solutions.notetaking.framework.db.NoteDao
import com.google.cloud.solutions.notetaking.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}