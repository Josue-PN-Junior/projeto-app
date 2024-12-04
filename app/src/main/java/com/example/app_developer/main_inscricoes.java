//
package com.example.app_developer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        // Encontrar o ImageView para a Home (imageView5)
        ImageView imageViewHome = findViewById(R.id.imageView5);

        // Configurar o clique para a Home
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(main_inscricoes.this, Home.class);
                startActivity(intent);  // Inicia a Home
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewVagas = findViewById(R.id.imageView14);

        // Configurar o clique para VagasVoluntarios
        imageViewVagas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, vagasvoluntarios.class);
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
                Intent intent = new Intent(main_inscricoes.this, Config.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewLupa = findViewById(R.id.imageView);

        // Configurar o clique para VagasVoluntarios
        imageViewLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewAtividadesRealizadasVoluntario = findViewById(R.id.textView5);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesRealizadasVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, MainActivityatividadesrealizadas.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewInscricoesVoluntario = findViewById(R.id.textView9);
        // Configurar o clique para VagasVoluntarios
        textViewInscricoesVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, main_inscricoes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewdescricao = findViewById(R.id.textView4);
        // Configurar o clique para VagasVoluntarios
        textViewdescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, MainPerfilVoluntarioActivity.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });



        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewSeta = findViewById(R.id.imageView7);

        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Configura o adapter e atualiza a RecyclerView
        TerceiraVagaAdpter = new TerceiraVagaAdpter(this, vagasList);  // Usando o SegundaVagaAdpter
        recyclerView.setAdapter(TerceiraVagaAdpter);  // Configura o adapter
    }
}