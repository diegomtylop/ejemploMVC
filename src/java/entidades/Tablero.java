/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class Tablero {
    private int puntuacion;
    private List<Jugador> jugadores;
    
    {
        jugadores = new ArrayList<Jugador>();
    }
    
    public void registrarJugador( Jugador nuevo ){
        jugadores.add(nuevo);
    }

    public  int getPuntuacion() {
        return puntuacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
