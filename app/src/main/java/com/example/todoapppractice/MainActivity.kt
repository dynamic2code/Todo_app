package com.example.todoapppractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapppractice.ui.theme.TodoApppracticeTheme

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
                    AddToDo()
                }
            }
        }
    }
}

@Composable
fun AddToDo(){
    val something: String by remember {
        mutableStateOf("")
    }
    Column(

    ) {
        OutlinedTextField(
            value = something,
            onValueChange = "")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add Activity")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoApppracticeTheme {

    }
}