package com.renatoarg.composelist.model

class PersonRepository {

    private val personList = mutableListOf<Person>()

    init {
        val list = listOf<Person>(
            Person(name = "Bill Gates", age = 67, imageUrl = "https://www.gettyimages.com.br/detail/foto/pixel-people-portrait-series-imagem-royalty-free/1181063344"),
            Person(name = "Oprah Winfrey", age = 69, imageUrl = "https://picsum.photos/id/186/200/300"),
            Person(name = "Stephen Hawking", age = 76, imageUrl = "https://picsum.photos/id/238/200/300"),
            Person(name = "Malala Yousafzai", age = 26, imageUrl = "https://picsum.photos/id/239/200/300"),
            Person(name = "Elon Musk", age = 51, imageUrl = "https://picsum.photos/id/240/200/300"),
            Person(name = "Marie Curie", age = 66, imageUrl = "https://ichef.bbci.co.uk/news/976/cpsprodb/F5E2/10485/marie_curie.jpg"),
            Person(name = "Leonardo da Vinci", age = 67, imageUrl = "https://www.biography.com/.image/ar_1:1,c_fill,cs_srgb,g_autoFocusX64,h_400,w_400/MTIwNjA5MzM0MjM3/leonardo-da-vinci-biography-image.jpg"),
            Person(name = "Nelson Mandela", age = 95, imageUrl = "https://cdn.britannica.com/sbb/media/1/1232/1232835-004-A4D2C31E.jpg"),
            Person(name = "Bill Gates", age = 67, imageUrl = "https://www.gettyimages.com.br/detail/foto/pixel-people-portrait-series-imagem-royalty-free/1181063344"),
            Person(name = "Oprah Winfrey", age = 69, imageUrl = "https://picsum.photos/id/186/200/300"),
            Person(name = "Stephen Hawking", age = 76, imageUrl = "https://picsum.photos/id/238/200/300"),
            Person(name = "Malala Yousafzai", age = 26, imageUrl = "https://picsum.photos/id/239/200/300"),
            Person(name = "Elon Musk", age = 51, imageUrl = "https://picsum.photos/id/240/200/300"),
            Person(name = "Marie Curie", age = 66, imageUrl = "https://ichef.bbci.co.uk/news/976/cpsprodb/F5E2/10485/marie_curie.jpg"),
            Person(name = "Leonardo da Vinci", age = 67, imageUrl = "https://www.biography.com/.image/ar_1:1,c_fill,cs_srgb,g_autoFocusX64,h_400,w_400/MTIwNjA5MzM0MjM3/leonardo-da-vinci-biography-image.jpg"),
            Person(name = "Nelson Mandela", age = 95, imageUrl = "https://cdn.britannica.com/sbb/media/1/1232/1232835-004-A4D2C31E.jpg"),
            Person(name = "Bill Gates", age = 67, imageUrl = "https://www.gettyimages.com.br/detail/foto/pixel-people-portrait-series-imagem-royalty-free/1181063344"),
            Person(name = "Oprah Winfrey", age = 69, imageUrl = "https://picsum.photos/id/186/200/300"),
            Person(name = "Stephen Hawking", age = 76, imageUrl = "https://picsum.photos/id/238/200/300"),
            Person(name = "Malala Yousafzai", age = 26, imageUrl = "https://picsum.photos/id/239/200/300"),
            Person(name = "Elon Musk", age = 51, imageUrl = "https://picsum.photos/id/240/200/300"),
            Person(name = "Marie Curie", age = 66, imageUrl = "https://ichef.bbci.co.uk/news/976/cpsprodb/F5E2/10485/marie_curie.jpg"),
            Person(name = "Leonardo da Vinci", age = 67, imageUrl = "https://www.biography.com/.image/ar_1:1,c_fill,cs_srgb,g_autoFocusX64,h_400,w_400/MTIwNjA5MzM0MjM3/leonardo-da-vinci-biography-image.jpg"),
            Person(name = "Nelson Mandela", age = 95, imageUrl = "https://cdn.britannica.com/sbb/media/1/1232/1232835-004-A4D2C31E.jpg"),
            Person(name = "Bill Gates", age = 67, imageUrl = "https://www.gettyimages.com.br/detail/foto/pixel-people-portrait-series-imagem-royalty-free/1181063344"),
            Person(name = "Oprah Winfrey", age = 69, imageUrl = "https://picsum.photos/id/186/200/300"),
            Person(name = "Stephen Hawking", age = 76, imageUrl = "https://picsum.photos/id/238/200/300"),
            Person(name = "Malala Yousafzai", age = 26, imageUrl = "https://picsum.photos/id/239/200/300"),
            Person(name = "Elon Musk", age = 51, imageUrl = "https://picsum.photos/id/240/200/300"),
            Person(name = "Marie Curie", age = 66, imageUrl = "https://ichef.bbci.co.uk/news/976/cpsprodb/F5E2/10485/marie_curie.jpg"),
            Person(name = "Leonardo da Vinci", age = 67, imageUrl = "https://www.biography.com/.image/ar_1:1,c_fill,cs_srgb,g_autoFocusX64,h_400,w_400/MTIwNjA5MzM0MjM3/leonardo-da-vinci-biography-image.jpg"),
            Person(name = "Nelson andela", age = 95, imageUrl = "https://cdn.britannica.com/sbb/media/1/1232/1232835-004-A4D2C31E.jpg"),
        )
        list.forEach {
            personList.add(it)
        }
    }

    val getPersonList = personList.asReversed()

    fun addPerson(person: Person) {
       personList.add(person)
    }

    fun removePerson(person: Person) {
        personList.remove(person)
    }
}