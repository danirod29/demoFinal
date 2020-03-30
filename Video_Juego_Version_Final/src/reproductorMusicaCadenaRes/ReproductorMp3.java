package reproductorMusicaCadenaRes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReproductorMp3 extends Reproductor {

	private static boolean pausa = false;

	@Override
	public void reproducir(int op) {
		//recibe el parametro y reproduce
		if (op == 1) {
			Player pl;
			try {
				pl = new Player(new FileInputStream(
						"src/musica/Radioactive (8 Bit Remix Cover Version) [Tribute to Imagine Dragons] - 8 Bit Universe.mp3"));
				try {
					new Thread() {
						public void run() {
							try {
								while (true) {
									if (!pausa) {
										if (!pl.play(1)) {
											break;
										}
									}
								}
							} catch (JavaLayerException e) {
								e.printStackTrace();
							}
						}
					}.start();

					Thread.sleep(10000);
					pausa = true;
					
					Thread.sleep(2000);
					pausa = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//en caso contrario pasa al siguente en la cadena	
		} else
			siguiente.reproducir(op);

	}

}
