package com.example.app_developer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SegundaVagaAdpter extends RecyclerView.Adapter<SegundaVagaAdpter.VagaViewHolder> {

    private Context context;
    private List<Vaga> vagaList;

    public SegundaVagaAdpter(Context context, List<Vaga> vagaList) {
        this.context = context;
        this.vagaList = vagaList;
    }

    @Override
    public VagaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla o layout para um item de vaga
        View view = LayoutInflater.from(context).inflate(R.layout.activity_vaga_voluntario, parent, false);
        return new VagaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VagaViewHolder holder, int position) {
        Vaga vaga = vagaList.get(position);

        // Preenche os dados da vaga
        holder.textTitulo.setText(vaga.getTitulo());
        holder.textInstituicao.setText(vaga.getInstituicao());
        holder.textLocal.setText(vaga.getLocal());

        // Configura o clique no TextView de "Ver detalhes"
        holder.textVerDetalhes.setOnClickListener(v -> {
            // Cria a Intent para abrir a atividade de detalhes
            Intent intent = new Intent(context, atividadesrealizadasdetalhes.class); // Corrigido o nome da classe

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
    }

    @Override
    public int getItemCount() {
        // Verifica se a lista não é nula e retorna o tamanho
        if (vagaList != null) {
            return vagaList.size();
        }
        return 0;
    }

    // ViewHolder para cada item da vaga
    public static class VagaViewHolder extends RecyclerView.ViewHolder {
        TextView textTitulo, textInstituicao, textLocal, textVerDetalhes;

        public VagaViewHolder(View itemView) {
            super(itemView);
            // Inicializa as views do item
            textTitulo = itemView.findViewById(R.id.textVaga);
            textInstituicao = itemView.findViewById(R.id.textOng);
            textLocal = itemView.findViewById(R.id.textLocal);
            textVerDetalhes = itemView.findViewById(R.id.textView39);  // "Ver detalhes"
        }
    }
}
