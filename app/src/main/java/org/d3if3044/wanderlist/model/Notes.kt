package org.d3if3044.wanderlist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "notes")
data class Notes (
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0L,
        val tujuan: String,
        val kendaraan: String,
        val catatan: String
)