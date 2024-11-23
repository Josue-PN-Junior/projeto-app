package com.example.app_developer;

import android.content.Intent;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        // ==========================
        // Barra de navegação
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationConfig);

        // Define o item de "Home" como selecionado inicialmente
        bottomNavigationView.setSelectedItemId(R.id.nav_config);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                // Não reinicia a Activity Home, apenas retorna true
                startActivity(new Intent(this, Home.class));
                return true;
            } else if (item.getItemId() == R.id.nav_config) {
                // Se o item for 'Config', abre a Activity Config
                startActivity(new Intent(this, Config.class));
                return true;
            } else if (item.getItemId() == R.id.nav_perfil) {
                // Se o item for 'Perfil', abre a Activity VagasPesquisa
                startActivity(new Intent(this, Home.class));
                return true;
            }  else if (item.getItemId() == R.id.nav_filtro) {
                // Se o item for 'Perfil', abre a Activity VagasPesquisa
                startActivity(new Intent(this, Home.class));
                return true;
            }  else if (item.getItemId() == R.id.nav_vagas) {
                // Se o item for 'Perfil', abre a Activity VagasPesquisa
                startActivity(new Intent(this, Home.class));
                return true;
            }
            return false;
        });




    }
    private void showToast(String message) {
        Toast.makeText(Config.this, message, Toast.LENGTH_SHORT).show();
    }
}

