package com.example.app_developer;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataManager {

    private SQLiteDatabase database;
    private CriaBanco dbHelper;

    // Construtor que recebe o contexto da Activity
    public DataManager(Context context) {
        dbHelper = new CriaBanco(context);
    }

    // Abrir o banco de dados
    public void open() {
        database = dbHelper.getWritableDatabase();  // Abre o banco para escrita
    }

    // Fechar o banco de dados
    public void close() {
        dbHelper.close();  // Fecha o banco
    }

    // Método para salvar dados de descrição
    public void saveData(String newText) {
        // Limpar a tabela antes de inserir a nova descrição
        database.delete(CriaBanco.TABLE_NAME, null, null);  // Deleta todas as linhas da tabela

        // Inserir a nova descrição
        ContentValues values = new ContentValues();
        values.put(CriaBanco.COLUMN_TEXT, newText);  // Coloca o novo texto na coluna
        long rowId = database.insert(CriaBanco.TABLE_NAME, null, values);  // Insere a nova descrição na tabela

        // Verifique se a inserção foi bem-sucedida
        if (rowId == -1) {
            // A inserção falhou
            System.out.println("Erro ao salvar a descrição.");
        }
    }

    // Método para salvar dados de atividade
    public void saveAtividade(String newText) {
        // Limpar a tabela antes de inserir a nova atividade
        database.delete(CriaBanco.TABLE_ATIVIDADES, null, null);  // Deleta todas as linhas da tabela

        // Inserir a nova atividade
        ContentValues values = new ContentValues();
        values.put(CriaBanco.COLUMN_ATIVIDADE, newText);  // Coloca o novo texto na coluna
        long rowId = database.insert(CriaBanco.TABLE_ATIVIDADES, null, values);  // Insere a nova atividade na tabela

        // Verifique se a inserção foi bem-sucedida
        if (rowId == -1) {
            // A inserção falhou
            System.out.println("Erro ao salvar a atividade.");
        }
    }

    // Método para salvar dados de atividade
    public void saveDescricaoOng(String newText) {
        // Limpar a tabela antes de inserir a nova atividade
        database.delete(CriaBanco.TABLE_DESCRICAO, null, null);  // Deleta todas as linhas da tabela

        // Inserir a nova atividade
        ContentValues values = new ContentValues();
        values.put(CriaBanco.COLUMN_DESCRICAO, newText);  // Coloca o novo texto na coluna
        long rowId = database.insert(CriaBanco.TABLE_DESCRICAO, null, values);  // Insere a nova atividade na tabela

        // Verifique se a inserção foi bem-sucedida
        if (rowId == -1) {
            // A inserção falhou
            System.out.println("Erro ao salvar a atividade.");
        }
    }
    // Método para salvar dados de vaga (com possibilidade de atualizar)
    public void saveVaga(String titulo, String instituicao, String local, String data,
                         String horario, String requisitos, String descricao, String id) {
        ContentValues values = new ContentValues();
        values.put(CriaBanco.COLUMN_VAGA_TITULO, titulo);
        values.put(CriaBanco.COLUMN_VAGA_INSTITUICAO, instituicao);
        values.put(CriaBanco.COLUMN_VAGA_LOCAL, local);
        values.put(CriaBanco.COLUMN_VAGA_DATA, data);
        values.put(CriaBanco.COLUMN_VAGA_HORARIO, horario);
        values.put(CriaBanco.COLUMN_VAGA_REQUISITOS, requisitos);
        values.put(CriaBanco.COLUMN_VAGA_DESCRICAO, descricao);

        // Verifica se a vaga com o mesmo ID já existe
        int rowsUpdated = database.update(CriaBanco.TABLE_VAGAS, values,
                CriaBanco.COLUMN_VAGA_ID + " = ?", new String[]{id});

        if (rowsUpdated == 0) {
            // Se não houve atualização, significa que não encontrou a vaga com esse ID, então insere
            long result = database.insert(CriaBanco.TABLE_VAGAS, null, values);
            if (result == -1) {
                Log.e("DataManager", "Erro ao salvar a vaga.");
            } else {
                Log.i("DataManager", "Vaga salva com sucesso! ID gerado: " + result);
            }
        } else {
            Log.i("DataManager", "Vaga atualizada com sucesso! Linhas afetadas: " + rowsUpdated);
        }
    }

    // Ler dados da tabela de descrição
    public String readData() {
        String result = "";
        Cursor cursor = database.query(CriaBanco.TABLE_NAME,
                new String[]{CriaBanco.COLUMN_TEXT},
                null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(CriaBanco.COLUMN_TEXT);  // Obtém o índice da coluna
                if (columnIndex != -1) {
                    do {
                        result += cursor.getString(columnIndex) + "\n";  // Adiciona o valor da coluna ao resultado
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();  // Fecha o cursor depois de usar
        }
        return result;
    }

    // Ler dados da tabela de atividades
    public String readAtividade() {
        String resultado = "";
        Cursor cursor2 = database.query(CriaBanco.TABLE_ATIVIDADES,
                new String[]{CriaBanco.COLUMN_ATIVIDADE},
                null, null, null, null, null);

        if (cursor2 != null) {
            if (cursor2.moveToFirst()) {
                int columnIndex = cursor2.getColumnIndex(CriaBanco.COLUMN_ATIVIDADE);  // Obtém o índice da coluna
                if (columnIndex != -1) {
                    do {
                        resultado += cursor2.getString(columnIndex) + "\n";  // Adiciona o valor da coluna ao resultado
                    } while (cursor2.moveToNext());
                }
            }
            cursor2.close();  // Fecha o cursor depois de usar
        }
        return resultado;
    }

    // Ler dados da tabela de descrição ONG
    public String readDescircaoONG() {
        String resultado2 = "";
        Cursor cursor3 = database.query(CriaBanco.TABLE_DESCRICAO,
                new String[]{CriaBanco.COLUMN_DESCRICAO},
                null, null, null, null, null);

        if (cursor3 != null) {
            if (cursor3.moveToFirst()) {
                int columnIndex = cursor3.getColumnIndex(CriaBanco.COLUMN_DESCRICAO);  // Obtém o índice da coluna
                if (columnIndex != -1) {
                    do {
                        resultado2 += cursor3.getString(columnIndex) + "\n";  // Adiciona o valor da coluna ao resultado
                    } while (cursor3.moveToNext());
                }
            }
            cursor3.close();  // Fecha o cursor depois de usar
        }
        return resultado2;
    }

    // Ler dados da tabela de vagas
    @SuppressLint("Range")
    public String[] readVaga() {
        String[] vagaDados = new String[8]; // Array com 8 campos: id, titulo, instituicao, local, data, horario, requisitos, descricao

        // Consulta para pegar uma vaga (aqui usando SQL direto, mas você pode usar qualquer método que retornar um Cursor)
        String query = "SELECT * FROM " + CriaBanco.TABLE_VAGAS + " LIMIT 1";  // Exemplo de consulta SQL
        Cursor cursor = database.rawQuery(query, null);  // Usando a variável correta 'database'

        if (cursor != null && cursor.moveToFirst()) {
            // Preenche o array com os dados da vaga
            vagaDados[0] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_ID));
            vagaDados[1] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_TITULO));
            vagaDados[2] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_INSTITUICAO));
            vagaDados[3] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_LOCAL));
            vagaDados[4] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_DATA));
            vagaDados[5] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_HORARIO));
            vagaDados[6] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_REQUISITOS));
            vagaDados[7] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_DESCRICAO));
        } else {
            Log.e("Cursor", "Erro: Nenhuma vaga encontrada ou erro na consulta SQL");
        }

        cursor.close();
        return vagaDados; // Retorna o array com os dados da vaga
    }

    // Método para ler todas as vagas disponíveis
    @SuppressLint("Range")
    public String[] readAllVagas() {
        String[] vagas = new String[8];  // Array para armazenar os dados da vaga
        String query = "SELECT * FROM " + CriaBanco.TABLE_VAGAS;  // Query para buscar todas as vagas
        Cursor cursor = database.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            int i = 0;
            do {
                vagas[i++] = "ID: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_ID)) +
                        ", Título: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_TITULO)) +
                        ", Instituição: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_INSTITUICAO)) +
                        ", Local: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_LOCAL)) +
                        ", Data: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_DATA)) +
                        ", Horário: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_HORARIO)) +
                        ", Requisitos: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_REQUISITOS)) +
                        ", Descrição: " + cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_DESCRICAO));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return vagas; // Retorna todas as vagas no formato de string
    }
}


