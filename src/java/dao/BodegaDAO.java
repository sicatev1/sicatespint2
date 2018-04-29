
package dao;

import conexion.ConexionSingleton;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import modelo.Bodega;


public class BodegaDAO implements IBodegaDAO{
    
//    @PersistenceUnit(unitName = "UnidadDePersistencia")
//    private EntityManager entityManager;

    public BodegaDAO() {
    }
    
  
    public List<Bodega> consultarTodos(){
        
        List<Bodega> lstBodegas = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select nombre,telefono,direccion from \"BODEGAS\"";
        try {
          
            System.out.println("consultando todos las bodegas : consultarTodos()");
     
            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String nombre = "";  
            String telefono = "";
            String direccion = "";
            
            while (rs.next()) {
                
                nombre = rs.getString("nombre");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                
                System.out.println("Se recupero el registro con el nombre "+nombre);
                
                Bodega bodega = new Bodega(nombre, telefono, direccion);
                lstBodegas.add(bodega);
                
            }
            
        } catch (SQLException ex) {
         
            System.err.println("Error al consultar bodegas");
            ex.printStackTrace();
            lstBodegas = new ArrayList();
            
        } 
        finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        return lstBodegas;
    }

   
   public boolean guardarBodega(Bodega bodega) {
       
        String insert = "insert into \"BODEGAS\" (nombre,telefono,direccion) values(?,?,?)";
        
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, bodega.getNombre());
            ps.setString(2, bodega.getTelefono());
            ps.setString(3, bodega.getDireccion());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

//    @Override
//    public void eliminar(Bodega destinatario) {
//         String insert = "delete from \"DESTINOS\" where nombre = ?";
//        
//        PreparedStatement ps = null;
//        try {
//            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);
//
//            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
//            ps.setString(1, destinatario.getNombre());
//
//            ps.executeUpdate();
//            ConexionSingleton.getInstancia().getConexion().commit();
//        } catch (Exception ex) {
//            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                ps.close();
//            } catch (Exception ex) {
//                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
    
    
}
