/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.global;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.com.syscenterlife.modelo.GloTipodocidentidad;
import pe.com.syscenterlife.servicio.global.DocumentoServicioI;



@Controller
public class DocumentoControl {
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    DocumentoServicioI documentoServicioI;

    @RequestMapping(value = {"/docMain" }, method = RequestMethod.GET)    
    public ModelAndView inicioDocumento(Locale locale, Map<String,Object> model){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"j"}, locale);
        List<GloTipodocidentidad> lista=documentoServicioI.listarEntidad();

        model.put("ListaDocumento", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");        
        return new ModelAndView("global/documento/mainDocumento");
    } 
    
    @RequestMapping(value = {"/buscarDoc"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"j"}, locale);
        String dato=r.getParameter("dato");
        List<GloTipodocidentidad> lista=documentoServicioI.listarEntidadDato(dato);
        model.put("ListaDocumento", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");    
    return new ModelAndView("global/documento/mainDocumento");
    } 
    
    @RequestMapping(value = {"/elimDoc" }, method = RequestMethod.GET)
    public ModelAndView eliminarDocumento(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        documentoServicioI.eliminarEntidad(idEntidad);
    return new ModelAndView(new RedirectView("/docMain"));
    }    
}
