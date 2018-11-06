/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.global.DocumentoDaoI;

import pe.com.syscenterlife.modelo.GloTipodocidentidad;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Service
@Transactional
public class DocumentoServicioImpl implements DocumentoServicioI{
 
    @Autowired
    public DocumentoDaoI dao;
    
    @Override
    public List<GloTipodocidentidad> listarEntidad(){ return dao.listarEntidad();}
    @Override
    public List<GloTipodocidentidad> listarEntidadDato(String dato){ return dao.listarEntidadDato(dato);}
    @Override
    public GloTipodocidentidad buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloTipodocidentidad documento){dao.guardarEntidad(documento);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloTipodocidentidad documento){dao.modificarEntidad(documento);}
}
