package com.google.cloud.solutions.core.usecase

import com.google.cloud.solutions.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)
}