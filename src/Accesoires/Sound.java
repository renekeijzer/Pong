package Accesoires;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sound {
	private static Audio boop;
	private static Audio beep;
	private static Audio bamf;
	
	public static void PlayBoop(){
		if (boop == null){
			boop = LoadAudio("Assets\\Boop.wav", "WAV");
		}
		boop.playAsSoundEffect(1.0f, 2.0f, false);
	}
	
	public static void PlayBeep(){
		if (beep == null){
			beep = LoadAudio("Assets\\Beep.wav", "WAV");
		}
		beep.playAsSoundEffect(1.0f, 0.5f, false);
	}
	
	public static void PlayBamf(){
		if (bamf == null){
			bamf = LoadAudio("Assets\\Bamf.wav", "WAV");
		}
		bamf.playAsSoundEffect(1.0f, 0.5f, false);
	}
	
	
	private static Audio LoadAudio(String location, String type){
		try {
			Audio Effect = AudioLoader.getAudio(type, ResourceLoader.getResourceAsStream(location));
			return Effect;
		} catch (IOException e) {
			return null;
		}
	}
	
}
