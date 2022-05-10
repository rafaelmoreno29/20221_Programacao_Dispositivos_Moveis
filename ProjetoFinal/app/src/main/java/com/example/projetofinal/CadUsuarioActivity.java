package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.models.Usuario;
import com.example.projetofinal.services.ListaUsuarioAsync;

public class CadUsuarioActivity extends AppCompatActivity {
    int id = 0;
    Usuario usuario;
    TextView txtEmail, txtSenha, txtNome;

    public Usuario getUsuario(){
        return  usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        txtNome = findViewById(R.id.txtNome);
        if(getIntent().hasExtra("id")){
            id = getIntent().getIntExtra("id",0);
            new CadUsuarioAsync("GET",CadUsuarioActivity.this).execute("api/usuario/" +id,"");
        }
    }
    public void carregarCampos(){
        txtNome.setText(usuario.getNome());
        txtSenha.setText(usuario.getSenha());
        txtEmail.setText(usuario.getEmail());
    }
}