/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.classConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jabes Bueno
 */
public class classFuncionario {
    private Integer idFuncionario;
    private String nome;
    private String dataAdmissao;
    private Double salario;
    private String status;
    private Integer idUsuario;
    
    public Integer getIdFuncionario() {
      return idFuncionario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDataAdmissao() {
        return dataAdmissao;
    }
    
    public Double getSalario() {
        return salario;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Integer getIdUsuario() {
      return idUsuario;
    }
    
    //Set
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String inserirFuncionario(classFuncionario funcionario) {
        classConexao conexao = new classConexao();
        conexao.conect();
        
        try {
            String sql = "insert into tbfuncionario(nome, dataadmissao, salario, status, usuario) values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.query(sql);
            stmt.setString(1, funcionario.nome);
            stmt.setString(2, funcionario.dataAdmissao);
            stmt.setDouble(3, funcionario.salario);
            stmt.setString(4, funcionario.status);
            stmt.setInt(5, funcionario.idUsuario);
            stmt.executeUpdate();
            conexao.disconect();
            return "Funcionário cadastrado com sucesso!";
	}catch (SQLException ex) {
            ex.printStackTrace();
            conexao.disconect();
            return "Erro ao cadastrar Funcionário: " + ex.getMessage();
	}
    }
    
    public List<classFuncionario> buscarFuncionarios() {
        classConexao conexao = new classConexao();
        conexao.conect();
        ArrayList<classFuncionario> funcionarios = new ArrayList<classFuncionario>();
        try {
            String sql = "select * from tbfuncionario";
            PreparedStatement stmt = conexao.query(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                classFuncionario funcionario = new classFuncionario();
                
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDataAdmissao(rs.getString("dataadmissao"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setStatus(rs.getString("status"));
                funcionario.setIdUsuario(rs.getInt("usuario"));
                funcionarios.add(funcionario);
            }
            
            conexao.disconect();
	}catch (SQLException ex) {
            ex.printStackTrace();
            conexao.disconect();
            return null;
	}
        return funcionarios;
    }
    
}
