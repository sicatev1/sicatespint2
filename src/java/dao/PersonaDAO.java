/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Persona;

public class PersonaDAO implements IPersonaDAO {

    public PersonaDAO() {
    }

    public List<Persona> consultarRemitenteDB() {

        List<Persona> lstPersona = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select nombre,identificacion,direccion,coordenadas,telefono,nacional_id from \"REMITENTES\"";
        try {

            System.out.println("consultando todos los remitentes : consultarTodosRemitente()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String nombre = "";
            String identificacion = "";
            String coordenadas = "";
            String ciudad = "";
            String telefono = "";
            String direccion = "";

            while (rs.next()) {

                nombre = rs.getString("nombre");
                identificacion = rs.getString("identificacion");
                ciudad = rs.getString("nacional_id");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                coordenadas = rs.getString("coordenadas");

                System.out.println("Se recupero el registro con el nombre " + nombre);

                Persona persona = new Persona(nombre, identificacion, direccion, coordenadas, telefono, ciudad);
                lstPersona.add(persona);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar Remitente");
            ex.printStackTrace();
            lstPersona = new ArrayList();

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstPersona;
    }

    public boolean guardarRemitenteDB(Persona persona) {

        String insert = "insert into \"REMITENTE\" (nombre,identificacion,direccion,coordenadas,telefono,nacional_id) values(?,?,?,?,?,?)";

        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getIdentificacion());
            ps.setString(3, persona.getDireccion());
            ps.setString(4, persona.getCoordenadas());
            ps.setString(5, persona.getTelefono());
            ps.setString(6, persona.getCiudad());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<Persona> consultarDestinatarioDB() {

        List<Persona> lstPersona = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select nombre,identificacion,direccion,coordenadas,telefono,nacional_id from \"DESTINATARIO\"";
        try {

            System.out.println("consultando todos los remitentes : consultarTodosDestinatario()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String nombre = "";
            String identificacion = "";
            String coordenadas = "";
            String ciudad = "";
            String telefono = "";
            String direccion = "";

            while (rs.next()) {

                nombre = rs.getString("nombre");
                identificacion = rs.getString("identificacion");
                ciudad = rs.getString("nacional_id");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                coordenadas = rs.getString("coordenadas");

                System.out.println("Se recupero el registro con el nombre " + nombre);

                Persona persona = new Persona(nombre, identificacion, direccion, coordenadas, telefono, ciudad);
                lstPersona.add(persona);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar Destinatario");
            ex.printStackTrace();
            lstPersona = new ArrayList();

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstPersona;
    }

    public boolean guardarDestinatarioDB(Persona persona) {

        String insert = "insert into \"DESTINATARIO\" (nombre,identificacion,direccion,coordenadas,telefono,nacional_id) values(?,?,?,?,?,?)";

        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getIdentificacion());
            ps.setString(3, persona.getDireccion());
            ps.setString(4, persona.getCoordenadas());
            ps.setString(5, persona.getTelefono());
            ps.setString(6, persona.getCiudad());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
