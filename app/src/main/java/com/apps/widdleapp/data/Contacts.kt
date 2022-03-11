package com.apps.widdleapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contanct")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val mobile: String,
    val desc: String
)

