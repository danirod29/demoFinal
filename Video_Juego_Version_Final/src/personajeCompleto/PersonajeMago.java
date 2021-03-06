package personajeCompleto;

import java.awt.Image;

import personajeOrdenarConstruccion.BuilderMago;
import personajeOrdenarConstruccion.BuilderRecolector;
import personajeOrdenarConstruccion.Director;

public class PersonajeMago extends PersonajeAnimado {
	//Constructor
	public PersonajeMago() {
	}
	
	//Asigna las caracteristicas del personaje Arquero 
	@Override
	public void asignarDatos() {
		this.oficio = "Mago";
		this.imgPerAni.setNombreImg(oficio);
	}
	
	
	//Retorna la imagen del personaje
	@Override
	public Image imgPersonaje() {
			this.realizarAccion();
		return imgPerAni.getImagenMov2();
	}
	
	//Reasigna el valor de la img del personaje
	@Override
	public void realizarAccion() {
		if(acumulador == 1) {
			imgPerAni.numImg = "1";
		}else {
			imgPerAni.numImg = "2";
			acumulador = 0;
		}
		acumulador ++;
	}
	
	//Clones para el Arquero
	@Override
	public PersonajeAnimado clonarPersonaje() {
		PersonajeAnimado miClonMago;
	    //Se Determinan las partes del Mago
	    Director miDirector = new Director();
	    BuilderMago miBuilderMago = new BuilderMago();
	        
	    miDirector.construir(miBuilderMago);
	    //Se instancia el objeto para que sea Mago
	    miClonMago = miBuilderMago.obtenerPerAnimado();
	    //Metodos que reciben parametros
	    return miClonMago;
	}
		

	@Override
	public void asignarDesplazamiento() {
		// TODO Auto-generated method stub
		
	}


}
