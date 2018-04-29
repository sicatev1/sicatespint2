/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio.interfaces;

import java.util.List;
import javax.ejb.Local;
import modelo.Persona;

@Local
public interface IControlaPersona {

    public List<Persona> consultarRemitente();

    public boolean guardarRemitente(Persona persona);

    public List<Persona> consultarDestinatario();

    public boolean guardarDestinatario(Persona persona);

}
