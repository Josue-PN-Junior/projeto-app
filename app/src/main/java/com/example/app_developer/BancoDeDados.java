package com.example.app_developer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper {
    private static final String BancoApp = "Banco_app_local";
    private static final int VERSAO = 11;
    public BancoDeDados(Context context) {
        super(context, BancoApp, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        // Tabelas Usuários
        String sql = "CREATE TABLE usuarios ("
                + "cpf TEXT PRIMARY KEY, "
                + "nome TEXT NOT NULL, "
                + "sobrenome TEXT NOT NULL, "
                + "email TEXT NOT NULL, "
                + "telefone TEXT, "
                + "foto text, " // UM DOS DOIS
                + "descricao TEXT, "
                + "ativo INTEGER NOT NULL DEFAULT 0, "
                + "senha TEXT NOT NULL, "
                + "UNIQUE(email) "
                + ");";
        dataBase.execSQL(sql);

        // Tabelas ONGs
        sql = "CREATE TABLE ongs ("
                + "cpnj TEXT PRIMARY KEY, "
                + "nome TEXT NOT NULL, "
                + "local TEXT, "
                + "telefone TEXT, "
                + "descricao TEXT, " // !!!!!!!!!!!1
                + "foto TEXT, "
                + "senha TEXT NOT NULL, "
                + "ativo INTEGER NOT NULL DEFAULT 0 "
                + ");";
        dataBase.execSQL(sql);

        // Tabelas Vagas
        sql = "CREATE TABLE vagas ("
                + "codVaga INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "atividade TEXT, "
                + "local TEXT, "
                + "data TEXT NOT NULL, "
                + "requisitos TEXT, "
                + "descricao TEXT, "
                + "ativo INTEGER NOT NULL DEFAULT 0, "
                + "ongCnpj TEXT NOT NULL, "
                + "FOREIGN KEY (ongCnpj) REFERENCES ongs (cnpj) "
                + "ON DELETE CASCADE ON UPDATE CASCADE"
                + ");";
        dataBase.execSQL(sql);

        // Tabelas Inscrições
        sql = "CREATE TABLE inscricoes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "codVaga INTEGER NOT NULL, "
                + "cpf TEXT NOT NULL, "
                + "ativo INTEGER NOT NULL DEFAULT 0, "
                + "FOREIGN KEY (cpf) REFERENCES usuarios (cpf) "
                + "ON DELETE CASCADE ON UPDATE CASCADE, "
                + "FOREIGN KEY (codVaga) REFERENCES vagas (codVaga) "
                + "ON DELETE CASCADE ON UPDATE CASCADE"
                + ");";
        dataBase.execSQL(sql);
        popularBancoDeDados(dataBase);

    }

    public void popularBancoDeDados(SQLiteDatabase dataBase) {
        // Inserir dados na tabela usuarios
        String sqlUsuarios = "INSERT INTO usuarios (cpf, nome, sobrenome, email, telefone, descricao, ativo, senha) VALUES "
                + "('12345678900', 'João', 'Silva', 'joao.silva@email.com', '11987654321', 'Usuário ativo', 1, 'senha123'), "
                + "('12345678999', 'Juca', 'Silva', 'juca@teste', '11987654328', 'Usuário ativo', 1, '123'), "
                + "('98765432100', 'Maria', 'Oliveira', 'maria.oliveira@email.com', '11976543210', 'Usuário inativo', 0, 'senha456');";
        dataBase.execSQL(sqlUsuarios);

        // Inserir dados na tabela ongs
        String sqlOngs = "INSERT INTO ongs (cpnj, nome, local, telefone, senha, ativo) VALUES "
                + "('12345678000195', 'Ong Esperança', 'São Paulo', '1132345678', 'senha123', 1), "
                + "('98765432000187', 'Ong Futuro', 'Rio de Janeiro', '2198765432', 'senha456', 1);";
        dataBase.execSQL(sqlOngs);

        // Inserir dados na tabela vagas
        String sqlVagas = "INSERT INTO vagas (nome, atividade, local, data, requisitos, descricao, ativo, ongCnpj) VALUES "
                + "('Vaga 1', 'Assistente de Projetos', 'São Paulo', '2024-11-26', 'Experiência em gestão de projetos', 'Ajudar na coordenação de projetos sociais', 1, '12345678000195'), "
                + "('Vaga 2', 'Voluntário de Ensino', 'Rio de Janeiro', '2024-11-27', 'Disponibilidade de tempo', 'Ajudar a ensinar crianças em situação de risco', 1, '98765432000187');";
        dataBase.execSQL(sqlVagas);

        // Inserir dados na tabela inscricoes
        String sqlInscricoes = "INSERT INTO inscricoes (codVaga, cpf, ativo) VALUES "
                + "(1, '12345678900', 1), "
                + "(1, '12345678999', 1), "
                + "(2, '98765432100', 0);";
        dataBase.execSQL(sqlInscricoes);
    }


    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int oldVersao, int newVersao) {
        dataBase.execSQL("DROP TABLE IF EXISTS usuarios");
        dataBase.execSQL("DROP TABLE IF EXISTS ongs ");
        dataBase.execSQL("DROP TABLE IF EXISTS vagas ");
        dataBase.execSQL("DROP TABLE IF EXISTS inscricoes");
        onCreate(dataBase);
    }
}