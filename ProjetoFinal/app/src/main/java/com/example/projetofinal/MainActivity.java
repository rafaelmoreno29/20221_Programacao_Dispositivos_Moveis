package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.projetofinal.adapters.UsuarioAdapter;
import com.example.projetofinal.models.Usuario;
import com.example.projetofinal.services.ListaUsuarioAsync;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Usuario> listaUsuarios;
    RecyclerView usuarioRecycler;
    UsuarioAdapter usuarioAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaUsuarios = new ArrayList<>();
        usuarioRecycler = (RecyclerView) findViewById(R.id.recyclerUsuario);
        progressDialog = new ProgressDialog(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        buscarUsuarios();
    }

    public void buscarUsuarios() {
        new ListaUsuarioAsync("GET",MainActivity.this).execute("api/usuario","");
    }

    public void setListaUsuarios(ArrayList<Usuario> usuarios){
        this.listaUsuarios = usuarios;
    }
    public void setupRecyclerUsuario(){
        LinearLayoutManager layout = new LinearLayoutManager(this);
        usuarioRecycler.setLayoutManager(layout);
        usuarioAdapter = new UsuarioAdapter(listaUsuarios);
        usuarioRecycler.setAdapter(usuarioAdapter);

        usuarioRecycler.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
}