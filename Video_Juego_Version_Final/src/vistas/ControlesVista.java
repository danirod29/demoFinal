package vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
//ventana con tutoriales
public class ControlesVista extends JFrame {

	
	//panel con las imagenes
	private PanelControl contentPane;
	
	private String ruta;

	


	//crea la ventana
	public ControlesVista(String ruta) {
		this.setLayout(null);
		this.ruta=ruta;
		this.setSize(700,500);
		contentPane = new PanelControl(ruta);
		contentPane.repaint();
		contentPane.setBounds(0, 0, 700, 500);
		this.add(contentPane);
		
		
	}

}
