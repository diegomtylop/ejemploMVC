/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Pregunta;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Diego
 */
public interface IPreguntasManager {
    
    public Pregunta obtenerPreguntaActual();
    
    public void cambiarPreguntaAleatorio();
    
    public void seleccionarPregunta( String idPreg );
    
    /*
    Lista todas las preguntas
    */
    public List listarPreguntas();

    public void registrarRespuesta(int idJugador, String idPregunta, String[] respuestas);
    
    public Map<String,Integer> obtenerResultados(String idPregunta);
}
