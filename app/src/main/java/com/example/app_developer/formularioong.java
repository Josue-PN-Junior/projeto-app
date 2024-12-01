package com.example.app_developer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class formularioong extends AppCompatActivity {

    private EditText edtTituloVaga, edtInstituicaoVaga, edtLocalVaga, edtDataVaga, edtHorarioVaga, edtRequisitosVaga, edtDescricaoVaga, edtID;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formularioong);

        // Encontrar os EditTexts para preencher os dados da vaga
        edtTituloVaga = findViewById(R.id.editTextText2);
        edtInstituicaoVaga = findViewById(R.id.editTextInstituicao);
        edtLocalVaga = findViewById(R.id.editTextLocal);
        edtDataVaga = findViewById(R.id.editTextData);
        edtHorarioVaga = findViewById(R.id.editTextHorario);
        edtRequisitosVaga = findViewById(R.id.editTextRequisitos);
        edtDescricaoVaga = findViewById(R.id.editTextDescricao);
        edtID = findViewById(R.id.editTextID);

        btnSalvar = findViewById(R.id.button6);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = edtTituloVaga.getText().toString();
                String instituicao = edtInstituicaoVaga.getText().toString();
                String local = edtLocalVaga.getText().toString();
                String data = edtDataVaga.getText().toString();
                String horario = edtHorarioVaga.getText().toString();
                String requisitos = edtRequisitosVaga.getText().toString();
                String descricao = edtDescricaoVaga.getText().toString();
                String id = edtID.getText().toString();

                if (!titulo.isEmpty() && !instituicao.isEmpty() && !local.isEmpty()) {
                    // Criação do objeto Vaga
                    Vaga vaga = new Vaga(titulo, instituicao, local, data, horario, requisitos, descricao, id);

                    // Salvando a vaga com SharedPreferences
                    saveVaga(vaga);

                    // Exibindo uma mensagem de sucesso
                    Toast.makeText(formularioong.this, "Vaga salva com sucesso!", Toast.LENGTH_SHORT).show();

                    // Enviar de volta para a ActivityVagasong
                    Intent intent = new Intent(formularioong.this, activity_vagasong.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(formularioong.this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para salvar a vaga usando SharedPreferences
    private void saveVaga(Vaga vaga) {
        SharedPreferences sharedPreferences = getSharedPreferences("vagas", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Concatena todos os dados da vaga em uma string
        String vagaData = vaga.getTitulo() + ";" +
                vaga.getInstituicao() + ";" +
                vaga.getLocal() + ";" +
                vaga.getData() + ";" +
                vaga.getHorario() + ";" +
                vaga.getRequisitos() + ";" +
                vaga.getDetalhamento();

        // Salva a string concatenada usando o id da vaga como chave
        editor.putString(vaga.getIdvaga(), vagaData);
        editor.apply();
    }
}
