package com.renatoarg.composelist.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.renatoarg.composelist.R
import com.renatoarg.composelist.model.ApiResult
import com.renatoarg.composelist.model.CountryItem
import com.renatoarg.composelist.viewmodel.CountriesViewModel

@Composable
fun CountriesList(
    viewModel: CountriesViewModel,
    modifier: Modifier
) {
    val apiResult by viewModel.countries.collectAsState()

    Box(
        modifier = modifier
            .background(Color.Black.copy(.1f))
    ) {

        when(apiResult) {
            is ApiResult.Loading -> {
                LoadingCircle(true)
            }
            is ApiResult.Success -> {
                LazyColumn(
                    modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                ) {
                    items(apiResult.data as List<CountryItem>) { country ->
                        PersonListItem(
                            country = country,
                            modifier = modifier
                        )
                    }
                }
            }
            is ApiResult.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = apiResult.error.orEmpty())
                }
            }
        }
    }
}

@Composable
private fun LoadingCircle(
    isLoading: Boolean = false
) {
    if (isLoading.not()) return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
        )
        Text(text = stringResource(id = R.string.loading))
    }
}

@Composable
private fun PersonListItem(
    country: CountryItem,
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
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
                    .width(100.dp)
                    .padding(8.dp),
            ) {
                ImageFromURL(
                    imageUrl = country.flags.png,
                    contentDescription = stringResource(id = R.string.cont_desc_country_flag)
                )
            }
            Text(
                    text = country.name.official,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
            )
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
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
}