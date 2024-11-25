package com.example.app_developer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_developer.modelo.vagasHome;

import java.util.ArrayList;

public class BancoController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public BancoController(Context context) {
        banco = new BancoDeDados(context);
    }

    public String gravarUsuario(String _Nome, String _Sobrenome, String _Email, String _CPF, String _Telefone, String _Senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("cpf", _CPF);
        valores.put("nome", _Nome);
        valores.put("sobrenome", _Sobrenome);
        valores.put("email", _Email);
        valores.put("telefone", _Telefone);
        valores.put("senha", _Senha);
        valores.put("ativo", 1);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1) {
          return "0";
        } else {
            return "1";
        }

    }

    public Cursor PesquisarLogin(String _email, String _senha) {
        Cursor cursor;
        String[] campos = {"cpf", "nome", "email", "senha"};
        String where = "email = '" + _email + "' and senha = '" + _senha + "' and ativo = 1";
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String PesquisarCpf(String _email) {
        String cpf = null; // Variável para armazenar o CPF
        String[] campos = {"cpf"};
        String where = "email = ? AND ativo = 1";
        String[] whereArgs = {_email};

        db = banco.getReadableDatabase();
        Cursor cursor = db.query("usuarios", campos, where, whereArgs, null, null, null);

        // Verifica se o cursor tem resultado
        if (cursor != null && cursor.moveToFirst()) {
            cpf = cursor.getString(cursor.getColumnIndexOrThrow("cpf")); // Obtém o valor do CPF
        }

        // Fecha o cursor e o banco de dados
        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return cpf; // Retorna o CPF ou null caso não encontrado
    }

    public ArrayList<vagasHome> getVagasRecem(int limite) {
        ArrayList<vagasHome> vagasRecem = new ArrayList<>();
        SQLiteDatabase db = banco.getReadableDatabase();

        // query / busca
        String query = "SELECT * FROM vagas ORDER BY data DESC LIMIT " + limite;

        Cursor cursor = db.rawQuery(query, null);

       // pesquisa
       if (cursor.moveToFirst()){
           do {
               String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
               int codOng = cursor.getInt(cursor.getColumnIndexOrThrow("ongCnpj"));
               String ong = getNomeOngVaga(codOng);
               String atividade = cursor.getString(cursor.getColumnIndexOrThrow("atividade"));
               String local = cursor.getString(cursor.getColumnIndexOrThrow("local"));
               int cod = cursor.getInt(cursor.getColumnIndexOrThrow("codVaga"));

           } while (cursor.moveToNext());
       }
       cursor.close();
       db.close();

       return vagasRecem;
    }

    public String getNomeOngVaga(int codVaga) {
        SQLiteDatabase db = banco.getReadableDatabase();
        String nomeOng = null;

        // Consulta SQL
        String query = "SELECT ongs.nome " +
                "FROM ongs " +
                "JOIN vagas ON vagas.ongCnpj = ongs.cpnj " +
                "WHERE vagas.codVaga = ?;";

        // Executa a consulta com o código da vaga como parâmetro
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(codVaga)});

        // Verifica se há resultados e recupera o nome
        if (cursor.moveToFirst()) {
            nomeOng = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
        }
        cursor.close(); // Fecha o cursor após o uso
        db.close(); // Fecha o banco de dados
        return nomeOng;
    }


}
