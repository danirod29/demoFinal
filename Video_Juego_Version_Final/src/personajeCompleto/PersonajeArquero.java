package personajeCompleto;

import java.awt.Image;

import personajeOrdenarConstruccion.BuilderArquero;
import personajeOrdenarConstruccion.BuilderMago;
import personajeOrdenarConstruccion.Director;

public class PersonajeArquero extends PersonajeAnimado{
	
	//Constructor
	public PersonajeArquero() {
	}
		
	//Asigna las caracteristicas del personaje Arquero 
	@Override
	public void asignarDatos() {
		this.oficio = "Arquero";
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
			PersonajeAnimado miClonArquero;
	       //Se Determinan las partes del Arquero
	       Director miDirector = new Director();
	       BuilderArquero miBuildeArquero = new BuilderArquero();
	        
	       miDirector.construir(miBuildeArquero);
	       //Se instancia el objeto para que sea Mago
	       miClonArquero = miBuildeArquero.obtenerPerAnimado();
	       //Metodos que reciben parametros
		return miClonArquero;
	}
	
	@Override
	public void asignarDesplazamiento() {
	}
}
