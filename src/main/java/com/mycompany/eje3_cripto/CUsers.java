/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eje3_cripto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lnxcity
 */
public class CUsers {
    int codigo;
    String Users;
    String Password;

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
    
    public void MostrarUsers(JTable paramTablaTotalAlumnos){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql="";
        
        modelo.addColumn("id");
        modelo.addColumn("users");
        modelo.addColumn("Password");
        
        paramTablaTotalAlumnos.setModel(modelo);
        
        sql = "SELECT * FROM  users;";
        
        String [] datos = new String[3];
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                
                modelo.addRow(datos);
                
            }
            paramTablaTotalAlumnos.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        
    }
    
//    public void insertarUsuario(JTextField paramUsers, JTextField paramPassword){
//        setUsers(paramUsers.getText());
//        setUsers(paramUsers.getText());
//        
//        CConexion objetoConexion = new CConexion();
//        
//        String consulta = "insert into users (usuario,contraseña) values(?,?)";
//        
//        try{
//            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
//            cs.setString(1, getUsers());
//            cs.setString(2, getPassword());
//            cs.execute();
//            JOptionPane.showMessageDialog(null, "Se insertó correctamente.");
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, "Error: "+e);
//        }
//        
//    }
    
}
