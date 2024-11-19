package com.example.app_developer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VagasPesquisa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vagas_pesquisa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Id dos Button
        Button btnCandidatar1 = findViewById(R.id.btnCandidatar1);
        Button btnCandidatar2 = findViewById(R.id.btnCandidatar2);
        Button btnCandidatar3 = findViewById(R.id.btnCandidatar3);

        configurarBotaoCandidatura(btnCandidatar1, "12345");
        configurarBotaoCandidatura(btnCandidatar2, "12346");
        configurarBotaoCandidatura(btnCandidatar3, "12347");
    }

    // Button cancelar inscrição
    private void configurarBotaoCandidatura(Button botao, String codigoVaga) {
        botao.setOnClickListener(new View.OnClickListener() {
            boolean isCandidatar = true;
            @Override
            public void onClick(View v) {
                if (isCandidatar) {
                    botao.setText("Cancelar Inscrição");
                    Toast.makeText(VagasPesquisa.this, "Candidatura enviada para vaga " + codigoVaga, Toast.LENGTH_SHORT).show();
                    isCandidatar = false;
                } else {
                    botao.setText("Me Candidatar");
                    Toast.makeText(VagasPesquisa.this, "Inscrição cancelada para vaga " + codigoVaga, Toast.LENGTH_SHORT).show();
                    isCandidatar = true;
                }
            }
        });
    }
}
