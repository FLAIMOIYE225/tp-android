package com.example.map_application.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.map_application.DetailActivity;
import com.example.map_application.R;
import com.example.map_application.model.Ville;

import java.util.List;

public class VilleAdapter extends RecyclerView.Adapter<VilleAdapter.VilleViewHolder> {

    private Context context;
    private List<Ville> villes;

    public VilleAdapter(Context context, List<Ville> villes) {
        this.context = context;
        this.villes = villes;
    }

    @NonNull
    @Override
    public VilleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_ville, parent, false);
        return new VilleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VilleViewHolder holder, int position) {
        Ville ville = villes.get(position);

        holder.nomVille.setText(ville.getNom());
        holder.imageVille.setImageResource(ville.getImageResId());

        //holder.nomVille.setText("Test " + position);
        //holder.imageVille.setImageResource(R.drawable.ic_launcher_foreground);

        // Clic sur un item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nom", ville.getNom());
            intent.putExtra("imageResId", ville.getImageResId());
            intent.putExtra("description", ville.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return villes.size();
    }

    static class VilleViewHolder extends RecyclerView.ViewHolder {

        ImageView imageVille;
        TextView nomVille;

        public VilleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVille = itemView.findViewById(R.id.imageVille);
            nomVille = itemView.findViewById(R.id.nomVille);
        }
    }
}
