/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import logica.JuegoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
public class TableroController {
    
    @Autowired
    private JuegoManager manager;
    
    @RequestMapping(value = "/tablero", method = RequestMethod.GET)
    public ModelAndView visualizarTablero(){
        ModelAndView model = new ModelAndView("tableroVista");
        model.addObject("jugadores", manager.listarJugadores());
        return model;
    }
}
