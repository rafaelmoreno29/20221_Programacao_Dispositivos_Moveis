package com.example.exemploapi.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.exemploapi.MainActivity;
import com.example.exemploapi.models.Usuario;

public class UsuarioService extends AsyncTask<String,String,String> {
    private String metodo;
    ProgressDialog progressDialog;
    Context context;

    public UsuarioService(String metodo, Context context) {
        this.metodo = metodo;
        this.progressDialog = new ProgressDialog(context);
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Aguarde", "Por favor aguarde...");
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = ServiceApi.getService(strings[0], metodo, strings[1]);
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (metodo == "GET") {
            ((MainActivity) context).setListaUsuarios(Usuario.parseArrayList(s));
            ((MainActivity) context).setupRecyclerUsuario();
            progressDialog.dismiss();
        } else if (s == "OK") {
            Toast.makeText(context, "Operação realizada com sucesso", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
            ((MainActivity) context).buscarUsuarios();
        }
    }
}