package reproductorMusicaCadenaRes;

import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//concrete handler
public class ReproductorWav extends Reproductor {

	@Override
	public void reproducir(int op) {
		if (op == 2) {
			try {
				Clip sonido = AudioSystem.getClip();
				File a = new File("src/musica/Believer [8 Bit Tribute to Imagine Dragons] - 8 Bit Universe.wav");
				sonido.open(AudioSystem.getAudioInputStream(a));
				sonido.start();
				
				Thread.sleep(10000); 
				sonido.close();
			} catch (Exception tipoError) {
				System.out.println("" + tipoError);
			}

		}

		else
			siguiente.reproducir(op);

	}

}
