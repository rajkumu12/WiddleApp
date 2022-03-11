package com.apps.widdleapp.Reposity

import androidx.lifecycle.LiveData
import com.apps.widdleapp.data.ContactDao
import com.apps.widdleapp.data.Contacts


class ContactRepository(private val contactDao: ContactDao) {

    fun getContacts(): LiveData<List<Contacts>> {
        return contactDao.getContancts()
    }

    suspend fun insertContacts(contacts: Contacts){
        contactDao.insertContact(contacts)
    }
}