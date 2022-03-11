package com.apps.widdleapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.widdleapp.Reposity.ContactRepository
import com.apps.widdleapp.data.Contacts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val contactRepository: ContactRepository) : ViewModel() {

    fun getContact() : LiveData<List<Contacts>> {
        return contactRepository.getContacts()
    }

    fun insertContact(contacts: Contacts){
        viewModelScope.launch(Dispatchers.IO){
            contactRepository.insertContacts(contacts)
        }

    }
}