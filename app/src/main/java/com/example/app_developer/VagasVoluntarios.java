package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VagasVoluntarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vagasvoluntarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewSeta = findViewById(R.id.imageView7);

        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(VagasVoluntarios.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewdescricao = findViewById(R.id.textView28);
        // Configurar o clique para VagasVoluntarios
        textViewdescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(VagasVoluntarios.this, atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewdescricao2 = findViewById(R.id.textView29);
        // Configurar o clique para VagasVoluntarios
        textViewdescricao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(VagasVoluntarios.this, atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewdescricao3 = findViewById(R.id.textView34);
        // Configurar o clique para VagasVoluntarios
        textViewdescricao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(VagasVoluntarios.this, atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });



    }
}