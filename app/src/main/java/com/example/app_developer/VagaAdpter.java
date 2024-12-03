package com.example.app_developer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VagaAdpter extends RecyclerView.Adapter<VagaAdpter.VagaViewHolder> {

    private Context context;
    private List<Vaga> vagaList;

    public VagaAdpter(Context context, List<Vaga> vagaList) {
        this.context = context;
        this.vagaList = vagaList;
    }

    @Override
    public VagaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla o layout para um item de vaga
        View view = LayoutInflater.from(context).inflate(R.layout.activity_vaga, parent, false);
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

        // Configura o clique no botão "Cancelar Vaga" (excluir)
        holder.btnCancelarVaga.setOnClickListener(v -> {
            // Chama o método de confirmação de exclusão com o AlertDialog
            confirmarExclusao(position);
        });
    }

    @Override
    public int getItemCount() {
        return vagaList.size();
    }

    // Método para confirmar a exclusão usando AlertDialog
    private void confirmarExclusao(int position) {
        new AlertDialog.Builder(context)
                .setTitle("Confirmar Exclusão")
                .setMessage("Tem certeza que deseja cancelar esta vaga?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    excluirVaga(position);
                })
                .setNegativeButton("Não", null)  // Se o usuário clicar em "Não", o diálogo será fechado
                .show(); // Exibe o diálogo
    }

    // Método para excluir a vaga
    private void excluirVaga(int position) {
        Vaga vaga = vagaList.get(position);

        // Remover a vaga do SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("vagas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(vaga.getIdvaga());  // Remove a vaga com o id correspondente
        editor.apply(); // Salva a remoção

        // Após a exclusão, remova a vaga da lista e atualize a UI
        vagaList.remove(position);
        notifyItemRemoved(position);

        // Mostrar uma mensagem de sucesso
        Toast.makeText(context, "Vaga cancelada com sucesso!", Toast.LENGTH_SHORT).show();
    }

    // ViewHolder para cada item da vaga
    public static class VagaViewHolder extends RecyclerView.ViewHolder {
        TextView textTitulo, textInstituicao, textLocal, textVerDetalhes;
        Button btnCancelarVaga;  // Botão de cancelar (excluir)

        public VagaViewHolder(View itemView) {
            super(itemView);
            // Inicializa as views do item
            textTitulo = itemView.findViewById(R.id.textVaga);
            textInstituicao = itemView.findViewById(R.id.textOng);
            textLocal = itemView.findViewById(R.id.textLocal);
            textVerDetalhes = itemView.findViewById(R.id.textView39);  // "Ver detalhes"
            btnCancelarVaga = itemView.findViewById(R.id.cancelarInscricao);  // Botão de excluir
        }
    }
}