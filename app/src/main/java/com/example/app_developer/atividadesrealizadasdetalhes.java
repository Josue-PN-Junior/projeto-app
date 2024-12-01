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

public class atividadesrealizadasdetalhes extends AppCompatActivity {

    // Declaração dos TextViews
    private TextView textVaga, textOng, textLocal, textData, textHorario, textRequisitos, textDescricao, textId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atividadesdetalhamento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializando os TextViews
        textVaga = findViewById(R.id.textView17);
        textOng = findViewById(R.id.textView18);
        textLocal = findViewById(R.id.textView19);
        textData = findViewById(R.id.textView20);
        textHorario = findViewById(R.id.textView21);
        textRequisitos = findViewById(R.id.textView22);
        textDescricao = findViewById(R.id.textView23);
        textId = findViewById(R.id.textView24);

        // Receber os dados da Intent
        String vagaName = getIntent().getStringExtra("vaga_name");
        String ongName = getIntent().getStringExtra("ong");
        String localName = getIntent().getStringExtra("local");
        String data = getIntent().getStringExtra("data");
        String horario = getIntent().getStringExtra("horario");
        String requisitos = getIntent().getStringExtra("requisitos");
        String descricao = getIntent().getStringExtra("descricao");
        String id = getIntent().getStringExtra("idvaga");

        // Definir os dados nos TextViews
        textVaga.setText(vagaName);
        textOng.setText(ongName);
        textLocal.setText(localName);
        textData.setText(data);
        textHorario.setText(horario);
        textRequisitos.setText(requisitos);
        textDescricao.setText(descricao);
        textId.setText(id);

        // Encontrar o ImageView para a Home (imageView5)
        ImageView imageViewHome = findViewById(R.id.imageView5);

        // Configurar o clique para a Home
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(atividadesrealizadasdetalhes.this, Home.class);
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
                Intent intent = new Intent(atividadesrealizadasdetalhes.this, activity_vagasong.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para Configurações (imageView10)
        ImageView imageViewEngrenagem = findViewById(R.id.imageView10);

        // Configurar o clique para VagasVoluntarios
        imageViewEngrenagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(atividadesrealizadasdetalhes.this, Config.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasPesquisa (imageView11)
        ImageView imageViewLupa = findViewById(R.id.imageView11);

        // Configurar o clique para VagasPesquisa
        imageViewLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasPesquisaActivity
                Intent intent = new Intent(atividadesrealizadasdetalhes.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para PerfilOng (imageView12)
        ImageView imageViewCone = findViewById(R.id.imageView12);

        imageViewCone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a PerfilOngActivity
                Intent intent = new Intent(atividadesrealizadasdetalhes.this, PerfilOng.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para voltar para a Home (imageView7)
        ImageView imageViewSeta = findViewById(R.id.imageView7);

        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(atividadesrealizadasdetalhes.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });
    }
}
