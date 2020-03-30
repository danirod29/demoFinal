package partesPersonaje;

import java.awt.Image;

public class HerramientaRey extends HerramientaPersonaje {
	//Constructor
	public HerramientaRey() {
		this.asignarDatorHerramienta();
	}

	//Inicializa los atributos
	@Override
	public void asignarDatorHerramienta() {
		//Atributos
		nombreHerramienta = "EspadaOro";
		categoriaHerramienta = "Rey";
		dagno = 3;
		elementoCategoria = categoriaHerramienta;
	}

	
	@Override
	public Image retornarImagen() {
		return null;
	}

	@Override
	public HerramientaPersonaje clonarHerramienta() {
		return null;
	}

}
