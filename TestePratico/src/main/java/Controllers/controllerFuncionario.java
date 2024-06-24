/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.classFuncionario;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jabes Bueno
 */
public class controllerFuncionario {
    public String cadastrar(String nome, String dataadmissao, Double salario, String status, Integer idUsuario) {
        try {
            
            classFuncionario funcionario = new classFuncionario();
            funcionario.setNome(nome);
            funcionario.setDataAdmissao(dataadmissao);
            funcionario.setSalario(salario);
            funcionario.setStatus(status);
            funcionario.setIdUsuario(idUsuario);
            funcionario.inserirFuncionario(funcionario);
            return "Funcionário cadastrado com sucesso!";
        } catch(Exception ex){
            return "Erro ao cadastar funcionário: " + ex;
        }
    }
    
    public List<classFuncionario> listarFuncionarios(){
        classFuncionario funcionario = new classFuncionario();
        return funcionario.buscarFuncionarios();
    }
}
