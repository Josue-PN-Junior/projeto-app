package com.example.app_developer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "perfil_voluntario.db";
    private static final int DATABASE_VERSION = 2;

    // Tabela de atividades realizadas
    public static final String TABLE_ATIVIDADES = "atividades_realizadas";
    public static final String COLUMN_ATIVIDADE = "atividade_text";

    // Tabela de descrições
    public static final String TABLE_NAME = "descricao";
    public static final String COLUMN_TEXT = "descricao_text";

    public CriaBanco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da tabela de descrições
        String CREATE_TABELA_DESCRICAO = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_TEXT + " TEXT);";
        db.execSQL(CREATE_TABELA_DESCRICAO);  // Criação da tabela de descrições

        // Criação da tabela de atividades realizadas
        String CREATE_TABELA_ATIVIDADES = "CREATE TABLE " + TABLE_ATIVIDADES + " (" +
                COLUMN_ATIVIDADE + " TEXT);";
        db.execSQL(CREATE_TABELA_ATIVIDADES);  // Criação da tabela de atividades
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Apaga as tabelas se elas já existirem e recria
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATIVIDADES);
        onCreate(db);
    }
}
