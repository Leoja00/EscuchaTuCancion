package com.example.escuchatucancion;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        ImageView albumCover = findViewById(R.id.albumCover);
        ListView trackListView = findViewById(R.id.trackListView);
        Button backToDiscographyButton = findViewById(R.id.backToDiscographyButton);

        String album = getIntent().getStringExtra("album");
        String[] tracks = getTracksByAlbum(album);

        // Cargar la imagen de la carátula (esto es solo un ejemplo)
        albumCover.setImageResource(R.drawable.ic_album_placeholder);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tracks);
        trackListView.setAdapter(adapter);

        trackListView.setOnItemClickListener((parent, view, position, id) -> {
            playTrack(tracks[position]);
        });

        backToDiscographyButton.setOnClickListener(v -> {
            finish();
        });
    }

    private String[] getTracksByAlbum(String album) {
        return new String[]{"Tema 1 " + album, "Tema 2 " + album, "Tema 3 " + album, "Tema 4 " + album};
    }

    private void playTrack(String track) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        // Asocia cada track con un recurso de audio (esto es solo un ejemplo)
        int resId = getResources().getIdentifier(track.toLowerCase().replace(" ", "_"), "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, resId);

        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> mediaPlayer.release());
        } else {
            Toast.makeText(this, "No se puede reproducir el tema", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}
