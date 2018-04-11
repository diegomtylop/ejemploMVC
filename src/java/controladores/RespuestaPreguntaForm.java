package controladores;

import entidades.Pregunta;
import java.util.List;

class RespuestaPreguntaForm{
        Pregunta pregunta;
        String prueba;
        String[] opcionesSeleccionadas;
        List opcionesDisponibles;

        public RespuestaPreguntaForm() {
        }
        
        

        public Pregunta getPregunta() {
            return pregunta;
        }

        public List getOpcionesDisponibles() {
            return opcionesDisponibles;
        }

        public void setOpcionesDisponibles(List opcionesDisponibles) {
            this.opcionesDisponibles = opcionesDisponibles;
        }

        public void setPregunta(Pregunta pregunta) {
            this.pregunta = pregunta;
        }

        public String getPrueba() {
            return prueba;
        }

        public void setPrueba(String prueba) {
            this.prueba = prueba;
        }

        public String[] getOpcionesSeleccionadas() {
            return opcionesSeleccionadas;
        }

        public void setOpcionesSeleccionadas(String[] opcionesSeleccionadas) {
            this.opcionesSeleccionadas = opcionesSeleccionadas;
        }
        
        
        
    }