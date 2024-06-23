/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testepratico;

import Database.classConexao;
import Views.frmCadastroUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jabes Bueno
 */
public class TestePratico {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        
        classConexao conexao = new classConexao();
        conexao.conect();
        PreparedStatement stmt = conexao.query("SELECT * FROM tbusuario");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
                System.out.println(" ID: " + rs.getInt("idUsuario") );
                System.out.println(" Nome: " + rs.getString("nome") );
                System.out.println(" Email: " + rs.getString("email") );
                System.out.println(" Senha: " + rs.getString("senha") );
        }
        conexao.disconect();
        
        frmCadastroUsuario usuario = new frmCadastroUsuario();
        usuario.setVisible(true);
    }
}
