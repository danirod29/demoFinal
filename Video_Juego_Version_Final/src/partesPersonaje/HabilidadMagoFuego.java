package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HabilidadMagoFuego extends HabilidadPersonaje{
	
	//Constructor
	public HabilidadMagoFuego() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	
	//Inicializa los atributos
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadFuego";
		categoriaHabilidad = "Mago";
		dagno = 13;
		miPlanImg.setNombreImg(nombreHabilidad);
		elementoCategoria = categoriaHabilidad;
	}

	//Retorna la imagen que representa el elemento
	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	
	//Realiza copias 
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadMagoFuego();
		return miClo;
	}

}
