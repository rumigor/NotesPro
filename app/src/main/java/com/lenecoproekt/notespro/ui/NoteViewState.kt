package com.lenecoproekt.notespro.ui

import com.lenecoproekt.notespro.model.Note
import com.lenecoproekt.notespro.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)