package partesPersonaje;

import java.awt.Image;

public class HerramientaRecolector extends HerramientaPersonaje {
	
	//Constructor
	public HerramientaRecolector() {
		this.asignarDatorHerramienta();
	}

	
	//Inicializa los atributos
	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "Canasto";
		categoriaHerramienta = "Recolector";
		dagno = 1;
		elementoCategoria = categoriaHerramienta;
	}
	
	//Realiza copias 
	@Override
	public HerramientaPersonaje clonarHerramienta() {
		HerramientaPersonaje miClon = new HerramientaRecolector();
		return miClon;
	}
	
	//Retorna la imagen que representa el elemento
	@Override
	public Image retornarImagen(){
		// TODO Auto-generated method stub
		return null;
	}

}
