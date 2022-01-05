package com.mintcode.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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


class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //compose는 여기 안에서 시작해야 됨
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //List 만드는법 1: Column 이용
                    //한번에 만들어놓은 느낌, 데이터 많은 경우 문제 발생
                    /*Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Blue)
                            .padding(16.dp)
                            .verticalScroll(scrollState),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        for(i in 1..30){
                            Text("구구단 2단: ${2*i}")
                        }
                    }*/
                    //for문 사용 불가
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Blue),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        contentPadding = PaddingValues(20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        item {
                            Text("구구단 시작")
                        }
                        items(77) { index ->
                            Text("구구단 2단: ${2 * index}")
                        }
                        item {
                            Text("구구단 끝")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DisplayPreviewList() {
    MyApplicationTheme {
        //안에 있는 자식들이 다 겹침(framelayout과 비슷)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (i in 1..9) {
                Text("구구단 2단: ${2 * i}")
            }
        }
    }
}