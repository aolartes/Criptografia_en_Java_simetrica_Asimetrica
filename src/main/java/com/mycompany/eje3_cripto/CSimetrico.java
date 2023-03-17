/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eje3_cripto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lnxcity
 */
public class CSimetrico {
    
    private int codigo;
    private String Users;
    private String Password;
    private String EncryptPassword;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsers() {
        return Users;
    }

    public void setUsers(String Users) {
        this.Users = Users;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEncryptPassword() {
        return EncryptPassword;
    }

    public void setEncryptPassword(String EncryptPassword) {
        this.EncryptPassword = EncryptPassword;
    }
    
    
    
    public static String encryptPassword(String password) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
        
    }
    
    
    
    public void EncriptarContraseña(JTextField paramCodigo,JTextField paramPassword)  {
        try {
            
            setCodigo(Integer.parseInt(paramCodigo.getText()));
            setPassword(paramPassword.getText());

            CConexion objetoConexion = new CConexion();

            String encryptedPass = encryptPassword(getPassword());       


            String consulta = "UPDATE users SET password_hash = ? WHERE id = ?;";

            try{
                CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
                cs.setString(1, encryptedPass);
                cs.setInt(2, getCodigo());
                cs.execute();
                JOptionPane.showMessageDialog(null, "Se encripto correctamente la contraseña");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e);
            }            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Seleccione un registro para poder encriptar la contraseña");
            
        }
        
    }  
    
    
    
}
