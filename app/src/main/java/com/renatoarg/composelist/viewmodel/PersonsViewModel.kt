package com.renatoarg.composelist.viewmodel

import androidx.lifecycle.ViewModel
import com.renatoarg.composelist.model.Person
import com.renatoarg.composelist.model.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(
    private val personRepo: PersonRepository
) : ViewModel() {


    val getPersonList = personRepo.getPersonList

    fun addPerson(person: Person) {
        personRepo.addPerson(person)
    }

}