package personajeCompleto;

import java.awt.Image;

import personajeOrdenarConstruccion.*;

public class PersonajeRey extends PersonajeAnimado{

	
	public PersonajeRey() {
	}
	
	
	//Asigna las caracteristicas del personaje Arquero 
	@Override
	public void asignarDatos() {
		this.oficio = "Rey";
		this.nivelDeVida = 300;
		this.imgPerAni.setNombreImg(oficio);
	}
	
	//Retorna la imagen del personaje
	@Override
	public Image imgPersonaje() {
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

	//Clones para el REY
	@Override
	public PersonajeAnimado clonarPersonaje() {
		PersonajeAnimado miClonRey;
        
        //Se Determinan las partes del Mago
        Director miDirector = new Director();
        BuilderRey miBuilderRey = new BuilderRey();
        
        miDirector.construir(miBuilderRey);
        
        //Se instancia el objeto para que sea Mago
        miClonRey = miBuilderRey.obtenerPerAnimado();
        miClonRey.asignarDesplazamiento(this.posicionX, this.posicionY+50);
        miClonRey.asignarDatos();
        //Metodos que reciben parametros
        miClonRey.oficio = "ReyB";
		miClonRey.imgPerAni.setNombreImg(miClonRey.oficio);
		return miClonRey;
	}

	
	
	@Override
	public void asignarDesplazamiento() {
	}
	public void utilizarHabilidadActual() {
		
	}

}
