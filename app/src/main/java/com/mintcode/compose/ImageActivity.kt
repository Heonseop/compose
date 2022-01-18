package com.mintcode.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //compose는 여기 안에서 시작해야 됨
        setContent {
            //rememberSaveable: 보존이 필요한 경우
            var isFavorite by rememberSaveable {
                mutableStateOf(false)
            }
            ImageCard(
                Modifier
                    .fillMaxWidth(0.4f)
                    .padding(16.dp),
                isFavorite = isFavorite
            ) { favorite ->
                isFavorite = favorite
            }
        }
    }
}

@Composable
private fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit,
) {


    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp),
        ) {
            Image(
                painterResource(id = R.drawable.manhwakyung),
                contentDescription = "manhwakyung",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(onClick = {
                    onTabFavorite(!isFavorite)
                }) {
                    Icon(
                        imageVector =
                        if (isFavorite) {
                            Icons.Default.FavoriteBorder
                        } else {
                            Icons.Default.Favorite
                        }, contentDescription = "favorite", tint = Color.White
                    )

                }
            }


        }
    }
}