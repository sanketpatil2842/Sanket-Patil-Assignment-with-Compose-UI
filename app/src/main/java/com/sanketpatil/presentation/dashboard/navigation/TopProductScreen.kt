package com.sanketpatil.presentation.dashboard.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.sanketpatil.presentation.dashboard.viewmodel.ProductViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardProductScreen(
    viewModel: ProductViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value.data

    Column(modifier = Modifier.background(Color(0xFFF5F5F5))) {
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            state?.let {
                items(it) { items ->
                    Card(elevation = 3.dp, modifier = Modifier.padding(5.dp)) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Icon(
                                imageVector = Icons.Rounded.Favorite,
                                contentDescription = "Icon",
                                tint = Color.LightGray, modifier = Modifier
                                    .align(
                                        Alignment.End
                                    )
                                    .padding(2.dp)
                                    .clickable {

                                    }
                            )
                            Image(
                                painter = rememberAsyncImagePainter(items.image ?: ""),
                                contentDescription = null,
                                modifier = Modifier.size(
                                    width = 400.dp, height = 150.dp
                                )
                            )
                            Text(
                                text = items.title ?: "",
                                modifier = Modifier
                                    .padding(2.dp)
                                    .height(50.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )

                            Box(modifier = Modifier.fillMaxSize()) {
                                Text(
                                    text = "$" + items.price ?: "",
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .align(
                                            Alignment.BottomStart
                                        ),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )

                                Icon(
                                    imageVector = Icons.Rounded.Add,
                                    contentDescription = "Icon",
                                    tint = Color.DarkGray, modifier = Modifier
                                        .align(
                                            Alignment.BottomEnd
                                        )
                                        .clickable {

                                        }
                                )
                            }
                        }
                    }
                }
            }
        })
    }
}