/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Jugador;
import java.util.ArrayList;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import logica.JuegoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
@SessionAttributes({"jugador","preguntasUsuario"})
public class JugadorController {
    
    @Autowired
    JuegoManager managerJuego;
    
    @ModelAttribute("jugador")
    public Jugador getJugador (HttpServletRequest request) {
        System.out.println("VA A SETTEAR EL ATRIBUTO DE SESIÓN");
        return new Jugador();
    }
    
    @RequestMapping( value = "/registrarJugador",method = RequestMethod.GET)
    public ModelAndView indexJugador( HttpServletRequest request ){
        ModelAndView model = null;
        if( request.getSession().getAttribute("jugador") == null ){
            model = new ModelAndView("registrarJugadorVista");
            model.addObject("jugador", new Jugador());
            model.addObject("jugadoresReg", managerJuego.listarJugadores() );
            model.addObject("preguntasUsuario", new ArrayList() );
        }else{
            //Si el usuario ya se registró es redirigido a la pantalla de preguntas
            model = new ModelAndView("redirect:pregunta");
        }
        
        return model;
    }
    
    @RequestMapping( value = "/registrarJugador",method = RequestMethod.POST)
    public ModelAndView registrarJugador( @ModelAttribute("jugador")Jugador jugador){
        System.out.println("Vamos a registrar este jugador "+jugador);
        managerJuego.registrarJugador(jugador);
        
        
        /*Prueba para mandar al otro controlador*/
        ModelAndView retorno = new ModelAndView("redirect:pregunta");
        return retorno;
        /* Así redirige a otra vista
        return "tableroVista";*/
    }
    
    @RequestMapping( value = "/cerrarSesion",method = RequestMethod.GET)
    public ModelAndView cerrarSesion( @ModelAttribute("jugador") Jugador  participante,
                                  HttpServletRequest request,
                                  SessionStatus sessionStatus ){
        //Invalida la sesión
        /*request.getSession().getAttributeNames().
        request.getSession().invalidate();*/
        //Elimina el atributo de la sesion
        sessionStatus.setComplete();
        
        ModelAndView model = new ModelAndView("index");
        
        return model;
    }
}
