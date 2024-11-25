package com.example.app_developer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper {
    private static final String BancoApp = "Banco_app_local";
    private static final int VERSAO = 1;
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
                //+ "foto BLOB, " // !!!!!!!!!!
                //+ "foto text, " // UM DOS DOIS
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
                //+ "descricao TEXT, " // !!!!!!!!!!!1
                //+ "foto BLOB, "      // UM DOS DOIS
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
