package com.example.app_developer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
}
