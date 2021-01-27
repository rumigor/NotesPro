package com.lenecoproekt.notespro.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import com.lenecoproekt.notespro.model.Color
import com.lenecoproekt.notespro.model.Note
import com.lenecoproekt.notespro.model.NoteResult
import com.lenecoproekt.notespro.model.Repository
import com.lenecoproekt.notespro.ui.NoteViewState
import com.lenecoproekt.notespro.ui.base.BaseViewModel
import java.util.*

class NoteViewModel(val repository: Repository = Repository) :
    BaseViewModel<Note?, NoteViewState>() {

    private var pendingNote: Note? = null

    fun saveChanges(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        if (pendingNote != null) {
            repository.saveNote(pendingNote!!)
        }
    }
    fun loadNote(noteId: String) {
        repository.getNoteById(noteId).observeForever(object : Observer<NoteResult> {
            override fun onChanged(t: NoteResult?) {
                if (t == null) return

                when (t) {
                    is NoteResult.Success<*> ->
                        viewStateLiveData.value = NoteViewState(note = t.data as? Note)
                    is NoteResult.Error ->
                        viewStateLiveData.value = NoteViewState(error = t.error)
                }
            }
        })
    }

    fun createNewNote(title: String, body: String, color: Color): Note {
        val note = Note(UUID.randomUUID().toString(), title, body)
        note.color = color
        Log.d("NEW_NOTE", "Note created")
        return note
    }
}