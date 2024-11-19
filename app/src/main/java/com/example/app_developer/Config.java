package com.example.app_developer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_config);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Definindo as ações dos botões
        findViewById(R.id.btn_alterar_dados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Alterar Dados Cadastrais");
            }
        });

        findViewById(R.id.btn_notificacoes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Notificações");}
        });

        findViewById(R.id.btn_localizacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Localização");
            }
        });

        findViewById(R.id.btn_permissoes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Permissões");
            }
        });
    }
    private void showToast(String message) {
        Toast.makeText(Config.this, message, Toast.LENGTH_SHORT).show();
    }
}

