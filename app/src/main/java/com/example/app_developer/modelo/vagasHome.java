package com.example.app_developer.modelo;

public class vagasHome  {
    public String titulo_vaga, cod_ong ,ong_vaga, atividade, local;
    int cod;

    // construtor

    public vagasHome(String titulo_vaga, String cod_ong, String ong_vaga, String atividade, String local, int cod) {
        this.titulo_vaga = titulo_vaga;
        this.cod_ong = cod_ong;
        this.ong_vaga = ong_vaga;
        this.atividade = atividade;
        this.local = local;
        this.cod = cod;
    }


//    public vagasHome(String titulo_vaga, String ong_vaga, String atividade, String local, int cod) {
//        this.titulo_vaga = titulo_vaga;
//        this.ong_vaga = ong_vaga;
//        this.atividade = atividade;
//        this.local = local;
//        this.cod = cod;
//    }

    // gets e sets
    public String getCod_ong() {
        return cod_ong;
    }

    public void setCod_ong(String cod_ong) {
        this.cod_ong = cod_ong;
    }

    public String getTitulo_vaga() {
        return titulo_vaga;
    }

    public void setTitulo_vaga(String titulo_vaga) {
        this.titulo_vaga = titulo_vaga;
    }

    public String getOng_vaga() {
        return ong_vaga;
    }

    public void setOng_vaga(String ong_vaga) {
        this.ong_vaga = ong_vaga;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }


}
