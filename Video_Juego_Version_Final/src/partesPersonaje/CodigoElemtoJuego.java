package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public abstract class CodigoElemtoJuego {
	//Atributos
	protected String codigoUbicacion;
	protected String elementoCategoria;
	protected PlantillaCreacionImagenes miPlanImg;
	
	//Asigna el codigo para cada elemento del juego(Habilidad,Armadura,Poder)
	public void asignarCodigo(String codigo) {
		this.codigoUbicacion = codigo;
	}
	
	
	public String retornarCodigo() {
		return codigoUbicacion;	
	}
	
	//Asigna la categoria de cada elemento(Mago, Arquero, Rey etc)
	public  String getElementoCategoria() {
		return elementoCategoria;
	}
	
	//Retorna la imegen de cada elemento(Fuego, hilo, arco etc)
	public abstract Image retornarImagen();
	
	
	public PlantillaCreacionImagenes plantillaImagen() {
		return miPlanImg;
	}
	

}
