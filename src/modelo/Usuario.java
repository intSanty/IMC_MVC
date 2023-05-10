package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import vista.Registrarse;
import java.sql.Connection;


public class Usuario {
    public String nombre,apellido,email,contraseña;
    Conexion cc = new Conexion();
    Connection con = cc.getConnection();
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }
    
        public void registrarUsuario() {

        String pass = String.valueOf(contraseña);
        String SQL = "insert into usuarios (usuario, pass, apellido, email) values(?,?,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, nombre);
            pst.setString(2, pass);
            pst.setString(3, apellido);
            pst.setString(4, email);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro." + e.getMessage());
        }
    }
}
