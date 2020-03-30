package elementosEscenario_Composite;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import plantillas.PlantillaCreacionImagenes;

/**
 *
 * @author Cristian
 */
public abstract class DibujoEspecifico extends PlantillaCreacionImagenes implements DibujoComponente{
    //Atributos
     protected String nombreObjeto;
     protected static final  int ANCHO = 50;
     protected static final int ALTO = 50;
    
     //--------------------------------------------------------------------
     //Constructor
     public DibujoEspecifico() {	
     }
     
     //Metodos de la clase
	 public static int getAncho() {
		return ANCHO;
	 }
	
	 public static int getAlto() {
		return ALTO;
	 }   
         
}
