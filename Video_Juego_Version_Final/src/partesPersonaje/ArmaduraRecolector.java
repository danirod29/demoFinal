package partesPersonaje;

import java.awt.Image;

public class ArmaduraRecolector extends ArmaduraPersonaje{

	//Constructor
	public ArmaduraRecolector() {
		this.asignarDatosArmadura();
	}
	
	//Asigna los valores a los atributos de (ArmaduraRecolector)
	@Override
	public void asignarDatosArmadura() {
		nombreArmadura = "Tunica";
		categoriaArmadura = "Recolector";
		dagno = 3;
		elementoCategoria = categoriaArmadura;
	}
	
	//Permite realizar clones
	@Override
	public ArmaduraPersonaje clonarArmadura() {
		ArmaduraPersonaje miClo = new ArmaduraRecolector();
		return miClo;
	}
	
	@Override
	public Image retornarImagen(){
		return null;
	}

}
