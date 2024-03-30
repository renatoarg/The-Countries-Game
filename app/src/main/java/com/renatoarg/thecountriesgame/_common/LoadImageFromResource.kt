package com.renatoarg.thecountriesgame._common

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.renatoarg.thecontriesgame.R

@Composable
fun LoadImageFromResource(
    imageUrl: Drawable,
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
        modifier = Modifier.fillMaxWidth()
    )
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewLoadSvgResource() {
    LocalContext.current.getDrawable(R.drawable.img_empty_list)?.let {
        LoadImageFromResource(imageUrl = it, contentDescription = "null")
    }
}