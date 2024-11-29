package com.example.app_developer; // O pacote correto

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Para o botão
import android.widget.EditText; // Para o EditText
import android.widget.ImageView; // Usando ImageView normal
import android.widget.TextView; // Para o TextView de descrição
import android.widget.Toast; // Importando a classe Toast para exibir mensagens

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainPerfilVoluntarioActivity extends AppCompatActivity {

    private DataManager dataManager;  // Instância do DataManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfilvoluntario);

        // Instância do DataManager
        dataManager = new DataManager(this);
        dataManager.open(); // Abre o banco de dados

        // Configuração da interface (já existe no seu código)
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
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, Home.class);
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
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, VagasVoluntarios.class);
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
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, Config.class);
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
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewPerfil = findViewById(R.id.imageView12);

        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, MainPerfilVoluntarioActivity.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewSeta = findViewById(R.id.imageView7);

        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewAtividadesRealizadasVoluntario = findViewById(R.id.textView5);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesRealizadasVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, MainActivityAtividadesRealizadas.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewInscricoesVoluntario = findViewById(R.id.textView9);
        // Configurar o clique para VagasVoluntarios
        textViewInscricoesVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, main_inscricoes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewdescricao = findViewById(R.id.textView4);
        // Configurar o clique para VagasVoluntarios
        textViewdescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(MainPerfilVoluntarioActivity.this, MainPerfilVoluntarioActivity.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o EditText (editTextText) para o usuário digitar a descrição
        EditText editTextDescricao = findViewById(R.id.editTextText);

        // Encontrar o Button (button6) para salvar a descrição
        Button buttonSalvar = findViewById(R.id.button6);

        // Ler dados do banco de dados e preencher o EditText
        String descricaoSalva = dataManager.readData();
        editTextDescricao.setText(descricaoSalva);  // Preenche o EditText com a descrição salva

        // Configurar o clique do botão para salvar a descrição
        buttonSalvar.setOnClickListener(v -> {
            // Obter o texto digitado pelo usuário no EditText
            String descricao = editTextDescricao.getText().toString();

            // Usar o DataManager para salvar ou atualizar a descrição no banco
            dataManager.saveData(descricao);  // Este método vai limpar a tabela e inserir a nova descrição

            // Exibir a descrição no próprio EditText
            editTextDescricao.setText(descricao);  // Atualiza o EditText com o texto inserido

            // Exibir uma mensagem Toast confirmando que a descrição foi salva
            Toast.makeText(MainPerfilVoluntarioActivity.this, "Descrição salva com sucesso!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataManager.close(); // Fechar o banco de dados quando a activity for destruída
    }
}
