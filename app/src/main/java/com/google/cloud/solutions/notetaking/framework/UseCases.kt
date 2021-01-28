package com.google.cloud.solutions.notetaking.framework

import com.google.cloud.solutions.core.usecase.AddNote
import com.google.cloud.solutions.core.usecase.GetAllNotes
import com.google.cloud.solutions.core.usecase.GetNote
import com.google.cloud.solutions.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)