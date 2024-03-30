@file:OptIn(ExperimentalMaterial3Api::class)

package com.renatoarg.thecountriesgame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.renatoarg.domain.viewmodel.CountriesViewModel
import com.renatoarg.thecountriesgame._common.AppConstants.APP_TAG
import com.renatoarg.thecountriesgame._common.theme.ComposeListTheme
import com.renatoarg.thecountriesgame.view.AppBottomBar
import com.renatoarg.thecountriesgame.view.AppTopBar
import com.renatoarg.thecountriesgame.view.CountriesMainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CountriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            AppTopBar()
                        },
                        bottomBar = {
                            AppBottomBar()
                        },
                    ) { innerPadding ->
                        CountriesMainScreen(
                            modifier = Modifier.padding(innerPadding),
                            state =  viewModel.countries,
                            onClick = {
                                Log.d("MainActivity", "onCreate: click on $it")
                            }
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}