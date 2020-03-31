package vistas;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelControl extends JPanel {

	
	ImageIcon img;
	
	//asigna y dibuja la imagen
	public PanelControl(String direccion) {
		super();
		
		img= new ImageIcon(getClass().getResource(direccion));
		setSize(img.getIconWidth(), img.getIconHeight());
		
	}
	
	public void paintComponent(Graphics g) {
		Dimension tama�o= getSize();
		
		g.drawImage(img.getImage(), 0, 0, tama�o.width, tama�o.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
}
