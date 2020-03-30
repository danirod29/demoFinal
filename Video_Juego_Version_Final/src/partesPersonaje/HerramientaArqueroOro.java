package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HerramientaArqueroOro extends HerramientaPersonaje{
	//Constructor
	public HerramientaArqueroOro() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatorHerramienta();
	}
	
	//Inicializa los atributos
	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "HerramientaArcoOro";
		categoriaHerramienta = "Arquero";
		dagno = 5;
		miPlanImg.setNombreImg(nombreHerramienta);
		elementoCategoria = categoriaHerramienta;
	}
	
	//Retorna la imagen que representa el elemento
	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	
	//Realiza copias 
	@Override
	public HerramientaPersonaje clonarHerramienta() {
		HerramientaPersonaje miClon = new HerramientaArqueroOro();
		return miClon;
	}

}
