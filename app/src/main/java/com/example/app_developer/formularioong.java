package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class formularioong extends AppCompatActivity {

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formularioong);


        // Inicializando o DataManager para acessar o banco de dados
        dataManager = new DataManager(this);
        dataManager.open(); // Abre o banco de dados

        // Encontrar os EditTexts para preencher os dados da vaga
        EditText edtTituloVaga = findViewById(R.id.editTextText2);
        EditText edtInstituicaoVaga = findViewById(R.id.editTextInstituicao);
        EditText edtLocalVaga = findViewById(R.id.editTextLocal);
        EditText edtDataVaga = findViewById(R.id.editTextData);
        EditText edtHorarioVaga = findViewById(R.id.editTextHorario);
        EditText edtRequisitosVaga = findViewById(R.id.editTextRequisitos);
        EditText edtDescricaoVaga = findViewById(R.id.editTextDescricao);
        EditText edtID = findViewById(R.id.editTextID);

        // Encontrar o botão para salvar a vaga
        Button btnSalvarVaga = findViewById(R.id.button6);

        // Ler dados da tabela de vagas do banco de dados
        String[] vagaDados = dataManager.readVaga();  // Supondo que esse método retorne um array de strings

        // Preencher os EditTexts com os dados da vaga (vagaDados[0] é o título, vagaDados[1] é a instituição, etc.)
        if (vagaDados != null && vagaDados.length == 8) {
            edtID.setText(vagaDados[0]);  // O id da vaga
            edtTituloVaga.setText(vagaDados[1]);  // Título da vaga
            edtInstituicaoVaga.setText(vagaDados[2]);  // Instituição
            edtLocalVaga.setText(vagaDados[3]);  // Local
            edtDataVaga.setText(vagaDados[4]);  // Data
            edtHorarioVaga.setText(vagaDados[5]);  // Horário
            edtRequisitosVaga.setText(vagaDados[6]);  // Requisitos
            edtDescricaoVaga.setText(vagaDados[7]);  // Descrição
        }

        // Configurar o clique do botão para salvar a vaga
        btnSalvarVaga.setOnClickListener(v -> {
            // Obter os dados dos EditTexts
            String id = edtID.getText().toString();
            String titulo = edtTituloVaga.getText().toString();
            String instituicao = edtInstituicaoVaga.getText().toString();
            String local = edtLocalVaga.getText().toString();
            String data = edtDataVaga.getText().toString();
            String horario = edtHorarioVaga.getText().toString();
            String requisitos = edtRequisitosVaga.getText().toString();
            String descricao = edtDescricaoVaga.getText().toString();

            // Verificar se todos os campos foram preenchidos
            if (titulo.isEmpty() || instituicao.isEmpty() || local.isEmpty() || data.isEmpty() || horario.isEmpty() || requisitos.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(formularioong.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Usar o DataManager para salvar os dados da vaga no banco
            dataManager.saveVaga(titulo, instituicao, local, data, horario, requisitos, descricao, id);

            // Exibir uma mensagem de sucesso
            Toast.makeText(formularioong.this, "Vaga salva com sucesso!", Toast.LENGTH_SHORT).show();
        });
        // Encontrar o ImageView para a Home (imageView5)
        ImageView imageViewHome = findViewById(R.id.imageView5);

        // Configurar o clique para a Home
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(formularioong.this, Home.class);
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
                Intent intent = new Intent(formularioong.this, activity_vagasong.class);
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
                Intent intent = new Intent(formularioong.this, Config.class);
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
                Intent intent = new Intent(formularioong.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        ImageView imageViewSeta = findViewById(R.id.imageView7);

        // Configurar o clique para a Home
        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(formularioong.this, Home.class);
                startActivity(intent);  // Inicia a Home
            }
        });
    }
}
