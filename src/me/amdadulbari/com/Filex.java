package me.amdadulbari.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Filex {
	public static void fileReaderFunc(String path) throws IOException {
		File file = new File(path);
		String line=null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			 while((line = bufferedReader.readLine()) != null){
				speechBot(line);
			}
		} catch (FileNotFoundException e) {
			
		}
		
		
	}
	
	public static void speechBot(String line){
		Voice voice;
		
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice("kevin");
		voice.allocate();
		voice.speak(line);
	}
}
