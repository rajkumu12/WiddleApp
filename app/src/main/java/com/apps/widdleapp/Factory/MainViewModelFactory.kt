package com.apps.widdleapp.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.widdleapp.Reposity.ContactRepository
import com.apps.widdleapp.ViewModel.MainViewModel


class MainViewModelFactory(private val contactRepository: ContactRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(contactRepository) as T
    }
}