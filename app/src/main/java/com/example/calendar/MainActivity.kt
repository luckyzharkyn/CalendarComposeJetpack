package com.example.calendar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calendar.ui.theme.CalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ListItem(name: String, prof: String) {
    var counter = remember {
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                counter.value++
                Log.d("MyLog", "state: $counter")
            },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Box(

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = counter.value.toString())
                    Text(text = prof)
                }
            }
        }
    }
}

@Composable
fun CircleItem() {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.Blue)
    }
    val textColor = remember {
        mutableStateOf(Color.White)
    }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                counter.value++
                if (counter.value >= 10) {
                    color.value = Color.Red
                    textColor.value = Color.Black
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = counter.value.toString(), style = TextStyle(color = textColor.value,
        fontSize = 20.sp))
    }
}

@Composable
fun myColumn() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(listOf("item1", "item2", "item3"))
        { index, item ->
            Text(
                text = item,
                fontSize = 30.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }
}

@Composable
fun horizontalRow() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(
            listOf(
                ItemRowModel(R.drawable.image_1, "Zharkyn"),
                ItemRowModel(R.drawable.image_2, "Putin"),
                ItemRowModel(R.drawable.image_3, "Nazarbayev"),
                ItemRowModel(R.drawable.image_4, "Daulet"),
                ItemRowModel(R.drawable.image_5, "Asylbek"),
                ItemRowModel(R.drawable.image_6, "Ernazar")
            )
        ) { _, item ->
            ItemRow(item = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalendarTheme {
        Column {
            horizontalRow()
        }
    }
}