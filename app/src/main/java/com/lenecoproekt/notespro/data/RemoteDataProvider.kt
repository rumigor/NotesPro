package com.lenecoproekt.notespro.data

import androidx.lifecycle.LiveData
import com.lenecoproekt.notespro.model.Note
import com.lenecoproekt.notespro.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>

}