package com.renatoarg.composelist.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.renatoarg.composelist.R
import com.renatoarg.composelist.model.Person

@Composable
fun PersonsList(
    persons: List<Person>,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Black.copy(.1f))
    ) {
        LazyColumn(
            modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
        ) {
            items(persons) { person ->
                PersonListItem(
                    person = person,
                    modifier = modifier
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonsList() {
    PersonsList(persons = listOf(
        Person(name = "Name 1", age = 29, imageUrl = ""),
        Person(name = "Name 2", age = 31, imageUrl = ""),
        Person(name = "Name 3", age = 24, imageUrl = ""),
    ), modifier = Modifier)
}

@Composable
private fun PersonListItem(
    person: Person,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = modifier
                .height(IntrinsicSize.Min)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Log.d("RENATO", "url: ${person.imageUrl}")
            Box(
                modifier = modifier
                    .width(60.dp)
                    .padding(4.dp),
            ) {
                ImageFromURL(
                    imageUrl = person.imageUrl,
                    contentDescription = stringResource(id = R.string.cont_desc_celebrity_image)
                )
            }
            Box (
                modifier = modifier
                    .fillMaxSize()
                    .defaultMinSize(minHeight = 60.dp)
                    .padding(4.dp)
            ) {
                Column {
                    Text(
                        text = person.name,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(text = "${person.age} years old")
                }
            }
        }
    }
}

@Composable
fun ImageFromURL(
    imageUrl: String,
    contentDescription: String
){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.baseline_broken_image_24),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}