//package Controlador;
//
//import Conector.Conector;
//import Conector.SQL2;
//import Modelo.ModeloRol;
//import Vistas.VistaMenu;
//import com.mysql.jdbc.PreparedStatement;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ControladorRol implements ActionListener{
//
//    ModeloRol modelo;
//    PreparedStatement ps;
//    ResultSet rs;
//    Conector conector = new Conector();
//    SQL2 sql = new SQL2();
//        
//    public ControladorRol(ModeloRol modelo){
//        this.modelo = modelo;
//    }
//    
//    public ControladorRol(){
//    
//    }
//        
////    @Override
////    public void actionPerformed(ActionEvent e) {
////        if (e.getActionCommand().equals(modelo.getVistaRol().btnIngresar.getActionCommand())){
////            if(ValidarDatos()){
////                VistaMenu vistaM = new VistaMenu();
////                vistaM.lblUsuarioM.setText("Usuario: " + modelo.getVistaR().txtCodRol.getText());
////                vistaM.setVisible(true);
////                modelo.getVistaRol().dispose();
////            }
////        }     
////        
////    }
//
//    public void ValidarDatos(){
//        boolean res = false;
//        try {
//            ps = (PreparedStatement) conector.preparar(sql.getValidarUsuario());
//            ps.setString(1, modelo.getCodigoRol());
//            ps.setString(1, modelo.getDescripcion());
//            ps.setString(1, modelo.getCmbNivelRol());          
//            rs = ps.executeQuery();
//             while (rs.next()) {
//                res = rs.getString("Rol").equals(modelo.getVistaR().CodigoRol.getText());
//                rs = rs.getString("Usuario").equals(modelo.getVistaR().CodigoRol.getText())
//                        && rs.getString("Passw").equals(String.valueOf(modelo.getVistaL().txtPassLogin.getPassword()));
//            }
//        } catch (SQLException ex) {
//            conector.desconectar();
//            return rs;
//        }
//    }
//}
