package com.mintcode.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class NavigationOnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "first"
            ) {
                composable("first") {
                    FirstScreen(navController)
                }
                composable("second") {
                    SecondScreen(navController)
                }
                composable("third/{value}") { backStackEntry ->
                    ThirdScreen(
                        navController = navController,
                        value = backStackEntry.arguments?.getString("value") ?: ""
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    val (value, setValue) = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "첫 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second")
        }) {
            Text("두 번째!")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = value, onValueChange = setValue)
        Button(onClick = {
            if (value.isNotEmpty()) {
                navController.navigate("third/$value")
            }

        }) {
            Text("세 번째")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "두 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigateUp()
            //이걸 써도 된다.
            //navController.popBackStack()
        }) {
            Text("뒤로 가기")
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController, value: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "세 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Text(value)
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("뒤로 가기")
        }
    }
}