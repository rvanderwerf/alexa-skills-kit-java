package com.amazon.speech.ui;

/**
 * Created by rvanderwerf on 9/13/16.
 */
public class AudioPlayerPlay extends Directive {

	private final String audioType = "REPLACE_ALL";
    /*
	public String getAudioType() {
		return audioType;
	}*/

	public AudioPlayerPlay() {
		super.setPlayBehavior(audioType);
	}


}
