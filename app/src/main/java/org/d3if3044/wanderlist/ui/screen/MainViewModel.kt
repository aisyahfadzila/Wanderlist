package org.d3if3044.wanderlist.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3044.wanderlist.database.NotesDao
import org.d3if3044.wanderlist.model.Notes

class MainViewModel(dao: NotesDao): ViewModel() {
    val data: StateFlow<List<Notes>> = dao.getNotes().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}