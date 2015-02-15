package org.sumanta;

import org.junit.Ignore;
import org.junit.Test;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SpeechTest {
	// Default voice is Kevin16
	private static final String VOICENAME = "kevin16";
	private static final String staticText= "hello world";
	
	@Ignore
	@Test
	public void testHelloWorld() {
		Voice voice;
		// Taking instance of voice from VoiceManager factory.
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME);
		// Allocating voice
		voice.allocate();
		// word per minute
		voice.setRate(120);
		voice.setPitch(100);
		try {
			voice.speak(staticText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
