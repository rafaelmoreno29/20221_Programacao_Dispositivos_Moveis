package com.example.exemploapi.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {
    private int Id;
    private String Nome;
    private String Email;
    private String Senha;

    public Usuario(int id, String nome, String email, String senha) {
        Id = id;
        Nome = nome;
        Email = email;
        Senha = senha;
    }

    public Usuario() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public static ArrayList<Usuario> parseArrayList(String json){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Usuario usuario = new Usuario();
                JSONObject obj = array.getJSONObject(i);
                usuario.setNome(obj.getString("nome"));
                usuario.setEmail(obj.getString("email"));
              //  usuario.setSenha(obj.getString("senha"));
              //  usuario.setId(obj.getInt("id"));
                usuarios.add(usuario);
            }
            return usuarios;
        }
        catch (Exception ex){
            return usuarios;
        }
    }
}