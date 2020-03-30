package plantillas;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PlantillaCreacionImagenes {
	//Atributos
    protected File ubicacion;
    protected Image imgDibujo;
    public String nombreImg;
    public static final int ANCHO=50, ALTO=50;
    public String numImg="";
   
    //Constructores---------------------------------------------------------
    public PlantillaCreacionImagenes() {	
    }
  
   //Metodos--------------------------------------------------------------------- 
   
   //Permite inicializar la imagen
   public Image getImagenMov(){
       //Asigna la ruta de la imagen
       ubicacion = new File("src/elementosEscenarioImagen/"+nombreImg+numImg+".png");
       //Crea la imagen con las especificaciones necesarias
       try {
           imgDibujo = ImageIO.read(ubicacion);
       } catch (IOException ex) {
           System.out.println(nombreImg+" NO ENCONTRADA");
       }
       return imgDibujo;
   }
   
   public Image getImagenMov2(){
       //Asigna la ruta de la imagen
       ubicacion = new File("src/partesPersonajeImagenes/"+nombreImg+numImg+".png");
       //Crea la imagen con las especificaciones necesarias
       try {
           imgDibujo = ImageIO.read(ubicacion);
       } catch (IOException ex) {
           System.out.println(nombreImg+" NO ENCONTRADA");
       }
       return imgDibujo;
   }


	public void setNombreImg(String nombreImg) {
		this.nombreImg = nombreImg;
	}
   //------------------------------------------------------------------------
}
