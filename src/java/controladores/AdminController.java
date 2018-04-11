/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Pregunta;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logica.IPreguntasManager;
import logica.PreguntasManagerEstatico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
@Scope("application")
@SessionAttributes({"esAdmin","preguntasSeleccionadas"})
public class AdminController {
    
    
    @Autowired
    private IPreguntasManager managerPreguntas;
    
    @RequestMapping(value = "/listaPreguntasAdmin")
    public ModelAndView listarPreguntas(){
        List preguntas = managerPreguntas.listarPreguntas();
        ModelAndView model = new ModelAndView("pregAdmin/listaPreguntas");
        model.addObject("preguntas",preguntas);
        return model;
    }
    
    /*
    Marca una pregunta como actual para que los participantes la puedan 
    responder
    */
    @RequestMapping(value = "/marcarActual")
    public String marcarPreguntaActual(@RequestParam("idPreg") String idPreg, @
        ModelAttribute("preguntasSeleccionadas") List pregSel, 
            ModelMap model){
        model.addAttribute("mensaje","Se ha seleccionado la pregunta, ya los participantes pueden actualizar la vista");
        managerPreguntas.seleccionarPregunta(idPreg);
        pregSel.add( idPreg );
        return "redirect:listaPreguntasAdmin";
    }
    
    @RequestMapping(value = "/loginAsAdmin",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("contra") String contra){
        
        ModelAndView model = new ModelAndView("pregAdmin/listaPreguntas");
        
        //ACÁ SE DEBERÍA VALIDAR CONTRAL LA BASE DE DATOS O EL DIRECTORIO ACTIVO
        if( contra.equals("nosegura")){
            model.addObject("esAdmin","true");
            model.addObject("preguntasSeleccionadas", new ArrayList() );
            model.setViewName("redirect:listaPreguntasAdmin");
        }else{
            model.addObject("mensaje","Error de autenticación");
            model.addObject("esAdmin","false");
        }
        return model;
    }
    
    /*
    Marca una pregunta como actual para que los participantes la puedan 
    responder
    */
    @RequestMapping(value = "/resultados")
    public String verResultados( ModelMap model){        
        Pregunta pregAct = managerPreguntas.obtenerPreguntaActual();
        Map resultados = managerPreguntas.obtenerResultados( pregAct.getId() );
        
        model.addAttribute("pregunta",pregAct);
        model.addAttribute("resultados",resultados);
        
        return "pregAdmin/resultadosVw";
    }
}
