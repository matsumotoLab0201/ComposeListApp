package com.example.jetpackcomposemvvmretrofitandrecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.jetpackcomposemvvmretrofitandrecyclerview.ui.theme.JetpackComposeMVVMRetrofitAndRecyclerviewTheme

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVVMRetrofitAndRecyclerviewTheme {

                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "都心温泉一覧",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color(0xFF03DAC5),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        MovieList(movieList = mainViewModel.movieListResponse)
                    }
                    mainViewModel.getMovieList()
                }
            }
        }
    }
}