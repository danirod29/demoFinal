package vistas;



import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.EventoTeclado;

public class VentanaBosque extends JFrame{
	//Atributos
	private PanelBosque jpBosque;
	private Hilo hiloBosque;

	
	public VentanaBosque() {
		//Disposicion de la ventana	
		this.setTitle("Bosque_Pequeño");
		this.setSize(569, 545);
		
		jpBosque = new PanelBosque();
		jpBosque.setBackground(Color.white);
		this.add(jpBosque);
		//La ventana estara a la escucha
		this.addKeyListener(new EventoTeclado());
		//Se inicializa el hilo
		hiloBosque = new Hilo(jpBosque);
		//El hilo inicia (Actualiza el estado de la pantalla)
		hiloBosque.start();
	}
}

