package com.example.app_developer; // O pacote correto

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button; // Para o botão
import android.widget.EditText; // Para o EditText

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast; // Importando a classe Toast para exibir mensagens

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivityAtividadesRealizadas extends AppCompatActivity {

    private DataManager dataManager;  // Instância do DataManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityatividadesrealizadas); // Certifique-se de que o layout está correto

        // Instância do DataManager
        dataManager = new DataManager(this);
        dataManager.open(); // Abre o banco de dados

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageViewHome = findViewById(R.id.imageView5);

        // Configurar o clique para a Home
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, Home.class);
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
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, VagasVoluntarios.class);
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
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, Config.class);
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
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewPerfil = findViewById(R.id.imageView12);

        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, MainPerfilVoluntarioActivity.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o EditText (editTextAtividades) para o usuário digitar a descrição da atividade
        EditText editTextDescricaoAtividade = findViewById(R.id.editTextAtividades);

        // Encontrar o Button (buttonSalvarAtividade) para salvar a atividade
        Button buttonSalvarAtividade = findViewById(R.id.button6);

        // Ler dados da tabela de atividades do banco de dados e preencher o EditText com as atividades
        String atividadesSalvas = dataManager.readAtividade();  // Use readAtividades() para ler da tabela de atividades
        editTextDescricaoAtividade.setText(atividadesSalvas);  // Preenche o EditText com as atividades salvas

        // Configurar o clique do botão para salvar a atividade
        buttonSalvarAtividade.setOnClickListener(v -> {
            // Obter o texto digitado pelo usuário no EditText
            String descricaoAtividade = editTextDescricaoAtividade.getText().toString();

            // Usar o DataManager para salvar ou atualizar a atividade no banco
            dataManager.saveAtividade(descricaoAtividade);  // Use saveAtividade() para salvar na tabela de atividades

            // Exibir a atividade no próprio EditText
            editTextDescricaoAtividade.setText(descricaoAtividade);  // Atualiza o EditText com o texto inserido

            // Exibir uma mensagem Toast confirmando que a atividade foi salva
            Toast.makeText(MainActivityAtividadesRealizadas.this, "Atividade salva com sucesso!", Toast.LENGTH_SHORT).show();
        });

        TextView textViewInscricoesVoluntario = findViewById(R.id.textView9);
        // Configurar o clique para VagasVoluntarios
        textViewInscricoesVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, main_inscricoes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewdescricao = findViewById(R.id.textView4);
        // Configurar o clique para VagasVoluntarios
        textViewdescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainActivityAtividadesRealizadas.this, MainPerfilVoluntarioActivity.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataManager.close(); // Fechar o banco de dados quando a activity for destruída
    }
}
