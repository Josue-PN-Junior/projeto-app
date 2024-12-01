package com.example.app_developer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class activity_vagasong extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VagaAdpter vagaAdpter;
    private List<Vaga> vagas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagasong);

        // Inicializando a RecyclerView
        recyclerView = findViewById(R.id.recyclerViewVagas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Criar a lista de vagas
        vagas = new ArrayList<>();
        vagas.add(new Vaga("Arrecadação de Brinquedos", "Crescer", "São Paulo", "05/03/2024","11 horas ate´14 horas", "Maioridade","Reforma","5"));
        vagas.add(new Vaga("Reforma da Cozinha", "Herdar", "São Paulo", "06/03/2024","11 horas ate´14 horas", "Maioridade","Reforma","6"));
        vagas.add(new Vaga("Roda de Leitura", "Herdar", "São Paulo", "07/03/2024","11 horas ate´14 horas", "Maioridade","Reforma","7"));

        // Criar o Adapter e associar com a RecyclerView
        vagaAdpter = new VagaAdpter(vagas);
        recyclerView.setAdapter(vagaAdpter);
    }
}
