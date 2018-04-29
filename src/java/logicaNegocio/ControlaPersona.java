/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import dao.PersonaDAO;
import dao.IPersonaDAO;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaPersona;
import modelo.Persona;

@Stateless
public class ControlaPersona implements IControlaPersona {

    private IPersonaDAO personaDAO = new PersonaDAO();

    public ControlaPersona() {
    }

    public List<Persona> consultarRemitente() {
        return personaDAO.consultarRemitenteDB();
    }

    public boolean guardarRemitente(Persona persona) {
        return personaDAO.guardarRemitenteDB(persona);
    }

    public List<Persona> consultarDestinatario() {
        return personaDAO.consultarDestinatarioDB();
    }

    public boolean guardarDestinatario(Persona persona) {
        return personaDAO.guardarDestinatarioDB(persona);
    }

}
