package org.d3if3044.wanderlist.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3044.wanderlist.database.NotesDao
import org.d3if3044.wanderlist.model.Notes

class DetailViewModel(private val dao: NotesDao) : ViewModel() {
    fun insert(tujuan: String, kendaraan: String, catatan: String) {
        val notes = Notes(
            tujuan = tujuan,
            kendaraan = kendaraan,
            catatan = catatan
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(notes)
        }
    }

    suspend fun getNotes(id: Long): Notes? {
        return dao.getNotesById(id)
    }

    fun update(id: Long, tujuan: String, kendaraan: String, catatan: String) {
        val notes = Notes(
            id = id,
            tujuan = tujuan,
            kendaraan = kendaraan,
            catatan = catatan
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(notes)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}