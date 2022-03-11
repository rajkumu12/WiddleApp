package com.apps.widdleapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * from contanct")
    fun getContancts() : LiveData<List<Contacts>>

    @Insert
    suspend fun insertContact(contacts: Contacts)
}