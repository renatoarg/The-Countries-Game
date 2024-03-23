package com.renatoarg.composelist.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renatoarg.composelist.model.Person
import com.renatoarg.composelist.model.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(
    private val personRepo: PersonRepository
) : ViewModel() {

    var personUiState by mutableStateOf(PersonUiState())

    private var fetchJob: Job? = null

    fun getPersonList() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val updatedPersonList = personRepo.getPersonList
                personUiState = personUiState.copy(
                    isLoading = true
                )
                personUiState = personUiState.copy(
                    persons = updatedPersonList,
                    isLoading = false
                )
            } catch (ioe: IOException) {
                Log.e("appLogger", "getPersonList: IOException ${ioe.stackTrace}")
            } catch (e: Exception) {
                Log.e("appLogger", "getPersonList: Exception ${e.stackTrace}")
            }
        }
    }

    fun addPerson(person: Person) {
        personRepo.addPerson(person)
    }


}