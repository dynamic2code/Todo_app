package com.example.todoapppractice


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapppractice.ui.theme.TodoApppracticeTheme
//import com.example.textfield.ui.theme.TextfieldTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


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
                    ToDoAPP()
                }
            }
        }
    }
}

@Composable
fun ToDoAPP(){
    var available_todo by remember { mutableStateOf(false) }
    var showDetails by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {  showDetails = !showDetails }) {
                Icon(Icons.Filled.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.White, shape = CircleShape)
                        .border(BorderStroke(4.dp, Color.Black), shape = CircleShape))
            }
        }
    ) {innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Main content here
//            logic to get check i data in db

            Column() {
                ToDo()
            }
            Column() {
                if (showDetails) {
                    AddTodoWidget()
                }
            }
        }

    }
}

@Composable
fun ToDo(){
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .requiredHeight(200.dp),
//        backgroundColor = Color.Magenta,
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.weight(1.0f)
            ) {
                Text(
                    text = "Task name",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Description of the task and any other explanation Description of the task and any other explanation Description of the task and any other explanation",
                    fontSize = MaterialTheme.typography.h6.fontSize

                )
            }
//            Spacer(modifier = Modifier.height(45.dp))
            Row(
//                modifier = Modifier
//                    .weight(1f, ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Edit",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h6.fontSize
                    )
                }
                Button(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = { /*TODO*/ }
                )
                {
                    Text(
                        text = "Delete",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h6.fontSize
                    )
                }
            }
        }

    }
}

@Composable
fun AddTodoWidget() {
    Card(
        elevation = 20.dp,
        modifier = Modifier
//            .align(Alignment.Center)
            .padding(10.dp)
            .requiredHeight(250.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            var task_name by remember {
                mutableStateOf("")
            }
            TextField(
                value = task_name,
                onValueChange = { new_name ->
                    task_name = new_name
                },
                label = {
                    Text(text = "Task Name")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(3.dp))
            var task_description by remember {
                mutableStateOf("")
            }
            TextField(
                value = task_description,
                onValueChange = { new_name ->
                    task_description = new_name
                },
                label = {
                    Text(text = "Task Description")
                },
                maxLines = 3,
                modifier = Modifier.fillMaxWidth()
            )
            // Add a spacer to push the button to the bottom of the card
            Spacer(modifier = Modifier.weight(1f))
            Box(
//                Modifier.align(Alignment.BottomEnd)
            ) {
                Button(
                    shape = RoundedCornerShape(100),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Add",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h6.fontSize
                    )
                }
            }
        }
    }
}
@Composable
fun Default_view(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "There are no tasks yet \n Add with the plus button",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }

}
@Preview(showBackground = true)
@Composable
fun AddPreview() {
    TodoApppracticeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ToDoAPP()
            Default_view()
        }
    }
}
