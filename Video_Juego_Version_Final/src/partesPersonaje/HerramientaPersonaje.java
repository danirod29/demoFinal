package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public abstract class HerramientaPersonaje extends CodigoElemtoJuego{
	//Atributos
	protected String nombreHerramienta;
	protected String categoriaHerramienta;
	public int dagno;
	protected boolean estado;
	protected Image imgHerramienta;
	
	public HerramientaPersonaje() {	
	}
	
	public abstract void asignarDatorHerramienta();
	public abstract Image retornarImagen();
	public abstract HerramientaPersonaje clonarHerramienta();
	
	//------------------------------------------------------
	

}
