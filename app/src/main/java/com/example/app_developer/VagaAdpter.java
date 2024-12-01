package com.example.app_developer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VagaAdpter extends RecyclerView.Adapter<VagaAdpter.VagaViewHolder> {

    private List<Vaga> vagaList;

    public VagaAdpter(List<Vaga> vagas) {
        this.vagaList = vagas;
    }

    @Override
    public VagaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla o layout para um item de vaga
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vaga, parent, false);
        return new VagaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VagaViewHolder holder, int position) {
        // Preenche os dados do item
        Vaga vaga = vagaList.get(position);
        holder.tituloVaga.setText(vaga.getTitulo());
        holder.instituicaoVaga.setText(vaga.getInstituicao());
        holder.localVaga.setText(vaga.getLocal());



        // Ao clicar no item, navega para a tela de detalhes e passa os dados completos
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), atividadesrealizadasdetalhes.class);
            intent.putExtra("vaga_name", vaga.getTitulo());
            intent.putExtra("ong", vaga.getInstituicao());
            intent.putExtra("local", vaga.getLocal());
            intent.putExtra("data", vaga.getData());
            intent.putExtra("horario", vaga.getHorario());
            intent.putExtra("requisitos", vaga.getRequisitos());
            intent.putExtra("descricao", vaga.getDetalhamento());
            intent.putExtra("idvaga", vaga.getIdvaga());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return vagaList.size();
    }

    // ViewHolder que armazena as referências para os elementos de cada item
    public static class VagaViewHolder extends RecyclerView.ViewHolder {
        TextView tituloVaga, instituicaoVaga, localVaga;
        Button botaoCancelar;

        public VagaViewHolder(View itemView) {
            super(itemView);
            tituloVaga = itemView.findViewById(R.id.textVaga);
            instituicaoVaga = itemView.findViewById(R.id.textOng);
            localVaga = itemView.findViewById(R.id.textLocal);
            botaoCancelar = itemView.findViewById(R.id.buttonCancelarVaga);
        }
    }
}
