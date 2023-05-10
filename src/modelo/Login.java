package modelo;

import conexion.Conexion;
import vista.Seguimiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.Logearse;


public class Login {
    public String nombre, contraseña;
    Conexion cc = new Conexion();
    Connection con = cc.getConnection();

    public Login() {
    }

    public Login(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    
        public void ingresarUsuario() {

        int resultado = 0;
        String pass = String.valueOf(contraseña);
        String usuario = nombre;
        String SQL = "select * from usuarios where usuario='" + usuario + "' and pass='" + pass + "'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {
                    int idUser = rs.getInt("id");
                    Seguimiento s = new Seguimiento();
                    s.setTitle("IMC");
                    s.setVisible(true);
                    s.nombreU1.setText(usuario);
                    s.idUser = idUser;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de logeo, usuario o contraseña incorrectos.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. " + e.getMessage());
        }
    }
}


