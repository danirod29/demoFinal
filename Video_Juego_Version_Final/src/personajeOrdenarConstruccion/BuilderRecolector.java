package personajeOrdenarConstruccion;

import partesPersonaje.*;
import personajeCompleto.*;

public class BuilderRecolector implements Builder{
	//Atributos
    private PersonajeAnimado miPerRecolector = new PersonajeRecolector();
    
    //Constructor
    public BuilderRecolector() {
    }
    /*
     * Se envian las correspondientes partes 
    	del personaje Mago
    */
        
    @Override
    public void construirArmadura() {
    	miPerRecolector.asigArmadura(new ArmaduraRecolector());  
    }

    @Override
    public void asignarHabilidad() {
    	miPerRecolector.asigHabilidad(null);
    }

    @Override
    public void asignarHerramienta() {
    	miPerRecolector.asigHerramienta(new HerramientaRecolector());
        
    }
    
    //Retorna el personaje-Mago
    public PersonajeAnimado obtenerPerAnimado(){
        return miPerRecolector;
    }

}
