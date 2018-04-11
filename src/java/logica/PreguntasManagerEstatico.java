/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Pregunta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego
 */
@Component
@Scope("application")
public class PreguntasManagerEstatico implements IPreguntasManager{

    private List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
    /*Indica la posición de la pregunta actual*/
    private int indexAct = 0;
    
    //private Map<String, Integer> respuestasXOpcion;
    private Map<String, Map<String,Integer>> respuestasXOpcion;
    
    /*Lista de preguntas estáticas*/
    {
        //SIMULA LA INFORMACIÓN QUE SE GUARDARÍA EN UNA BD
        Pregunta preg1 = new Pregunta("preg1","¿Cual de los siguientes no es un RNF?");
        preg1.addOpcion("Usabilidad", false);
        preg1.addOpcion("Rendimiento", false);
        preg1.addOpcion("Seguridad", false);
        preg1.addOpcion("Entendimiento", true);
        
        Pregunta preg2 = new Pregunta("preg2","¿Con que RNF está mas relacionado el tema de UX?");
        preg2.addOpcion("Usabilida", true);
        preg2.addOpcion("Seguridad", false);
        preg2.addOpcion("Mantenibilidad", false);
        preg2.addOpcion("Portabilidad", false);
        
        Pregunta preg3 = new Pregunta("preg3","¿Cuál de las siguientes opciones NO es una característica de un componente en el ámbito de la Arquitectura de software?");
        preg3.addOpcion("Encapsulado", false);
        preg3.addOpcion("Expone interfaces", false);
        preg3.addOpcion("tiene múltiples responsabilidades", true);
        preg3.addOpcion("Reusable", false);
        
        Pregunta preg4 = new Pregunta("preg4","Seleccione el principio básico más relacionados con el término encapsulamiento");
        preg4.addOpcion("Ocultamiento de la información", false);
        preg4.addOpcion("Rapidez en la implementación", true);
        preg4.addOpcion("Legibilidad del código fuente", false);
        preg4.addOpcion("Facilidad en la diagramación", false);
        
        
        Pregunta preg5 = new Pregunta("preg5","¿Cuál de las siguientes etapas o fase NO hace parte del ciclo de vida del desarrollo de software?");
        preg5.addOpcion("Retrospectiva", true);
        preg5.addOpcion("Análisis", false);
        preg5.addOpcion("Pruebas", false);
        preg5.addOpcion("Diseño", false);
        
        Pregunta preg6 = new Pregunta("preg6","¿Cuál de las siguientes opciones NO es una característica de un componente en el ámbito de la Arquitectura de software:");
        preg6.addOpcion("Encapsulado", false);
        preg6.addOpcion("Expone interfaces", false);
        preg6.addOpcion("Tiene múltiples responsabilidades", true);
        preg6.addOpcion("Resuable", false);
        
        
        Pregunta preg7 = new Pregunta("preg7","La arquitectura de software busca definir cada uno de los detalles de implementación de un sistema en un lenguaje de programación específico (Afirmación) PORQUE La Arquitectura de software de un sistema es una abstracción de dicho sistema (Razón).");
        preg7.addOpcion("La afirmación y la razón son verdaderas, y la razón justifica correctamente la afirmación", false);
        preg7.addOpcion("La afirmación y la razón son verdaderas, pero la razón no justifica la afirmación", false);
        preg7.addOpcion("La afirmación es verdadera y la razón es falsa", false);
        preg7.addOpcion("La afirmación es falsa y la razón es verdadera", true);
        
        this.listaPreguntas.add(preg1);
        this.listaPreguntas.add(preg2);
        this.listaPreguntas.add(preg3);
        this.listaPreguntas.add(preg4);
        this.listaPreguntas.add(preg5);
        this.listaPreguntas.add(preg6);
        this.listaPreguntas.add(preg7);
        
        //Map<String,Integer> cantidadRespXOpcion = new HashMap<String,Integer>();
        respuestasXOpcion = new HashMap<String,Map<String,Integer>>();
    }
    
    @Override
    public Pregunta obtenerPreguntaActual() {
        //TODO: IMPLEMENTAR
        return this.listaPreguntas.get(indexAct);
    }
    
    @Override
    public void cambiarPreguntaAleatorio() {
        if( this.indexAct > this.listaPreguntas.size() ){
            this.indexAct = 0;//Evita sobrepasar las preguntas
        }else{
            this.indexAct++;
        }
    }

    /*
    Lista todas las preguntas
    */
    public List listarPreguntas() {
        return this.listaPreguntas;
    }

    @Override
    public void seleccionarPregunta(String idPreg) {
        for( int i = 0; i < this.listaPreguntas.size(); i++ ){
            Pregunta pregAct = this.listaPreguntas.get(i);
            if( pregAct.getId().equals( idPreg )){
                this.indexAct = i;
                return;
            }
        }
        throw new RuntimeException("No existe pergunta con el id especificado");
    }

    /*
    Método en el que se registran las respuestas dadas por los usuarios a las preguntas
    */
    @Override
    public void registrarRespuesta(int idJugador, String idPregunta, String[] respuestas) {
        //Cantidad de respuestas de cada opción
        Pregunta actual = obtenerPreguntaActual();
        
        //Obtiene la lista de respuestas por opocón para la pregunta actual
        Map<String,Integer> cantidadRespXOpcion = this.respuestasXOpcion.get( idPregunta );
        
        if( cantidadRespXOpcion == null ){
            cantidadRespXOpcion = new HashMap<String,Integer>();
            this.respuestasXOpcion.put(idPregunta, cantidadRespXOpcion);
        }
        
        for( String idRespuesta : respuestas ){
            //String key = idRespuesta;
            
            Integer respAct = cantidadRespXOpcion.get(idRespuesta);
            if(respAct == null ){
                cantidadRespXOpcion.put(idRespuesta, new Integer(1));
            }else{
                Integer nuevoResp = new Integer( respAct.intValue()+1 );
                cantidadRespXOpcion.put(idRespuesta, nuevoResp );
            }
        }
    }    

    @Override
    public Map<String, Integer> obtenerResultados(String idPregunta) {
        return this.respuestasXOpcion.get( idPregunta );
    }
}
