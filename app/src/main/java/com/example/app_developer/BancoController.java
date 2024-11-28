package com.example.app_developer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        String cpf = null;
        SQLiteDatabase db = banco.getReadableDatabase();
        String query = "SELECT cpf FROM usuarios WHERE email = ? AND ativo = 1";

        Cursor cursor = db.rawQuery(query, new String[]{_email});
        if (cursor != null && cursor.moveToFirst()) {
            cpf = cursor.getString(cursor.getColumnIndexOrThrow("cpf"));
        }

        cursor.close();
        db.close();
        return cpf;
    }
    public String getNomeOngVaga(String codVaga) {
        SQLiteDatabase db = banco.getReadableDatabase();
        String nomeOng = null;

        // Verificando o valor de ongCnpj associado à vaga
        Cursor cursorVagas = db.rawQuery("SELECT ongCnpj FROM vagas WHERE codVaga = ?", new String[]{codVaga});
        if (cursorVagas.moveToFirst()) {
            String ongCnpj = cursorVagas.getString(cursorVagas.getColumnIndex("ongCnpj"));
            Log.d("BancoController", "CNPJ da ONG associado à vaga: " + ongCnpj);
        } else {
            Log.d("BancoController", "Nenhuma vaga encontrada com codVaga: " + codVaga);
        }
        cursorVagas.close();

        // Consulta SQL para obter o nome da ONG
        String query = "SELECT nome "
                + "FROM ongs "
                + "WHERE cpnj = ?;";

        Cursor cursor = db.rawQuery(query, new String[]{codVaga});  // Passando o código da vaga como parâmetro

        if (cursor.moveToFirst()) {
            nomeOng = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            Log.d("BancoController", "Nome da ONG encontrado: " + nomeOng);
        } else {
            Log.d("BancoController", "Nenhuma ONG encontrada para a vaga: " + codVaga);
        }

        cursor.close(); // Fecha o cursor após o uso
        db.close(); // Fecha o banco de dados

        Log.d("BancoController", "Nome da ONG retornado: " + nomeOng);
        return nomeOng;
    }

