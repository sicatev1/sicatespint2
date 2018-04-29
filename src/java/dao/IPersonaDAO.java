/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Persona;

public interface IPersonaDAO {

    public List<Persona> consultarRemitenteDB();

    public boolean guardarRemitenteDB(Persona persona);

    public List<Persona> consultarDestinatarioDB();

    public boolean guardarDestinatarioDB(Persona persona);

}
