package com.example.exemploapi.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemploapi.R;
import com.example.exemploapi.holders.UsuarioHolder;
import com.example.exemploapi.models.Usuario;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder> {
    private final ArrayList<Usuario> usuarios;

    public UsuarioAdapter(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsuarioHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listagem_usuario,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHolder holder, int position) {
        holder.txtNome.setText(usuarios.get(position).getNome());
        holder.txtEmail.setText(usuarios.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return usuarios != null ? usuarios.size() : 0;
    }
}