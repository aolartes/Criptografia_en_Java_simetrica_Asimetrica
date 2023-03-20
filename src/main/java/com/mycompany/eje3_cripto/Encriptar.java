/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eje3_cripto;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alvar
 */
public class Encriptar {
    public static String encriptar(JTextField txtUser, JTextField txtPassword) throws Exception{
         // Se solicita al usuario ingresar la cadena a encriptar
        String cadena = txtPassword.getText();
        String usuario = txtUser.getText();
        // Se genera un par de claves pública y privada con el algoritmo RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512); // Tamaño de la clave RSA en bits
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();
        //System.out.println("privateKey = " + privateKey);
        //System.out.println("publicKey = " + publicKey);
        
        // Se firma la cadena utilizando la clave privada
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(cadena.getBytes());
        byte[] signedData = signature.sign();
        JOptionPane.showMessageDialog(null,"Password encriptado: " + new String(signedData));
        
        
        // Se verifica la firma utilizando la clave pública
        
        signature.initVerify(publicKey);
        signature.update(cadena.getBytes());
        boolean verified = signature.verify(signedData);
        if (verified == true) {
            JOptionPane.showMessageDialog(null,"Usuario: "+usuario+"\n"+"Firma verificada, password desencriptado: " + cadena);            
        } else {
            JOptionPane.showMessageDialog(null,"Firma no válida");            
        }
        return (null);
    }
    
}

