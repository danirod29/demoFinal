package personajeOrdenarConstruccion;

import partesPersonaje.ArmaduraRecolector;
import partesPersonaje.HabilidadArqueroMira;
import partesPersonaje.HabilidadMagoFuego;
import partesPersonaje.HerramientaArqueroOro;
import partesPersonaje.HerramientaRecolector;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeArquero;
import personajeCompleto.PersonajeMago;

public class BuilderArquero implements Builder{
	//Atributos
    private PersonajeAnimado miPerArquero = new PersonajeArquero();
    
    //Constructor
    public BuilderArquero() {
    }
    /*
     * Se envian las correspondientes partes 
    	del personaje Mago
    */

	@Override
	public void construirArmadura() {
		miPerArquero.asigArmadura(new ArmaduraRecolector());
	}

	@Override
	public void asignarHabilidad() {
		miPerArquero.asigHabilidad(new HabilidadArqueroMira());
	}

	@Override
	public void asignarHerramienta() {
		miPerArquero.asigHerramienta(new HerramientaArqueroOro());
	}
	
	//Retorna el personaje-Mago
    public PersonajeAnimado obtenerPerAnimado(){
        return miPerArquero;
    }

}
