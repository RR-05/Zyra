package com.example.zyra.ui.theme


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import com.example.zyra.data.Song
import android.content.ContentUris
import androidx.core.net.toUri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.zyra.R

@Composable
fun SongList(
    songs:List<Song>,
    onSongClick:(Int)->Unit,
    modifier:Modifier=Modifier
){
    LazyColumn(
        modifier=Modifier.fillMaxWidth()
    ){
       itemsIndexed(songs){
           index,song ->
           SongListItem(
               song=song,
               onClick={onSongClick(index)}
           )
       }

    }
}
@Composable
fun SongListItem(song:Song,onClick:()->Unit){
    val albumArtUri=ContentUris.withAppendedId(
        "content://media/external/audio/albumart".toUri(),
        song.albumId
    )
    Row(modifier= Modifier
        .fillMaxWidth()
        .clickable{onClick()}
        .padding(8.dp)
        .height(72.dp),
    verticalAlignment=Alignment.CenterVertically
    ){
        AsyncImage(
            model=albumArtUri,
            contentDescription=null,
            modifier=Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0x33000000)),
            contentScale=ContentScale.Crop,
            error=painterResource(R.drawable.baseline_music_note_24),
            placeholder=painterResource(R.drawable.baseline_music_note_24)
        )
        Column (modifier=Modifier.padding(start=12.dp)){
            Text(song.title.orEmpty(),
                color=Color.White,
                fontWeight=FontWeight.Bold,
                fontSize=16.sp,
                maxLines=1,
                overflow=TextOverflow.Ellipsis
            )
            Text(
                song.artist.orEmpty(),
                color=Color(0xffbbbbbb),
                fontSize=14.sp,
                maxLines=1,
                overflow=TextOverflow.Ellipsis
            )

        }
    }
}