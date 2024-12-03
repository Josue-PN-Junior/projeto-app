package com.example.app_developer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class main_inscricoes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VagaAdapter vagaAdapter;
    private List<Vaga> vagasList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inscricoes);  // O layout correto

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Recupera a lista de vagas salvas no SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("vaga_pref", MODE_PRIVATE);
        String vagasSalvas = sharedPreferences.getString("vagas_lista", "");

        if (!vagasSalvas.isEmpty()) {
            String[] vagasArray = vagasSalvas.split("\\|\\|");  // Separa as vagas usando "||"

            for (String vagaData : vagasArray) {
                String[] dadosVaga = vagaData.split(";");
                Vaga vaga = new Vaga(dadosVaga[0], dadosVaga[1], dadosVaga[2], dadosVaga[3], dadosVaga[4], dadosVaga[5], dadosVaga[6]);
                vagasList.add(vaga);
            }
        }

        vagaAdapter = new VagaAdapter(vagasList);
        recyclerView.setAdapter(vagaAdapter);
    }

    // Classe para representar uma Vaga
    public static class Vaga {
        String titulo, instituicao, local, data, horario, requisitos, descricao;

        public Vaga(String titulo, String instituicao, String local, String data, String horario, String requisitos, String descricao) {
            this.titulo = titulo;
            this.instituicao = instituicao;
            this.local = local;
            this.data = data;
            this.horario = horario;
            this.requisitos = requisitos;
            this.descricao = descricao;
        }
    }

    // Adapter para o RecyclerView
    public static class VagaAdapter extends RecyclerView.Adapter<VagaAdapter.VagaViewHolder> {

        private List<Vaga> vagasList;

        public VagaAdapter(List<Vaga> vagasList) {
            this.vagasList = vagasList;
        }

        @Override
        public VagaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vagainscricaounificado, parent, false);
            return new VagaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(VagaViewHolder holder, int position) {
            Vaga vaga = vagasList.get(position);
            holder.textVaga.setText( vaga.titulo + "\n" +
                    "Instituição: " + vaga.instituicao);
                   }

        @Override
        public int getItemCount() {
            return vagasList.size();
        }

        public static class VagaViewHolder extends RecyclerView.ViewHolder {
            TextView textVaga;

            public VagaViewHolder(View itemView) {
                super(itemView);
                textVaga = itemView.findViewById(R.id.textVaga);
            }
        }
    }
}
