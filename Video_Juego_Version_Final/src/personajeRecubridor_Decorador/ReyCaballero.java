package personajeRecubridor_Decorador;

import java.awt.Image;

import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.BuiderCaballero;
import personajeOrdenarConstruccion.BuilderMago;

public class ReyCaballero extends PersonajeComplemento{
	//Constructor
	public ReyCaballero(PersonajeAnimado miREY) {
		super(miREY);
		this.complementarPersonaje();
	}
	
	/*
	 * Carateristicas añadidas en tiempo de ejecución para el personaje actual.
	 * Asignando las caracteristicas de una Caballero para el Rey
	 */

	@Override
	public void complementarPersonaje() {
		BuiderCaballero miCaballero = new BuiderCaballero();
		
		directorPersonaje.construir(miCaballero);
		miPerTran = miCaballero.obtenerPerAnimado();
		miPerTran.asignarDatos();
		
		this.posicionX = miREY.posicionX;
		this.posicionY = miREY.posicionY;
		
		//Nuevas caracteristicas en tiempo de ejecucion
		miREY.asigArmadura(miPerTran.getArmaduraPer());
		miREY.asigHabilidad(miPerTran.getHabilidadPer());
		miREY.asigHerramienta(miPerTran.getHerramientaPer());
		
		//Asignacion de los nuevo oficio(Caballero)
		miREY.oficio = miPerTran.oficio;
		miREY.imgPerAni.setNombreImg(miREY.oficio);
		this.experiencia = miREY.experiencia;

	}
	//----------------------------------------------------

	@Override
	public void realizarAccion() {
		miREY.realizarAccion();
	}

	@Override
	public PersonajeAnimado clonarPersonaje() {
		return miREY;
	}

	//Nueva imagen que debe mostrar
	@Override
	public Image imgPersonaje() {
		return miPerTran.imgPersonaje();
	}

	@Override
	public void asignarDatos() {		
	}
	
	@Override
	public void asignarDesplazamiento() {
		// TODO Auto-generated method stub	
	}

}
