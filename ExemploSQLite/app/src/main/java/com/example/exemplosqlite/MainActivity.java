package com.example.exemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SqliteDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new SqliteDbHelper(MainActivity.this);
    }
    public void btnLerClick(View view){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //Projeção
        String[] projecao = {
                BaseColumns._ID, SqliteContrato.Anuncio.COLUMN_NAME_TITULO,
                SqliteContrato.Anuncio.COLUMN_NAME_SUBTITULO  };
        //Filtro
        String filtro = SqliteContrato.Anuncio.COLUMN_NAME_TITULO + " = ?";
        String[] valorFiltro = {"Título 1"};
        //Ordenação
        String ordenacao = BaseColumns._ID + " DESC";
        //Executar comando
        Cursor c = db.query(SqliteContrato.Anuncio.TABLE_NAME,
                projecao,filtro,valorFiltro,null,null,ordenacao);
        //Ler registros do banco de dados
        while(c.moveToNext()){
            Log.i("TÍTULO: ",c.getString(c.getColumnIndexOrThrow(
                        SqliteContrato.Anuncio.COLUMN_NAME_TITULO)));
        }
        c.close();
    }

    public void btnExcluir(View v){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String filtro = BaseColumns._ID + " = ?";
        String[] valorFiltro = {"2"};
        int qtdeLinhasExcluidas = db.delete(SqliteContrato.Anuncio.TABLE_NAME,
                                                            filtro,valorFiltro);
        Log.i("QTDE EXCLUÍDO","" + qtdeLinhasExcluidas);
    }
    public void btnEditar(View v){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String titulo = "Novo titulo";
        ContentValues values = new ContentValues();
        values.put(SqliteContrato.Anuncio.COLUMN_NAME_TITULO,titulo);

        //FILTRO
        String filtro = BaseColumns._ID + " = ?";
        String[] valorFiltro = {"1"};
        int qtde = db.update(SqliteContrato.Anuncio.TABLE_NAME,values,filtro,valorFiltro);
        Log.i("Qtde editado",""+qtde);
    }

    public void btnAdicionarClick(View v){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SqliteContrato.Anuncio.COLUMN_NAME_TITULO,"Título 1");
        values.put(SqliteContrato.Anuncio.COLUMN_NAME_SUBTITULO, "SubTítulo 1");

        long newID = db.insert(SqliteContrato.Anuncio.TABLE_NAME,null,values);
        Log.i("ID GERADO: ", newID+"");
    }
}