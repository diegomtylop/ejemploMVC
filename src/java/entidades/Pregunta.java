/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Diego
 */
public class Pregunta {
    private String enunciado;
    private List<OpcionRespuesta> opcionesRespuesta;
    private String id;

    {
    opcionesRespuesta = new ArrayList<OpcionRespuesta>();
    }
    
    public Pregunta( String id, String enunciado){
        this.id=id;
        this.enunciado = enunciado;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List getOpcionesRespuesta() {
        return opcionesRespuesta;
    }

    
    public void addOpcion(String opcion, boolean valida ){
        OpcionRespuesta nueva = new OpcionRespuesta( this.opcionesRespuesta.size()+1+"", opcion, valida);
        this.opcionesRespuesta.add( nueva );
    }
}
