package personajeOrdenarConstruccion;

import personajeOrdenarConstruccion.*;;

public class Director {
	//Orden en la construccion del personaje
	 public void construir(Builder miBuilder){
	        miBuilder.construirArmadura();
	        miBuilder.asignarHabilidad();
	        miBuilder.asignarHerramienta();
	    }
}
