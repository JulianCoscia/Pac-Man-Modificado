package Musica;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Musica{
	
	private Clip clip;
	
	public Musica() {
	            	try {
						clip =AudioSystem.getClip();
					} catch (LineUnavailableException e) {
						e.printStackTrace();
					}
	}

	public void abrir(AudioInputStream stream) throws LineUnavailableException, IOException {
		clip.open(stream);
	}
	public void iniciar() {
		clip.start();
	}
	public void repetirInfinitamente() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void detener() {
		clip.stop();
	}
}
