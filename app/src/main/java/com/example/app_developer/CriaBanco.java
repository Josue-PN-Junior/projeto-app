package com.example.app_developer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "perfil.db";
    private static final int DATABASE_VERSION = 3;  // Atualizei a versão para 3, pois provavelmente você já está na versão 2

    // Tabelas existentes
    public static final String TABLE_ATIVIDADES = "atividades_realizadas";
    public static final String COLUMN_ATIVIDADE = "atividade_text";
    public static final String TABLE_NAME = "descricao";
    public static final String COLUMN_TEXT = "descricao_text";
    public static final String TABLE_DESCRICAO = "descricaoONG";
    public static final String COLUMN_DESCRICAO = "descricao_textONG";

    // Tabela nova de Vagas
    public static final String TABLE_VAGAS = "vagas";
    public static final String COLUMN_VAGA_ID = "id_vaga";
    public static final String COLUMN_VAGA_TITULO = "titulo_vaga";
    public static final String COLUMN_VAGA_INSTITUICAO = "instituicao_vaga";
    public static final String COLUMN_VAGA_LOCAL = "local_vaga";
    public static final String COLUMN_VAGA_DATA = "data_vaga";
    public static final String COLUMN_VAGA_HORARIO = "horario_vaga";
    public static final String COLUMN_VAGA_REQUISITOS = "requisitos_vaga";
    public static final String COLUMN_VAGA_DESCRICAO = "descricao_vaga";

    public CriaBanco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da tabela de descrições
        String CREATE_TABELA_DESCRICAO = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_TEXT + " TEXT);";
        db.execSQL(CREATE_TABELA_DESCRICAO);

        // Criação da tabela de atividades realizadas
        String CREATE_TABELA_ATIVIDADES = "CREATE TABLE " + TABLE_ATIVIDADES + " (" +
                COLUMN_ATIVIDADE + " TEXT);";
        db.execSQL(CREATE_TABELA_ATIVIDADES);

        // Criação da tabela de descrição ONG
        String CREATE_TABELA_DESCRICAOONG = "CREATE TABLE " + TABLE_DESCRICAO + " (" +
                COLUMN_DESCRICAO + " TEXT);";
        db.execSQL(CREATE_TABELA_DESCRICAOONG);

        // Criação da nova tabela de Vagas
        String CREATE_TABELA_VAGAS = "CREATE TABLE " + TABLE_VAGAS + " (" +
                COLUMN_VAGA_ID + " TEXT PRIMARY KEY, " + // ID de texto
                COLUMN_VAGA_TITULO + " TEXT, " +
                COLUMN_VAGA_INSTITUICAO + " TEXT, " +
                COLUMN_VAGA_LOCAL + " TEXT, " +
                COLUMN_VAGA_DATA + " TEXT, " +
                COLUMN_VAGA_HORARIO + " TEXT, " +
                COLUMN_VAGA_REQUISITOS + " TEXT, " +
                COLUMN_VAGA_DESCRICAO + " TEXT);";
        db.execSQL(CREATE_TABELA_VAGAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualizar o banco de dados se a versão for alterada
        if (oldVersion < 3) {
            // Se a versão do banco de dados for anterior à versão 3, criamos a nova tabela de Vagas
            String CREATE_TABELA_VAGAS = "CREATE TABLE " + TABLE_VAGAS + " (" +
                    COLUMN_VAGA_ID + " TEXT PRIMARY KEY, " +
                    COLUMN_VAGA_TITULO + " TEXT, " +
                    COLUMN_VAGA_INSTITUICAO + " TEXT, " +
                    COLUMN_VAGA_LOCAL + " TEXT, " +
                    COLUMN_VAGA_DATA + " TEXT, " +
                    COLUMN_VAGA_HORARIO + " TEXT, " +
                    COLUMN_VAGA_REQUISITOS + " TEXT, " +
                    COLUMN_VAGA_DESCRICAO + " TEXT);";
            db.execSQL(CREATE_TABELA_VAGAS);
        }
    }
}
