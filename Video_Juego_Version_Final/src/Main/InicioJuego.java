package Main;

import vistas.VentanaBosque;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import reproductorMusicaCadenaRes.Reproductor;
import reproductorMusicaCadenaRes.ReproductorMp3;
import reproductorMusicaCadenaRes.ReproductorWav;
import reproductorMusicaCadenaRes.Reproductordefault;
import vistas.*;

import javax.swing.JComponent;


/**
 *@author Angiu Vanessa Ramirez 20172020-100
 *@author Cristian  Torres Chaparro 20172020-116
 * @author Daniel Rodriguez 20172020-120
 */
public class InicioJuego {
    public static void main(String[] args) {
    	//crea e inicializa los reproductores de musica
    	Reproductor rep[] = new Reproductor[3];

		rep[0] = new ReproductorMp3();
		rep[1] = new ReproductorWav();
		rep[2] = new Reproductordefault();
		
    	//Para ventana
		VentanaBosque jfInicio = new VentanaBosque();
		jfInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfInicio.setVisible(true);
		//asigna el siguiente en la cola
		for (int i = 0; i < rep.length - 1; i++) {
			rep[i].setSiguiente(rep[i + 1]);
		}
		//ciclo de reproduccion
		long cont = System.nanoTime();
		while (true) {
			if (System.nanoTime() >= cont) {
				rep[0].reproducir(1);
				cont=System.nanoTime()+cont;	
			}
			else {
				rep[0].reproducir(2);
				cont=System.nanoTime();
			}
		}
    }
}