package com.example.zyra.presentation

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.zyra.ui.theme.SongListScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.zyra.ui.theme.ZyraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SongListScreen{songs,position ->
                val intent=Intent(this,PlayerActivity::class.java)
                intent.putParcelableArrayListExtra("songList",ArrayList(songs))
                intent.putExtra("position",position)
                startActivity(intent)
            }
        }
    }
}