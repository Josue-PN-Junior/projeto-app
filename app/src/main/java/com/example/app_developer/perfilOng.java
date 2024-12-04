package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class perfilOng extends AppCompatActivity {

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_ong);

        dataManager = new DataManager(this);
        dataManager.open(); // Abre o banco de dados


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
                Intent intent = new Intent(perfilOng.this, Home.class);
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
                Intent intent = new Intent(perfilOng.this, activity_vagasong.class);
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
                Intent intent = new Intent(perfilOng.this, Config.class);
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
                Intent intent = new Intent(perfilOng.this, VagasPesquisa.class);
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
                Intent intent = new Intent(perfilOng.this, perfil_ong_atividadesrealizadas.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewSeta = findViewById(R.id.imageView7);

        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfilOng.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o EditText (editTextAtividades) para o usuário digitar a descrição da atividade
        EditText editTextDescricaoAtividadeONG = findViewById(R.id.editTextText);

        // Encontrar o Button (buttonSalvarAtividade) para salvar a atividade
        Button buttonSalvarAtividadeONG = findViewById(R.id.button6);

        // Ler dados da tabela de atividades do banco de dados e preencher o EditText com as atividades
        String atividadesSalvasONG = dataManager.readDescircaoONG();  // Use readAtividades() para ler da tabela de atividades
        editTextDescricaoAtividadeONG.setText(atividadesSalvasONG);  // Preenche o EditText com as atividades salvas

        // Configurar o clique do botão para salvar a atividade
        buttonSalvarAtividadeONG.setOnClickListener(v -> {
            // Obter o texto digitado pelo usuário no EditText
            String descricaoAtividade = editTextDescricaoAtividadeONG.getText().toString();

            // Usar o DataManager para salvar ou atualizar a atividade no banco
            dataManager.saveDescricaoOng(descricaoAtividade);  // Use saveAtividade() para salvar na tabela de atividades

            // Exibir a atividade no próprio EditText
            editTextDescricaoAtividadeONG.setText(descricaoAtividade);  // Atualiza o EditText com o texto inserido

            // Exibir uma mensagem Toast confirmando que a atividade foi salva
            Toast.makeText(perfilOng.this, "Atividade salva com sucesso!", Toast.LENGTH_SHORT).show();
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewPerfil = findViewById(R.id.imageView12);

        imageViewPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(perfilOng.this, perfilOng.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

    }
}