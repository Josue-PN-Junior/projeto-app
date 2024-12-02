package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VagasVoluntarios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SegundaVagaAdpter segundaVagaAdpter;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagasvoluntarios);

        // Inicializar o DataManager
        dataManager = new DataManager(this);
        dataManager.open(); // Abrir o banco de dados

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewSeta = findViewById(R.id.imageView7);
        imageViewSeta.setOnClickListener(v -> {
            // Criar a Intent para abrir a HomeActivity
            Intent intent = new Intent(VagasVoluntarios.this, Home.class);
            startActivity(intent);  // Inicia a nova Activity
        });

        // Inicializando a RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Carregar as vagas do banco de dados
        List<Vaga> vagas = dataManager.readAllVagas(); // Lê todas as vagas

        // Criar o Adapter e associá-lo à RecyclerView
        segundaVagaAdpter = new SegundaVagaAdpter(this, vagas);
        recyclerView.setAdapter(segundaVagaAdpter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataManager.close(); // Fechar o banco de dados quando a activity for destruída
    }
}
