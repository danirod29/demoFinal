package personajeOrdenarConstruccion;

import partesPersonaje.ArmaduraRecolector;
import partesPersonaje.HabilidadMagoFuego;
import partesPersonaje.HerramientaRecolector;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeMago;
import personajeCompleto.PersonajeRecolector;

public class BuilderMago implements Builder{
	//Atributos
    private PersonajeAnimado miPerMago = new PersonajeMago();
    
    //Constructor
    public BuilderMago() {
    }
    /*
     * Se envian las correspondientes partes 
    	del personaje Mago
    */

	@Override
	public void construirArmadura() {
		miPerMago.asigArmadura(new ArmaduraRecolector());
	}

	@Override
	public void asignarHabilidad() {
		miPerMago.asigHabilidad(new HabilidadMagoFuego());
	}

	@Override
	public void asignarHerramienta() {
		miPerMago.asigHerramienta(new HerramientaRecolector());
		
	}
	
	//Retorna el personaje-Mago
    public PersonajeAnimado obtenerPerAnimado(){
        return miPerMago;
    }
}
