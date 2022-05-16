package com.example.projetofinal.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.projetofinal.CadUsuarioActivity;
import com.example.projetofinal.MainActivity;
import com.example.projetofinal.models.Usuario;

public class CadUsuarioAsync extends AsyncTask<String,String,String> {
    private String metodo;
    ProgressDialog progressDialog;
    Context context;

    public CadUsuarioAsync(String metodo, Context context){
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
            ((CadUsuarioActivity)context).setUsuario(Usuario.parseObject(s));
            ((CadUsuarioActivity)context).carregarCampos();
            progressDialog.dismiss();
        }

    }
    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        if(metodo.equals("GET"))
            data = ServiceApi.getService(strings[0],strings[1]);

        return data;
    }
}
