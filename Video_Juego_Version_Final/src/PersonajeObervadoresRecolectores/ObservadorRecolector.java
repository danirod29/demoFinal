package PersonajeObervadoresRecolectores;

import java.awt.Graphics;

import partesPersonaje.CodigoElemtoJuego;
import personajeCompleto.PersonajeAnimado;

public interface ObservadorRecolector {
	//Notifica al observador
	public void notificar(PersonajeAnimado personajeActual, CodigoElemtoJuego codigoAgrega);
	//Accion a realizar por el observador
	public PersonajeAnimado retornarNuevoEstado();
}
