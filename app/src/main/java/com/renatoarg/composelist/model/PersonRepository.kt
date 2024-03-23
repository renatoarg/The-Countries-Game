package com.renatoarg.composelist.model

class PersonRepository {

    private val personList = mutableListOf<Person>()

    init {
        val person1 = Person(name = "Bill Gates", age = 67, imageUrl = "")
        val person2 = Person(name = "Steve Jobs", age = 53, imageUrl = "")
        val person3 = Person(name = "Elon Must", age = 47, imageUrl = "")

        personList.add(person1)
        personList.add(person2)
        personList.add(person3)
    }

    val getPersonList = personList

    fun addPerson(person: Person) {
       personList.add(person)
    }

    fun removePerson(person: Person) {
        personList.remove(person)
    }
}