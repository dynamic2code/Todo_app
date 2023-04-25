package com.example.todoapppractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapppractice.ui.theme.TodoApppracticeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApppracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ToDo()
                }
            }
        }
    }
}

@Composable
fun ToDo(){
    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(10.dp)
            .requiredHeight(200.dp),
        backgroundColor = Color.Magenta
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                Row() {
                    Text(text = "Task name")
//            the todo button
                }
            }
            Column(
                modifier = Modifier.requiredHeight(100.dp)
            ) {
                Text(text = "Description of the task and any other explanation")
            }
            Column(
                verticalAlignment = Alignment.Bottom,
            ) {
                Row() {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Edit")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Delete")
                    }
                }

            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoApppracticeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ToDo()
        }
    }
}