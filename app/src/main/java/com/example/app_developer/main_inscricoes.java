package com.example.app_developer;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class main_inscricoes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TerceiraVagaAdpter TerceiraVagaAdpter;  // Usando o SegundaVagaAdpter
    private List<Vaga> vagasList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inscricoes);  // O layout correto

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Recupera as vagas salvas no SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("vaga_pref", MODE_PRIVATE);
        String vagaName = sharedPreferences.getString("vaga_name", null);

        // Se existir uma vaga salva, adicione-a à lista
        if (vagaName != null) {
            String ong = sharedPreferences.getString("ong", "");
            String local = sharedPreferences.getString("local", "");
            String data = sharedPreferences.getString("data", "");
            String horario = sharedPreferences.getString("horario", "");
            String requisitos = sharedPreferences.getString("requisitos", "");
            String descricao = sharedPreferences.getString("descricao", "");
            String idvaga = sharedPreferences.getString("idvaga", "");

            // Cria a nova vaga e adiciona à lista
            Vaga vaga = new Vaga(vagaName, ong, local, data, horario, requisitos, descricao, idvaga);
            vagasList.add(vaga);
        }

        // Configura o adapter e atualiza a RecyclerView
        TerceiraVagaAdpter = new TerceiraVagaAdpter(this, vagasList);  // Usando o SegundaVagaAdpter
        recyclerView.setAdapter(TerceiraVagaAdpter);  // Configura o adapter
    }
}
