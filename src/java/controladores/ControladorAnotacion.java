/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
public class ControladorAnotacion{
    {
    System.out.println("INICIALIZÓ EL CONTROLLADOR CON ANOTACIONES");
    }
    
    @RequestMapping(value = "/anotada",method = RequestMethod.GET)
    public String pruebaMetodo(){
        System.out.println("METODO DEL CONTROLADOR");
        return "vistaDelControladorAnotado";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
		
	return "index";
    }
    
    @RequestMapping(value = "/otro", method = RequestMethod.GET)
    public String index2(Map<String, Object> model) {
		
	return "vistaDelControladorAnotado";
    }
    
}
