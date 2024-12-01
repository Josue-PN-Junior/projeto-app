package com.example.app_developer;

public class Vaga {

    private String titulo;
    private String instituicao;
    private String local;
    private String data;
    private String horario;
    private String requisitos;
    private String detalhamento;
    private String idvaga;

    // Construtor
    public Vaga(String titulo, String instituicao, String local, String data, String horario, String requisitos, String detalhamento, String idvaga) {
        this.titulo = titulo;
        this.instituicao = instituicao;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.requisitos = requisitos;
        this.detalhamento = detalhamento;
        this.idvaga = idvaga;
    }

    // Métodos getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public String getIdvaga() {
        return idvaga;
    }

    public void setIdvaga(String idvaga) {
        this.idvaga = idvaga;
    }
}
