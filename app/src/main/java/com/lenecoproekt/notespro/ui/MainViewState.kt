package com.lenecoproekt.notespro.ui

import com.lenecoproekt.notespro.model.Note
import com.lenecoproekt.notespro.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) :
    BaseViewState<List<Note>?>(notes, error)