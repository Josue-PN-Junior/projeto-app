package com.example.app_developer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_developer.adapter.AdapterListaHome;
import com.example.app_developer.databinding.ActivityHomeBinding;
import com.example.app_developer.modelo.vagasHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomeBinding binding;
    private AdapterListaHome homeListaAdapter, homeListaAdapterMinhas, homeListaAdapterVistas;
    private ArrayList<vagasHome> vagasHome = new ArrayList<vagasHome>();
    private ArrayList<vagasHome> vagasMinhas = new ArrayList<vagasHome>();
    String email, cpf;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // recebendo
        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        email = parametros.getString("email");
        BancoController bd = new BancoController(getBaseContext());
        cpf = bd.PesquisarCpf(email).toString();

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Recém Publi
        RecyclerView recyclerViewHome = binding.recycleViewVagasRecPubli;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHome.setLayoutManager(layoutManager);
        recyclerViewHome.setHasFixedSize(true);

        // Adpater Publi
        homeListaAdapter = new AdapterListaHome(vagasHome, this);
        recyclerViewHome.setAdapter(homeListaAdapter);
        getVagasHome();
        if ((vagasHome.size() % 2) == 1) {
            vagasHome.add(getVagasNot());
        } else if (vagasHome.isEmpty()) {
            vagasHome.add(getVagasNot());
            vagasHome.add(getVagasNot());
        }

        // Minhas
        RecyclerView recyclerViewHomeMinhas = binding.recycleViewVagasMinhas;
        LinearLayoutManager layoutManagerMinhas = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHomeMinhas.setLayoutManager(layoutManagerMinhas);
        recyclerViewHomeMinhas.setHasFixedSize(true);

        // Adpater Minhas
        homeListaAdapterMinhas = new AdapterListaHome(vagasHome, this);
            recyclerViewHomeMinhas.setAdapter(homeListaAdapter);
        getVagasHome();
        if ((vagasHome.size() % 2) == 1) {
            vagasHome.add(getVagasNot());
        } else if (vagasHome.isEmpty()) {
            vagasHome.add(getVagasNot());
            vagasHome.add(getVagasNot());
        }

        // Vista
        RecyclerView recyclerViewHomeVistas = binding.recycleViewVagasVista;
        LinearLayoutManager layoutManagerVistas = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHomeVistas.setLayoutManager(layoutManagerVistas);
        recyclerViewHomeVistas.setHasFixedSize(true);

        // Adpater Vistas
        homeListaAdapterVistas = new AdapterListaHome(vagasHome, this);
        recyclerViewHomeVistas.setAdapter(homeListaAdapter);
        getVagasHome();
        if ((vagasHome.size() % 2) == 1) {
            vagasHome.add(getVagasNot());
        } else if (vagasHome.isEmpty()) {
            vagasHome.add(getVagasNot());
            vagasHome.add(getVagasNot());
        }



        // ==========================
        // Barra de navegação
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Define o item de "Home" como selecionado inicialmente
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                //Se o item for 'Config', abre a Activity Config
                //startActivity(new Intent(this, Home.class));
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

    // se não tiver vagas
    private vagasHome getVagasNot() {

        vagasHome vagaN = new vagasHome(
                "Não encontrada",
                "",
                "",
                "",
                0
        );
       return vagaN;

    }

    private void getVagasHome() {
//        BancoController bd = new BancoController(getBaseContext());
//        bd.getVagasRecem(6);
        vagasHome vaga1 = new vagasHome(
                "Coleta de Alimentos",
                "Banco de Alimentos",
                "Coleta de Alimentos",
                "São Paulo - SP",
                1234
        );
        vagasHome.add(vaga1);

        vagasHome vaga2 = new vagasHome(
                "Arrecadação de Brinquedos",
                "Crescer",
                "Arrecadação de brinquedos",
                "São Paulo - SP",
                1235
        );
        vagasHome.add(vaga2);

        vagasHome vaga3 = new vagasHome(
                "Coleta de Alimentos",
                "Banco de Alimentos",
                "Coleta de Alimentos",
                "São Paulo - SP",
                1236
        );
        vagasHome.add(vaga3);

        vagasHome vaga4 = new vagasHome(
                "Arrecadação de Brinquedos",
                "Crescer",
                "Arrecadação de brinquedos e separação, entrega e ver a alegria delas.",
                "São Paulo - SP",
                1237
        );
        vagasHome.add(vaga4);

    }

    @Override
    public void onClick(View view) {

    }
}