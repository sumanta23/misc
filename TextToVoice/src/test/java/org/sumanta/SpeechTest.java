package org.sumanta;

import org.junit.Ignore;
import org.junit.Test;
import org.sumanta.json.Example;

import com.google.gson.Gson;
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
	
	@Test
	public void testLanguageChangeAndSpeech(){
	    WebUtil webUtil=new WebUtil();
	    String baseUrl="https://www.googleapis.com/language/translate/v2?key=AIzaSyBtfSp9TSlUDCNJ0jTwFc-PelOc24-LuzM&source=en&target=de&q=";
	    String jsonTxt=webUtil.executeCommand(baseUrl, "good day");
	    jsonTxt=jsonTxt.replace("\n", "");
	    Gson gson=new Gson();
	    Example data=gson.fromJson(jsonTxt, Example.class);
	    jsonTxt=data.getData().getTranslations().get(0).getTranslatedText();
	    
	    
	    Voice voice;
            // Taking instance of voice from VoiceManager factory.
            VoiceManager voiceManager = VoiceManager.getInstance();
            voice = voiceManager.getVoice(VOICENAME);
            // Allocating voice
            voice.allocate();
            // word per minute
            voice.setRate(110);
            voice.setPitch(120);
            try {
                    voice.speak(jsonTxt);
            } catch (Exception e) {
                    e.printStackTrace();
            }
	}
	
	
}
