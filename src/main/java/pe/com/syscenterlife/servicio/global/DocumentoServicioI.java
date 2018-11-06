/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloTipodocidentidad;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public interface DocumentoServicioI {
    public List<GloTipodocidentidad> listarEntidad();
    public List<GloTipodocidentidad> listarEntidadDato(String dato);
    public GloTipodocidentidad buscarEntidadId(int id);
    public void guardarEntidad(GloTipodocidentidad documento);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloTipodocidentidad documento);    
}
