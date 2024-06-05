package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DiscographyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discography);

        ListView discographyListView = findViewById(R.id.discographyListView);
        Button backToArtistsButton = findViewById(R.id.backToArtistsButton);

        String artist = getIntent().getStringExtra("artist");
        String[] albums = getAlbumsByArtist(artist);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albums);
        discographyListView.setAdapter(adapter);

        discographyListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(DiscographyActivity.this, AlbumActivity.class);
            intent.putExtra("album", albums[position]);
            startActivity(intent);
        });

        backToArtistsButton.setOnClickListener(v -> {
            finish();
        });
    }

    private String[] getAlbumsByArtist(String artist) {
        return new String[]{"Disco 1 " + artist, "Disco 2 " + artist, "Disco 3 " + artist, "Disco 4 " + artist};
    }
}
