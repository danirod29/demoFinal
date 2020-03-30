package PersonajeObervadoresRecolectores;

import java.awt.Graphics;

import partesPersonaje.CodigoElemtoJuego;
import personajeCompleto.PersonajeAnimado;
import personajeEstados.PersonajePoder;
import personajeOrdenarConstruccion.BuilderRey;
import personajeOrdenarConstruccion.Director;
import personajeRecubridor_Decorador.ReyArquero;
import personajeRecubridor_Decorador.ReyCaballero;
import personajeRecubridor_Decorador.ReyMago;

public class ObservadorReyB implements ObservadorRecolector{
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
		
		//Asigna el poder, Habilidad o Armadura(Para mostrar la imagen)
		poderPersonaje = new PersonajePoder(codigoAgrega);
		personajeActual.asignarPoderActual(poderPersonaje);
	}

	//Retorna el personaje con las nuevas caracteristicas
	@Override
	public PersonajeAnimado retornarNuevoEstado() {
		return personajeActual;
	}

}
