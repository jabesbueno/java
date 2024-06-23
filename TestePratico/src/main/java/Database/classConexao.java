/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jabes Bueno
 */
public class classConexao {
    private Connection conexao = null;
    private PreparedStatement st;
    private Statement stmt;
    private ResultSet rs;
    private String jdbc = "org.postgresql.Driver";
    private String host = "jdbc:postgresql://localhost:5432/testePratico";
    private String user = "postgres";
    private String password = "0000";
    
    //Getters
    public Connection getConexao() { 
         return conexao; 
    }
    
    public PreparedStatement getSt() { 
         return st; 
    }
    
    public Statement getStmt() { 
         return stmt; 
    }
    
    public ResultSet getRs() { 
         return rs; 
    }
    
    public String getJDBC() { 
         return jdbc; 
    }
    
    public String getHost() { 
         return host; 
    }
    
    public String getUser() { 
         return user; 
    }
    
    public String getPassword() { 
         return password; 
    }
    
    //Setters
    public void setConexao(Connection conexao) {
          this.conexao = conexao; 
    }
    
    public void setSt(PreparedStatement st) {
          this.st = st; 
    }
    
    public void setStmt(Statement stmt) {
          this.stmt = stmt; 
    }
    
    public void setRs(ResultSet rs) {
          this.rs = rs; 
    }
    
    public void setJDBC(String jdbc) {
          this.jdbc = jdbc; 
    }
    
    public void setHost(String host) {
          this.host = host; 
    }
    
    public void setUser(String user) {
          this.user = user; 
    }
    
    public void setPassword(String password) {
          this.password = password; 
    }
    
    public Connection conect(){
        try {
            Class.forName(getJDBC());
            setConexao(DriverManager.getConnection(getHost(), getUser(), getPassword()));
            return conexao;
        }catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
            return null;
        }
    }
    
    public PreparedStatement query(String query){
	try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            return stmt;
	}catch (SQLException ex) {
            ex.printStackTrace();
            return null;
	}
    }

    public void disconect(){
	try {
            getConexao().close();
	}catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
	}
    }

}
