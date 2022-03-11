package com.apps.widdleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apps.widdleapp.Factory.MainViewModelFactory
import com.apps.widdleapp.Reposity.ContactRepository
import com.apps.widdleapp.ViewModel.MainViewModel
import com.apps.widdleapp.data.Contacts
import com.apps.widdleapp.data.ContactsDatabase
import com.apps.widdleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = ContactsDatabase.getDatabase(applicationContext).contactDao()
        val repository = ContactRepository(dao)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getContact().observe(this, Observer {
            binding.contacts = it.toString()
        })

        binding.tvbtn.setOnClickListener {

            if (Validator.Validateintputs(binding.etName.text.toString(),binding.etPhone.text.toString(),binding.etDesc.text.toString())){
                val contacts = Contacts(0,binding.etName.text.toString(),binding.etPhone.text.toString(), binding.etDesc.text.toString())
                mainViewModel.insertContact(contacts)
            }else{
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show()
            }

        }
    }
}