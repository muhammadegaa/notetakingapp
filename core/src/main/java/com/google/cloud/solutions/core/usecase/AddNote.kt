package com.google.cloud.solutions.core.usecase

import com.google.cloud.solutions.core.data.Note
import com.google.cloud.solutions.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)


}