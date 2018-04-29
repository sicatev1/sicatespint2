/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BodegaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Bodega;
import dao.IBodegaDAO;
import java.util.ArrayList;
import javax.ejb.EJB;
import logicaNegocio.interfaces.IControlaBodega;

/**
 *
 * @author cristian gomez ruiz
 */
@ManagedBean
@RequestScoped
public class BodegaMB {
    
    @EJB
    private IControlaBodega controlaBodegaInterface;
    
    private Bodega bodegaSelected;
    private List<Bodega> lstBodega;
    
    public BodegaMB() {
        bodegaSelected = new Bodega();
//        probar injeccion de dependencias
//        lstBodega = controlaBodegaInterface.consultarBodegas();
        lstBodega = new ArrayList<>();
    }
    

    public void guardarBodega(){
        
        boolean guardado = controlaBodegaInterface.guardarBodega(bodegaSelected);
        if (guardado) {

            lstBodega = controlaBodegaInterface.consultarBodegas();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bodega Guardada", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    
    public void limpiar(){
        bodegaSelected = new Bodega();
    }
    
    public Bodega getBodegaSelected() {
        return bodegaSelected;
    }

    public void setBodegaSelected(Bodega bodegaSelected) {
        this.bodegaSelected = bodegaSelected;
    }

    public List<Bodega> getLstBodega() {
        return lstBodega;
    }

    public void setLstBodega(List<Bodega> lstBodega) {
        this.lstBodega = lstBodega;
    }
    
    
    
}
