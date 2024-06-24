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
        frmCadastroUsuario usuario = new frmCadastroUsuario();
        usuario.setVisible(true);
    }
}
