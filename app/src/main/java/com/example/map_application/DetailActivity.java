package com.example.map_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailDescription;
    private Button buttonAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailImage);
        detailDescription = findViewById(R.id.detailDescription);
        buttonAction = findViewById(R.id.buttonAction);

        // Récupération des Intent extras
        String nom = getIntent().getStringExtra("nom");
        int imageResId = getIntent().getIntExtra("imageResId", -1);
        String description = getIntent().getStringExtra("description");

        // Mise à jour de l'UI
        setTitle(nom);

        if (imageResId != -1) {
            detailImage.setImageResource(imageResId);
        }

        detailDescription.setText(description);

        buttonAction.setOnClickListener(v -> finish());
    }
}
