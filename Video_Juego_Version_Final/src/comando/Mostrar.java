package comando;

import vistas.ControlesVista;

public class Mostrar {
	
	public Mostrar() {
		
	}
	
	
	public void mostrarControles() {
		ControlesVista ver= new ControlesVista("/tuto/controles.png");
		ver.setVisible(true);
		
	}
	
	public void mostrarInstruciones() {
		ControlesVista ver= new ControlesVista("/tuto/instrucciones.png");
		ver.setVisible(true);
	}
	
	public void mostrarImg() {
		System.out.print("no mostrado");
	}

}
