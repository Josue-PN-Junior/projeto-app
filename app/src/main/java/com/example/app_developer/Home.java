package com.example.app_developer;

import android.os.Bundle;

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

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private AdapterListaHome homeListaAdapter;
    private ArrayList<vagasHome> vagasHome = new ArrayList<vagasHome>();

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

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerViewHome = binding.recycleViewVagasRecPubli;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHome.setLayoutManager(layoutManager);
        recyclerViewHome.setHasFixedSize(true);

        homeListaAdapter = new AdapterListaHome(vagasHome, this);
        recyclerViewHome.setAdapter(homeListaAdapter);
        getVagasHome();

    }

    private void getVagasHome() {

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

}