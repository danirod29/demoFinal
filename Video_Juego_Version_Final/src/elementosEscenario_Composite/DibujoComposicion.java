package elementosEscenario_Composite;

import java.awt.Graphics;
import java.util.ArrayList;

import plantillas.PlantillaCreacionImagenes;

public abstract class DibujoComposicion extends PlantillaCreacionImagenes implements DibujoComponente{
    //Atributos
    protected ArrayList<DibujoEspecifico> elementosDibujo = new ArrayList<>();

    //Constructor
    public DibujoComposicion() {
    	
    }
  
    //----------------------------------------------------------------------
    
    //Permite agregar un elemento a la lista
    @Override
	public void agregarElementoComposicion(DibujoComponente miComposicion) {
		elementosDibujo.add((DibujoEspecifico)miComposicion);
	}   
    
    //Retorna la lista de elementos de la composicion
    public ArrayList<DibujoEspecifico> getElementosDibujo() {
		return elementosDibujo;
	}  
}
