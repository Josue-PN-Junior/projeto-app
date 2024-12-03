package com.example.app_developer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TerceiraVagaAdpter extends RecyclerView.Adapter<TerceiraVagaAdpter.VagaViewHolder> {

    private Context context;
    private List<Vaga> vagaList;

    public TerceiraVagaAdpter(Context context, List<Vaga> vagaList) {
        this.context = context;
        this.vagaList = vagaList;
    }

    @Override
    public VagaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla o layout correto para um item de vaga
        View view = LayoutInflater.from(context).inflate(R.layout.activity_vagainscricaounificado, parent, false);
        return new VagaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VagaViewHolder holder, int position) {
        Vaga vaga = vagaList.get(position);

        // Preenche os campos com as informações da vaga
        holder.textTitulo.setText(vaga.getTitulo());
        holder.textInstituicao.setText(vaga.getInstituicao());


        // Clique no TextView "Ver Detalhes"
        holder.textVerDetalhes.setOnClickListener(v -> {
            Log.d("TerceiraVagaAdpter", "Clicado em Ver Detalhes para a vaga: " + vaga.getTitulo());
            // Cria a Intent para abrir a atividade de detalhes
            Intent intent = new Intent(context, atividadesrealizadasdetalhes.class);

            // Passa os dados da vaga para a nova Activity
            intent.putExtra("vaga_name", vaga.getTitulo());
            intent.putExtra("ong", vaga.getInstituicao());
            intent.putExtra("local", vaga.getLocal());
            intent.putExtra("data", vaga.getData());
            intent.putExtra("horario", vaga.getHorario());
            intent.putExtra("requisitos", vaga.getRequisitos());
            intent.putExtra("descricao", vaga.getDetalhamento());
            intent.putExtra("idvaga", vaga.getIdvaga());

            // Inicia a Activity
            context.startActivity(intent);
        });

        // Clique no botão "Me Candidatar"
        holder.buttonCandidatar.setOnClickListener(v -> {
            Log.d("TerceiraVagaAdpter", "Clicado em Me Candidatar para a vaga: " + vaga.getTitulo());

            // Salvar os dados da vaga no SharedPreferences
            SharedPreferences sharedPreferences = context.getSharedPreferences("vaga_pref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            // Salvar dados da vaga
            editor.putString("vaga_name", vaga.getTitulo());
            editor.putString("ong", vaga.getInstituicao());
            editor.putString("local", vaga.getLocal());
            editor.putString("data", vaga.getData());
            editor.putString("horario", vaga.getHorario());
            editor.putString("requisitos", vaga.getRequisitos());
            editor.putString("descricao", vaga.getDetalhamento());
            editor.putString("idvaga", vaga.getIdvaga());
            editor.apply();  // Salva os dados

            // Agora, você pode abrir a Activity main_inscricoes
            Intent intent = new Intent(context, main_inscricoes.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return vagaList != null ? vagaList.size() : 0;
    }

    public static class VagaViewHolder extends RecyclerView.ViewHolder {
        TextView textTitulo, textInstituicao, textVerDetalhes;
        Button buttonCandidatar;

        public VagaViewHolder(View itemView) {
            super(itemView);
            // Inicializa as views do item
            textTitulo = itemView.findViewById(R.id.textVaga);
            textInstituicao = itemView.findViewById(R.id.textOng);
            textVerDetalhes = itemView.findViewById(R.id.textView39);  // "Ver detalhes"
            buttonCandidatar = itemView.findViewById(R.id.buttonCandidatarVaga);  // Botão "Me Candidatar"
        }
    }
}
