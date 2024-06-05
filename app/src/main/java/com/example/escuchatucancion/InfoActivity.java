package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Button backToMainButton = findViewById(R.id.backToMainButton);
        Button goToGenresButton = findViewById(R.id.goToGenresButton);

        backToMainButton.setOnClickListener(v -> {
            finish();
        });

        goToGenresButton.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, GenreActivity.class);
            startActivity(intent);
        });
    }
}
