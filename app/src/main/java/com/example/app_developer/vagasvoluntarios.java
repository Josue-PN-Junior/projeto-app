package com.example.app_developer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class vagasvoluntarios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SegundaVagaAdpter segundaVagaAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagasvoluntarios);

        // Inicializando a RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Carregar as vagas do SharedPreferences
        List<Vaga> vagas = loadVagasFromSharedPreferences(); // Carrega as vagas

        // Verifica se há vagas e exibe um aviso caso contrário
        if (vagas.isEmpty()) {
            Toast.makeText(this, "Não há vagas disponíveis.", Toast.LENGTH_SHORT).show();
        }

        // Criar o Adapter e associá-lo à RecyclerView
        segundaVagaAdpter = new SegundaVagaAdpter(this, vagas);
        recyclerView.setAdapter(segundaVagaAdpter);

        // Encontrar o ImageView para VagasVoluntarios (imageView7)
        ImageView imageViewSeta = findViewById(R.id.imageView7);
        imageViewSeta.setOnClickListener(v -> {
            // Criar a Intent para abrir a HomeActivity
            Intent intent = new Intent(vagasvoluntarios.this, Home.class);
            startActivity(intent);  // Inicia a nova Activity
        });
    }

    // Método para carregar as vagas do SharedPreferences
    private List<Vaga> loadVagasFromSharedPreferences() {
        List<Vaga> vagas = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("vagas", MODE_PRIVATE);

        // Recuperar todas as vagas salvas no SharedPreferences
        for (String id : sharedPreferences.getAll().keySet()) {
            String vagaData = sharedPreferences.getString(id, null);
            if (vagaData != null) {
                // Dividir a string para extrair os dados da vaga
                String[] dadosVaga = vagaData.split(";");

                // Verificar se os dados possuem a quantidade esperada
                if (dadosVaga.length == 7) {
                    Vaga vaga = new Vaga(
                            dadosVaga[0], // título
                            dadosVaga[1], // instituição
                            dadosVaga[2], // local
                            dadosVaga[3], // data
                            dadosVaga[4], // horário
                            dadosVaga[5], // requisitos
                            dadosVaga[6], // detalhamento
                            id // idvaga
                    );
                    vagas.add(vaga);
                }
            }
        }

        return vagas;
    }
}