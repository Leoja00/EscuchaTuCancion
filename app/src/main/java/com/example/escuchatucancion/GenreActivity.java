package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class GenreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        ListView genreListView = findViewById(R.id.genreListView);
        Button backToMainButton = findViewById(R.id.backToMainButton);

        String[] genres = {"Rock", "Cumbia", "Reguetón", "Pop"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genres);
        genreListView.setAdapter(adapter);

        genreListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(GenreActivity.this, ArtistActivity.class);
            intent.putExtra("genre", genres[position]);
            startActivity(intent);
        });

        backToMainButton.setOnClickListener(v -> {
            finish();
        });
    }
}

