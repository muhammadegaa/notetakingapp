package com.google.cloud.solutions.core.usecase

import com.google.cloud.solutions.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {
    suspend operator fun invoke() = noteRepository.getAllNotes()
}