//    public ArrayList<vagasHome> getVagasCadastradas(String _cpf, int limite) {
//        ArrayList<vagasHome> vagasCad = new ArrayList<>();
//        String vaga = null;
//        SQLiteDatabase db = banco.getReadableDatabase();
//        String query = "SELECT codVaga FROM inscricoes WHERE cpf = ? AND ativo = 1";
//
//        Cursor cursor = db.rawQuery(query, new String[]{_cpf});
//        if (cursor != null && cursor.moveToFirst()) {
//            vaga = cursor.getString(cursor.getColumnIndexOrThrow("codVaga"));
//        }
//
//        cursor.close();
//        db.close();
//        String where = "cpf = '" + _cpf + "' and codVaga = '" + vaga + "' and ativo = 1";
//        String[] campos = {"codVaga", "nome", "atividade", "local", "data", "ongCnpj"};
//        String limit = String.valueOf(limite);
//        cursor = db.query("inscricoes", campos, where, null, null, null, "data DESC", limit);
//
//        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
//                String codOng = cursor.getString(cursor.getColumnIndexOrThrow("ongCnpj"));
//                String ong = getNomeOngVaga(codOng);
//                String atividade = cursor.getString(cursor.getColumnIndexOrThrow("atividade"));
//                String local = cursor.getString(cursor.getColumnIndexOrThrow("local"));
//                int cod = cursor.getInt(cursor.getColumnIndexOrThrow("codVaga"));
//
//                vagasHome vagas = new vagasHome(nome, codOng, ong, atividade, local, cod);
//
//                // Adiciona a vaga à lista
//                vagasCad.add(vagas);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//
//        return vagasCad;
//    }

    public ArrayList<vagasHome> getVagasCadastradas(String _cpf, int limite) {
        ArrayList<vagasHome> vagasCad = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = banco.getReadableDatabase();

            // Consulta para obter os códigos das vagas em "inscricoes"
            String queryInscricoes = "SELECT codVaga FROM inscricoes WHERE cpf = ? AND ativo = 1";
            cursor = db.rawQuery(queryInscricoes, new String[]{_cpf});

            // Lista para armazenar os códigos das vagas
            ArrayList<String> codigosVagas = new ArrayList<>();
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    codigosVagas.add(cursor.getString(cursor.getColumnIndexOrThrow("codVaga")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            // Monta a cláusula WHERE para buscar os detalhes das vagas
            if (!codigosVagas.isEmpty()) {
                String wherePlaceholders = new String(new char[codigosVagas.size()]).replace("\0", "?, ").trim();
                wherePlaceholders = wherePlaceholders.substring(0, wherePlaceholders.length() - 1); // Remove última vírgula
                String queryVagas = "SELECT codVaga, nome, atividade, local, data, ongCnpj " +
                        "FROM vagas " +
                        "WHERE codVaga IN (" + wherePlaceholders + ") AND ativo = 1 " +
                        "ORDER BY data DESC LIMIT ?";

                // Prepara os argumentos para a consulta
                String[] whereArgs = new String[codigosVagas.size() + 1];
                for (int i = 0; i < codigosVagas.size(); i++) {
                    whereArgs[i] = codigosVagas.get(i);
                }
                whereArgs[whereArgs.length - 1] = String.valueOf(limite);

                // Executa a consulta para buscar os detalhes das vagas
                cursor = db.rawQuery(queryVagas, whereArgs);

                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        // Coleta os dados das vagas
                        String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                        String codOng = cursor.getString(cursor.getColumnIndexOrThrow("ongCnpj"));
                        String ong = getNomeOngVaga(codOng); // Função para obter o nome da ONG
                        String atividade = cursor.getString(cursor.getColumnIndexOrThrow("atividade"));
                        String local = cursor.getString(cursor.getColumnIndexOrThrow("local"));
                        int cod = cursor.getInt(cursor.getColumnIndexOrThrow("codVaga"));

                        // Cria o objeto e adiciona à lista
                        vagasHome vaga = new vagasHome(nome, codOng, ong, atividade, local, cod);
                        vagasCad.add(vaga);
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log para diagnóstico de erros
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return vagasCad;
    }



    public ArrayList<vagasHome> getVagasRecem(int limite) {
        ArrayList<vagasHome> vagasRecem = new ArrayList<>();
        SQLiteDatabase db = banco.getReadableDatabase();
;
        // Log para verificar se estamos chegando até a consulta
        Log.d("BancoController", "Executando a consulta para obter vagas");

        // query / busca
        String[] campos = {"codVaga", "nome", "atividade", "local", "data", "ongCnpj"};
        String limit = String.valueOf(limite);
        Cursor cursor = db.query("vagas", campos, null, null, null, null, "data DESC", limit);

        // Verificar se o cursor contém dados
        if (cursor != null) {
            Log.d("BancoController", "Cursor retornou resultados: " + cursor.getCount());
        } else {
            Log.d("BancoController", "Cursor está vazio");
        }

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                String codOng = cursor.getString(cursor.getColumnIndexOrThrow("ongCnpj"));
                String ong = getNomeOngVaga(codOng);
                String atividade = cursor.getString(cursor.getColumnIndexOrThrow("atividade"));
                String local = cursor.getString(cursor.getColumnIndexOrThrow("local"));
                int cod = cursor.getInt(cursor.getColumnIndexOrThrow("codVaga"));

                Log.d("BancoController", "Vaga encontrada: " + nome); // Log da vaga encontrada

                vagasHome vaga = new vagasHome(nome, codOng, ong, atividade, local, cod);

                // Adiciona a vaga à lista
                vagasRecem.add(vaga);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // Verificando o tamanho da lista após a consulta
        Log.d("BancoController", "Total de vagas recuperadas: " + vagasRecem.size());
        return vagasRecem;
    }

    public void setDadosBancoOng(String _cpnj, String _nome, String _local, String _telefone, String _senha) {
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cpnj", _cpnj);
        values.put("nome", _nome);
        values.put("local", _local);
        values.put("telefone", _telefone);
        values.put("senha", _senha);
        values.put("ativo", 1);

        db.insert("ongs", null, values);
        db.close();
    }

    public void setDadosBancoVaga(String _codVaga, String _nome, String _atividade, String _local, String _data, String _requisitos, String _descricao, String _ongCnpj) {
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("codVaga", _codVaga);
        values.put("nome", _nome);
        values.put("atividade", _atividade);
        values.put("local", _local);
        values.put("data", _data);
        values.put("requisitos", _requisitos);
        values.put("descricao", _descricao);
        values.put("ativo", 1);
        values.put("ongCnpj", _ongCnpj);

        db.insert("vagas", null, values);
        db.close();
    }



}
