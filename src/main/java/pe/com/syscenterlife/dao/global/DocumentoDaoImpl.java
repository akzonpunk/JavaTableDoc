/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloTipodocidentidad;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Repository
public class DocumentoDaoImpl extends SysDataAccess<Integer, GloTipodocidentidad> implements DocumentoDaoI{

        @SuppressWarnings("unchecked")
    
        @Override
        public List<GloTipodocidentidad> listarEntidad(){return getListAll();}
        @Override
        public List<GloTipodocidentidad> listarEntidadDato(String dato){
        return (List<GloTipodocidentidad>)sessionFactory.getCurrentSession()
                .createQuery("SELECT px FROM GloTipodocidentidad px WHERE CONCAT(px.codigo,' ', px.descripcion) LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        @Override
        public GloTipodocidentidad buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(GloTipodocidentidad documento){savev(documento);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(GloTipodocidentidad documento){update(documento);}

   
}