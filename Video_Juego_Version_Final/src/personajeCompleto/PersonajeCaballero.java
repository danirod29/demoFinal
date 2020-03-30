package personajeCompleto;

import java.awt.Image;

import personajeOrdenarConstruccion.BuilderArquero;
import personajeOrdenarConstruccion.Director;

public class PersonajeCaballero extends PersonajeAnimado{
	//Constructor
	public PersonajeCaballero() {
	}
	
	//Asigna las caracteristicas del personaje Arquero
	@Override
	public void asignarDatos() {
		this.oficio = "Caballero";
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
			PersonajeAnimado miClonCaballero;
			//Se Determinan las partes del Mago
			Director miDirector = new Director();
			BuilderArquero miBuilderCaballero = new BuilderArquero();
			        
			miDirector.construir(miBuilderCaballero);
			//Se instancia el objeto para que sea Mago
			miClonCaballero = miBuilderCaballero.obtenerPerAnimado();
			//Metodos que reciben parametros
		return miClonCaballero;
	}
		
	@Override
	public void asignarDesplazamiento() {
		// TODO Auto-generated method stub	
	}
	
}
