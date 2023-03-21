/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eje3_cripto;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author lnxcity
 */
public class CConexion {
    
    Connection conectar = null;
    
    String usuario = "aolartes";
    String contrasenia = "Password123";
    String bd = "javadb";
    String ip = "Localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            Class.forName("org.postgresql.Driver");
            
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base de datos");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar"+e.toString());
        }
        return conectar;
    }
    
    
}
