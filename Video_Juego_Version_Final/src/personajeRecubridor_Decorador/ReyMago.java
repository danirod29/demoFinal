package personajeRecubridor_Decorador;

import java.awt.Image;

import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.BuilderMago;

public class ReyMago extends PersonajeComplemento{

	//Constructor
	public ReyMago(PersonajeAnimado miREY) {
		super(miREY);
		this.complementarPersonaje();
	}
	
	/*
	 * Carateristicas a�adidas en tiempo de ejecuci�n para el personaje actual.
	 * Asignando las caracteristicas de una Mago para el Rey
	 */


	@Override
	public void complementarPersonaje() {
		BuilderMago miMago = new BuilderMago();
		
		directorPersonaje.construir(miMago);
		miPerTran = miMago.obtenerPerAnimado();
		miPerTran.asignarDatos();
		
		this.posicionX = miREY.posicionX;
		this.posicionY = miREY.posicionY;
		
		//Nuevas caracteristicas en tiempo de ejecucion
		miREY.asigArmadura(miPerTran.getArmaduraPer());
		miREY.asigHabilidad(miPerTran.getHabilidadPer());
		miREY.asigHerramienta(miPerTran.getHerramientaPer());
		
		//Asignacion de los nuevo oficio(Mago)
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
