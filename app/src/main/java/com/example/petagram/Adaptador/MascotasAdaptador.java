package com.example.petagram.Adaptador;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.BaseDatos.ConstructorMascotas;
import com.example.petagram.Mascota;
import com.example.petagram.R;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    int contadorinicial = 0;
    int contadorT  = 0;
    int contadorL  = 0;
    int contadorTo = 0;
    int contadorP  = 0;
    int contadorM  = 0;


    public MascotasAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cvmascotas,parent,false);

        return new MascotasViewHolder(v);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull final MascotasViewHolder mascotasViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);

        mascotasViewHolder.Foto.setImageResource(mascota.getFoto());
        mascotasViewHolder.Nombre.setText(mascota.getNombre());
       // mascotasViewHolder.Cantidad.setText(String.valueOf(contadorinicial));
        mascotasViewHolder.Cantidad.setText(String.valueOf(mascota.getLikes()));

        mascotasViewHolder.Like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, "Like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.insertarLikesMascota(mascota);
                mascotasViewHolder.Cantidad.setText(constructorMascotas.obtenerLikesMascotaa(mascota));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView   Foto;
        private ImageButton Like;
        private TextView    Nombre;
        private TextView    Cantidad;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            Foto     = itemView.findViewById(R.id.Foto);
            Like     = itemView.findViewById(R.id.Like);
            Nombre   = itemView.findViewById(R.id.Nombre);
            Cantidad = itemView.findViewById(R.id.Cantidad);
        }
    }
}

