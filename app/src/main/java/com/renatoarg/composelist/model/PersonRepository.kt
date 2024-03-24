package com.renatoarg.composelist.model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PersonRepository(
    private val httpClient: HttpClient
) {

    private val countryList = mutableListOf<CountryItem>()

    suspend fun getPersonList(): List<CountryItem> {
        val httpCall = httpClient.get("").call
        return httpCall.body()
    }

    fun addPerson(country: CountryItem) {
       countryList.add(country)
    }

    fun removePerson(country: CountryItem) {
        countryList.remove(country)
    }
}