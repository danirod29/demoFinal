package personajeEstados;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class PersonajeEstadoVisualRecolectorA implements PersonajeEstadoVisual{
	//Atributos
	private PlantillaCreacionImagenes plantillaImg = new PlantillaCreacionImagenes();
	
	//Retorna la imagen del personajeRecolector en tiempo de ejecución
	@Override
	public Image asignarImagen() {
		plantillaImg.setNombreImg("RecolectorA");
		return plantillaImg.getImagenMov2();
	}

}
