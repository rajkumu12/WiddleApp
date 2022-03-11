package com.apps.widdleapp.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ContactsDatabaseTest: TestCase() {

    private lateinit var contactDao: ContactDao
    private lateinit var db: ContactsDatabase

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ContactsDatabase::class.java
        ).build()
        contactDao = db.contactDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadSpend() = runBlocking {
        val contacts = Contacts(0, "Rajeev", "9781767938","rttttttttttttttttewr")
        contactDao.insertContact(contacts)
        val contactss = contactDao.getContancts()


        if (contactss.toString() !=""){
            val m=true
            assert(m, { true })
        }

    }
}