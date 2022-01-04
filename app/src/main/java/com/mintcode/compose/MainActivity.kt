package com.mintcode.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mintcode.compose.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //내부의 text가 한개씩 들어감(linearlayout과 비슷)
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Blue)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Hello")
                        Spacer(Modifier.width(16.dp))
                        Text("World")
                    }

                    //안에 있는 자식들이 다 겹침(framelayout과 비슷)
                    Box(
                        modifier = Modifier.background(color = Color.Green)
                    ) {
                        Text("Hi Mint")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DisplayPreview() {
    MyApplicationTheme {
        //안에 있는 자식들이 다 겹침(framelayout과 비슷)
        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Text("Hi Mint")
        }
    }
}