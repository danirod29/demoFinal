package personajeRecubridor_Decorador;

import java.awt.Image;

import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.BuilderArquero;
import personajeOrdenarConstruccion.BuilderMago;

public class ReyArquero extends PersonajeComplemento {

	//Constructor
	public ReyArquero(PersonajeAnimado miREY) {
		super(miREY);
		this.complementarPersonaje();
	}
	
	/*
	 * Carateristicas añadidas en tiempo de ejecución para el personaje actual.
	 * Asignando las caracteristicas de una Arquero para el Rey
	 */
	
	@Override
	public void complementarPersonaje() {
		
		BuilderArquero miArquero = new BuilderArquero();
		directorPersonaje.construir(miArquero);
		
		miPerTran = miArquero.obtenerPerAnimado();
		miPerTran.asignarDatos();
		
		this.posicionX = miREY.posicionX;
		this.posicionY = miREY.posicionY;
		
		//Nuevas caracteristicas en tiempo de ejecucion
		miREY.asigArmadura(miPerTran.getArmaduraPer());
		miREY.asigHabilidad(miPerTran.getHabilidadPer());
		miREY.asigHerramienta(miPerTran.getHerramientaPer());
		
		//Asignacion de los nuevo oficio(Arquero)
		miREY.oficio = miPerTran.oficio;
		
		miREY.imgPerAni.setNombreImg(miREY.oficio);
		this.experiencia = miREY.experiencia;

	}
	//----------------------------------------------------
	
	@Override
	public void realizarAccion() {
		miREY.realizarAccion();
	}
	
	//Nueva imagen que debe mostrar
	@Override
	public Image imgPersonaje() {
		return miPerTran.imgPersonaje();
	}
	
	
	@Override
	public PersonajeAnimado clonarPersonaje() {
		return miREY;
	}

	@Override
	public void asignarDatos() {		
	}
	
	@Override
	public void asignarDesplazamiento() {		
	}
	

}
