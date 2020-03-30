package personajeRecubridor_Decorador;

import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.Director;

public abstract class PersonajeComplemento extends PersonajeAnimado{
	//Atributos
	protected Director directorPersonaje = new Director();
	protected PersonajeAnimado miREY;
	protected PersonajeAnimado miPerTran;
	
	//Personaje a recubrir
	public PersonajeComplemento(PersonajeAnimado miREY) {
		this.miREY = miREY;
	}
	
	//Asigna las nuevas caracteristica en tiempo de ejecucion
	public abstract void complementarPersonaje();
}
