package personajeOrdenarConstruccion;


import partesPersonaje.ArmaduraCaballeroOro;
import partesPersonaje.ArmaduraRecolector;
import partesPersonaje.HabilidadArqueroMira;
import partesPersonaje.HabilidadCaballeroGolpeCritico;
import partesPersonaje.HerramientaArqueroOro;
import partesPersonaje.HerramientaRey;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeArquero;
import personajeCompleto.PersonajeCaballero;

public class BuiderCaballero implements Builder{
	//Atributos
    private PersonajeAnimado miPerCaballero = new PersonajeCaballero();
    
    //Constructor
    public BuiderCaballero() {
    }
    /*
     * Se envian las correspondientes partes 
    	del personaje Mago
    */

	@Override
	public void construirArmadura() {
		miPerCaballero.asigArmadura(new ArmaduraCaballeroOro());
	}

	@Override
	public void asignarHabilidad() {
		miPerCaballero.asigHabilidad(new HabilidadCaballeroGolpeCritico());
	}

	@Override
	public void asignarHerramienta() {
		miPerCaballero.asigHerramienta(new HerramientaRey());
	}
	
	//Retorna el personaje-Mago
    public PersonajeAnimado obtenerPerAnimado(){
        return miPerCaballero;
    }
}
