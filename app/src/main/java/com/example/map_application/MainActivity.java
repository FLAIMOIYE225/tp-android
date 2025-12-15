package com.example.map_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button navButton;
    Button cityListe;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.camera_icon) {
            // Action Google Maps
            startActivity(new Intent(this, MapsActivity.class));
            return true;
        }

        if (id == R.id.location_icon) {
            startActivity(new Intent(this, MapsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navButton = findViewById(R.id.navToMap);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actions to perform when the button is clicked
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                // Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                // You can add any other logic here, like starting a new activity,
                // updating UI elements, etc.
            }
        });

        cityListe = findViewById(R.id.navToCityList);
        cityListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityListActivity.class);
                startActivity(intent);
            }
        });
    }
}