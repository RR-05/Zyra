package com.example.zyra.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.zyra.ui.theme.PlayerScreen
import com.example.zyra.data.Song


class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mySongList = intent.getSerializableExtra("songList") as? ArrayList<Song> ?: arrayListOf()
        val initialIndex=intent.getIntExtra("position",0)

        setContent {
            PlayerScreen(
                songList =mySongList,
                initialIndex=initialIndex,
                onBack={ finish() }
            )

        }
    }
}