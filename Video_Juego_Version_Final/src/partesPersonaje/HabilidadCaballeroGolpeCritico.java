package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HabilidadCaballeroGolpeCritico extends HabilidadPersonaje{
	//Constructor
	public HabilidadCaballeroGolpeCritico() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	
	//Inicializa los atributos
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadGolpeCritico";
		categoriaHabilidad = "Caballero";
		dagno = 15;
		miPlanImg.setNombreImg(nombreHabilidad);
		elementoCategoria = categoriaHabilidad;
	}

	//Reroena la imagen que representa el elemento
	@Override
	public Image retornarImagen() {
		return miPlanImg.getImagenMov2();
	}
	
	
	//Realiza copias 
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadCaballeroGolpeCritico();
		return miClo;
	}

}
