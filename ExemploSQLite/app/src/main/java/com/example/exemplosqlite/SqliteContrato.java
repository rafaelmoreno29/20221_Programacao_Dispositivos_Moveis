package com.example.exemplosqlite;

import android.provider.BaseColumns;

public final class SqliteContrato {
    private SqliteContrato(){}

    public static class Anuncio implements BaseColumns{
        public static final String TABLE_NAME = "anuncio";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_SUBTITULO = "subtitulo";

        public static final String SQL_CREATE_ANUNCIO =
                "CREATE TABLE " + TABLE_NAME + " ( "+
                        Anuncio._ID + " INTEGER PRIMARY KEY, "+
                        COLUMN_NAME_TITULO + " TEXT, " +
                        COLUMN_NAME_SUBTITULO + " TEXT)";
        public static final String SQL_DROP_ANUNCIO =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
