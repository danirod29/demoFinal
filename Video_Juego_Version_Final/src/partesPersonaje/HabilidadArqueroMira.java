package partesPersonaje;

import java.awt.Image;

import elementosEscenario_Composite.DibujoEspecifico;
import elementosEscenario_Composite.DibujoEspecificoArbol;
import plantillas.PlantillaCreacionImagenes;

public class HabilidadArqueroMira extends HabilidadPersonaje{
	
	//Constructor
	public HabilidadArqueroMira() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	
	//Inicializa los atributos
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadMira";
		categoriaHabilidad = "Arquero";
		dagno = 16;
		miPlanImg.setNombreImg(nombreHabilidad);
		elementoCategoria = categoriaHabilidad;
	}
	
	//Reroena la imagen que representa el elemento
	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	
	//Realiza copias 
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadArqueroMira();
		return miClo;
	}

}
