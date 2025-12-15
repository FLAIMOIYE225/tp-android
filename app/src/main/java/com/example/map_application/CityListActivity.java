package com.example.map_application;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.map_application.adapter.VilleAdapter;
import com.example.map_application.model.Ville;

import java.util.ArrayList;
import java.util.List;


public class CityListActivity extends AppCompatActivity {

    RecyclerView recyclerVilles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_city_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerVilles = findViewById(R.id.recyclerVilles);
        List<Ville> villes = new ArrayList<>();
        villes.add(new Ville("Rabat", R.drawable.rabat, "Rabat (en arabe : الرباط, ar-Ribāṭ ; en amazighe : ⵕⵕⴱⴰⵟ, Ṛṛbaṭ ; en arabe marocain : الرّباط, Rbaṭ) est la capitale du royaume du Maroc. La ville est située sur la côte l'Atlantique, au nord-ouest du Maroc, à 40 km au sud de Kénitra, à 240 km au sud-ouest de Tanger et du détroit de Gibraltar et à 87 km au nord-est de Casablanca. Elle est séparée de la ville de Salé par l'embouchure du Bouregreg, ce qui vaut aux deux villes le surnom de « villes jumelles »."));
        villes.add(new Ville("Casablanca", R.drawable.casa, "Casablanca (/ka.za.blɑ̃.ka/, en espagnol : /kasaˈβlaŋka/ ; en amazighe : ⵜⴰⴷⴷⴰⵔⵜ ⵜⵓⵎⵍⵉⵍⵜ (taddart tumlilt); en arabe : الدَّارُ ٱلْبَيْضَاء, ad-Dāru al-Bayḍā’, /adˈdaːru ɫbajdˤaːʔ/) est une ville située dans le Nord-Ouest du Maroc, sur la côte atlantique, à environ 80 km au sud de Rabat, la capitale administrative. Capitale économique du pays, siège de la région Casablanca-Settat, c'est la plus grande ville du Maghreb par sa population; lors du recensement de 2014, sa population était de 4 359 818 habitants, faisant d'elle la ville la plus peuplée du royaume, et celle de son agglomération s'élevait à 4 570 750 habitants."));
        villes.add(new Ville("Fès", R.drawable.fes, "Fès ou Fez (en arabe : فَاس, Fās; en amazighe standard marocain : ⴼⴰⵙ, Fas) est une ville du Maroc septentrional, située à 180 km à l'est de Rabat, entre le massif du Rif et le Moyen Atlas. Faisant partie des villes impériales du Maroc, elle a été à plusieurs époques la capitale du pays et est considérée de nos jours comme sa capitale spirituelle."));

        VilleAdapter adapter = new VilleAdapter( this, villes );

        recyclerVilles.setLayoutManager(new LinearLayoutManager(this));
        recyclerVilles.setAdapter(adapter);
    }
}