package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class ArmaduraCaballeroOro extends ArmaduraPersonaje{
	public ArmaduraCaballeroOro() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosArmadura();
	}
	@Override
	public void asignarDatosArmadura() {
		nombreArmadura = "ArmaduraOro";
		categoriaArmadura = "Caballero";
		dagno = 16;
		miPlanImg.setNombreImg(nombreArmadura);
		elementoCategoria = categoriaArmadura;
	}

	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	
	@Override
	public ArmaduraPersonaje clonarArmadura() {
		ArmaduraPersonaje miClo = new ArmaduraCaballeroOro();
		return miClo;
	}

}
