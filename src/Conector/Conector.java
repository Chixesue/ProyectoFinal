package Conector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conector {
    private static final String CLASE = "com.mysql.jdbc.Driver";
    private final String HOST = "sql.freedb.tech:3306";
    private final String USUARIO = "freedb_Josue Arriola";
    private final String CLAVE = "U?TEnG%hHsze78G";
    private final String BASEDATOS = "freedb_ProyectoBDA";
    private final String URL;

    private Connection link;
    private PreparedStatement ps;

    public Conector() {
        this.URL = "jdbc:mysql://" + this.HOST + "/" + this.BASEDATOS;
    }

    public void conectar() {
        try {
            Class.forName(CLASE).getDeclaredConstructor().newInstance();
            this.link = DriverManager.getConnection(this.URL, this.USUARIO, this.CLAVE);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | SQLException | InstantiationException |
                IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            this.link.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public PreparedStatement preparar(String sql){
        try {
            this.conectar();
            ps = link.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ps;
    }
    
    /**
     * Metodo usado para mostrar mensajes al usuario.
     * @param mensaje - EL mensaje que se desea mostrar
     * @param titulo - El titulo de la ventana
     * @param tipoMensaje - El tipo de mensaje 1[Informacion] - 0[Error]
     */
    public void mensaje(String mensaje, String titulo, int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }
}
