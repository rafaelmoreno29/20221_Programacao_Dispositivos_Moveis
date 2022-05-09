package com.example.projetofinal.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.projetofinal.MainActivity;
import com.example.projetofinal.models.Usuario;

public class ListaUsuarioAsync extends AsyncTask<String,String,String> {
    private String metodo;
    ProgressDialog progressDialog;
    Context context;

    public ListaUsuarioAsync(String metodo, Context context){
        this.metodo = metodo;
        this.progressDialog = new ProgressDialog(context);
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Carregando...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(metodo.equals("GET")){
           ((MainActivity)context).setListaUsuarios(Usuario.parseArrayList(s));
            ((MainActivity)context).setupRecyclerUsuario();
        }
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = ServiceApi.getService(strings[0],strings[1]);
        return data;
    }
}
