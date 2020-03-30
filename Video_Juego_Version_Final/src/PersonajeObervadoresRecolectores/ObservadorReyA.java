package PersonajeObervadoresRecolectores;

import java.awt.Graphics;

import partesPersonaje.CodigoElemtoJuego;
import partesPersonaje.HabilidadMagoFuego;
import personajeCompleto.PersonajeAnimado;
import personajeEstados.PersonajePoder;
import personajeRecubridor_Decorador.ReyArquero;
import personajeRecubridor_Decorador.ReyCaballero;
import personajeRecubridor_Decorador.ReyMago;

public class ObservadorReyA implements ObservadorRecolector{
	//Atributos
	PersonajeAnimado personajeActual;
	PersonajePoder poderPersonaje;
	
	
	//Asigna las nuevas caracteristicas para el personaje A
	@Override
	public void notificar(PersonajeAnimado per, CodigoElemtoJuego codigoAgrega) {
		this.personajeActual = per;
		//Recubre al personaje
		if(codigoAgrega.getElementoCategoria()=="Mago") {
			personajeActual = new ReyMago(personajeActual);
		}else if(codigoAgrega.getElementoCategoria()=="Caballero") {
			personajeActual = new ReyCaballero(personajeActual);
		}else if(codigoAgrega.getElementoCategoria()=="Arquero"){
			personajeActual = new ReyArquero(personajeActual);
		}
		
		//Asigna el poder, Habilidad o Armadura 
		poderPersonaje = new PersonajePoder(codigoAgrega);
		
		
		//Agrega la nueva caracteristica al personaje
		personajeActual.asignarPoderActual(poderPersonaje);
	}

	//Retorna el personaje con las nuevas caracteristicas
	@Override
	public PersonajeAnimado retornarNuevoEstado() {
		return personajeActual;
	}

}
