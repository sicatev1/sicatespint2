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
import modelo.Paquete;

public class PaqueteDAO implements IPaqueteDAO {

    public PaqueteDAO() {
    }

    public List<Paquete> consultarPaqueteDB() {

        List<Paquete> lstPaquete = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select guia,fecha_Entrega,fecha_salida,remitente_idtable,destinatario_iptable,rutas_idruta from \"PAQUETE\"";
        try {

            System.out.println("consultando todos los paquetes : consultarPaqueteDB()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String guia = "";
            String fecha_Entrega = "";
            String fecha_Salida = "";
            String remitente_idtable = "";
            String destinatario_iptable = "";
            String rutas_idruta = "";

            while (rs.next()) {

                guia = rs.getString("guia");
                fecha_Entrega = rs.getString("fecha_Entrega");
                fecha_Salida = rs.getString("fecha_Salida");
                remitente_idtable = rs.getString("remitente_idtable");
                destinatario_iptable = rs.getString("destinatario_iptable");
                rutas_idruta = rs.getString("rutas_idruta");

                System.out.println("Se recupero el registro con la guia " + guia);

                Paquete paquete = new Paquete(guia, fecha_Entrega, fecha_Salida, remitente_idtable, destinatario_iptable, rutas_idruta);
                lstPaquete.add(paquete);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar paquete");
            ex.printStackTrace();
            lstPaquete = new ArrayList();

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstPaquete;
    }

    public boolean guardarPaqueteDB(Paquete paquete) {

        String insert = "insert into \"PAQUETE\" (guia,fecha_Entrega,fecha_Salida,remitente_idtable,destinatario_iptable,rutas_idruta) values(?,?,?,?,?,?)";

        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, paquete.getGuia());
            ps.setString(2, paquete.getFecha_entrega());
            ps.setString(3, paquete.getFecha_salida());
            ps.setString(4, paquete.getRemitente());
            ps.setString(5, paquete.getDestinatario());
            ps.setString(6, paquete.getRuta());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
