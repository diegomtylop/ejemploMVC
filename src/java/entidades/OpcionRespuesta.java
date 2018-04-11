/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Diego
 */
public class OpcionRespuesta {
    private String id;
    private String descripcion;
    private boolean valida;

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OpcionRespuesta(String id, String descripcion, boolean valida) {
        this.id = id;
        this.descripcion = descripcion;
        this.valida = valida;
    }
    
}
