package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventoTeclado extends KeyAdapter{
	public static boolean IZQUIERDA, DERECHA, ARRIBA, ABAJO;
	public static boolean TOMARobjA, TOMAobjS;
	private static boolean control, ins;
	
	public void keyPressed(KeyEvent e) {		
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_LEFT) {
			IZQUIERDA = true;
		}
		if(id == KeyEvent.VK_RIGHT) {
			DERECHA = true;
		}
		if(id  == KeyEvent.VK_UP) {
			ARRIBA = true;
		}
		if(id == KeyEvent.VK_DOWN) {
			ABAJO = true;
		}
		if(id == KeyEvent.VK_A) {
			TOMARobjA = true;
		}
		if(id == KeyEvent.VK_S) {
			TOMAobjS = true;
		}
		if(id==KeyEvent.VK_C) {
			control=true;
			
		}
		if(id==KeyEvent.VK_I) {
			ins=true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_LEFT) {
			IZQUIERDA = false;
		}
		if(id == KeyEvent.VK_RIGHT) {
			DERECHA = false;
		}
		if(id  == KeyEvent.VK_UP) {
			ARRIBA = false;
		}
		if(id == KeyEvent.VK_DOWN) {
			ABAJO = false;
		}
		if(id == KeyEvent.VK_A) {
			TOMARobjA = false;
		}
		if(id == KeyEvent.VK_S) {
			TOMAobjS = false;
		}
		if(id==KeyEvent.VK_C) {
			control=false;
		}
		if(id==KeyEvent.VK_I) {
			ins=false;
		}
	}

	public static boolean isControl() {
		return control;
	}

	public static void setControl(boolean control) {
		EventoTeclado.control = control;
	}

	public static boolean isIns() {
		return ins;
	}

	public static void setIns(boolean ins) {
		EventoTeclado.ins = ins;
	}
	

}
