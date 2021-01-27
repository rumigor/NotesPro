package com.lenecoproekt.notespro.model

import com.lenecoproekt.notespro.data.FireStoreProvider
import com.lenecoproekt.notespro.data.RemoteDataProvider

object Repository {
    private val remoteProvider: RemoteDataProvider = FireStoreProvider()

    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
}