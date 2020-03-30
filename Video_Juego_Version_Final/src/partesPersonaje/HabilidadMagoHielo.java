package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HabilidadMagoHielo extends HabilidadPersonaje{
	//Constructor
	public HabilidadMagoHielo() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	
	//Inicializa los atributos
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadHielo";
		categoriaHabilidad = "Mago";
		dagno = 9;
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
		HabilidadPersonaje miClo = new HabilidadMagoHielo();
		return miClo;
	}
}
