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

public class perfil_ong_atividadesrealizadas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_ong_atividadesrealizadas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Encontrar o ImageView para a Home (imageView5)
        ImageView imageViewHome = findViewById(R.id.imageView5);

        // Configurar o clique para a Home
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, Home.class);
                startActivity(intent);  // Inicia a Home
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewVagas = findViewById(R.id.imageView9);

        // Configurar o clique para VagasVoluntarios
        imageViewVagas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, activity_vagasong.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewEngrenagem = findViewById(R.id.imageView10);

        // Configurar o clique para VagasVoluntarios
        imageViewEngrenagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, Config.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewLupa = findViewById(R.id.imageView11);

        // Configurar o clique para VagasVoluntarios
        imageViewLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        TextView textViewAtividadesOng = findViewById(R.id.textView5);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, perfil_ong_atividadesrealizadas.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewSeta = findViewById(R.id.imageView7);

        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewPerfil = findViewById(R.id.imageView12);

        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, perfilOng.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });


        TextView textViewAtividadesOngDetalahemento1 = findViewById(R.id.textView11);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesOngDetalahemento1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, perfil_ong_atividadesrealizadasdetalhamento.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });


        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        TextView textViewAtividadesOngDetalahemento2 = findViewById(R.id.textView15);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesOngDetalahemento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfil_ong_atividadesrealizadas.this, perfil_ong_atividadesrealizadasdetalhamento.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

    }
}