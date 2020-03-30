package personajeEstados;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class PersonajeEstadoVisualRecolectorB implements PersonajeEstadoVisual{
	//Atributos
	private PlantillaCreacionImagenes plantillaImg = new PlantillaCreacionImagenes();

	//Retorna la imagen del personajeRecolector en tiempo de ejecución
	@Override
	public Image asignarImagen() {
		plantillaImg.setNombreImg("RecolectorB");
		return plantillaImg.getImagenMov2();
	}
}
