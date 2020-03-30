package partesPersonaje;

import java.awt.Image;

import personajeCompleto.PersonajeAnimado;
import plantillas.PlantillaCreacionImagenes;

public abstract class HabilidadPersonaje extends CodigoElemtoJuego{
		//Atributos
		protected String nombreHabilidad;
		protected String categoriaHabilidad;
		public int dagno;
		protected boolean estado;
		protected Image imgHabilidad;

		
		public HabilidadPersonaje() {	
		}
		
		public abstract void asignarDatosHabilidad();
		public abstract Image retornarImagen();
		
		
		//------------------------------------------------------
		public abstract HabilidadPersonaje clonarHabilidad();
		
		

}
