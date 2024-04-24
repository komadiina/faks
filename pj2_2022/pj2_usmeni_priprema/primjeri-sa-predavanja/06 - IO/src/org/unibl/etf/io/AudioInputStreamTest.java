package org.unibl.etf.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AudioInputStreamTest {
	public AudioInputStreamTest() {

		try {
//			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("music.wav"));
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Test_ogg_mp3_48kbps.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			Thread.sleep(15000);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	        SwingUtilities.invokeLater(() -> {
	            JOptionPane.showMessageDialog(null, "Close to exit!");
	        });
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new AudioInputStreamTest();
	}
}