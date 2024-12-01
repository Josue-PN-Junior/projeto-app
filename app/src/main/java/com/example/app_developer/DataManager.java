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
        if (database != null && database.isOpen()) {
            database.close();
        }
        dbHelper.close();  // Fecha o banco de dados helper
    }

    // Método genérico para salvar dados em qualquer tabela
    private boolean saveDataInTable(String tableName, String columnName, String newText) {
        try {
            // Limpar a tabela antes de inserir a nova descrição
            database.delete(tableName, null, null);  // Deleta todas as linhas da tabela

            // Inserir a nova descrição
            ContentValues values = new ContentValues();
            values.put(columnName, newText);  // Coloca o novo texto na coluna
            long rowId = database.insert(tableName, null, values);  // Insere a nova descrição na tabela

            // Verifique se a inserção foi bem-sucedida
            return rowId != -1;
        } catch (Exception e) {
            Log.e("DataManager", "Erro ao salvar dados na tabela " + tableName, e);
            return false;
        }
    }

    // Métodos para salvar dados nas tabelas específicas
    public boolean saveData(String newText) {
        return saveDataInTable(CriaBanco.TABLE_NAME, CriaBanco.COLUMN_TEXT, newText);
    }

    public boolean saveAtividade(String newText) {
        return saveDataInTable(CriaBanco.TABLE_ATIVIDADES, CriaBanco.COLUMN_ATIVIDADE, newText);
    }

    public boolean saveDescricaoOng(String newText) {
        return saveDataInTable(CriaBanco.TABLE_DESCRICAO, CriaBanco.COLUMN_DESCRICAO, newText);
    }

    // Método para salvar dados de vaga (com possibilidade de atualizar)
    public boolean saveVaga(String titulo, String instituicao, String local, String data,
                            String horario, String requisitos, String descricao, String id) {
        try {
            ContentValues values = new ContentValues();
            values.put(CriaBanco.COLUMN_VAGA_TITULO, titulo);
            values.put(CriaBanco.COLUMN_VAGA_INSTITUICAO, instituicao);
            values.put(CriaBanco.COLUMN_VAGA_LOCAL, local);
            values.put(CriaBanco.COLUMN_VAGA_DATA, data);
            values.put(CriaBanco.COLUMN_VAGA_HORARIO, horario);
            values.put(CriaBanco.COLUMN_VAGA_REQUISITOS, requisitos);
            values.put(CriaBanco.COLUMN_VAGA_DESCRICAO, descricao);
            values.put(CriaBanco.COLUMN_VAGA_ID, id);

            // Verifica se a vaga com o mesmo ID já existe
            int rowsUpdated = database.update(CriaBanco.TABLE_VAGAS, values,
                    CriaBanco.COLUMN_VAGA_ID + " = ?", new String[]{id});

            if (rowsUpdated == 0) {
                // Se não houve atualização, significa que não encontrou a vaga com esse ID, então insere
                long result = database.insert(CriaBanco.TABLE_VAGAS, null, values);
                if (result == -1) {
                    Log.e("DataManager", "Erro ao salvar a vaga.");
                    return false;
                } else {
                    Log.i("DataManager", "Vaga salva com sucesso! ID gerado: " + result);
                    return true;
                }
            } else {
                Log.i("DataManager", "Vaga atualizada com sucesso! Linhas afetadas: " + rowsUpdated);
                return true;
            }
        } catch (Exception e) {
            Log.e("DataManager", "Erro ao salvar ou atualizar a vaga", e);
            return false;
        }
    }

    // Ler dados da tabela de descrição
    public String readData() {
        return readDataFromTable(CriaBanco.TABLE_NAME, CriaBanco.COLUMN_TEXT);
    }

    // Ler dados da tabela de atividades
    public String readAtividade() {
        return readDataFromTable(CriaBanco.TABLE_ATIVIDADES, CriaBanco.COLUMN_ATIVIDADE);
    }

    // Ler dados da tabela de descrição ONG
    public String readDescircaoONG() {
        return readDataFromTable(CriaBanco.TABLE_DESCRICAO, CriaBanco.COLUMN_DESCRICAO);
    }

    // Método genérico para ler dados de qualquer tabela
    private String readDataFromTable(String tableName, String columnName) {
        StringBuilder result = new StringBuilder();
        Cursor cursor = null;
        try {
            cursor = database.query(tableName, new String[]{columnName}, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(columnName);  // Obtém o índice da coluna
                if (columnIndex != -1) {
                    do {
                        result.append(cursor.getString(columnIndex)).append("\n");  // Adiciona o valor da coluna ao resultado
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            Log.e("DataManager", "Erro ao ler dados da tabela " + tableName, e);
        } finally {
            if (cursor != null) cursor.close();  // Fecha o cursor depois de usar
        }
        return result.toString();
    }

    // Ler dados da tabela de vagas
    @SuppressLint("Range")
    public String[] readVaga() {
        String[] vagaDados = new String[8]; // Array com 8 campos: id, titulo, instituicao, local, data, horario, requisitos, descricao

        String query = "SELECT * FROM " + CriaBanco.TABLE_VAGAS + " LIMIT 1";  // Exemplo de consulta SQL
        Cursor cursor = null;
        try {
            cursor = database.rawQuery(query, null);  // Usando a variável correta 'database'

            if (cursor != null && cursor.moveToFirst()) {
                vagaDados[0] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_ID));
                vagaDados[1] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_TITULO));
                vagaDados[2] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_INSTITUICAO));
                vagaDados[3] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_LOCAL));
                vagaDados[4] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_DATA));
                vagaDados[5] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_HORARIO));
                vagaDados[6] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_REQUISITOS));
                vagaDados[7] = cursor.getString(cursor.getColumnIndex(CriaBanco.COLUMN_VAGA_DESCRICAO));
            }
        } catch (Exception e) {
            Log.e("DataManager", "Erro ao ler dados da vaga", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return vagaDados;  // Retorna o array com os dados da vaga
    }

    // Método para ler todas as vagas disponíveis
    @SuppressLint("Range")
    public String[] readAllVagas() {
        String[] vagas = new String[8];  // Array para armazenar os dados da vaga
        String query = "SELECT * FROM " + CriaBanco.TABLE_VAGAS;  // Query para buscar todas as vagas
        Cursor cursor = null;

        try {
            cursor = database.rawQuery(query, null);

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
        } catch (Exception e) {
            Log.e("DataManager", "Erro ao ler todas as vagas", e);
        } finally {
            if (cursor != null) cursor.close();
        }

        return vagas; // Retorna todas as vagas no formato de string
    }
}
