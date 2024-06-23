/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.classUsuario;

/**
 *
 * @author Jabes Bueno
 */
public class controllerUsuario {
    public String cadastrar(String nome, String email, String senha) {
        try {
            
            
            classUsuario usuario = new classUsuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.inserirUsuario(usuario);
            return "Usuário cadastrado com sucesso!";
        } catch(Exception ex){
            return "Erro ao cadastar usuário: " + ex;
        }
        
    }
    
}
