/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xbrain.gerenciamento.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3307/empresa_db";
    private static final String user = "root";  
    private static final String senha = "";
    private static Connection conn = null;
    
    private Conexao(){
    }
    
    public static synchronized Connection conectar() {
        
        try{
            conn = DriverManager.getConnection(url,user,senha);   
        } catch (SQLException e){
            e.printStackTrace();
        }
    
    return conn;
}
}
    

