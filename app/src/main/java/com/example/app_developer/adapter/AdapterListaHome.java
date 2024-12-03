package com.example.app_developer.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_developer.databinding.ItensListaHomeBinding;
import com.example.app_developer.modelo.vagasHome;

import java.util.ArrayList;

public class AdapterListaHome extends RecyclerView.Adapter<AdapterListaHome.listaHomeViewHolder> {

    private final ArrayList<vagasHome> vagasLista;
    private final Context context;

    public AdapterListaHome(ArrayList<vagasHome> vagasLista, Context context) {
        this.vagasLista = vagasLista;
        this.context = context;
    }

    @NonNull
    @Override
    public listaHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItensListaHomeBinding listaItens;
        listaItens = ItensListaHomeBinding.inflate(LayoutInflater.from(context), parent, false);
        return new listaHomeViewHolder(listaItens);
    }

    @Override
    public void onBindViewHolder(@NonNull listaHomeViewHolder holder, int position) {
        holder.binding.homeTituloItenLista.setText(vagasLista.get(position).getTitulo_vaga());
<<<<<<< HEAD

        String lixo = vagasLista.get(position).getCod_ong();

        //holder.binding.homeOngItenLista.setText(vagasLista.get(position).getOng_vaga());
        holder.binding.homeOngItenLista.setText(
                Html.fromHtml("<b> Ong: </b>" + vagasLista.get(position).getOng_vaga()),
                TextView.BufferType.SPANNABLE
        );

        //holder.binding.homeAtividadeItenLista.setText(vagasLista.get(position).getAtividade());
        holder.binding.homeAtividadeItenLista.setText(
                Html.fromHtml("<b>Atividade: </b>" + vagasLista.get(position).getAtividade()),
                TextView.BufferType.SPANNABLE
        );

        //holder.binding.homeLocalItenLista.setText(vagasLista.get(position).getLocal());
        holder.binding.homeLocalItenLista.setText(
                Html.fromHtml("<b>Local: </b>" + vagasLista.get(position).getLocal()),
                TextView.BufferType.SPANNABLE
        );

        //holder.binding.homeCodItenLista.setText(String.valueOf(vagasLista.get(position).getCod()));
        holder.binding.homeCodItenLista.setText(
                Html.fromHtml("<b>Cod:</b> " + String.valueOf(vagasLista.get(position).getCod())),
                TextView.BufferType.SPANNABLE
        );

=======
        holder.binding.homeOngItenLista.setText(vagasLista.get(position).getOng_vaga());
        holder.binding.homeAtividadeItenLista.setText(vagasLista.get(position).getAtividade());
        holder.binding.homeLocalItenLista.setText(vagasLista.get(position).getLocal());
        //holder.binding.homeCodItenLista.setText(vagasLista.get(position).getCod());
        holder.binding.homeCodItenLista.setText(String.valueOf(vagasLista.get(position).getCod()));
>>>>>>> unificar2



    }

    @Override
    public int getItemCount() {
        return vagasLista.size();
    }

    public static class listaHomeViewHolder extends RecyclerView.ViewHolder{

        ItensListaHomeBinding binding;

        public listaHomeViewHolder(ItensListaHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
