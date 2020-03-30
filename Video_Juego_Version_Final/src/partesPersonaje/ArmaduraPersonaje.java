package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public abstract class ArmaduraPersonaje extends CodigoElemtoJuego{
	//Atributos
	protected String nombreArmadura;
	protected String categoriaArmadura;
	public int dagno;
	protected boolean estado;
	protected Image imgArmadura;

	//Constructor		
	public ArmaduraPersonaje() {	
	}
	
	//Metodos
	public abstract void asignarDatosArmadura();
	public abstract Image retornarImagen();
	public abstract ArmaduraPersonaje clonarArmadura();
	
	

}
