package com.apps.widdleapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacts::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactsDatabase? = null
        fun getDatabase(context: Context): ContactsDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        ContactsDatabase::class.java,
                        "contact_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}