package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqliteDbHelper dbHelper = new SqliteDbHelper(MainActivity.this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( SqlLiteContract.Noticia.COLUMN_NAME_TITULO, "teste");
        values.put(SqlLiteContract.Noticia.COLUMN_NAME_SUBTITULO, "sub teste");
        long newRowId = db.insert(SqlLiteContract.Noticia.TABLE_NAME, null, values);


        SQLiteDatabase dbReader = dbHelper.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                SqlLiteContract.Noticia.COLUMN_NAME_TITULO,
                SqlLiteContract.Noticia.COLUMN_NAME_SUBTITULO };

        String selection = SqlLiteContract.Noticia.COLUMN_NAME_TITULO + " = ?";
        String[] selectionArgs = { "teste" };

        String sortOrder = SqlLiteContract.Noticia.COLUMN_NAME_SUBTITULO + " DESC";
        Cursor cursor = db.query(SqlLiteContract.Noticia.TABLE_NAME,  projection, selection,  selectionArgs,  null, null,  sortOrder);

        List itemIds = new ArrayList();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(SqlLiteContract.Noticia._ID));
            itemIds.add(itemId);
            Log.i("ID",""+cursor.getLong(cursor.getColumnIndexOrThrow(SqlLiteContract.Noticia._ID)));
            Log.i("nome",""+cursor.getString(cursor.getColumnIndexOrThrow(SqlLiteContract.Noticia.COLUMN_NAME_TITULO)));

        }
        cursor.close();
    }
}