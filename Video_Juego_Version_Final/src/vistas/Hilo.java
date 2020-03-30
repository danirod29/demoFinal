package vistas;

import java.awt.event.KeyEvent;

import comando.ComandoDefecto;
import comando.Controles;
import comando.Instrucciones;
import comando.Invoker;
import comando.Mostrar;
import controlador.EventoTeclado;

public class Hilo extends Thread{
	//Panel del juevo(Tablero)
	private PanelBosque tableroJuego;
	
	private boolean estado = true;
	//variables para command
	private Mostrar mostrar= new Mostrar();
	private ComandoDefecto cdef= new ComandoDefecto(mostrar);
	private Controles control= new Controles(mostrar);
	private Instrucciones ins= new Instrucciones(mostrar);
	private Invoker inv;
	
	public Hilo(PanelBosque tableroJuego) {
		this.tableroJuego = tableroJuego;
		//instancia invoker
		inv= new Invoker();
		
	}
	//Actualiza constantemente la pantalla
	public void run() {
		try {
			while(estado) {
				
				tableroJuego.repaint();
				Thread.sleep(350);
				tableroJuego.setFocusable(true);
				
				if(EventoTeclado.isControl()) {
					//toma el comando y lo ejecuta
					inv.TomarComando(control);
					inv.Ordenar();
				}
				if(EventoTeclado.isIns()) {
					inv.TomarComando(ins);
					inv.Ordenar();
				}
				EventoTeclado.setControl(false);
				EventoTeclado.setIns(false);
				
			}
		} catch (Exception e) {
			System.out.println("El hilo no puede iniciar");
			
		}
	}

}
