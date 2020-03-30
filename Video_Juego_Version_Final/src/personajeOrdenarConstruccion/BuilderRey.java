package personajeOrdenarConstruccion;

import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeRey;
import personajeOrdenarConstruccion.*;
import partesPersonaje.ArmaduraCaballeroOro;
import partesPersonaje.ArmaduraRecolector;
import partesPersonaje.HerramientaArqueroOro;
import partesPersonaje.HerramientaRecolector;
import partesPersonaje.HerramientaRey;

public class BuilderRey implements Builder{
	//Atributos
    private PersonajeAnimado miPerRey = new PersonajeRey();
    
    //Constructor
    public BuilderRey() {
    }
    /*
     * Se envian las correspondientes partes 
    	del personaje Mago
    */

    @Override
    public void construirArmadura() {
    	miPerRey.asigArmadura(new ArmaduraCaballeroOro());  
    }

    @Override
    public void asignarHabilidad() {
    	miPerRey.asigHabilidad(null);
    }

    @Override
    public void asignarHerramienta() {
    	miPerRey.asigHerramienta(new HerramientaRey());
    }
    
    //Retorna el personaje-Mago
    public PersonajeAnimado obtenerPerAnimado(){
        return miPerRey;
    }
}
