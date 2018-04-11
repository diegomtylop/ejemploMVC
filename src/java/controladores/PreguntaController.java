/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Jugador;
import entidades.Pregunta;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.IPreguntasManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
@Scope("session")
@SessionAttributes({"jugador","preguntasUsuario"})
public class PreguntaController implements Serializable{
    
    private String id;
    //Pregunta actual
    private Pregunta preguntaActual;
    
    @Autowired
    private IPreguntasManager preguntaManager;
    {
        try {
            this.id= SecureRandom.getInstanceStrong().toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PreguntaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "/pregunta",method = RequestMethod.GET)
    public String mostrarPregunta(ModelMap map,@ModelAttribute("jugador")Jugador jugador,@ModelAttribute("preguntasUsuario")List pregUsuario){
        //ModelAndView model = new ModelAndView("preguntas/preguntaActualVw");
        RespuestaPreguntaForm pregForm = new RespuestaPreguntaForm();
        
        /*Obtiene la pregunta actual*/
        this.preguntaActual = preguntaManager.obtenerPreguntaActual();
        pregForm.setPregunta( preguntaActual );
        pregForm.setPrueba("Esto es una prueba");
        
        if( pregUsuario.contains( preguntaActual.getId() )){
            map.addAttribute("mensaje","Ya respondiste esta pregunta");
            map.addAttribute("respondida","true");
        }else{
            //Si la pregunta no ha sido respondida
            /*List disponibles = new ArrayList<String>();
            disponibles.add("uno");
            disponibles.add("dos");
            disponibles.add("tres");
            disponibles.add("cuatro");
            pregForm.setOpcionesDisponibles( disponibles );*/
            //nuevoComando.setOpcionesSeleccionadas( new String[4]);
            map.addAttribute("preguntaForm", pregForm);

            //map.addAttribute("disponibles",disponibles);
            map.addAttribute("preguntaActual", preguntaManager.obtenerPreguntaActual() );

            map.addAttribute("idDeSession",this.id);
        }
        
        return "preguntas/preguntaActualVw";
    }
    
    @RequestMapping(value = "/pregunta2",method = RequestMethod.GET)
    public ModelAndView mostrarPreguntaOld(@ModelAttribute("command") Pregunta pregunta){
        ModelAndView model = new ModelAndView("preguntas/preguntaActualVw");
        model.addObject("preguntaActual", preguntaManager.obtenerPreguntaActual() );
        model.addObject("prueba","Esto es una prueba");
        model.addObject("opcionesSeleccionadas", new boolean[4]);
        return model;
    }
    
    
    @RequestMapping(value = "/enviarRespuesta",method = RequestMethod.POST)
    public ModelAndView enviarRespuesta(@ModelAttribute RespuestaPreguntaForm preguntaForm,
            @ModelAttribute("preguntasUsuario")List pregUsuario,
            @ModelAttribute("jugador")Jugador jugador){
        String[] respuestas = preguntaForm.getOpcionesSeleccionadas();
        
        preguntaManager.registrarRespuesta(jugador.getId(), this.preguntaActual.getId(), respuestas);
        //ModelAndView model = new ModelAndView("preguntas/preguntaOk");
        ModelAndView model = new ModelAndView("redirect:pregunta");
        
        model.addObject("preguntaActual", this.preguntaActual );
        
        pregUsuario.add( this.preguntaActual.getId() );
        //TODO: SERÍA CUESTIÓN DE MANIPULAR LA INFORMACIÓN RECIBIDA
        return model;
    }
}
