package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class HerramientaArqueroDiamante extends HerramientaPersonaje{

	//Constructor
	public HerramientaArqueroDiamante() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatorHerramienta();
	}
	

	//Inicializa los atributos
	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "HerramientaArcoDiamante";
		categoriaHerramienta = "Arquero";
		dagno = 15;
		miPlanImg.setNombreImg(nombreHerramienta);
		elementoCategoria = categoriaHerramienta;
		
	}


	//Inicializa los atributos
	@Override
	public Image retornarImagen(){
		// TODO Auto-generated method stub
		return miPlanImg.getImagenMov2();
	}
	
	//Realiza copias
	@Override
	public HerramientaPersonaje clonarHerramienta() {
		HerramientaPersonaje miClon = new HerramientaArqueroDiamante();
		return miClon;
	}

}
