
//package SeulGame;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	public static void main(String[] args) {
		File Victory = new File("BattleShip_Victory.wav");
		File Defeat = new File("BattleShip_Defeat.wav");
		File Explosion = new File("BattleShip_Explosion.wav");
		File Miss = new File("BattleShip_Miss.wav");

		PlaySound(Victory);

	}

	public static void PlaySound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();

			Thread.sleep(clip.getMicrosecondLength() / 1000);
		} catch (Exception e) {

		}
	}
}
