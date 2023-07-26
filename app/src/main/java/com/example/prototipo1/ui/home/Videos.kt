package com.example.prototipo1.ui.home
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.prototipo1.R


class Videos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        val listViewVideos: ListView = findViewById(R.id.listViewVideos)

        // Lista de títulos de videos (puedes reemplazar esto con tus datos)
        val videoTitles = listOf("Video 1", "Video 2", "Video 3", "Video 4", "Video 5","Video 6","Video 7")

        // Crear un ArrayAdapter para el ListView
        val adapter = ArrayAdapter(this, R.layout.list_item_video, R.id.textViewTitle, videoTitles)

        // Asignar el adapter al ListView
        listViewVideos.adapter = adapter

        // Agregar un OnItemClickListener al ListView
        listViewVideos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedVideo = videoTitles[position]

            // Verificar si el video seleccionado es "Video 1" y abrir el enlace de YouTube
            if (selectedVideo == "Video 1") {
                val youtubeLink = "https://youtu.be/DGjrTq7QiRc" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }else if(selectedVideo=="Video 2"){
                val youtubeLink = "https://youtu.be/Gbxcl5kUnYY" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }else if(selectedVideo=="Video 3"){
                val youtubeLink = "https://youtu.be/FXPOYkiIGzQ" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }else if(selectedVideo=="Video 4"){
                val youtubeLink = "https://youtu.be/N4kYkf7zP1M" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }else if(selectedVideo=="Video 5"){
                val youtubeLink = "https://youtu.be/04ONsQhHkEs" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }else if(selectedVideo=="Video 6"){
                val youtubeLink = "https://youtu.be/6DEXFgX2vqM" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }else if(selectedVideo=="Video 7"){
                val youtubeLink = "https://youtu.be/zNZL8IZ9BIM" // Reemplaza YOUR_VIDEO_ID_HERE con el ID real de tu video en YouTube
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
                startActivity(intent)
            }

        }

    }
}