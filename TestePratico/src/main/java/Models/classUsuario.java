/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.classConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jabes Bueno
 */
public class classUsuario {
    private Integer idUsuario;
    private String nome;
    private String email;
    private String senha;
    
    //Get
    public Integer getIdUsuario() {
      return idUsuario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    //Set
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String inserirUsuario(classUsuario usuario) {
        classConexao conexao = new classConexao();
        conexao.conect();
        
        try {
            String sql = "insert into tbusuario(nome, email, senha) values(?, ?, ?)";
            PreparedStatement stmt = conexao.query(sql);
            stmt.setString(1, usuario.nome);
            stmt.setString(2, usuario.email);
            stmt.setString(3, usuario.senha);
            stmt.executeUpdate();
            conexao.disconect();
            return "Usuário cadastrado com sucesso!";
	}catch (SQLException ex) {
            ex.printStackTrace();
            conexao.disconect();
            return "Erro ao cadastrar usuário: " + ex.getMessage();
	}
    }
    
    public classUsuario verificarLogin(String email,  String senha) {
        classConexao conexao = new classConexao();
        conexao.conect();
        classUsuario usuario = new classUsuario();
        
        try {
            String sql = "select * from tbusuario where email=? and senha=?";
            PreparedStatement stmt = conexao.query(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
            
            conexao.disconect();
            return usuario;
	}catch (SQLException ex) {
            ex.printStackTrace();
            conexao.disconect();
            return null;
	}
    }
}
