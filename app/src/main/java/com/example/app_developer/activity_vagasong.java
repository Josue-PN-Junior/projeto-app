
package com.example.app_developer;

import android.content.SharedPreferences;
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

        // Carregar as vagas salvas
        vagas = loadVagas();

        // Criar o Adapter e associar com a RecyclerView
        vagaAdpter = new VagaAdpter(this, vagas);
        recyclerView.setAdapter(vagaAdpter);
    }

    // Método para carregar as vagas salvas usando SharedPreferences
    private List<Vaga> loadVagas() {
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
                            dadosVaga[0], // titulo
                            dadosVaga[1], // instituicao
                            dadosVaga[2], // local
                            dadosVaga[3], // data
                            dadosVaga[4], // horario
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
