/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Jugador;
import entidades.Tablero;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego
 */
@Component
@Scope("application")
public class JuegoManager {
    private Tablero tablero;
    private String ensayoInyectado;

    public String getEnsayoInyectado() {
        return ensayoInyectado;
    }

    public void setEnsayoInyectado(String ensayoInyectado) {
        this.ensayoInyectado = ensayoInyectado;
    }
    //Inicializa el tabler
    { 
        tablero = new Tablero();
    }
    
    public void registrarJugador(Jugador jugador){
        tablero.registrarJugador( jugador );
    }
    
    public List listarJugadores(){
        return tablero.getJugadores();
    }
            
}
