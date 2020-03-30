package elementosEscenario_Composite;

import java.awt.Graphics;

/**
 *
 * @author Cristian
 */
public class DibujoEspecificoArbol extends DibujoEspecifico{
    
	//Se inicializa para arbol por defecto(Pequeño)
	public DibujoEspecificoArbol(){
        //Se inicializa el nombre de la imagen
        this.nombreObjeto = "arbolPequegno";
        nombreImg = nombreObjeto;
    }
	
	@Override
	public DibujoComponente clonarComponente() {
		DibujoEspecifico miArbolPeg = new DibujoEspecificoArbol();
        return  miArbolPeg;
	}


	@Override
	public void agregarElementoComposicion(DibujoComponente miComposicion) {		
	}  
}
