package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        ListView artistListView = findViewById(R.id.artistListView);
        Button backToGenresButton = findViewById(R.id.backToGenresButton);

        String genre = getIntent().getStringExtra("genre");
        String[] artists = getArtistsByGenre(genre);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, artists);
        artistListView.setAdapter(adapter);

        artistListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ArtistActivity.this, DiscographyActivity.class);
            intent.putExtra("artist", artists[position]);
            startActivity(intent);
        });

        backToGenresButton.setOnClickListener(v -> {
            finish();
        });
    }

    private String[] getArtistsByGenre(String genre) {
        switch (genre) {
            case "Rock":
                return new String[]{"Musico1 Rock", "Musico2 Rock", "Musico3 Rock", "Musico4 Rock"};
            case "Cumbia":
                return new String[]{"Musico1 Cumbia", "Musico2 Cumbia", "Musico3 Cumbia", "Musico4 Cumbia"};
            case "Reguetón":
                return new String[]{"Musico1 Reguetón", "Musico2 Reguetón", "Musico3 Reguetón", "Musico4 Reguetón"};
            case "Pop":
                return new String[]{"Musico1 Pop", "Musico2 Pop", "Musico3 Pop", "Musico4 Pop"};
            default:
                return new String[]{};
        }
    }
}
