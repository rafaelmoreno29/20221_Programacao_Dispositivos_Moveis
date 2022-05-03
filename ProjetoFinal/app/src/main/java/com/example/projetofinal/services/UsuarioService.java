package com.example.projetofinal.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class UsuarioService extends AsyncTask<String,String,String> {
    private String metodo;
    ProgressDialog progressDialog;
    Context context;

    public UsuarioService(String metodo, Context context){
        this.metodo = metodo;
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
