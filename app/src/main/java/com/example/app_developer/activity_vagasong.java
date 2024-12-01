package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class activity_vagasong extends AppCompatActivity {

    private LinearLayout vagasContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagasong);

        // Inicialize o LinearLayout que irá conter as vagas
        vagasContainer = findViewById(R.id.vagasContainer);

        // Exemplo de dados para as vagas
        List<Vaga> vagas = new ArrayList<>();
        vagas.add(new Vaga("Arrecadação de Brinquedos", "ONG: Crescer", "Local: São Paulo"));
        vagas.add(new Vaga("Reforma da Cozinha", "ONG: Herdar", "Local: São Paulo"));
        vagas.add(new Vaga("Roda de Leitura", "ONG: Herdar", "Local: São Paulo"));

        // Adiciona as vagas dinamicamente
        for (Vaga vaga : vagas) {
            addVagaView(vaga);
        }
    }

    // Função para adicionar uma vaga no layout
    private void addVagaView(Vaga vaga) {
        // Infla o layout do item da vaga
        LayoutInflater inflater = LayoutInflater.from(this);
        View vagaView = inflater.inflate(R.layout.activity_vaga, null);

        // Referências para os TextViews e Button
        TextView textVaga = vagaView.findViewById(R.id.textVaga);
        TextView textOng = vagaView.findViewById(R.id.textOng);
        TextView textLocal = vagaView.findViewById(R.id.textLocal);
        Button buttonCancelar = vagaView.findViewById(R.id.buttonCancelarVaga);
        TextView textVerDetalhes = vagaView.findViewById(R.id.textView39);  // ID para o "Ver Detalhes"

        // Definindo os dados da vaga nos TextViews
        textVaga.setText(vaga.getVagaName());  // Nome da vaga
        textOng.setText(vaga.getOng());
        textLocal.setText(vaga.getLocal());

        // Configurar o comportamento do botão de cancelar vaga
        buttonCancelar.setOnClickListener(v -> {
            // Criar o AlertDialog
            new AlertDialog.Builder(activity_vagasong.this)
                    .setTitle("Confirmar Cancelamento")
                    .setMessage("Você tem certeza que deseja cancelar essa vaga?")
                    .setPositiveButton("Sim", (dialog, which) -> {
                        // Se o usuário confirmar, removemos a vaga do layout
                        vagasContainer.removeView(vagaView);
                    })
                    .setNegativeButton("Não", (dialog, which) -> {
                        // Se o usuário cancelar, nada acontece
                        dialog.dismiss();
                    })
                    .show();
        });

        // Adicionando o comportamento de abrir a Activity de detalhes quando o texto "Ver Detalhes" for clicado
        textVerDetalhes.setOnClickListener(v -> {
            // Criar a Intent para abrir a Activity de detalhes
            Intent intent = new Intent(activity_vagasong.this, atividadesrealizadasdetalhes.class);
            startActivity(intent);  // Inicia a nova Activity
        });

        // Adiciona a view inflada no LinearLayout
        vagasContainer.addView(vagaView);
    }

    // Classe para representar uma vaga
    public static class Vaga {
        private String vagaName;
        private String ong;
        private String local;

        // Construtor
        public Vaga(String vagaName, String ong, String local) {
            this.vagaName = vagaName;
            this.ong = ong;
            this.local = local;
        }

        public String getVagaName() {
            return vagaName;  // Apenas o nome da vaga, sem prefixos
        }

        public String getOng() {
            return ong;
        }

        public String getLocal() {
            return local;
        }
    }
}
