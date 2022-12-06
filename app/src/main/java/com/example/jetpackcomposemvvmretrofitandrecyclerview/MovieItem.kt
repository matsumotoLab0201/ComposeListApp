package com.example.jetpackcomposemvvmretrofitandrecyclerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation

@Composable
fun MovieItem(movie: Movie, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {

    val backgroundColor =
        if (index == selectedIndex) MaterialTheme.colors.primary else MaterialTheme.colors.background
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .clickable { onClick(index) }
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface(color = backgroundColor) {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                //写真
                Image(
                    painter = rememberImagePainter(
                        data = movie.imageUrl,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.placeholder)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                        .clickable {
                            //TODO: 温泉サイトへのdeeplinkの設定
                        }
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    //温泉名
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    //時間
                    var walk = movie.walk
                    var time = movie.time
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(
                            text = movie.station,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "徒歩${walk}分",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "家から${time}分",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    //料金
                    var cost1 = movie.cost1
                    var cost2 = movie.cost2

                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "平日：${cost1}円",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "土日祝：${cost2}円",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )


                    }

                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MovieItem() {
    val movie = Movie(
        id = 1,
        imageUrl = "https://www.sakura-2005.com/wp-content/uploads/2017/11/facilities_ct05_004.jpg",
        name = "東京染井温泉",
        station = "巣鴨駅",
        walk = 4,
        time = 41,
        cost1 = 1705,
        cost2 = 1925
    )

    MovieItem(movie = movie, 0, 0) { i ->

    }
}