package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                // 显示图书卡片页面
                BookCard(
                    title = "Atomic Habits",
                    author = "James Clear",
                    progress = 65
                )
            }
        }
    }
}

@Composable
fun BookCard(title: String, author: String, progress: Int) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleLarge)
            Text(text = "By $author", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(progress / 100f, modifier = Modifier.fillMaxWidth())
            Text(text = "$progress% completed", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    MyApplicationTheme {
        BookCard(
            title = "Atomic Habits",
            author = "James Clear",
            progress = 65
        )
    }
}

@Composable
fun BookListScreen() {
    val books = listOf(
        Book("Atomic Habits", "James Clear", 65),
        Book("Deep Work", "Cal Newport", 30),
        Book("Clean Code", "Robert C. Martin", 90)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(books) { book ->
            BookCard(
                title = book.title,
                author = book.author,
                progress = book.progress
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

data class Book(val title: String, val author: String, val progress: Int)

