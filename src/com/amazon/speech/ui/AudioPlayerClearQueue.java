package com.amazon.speech.ui;

/**
 * Created by rvanderwerf on 9/13/16.
 */
public class AudioPlayerClearQueue extends Directive {

	String audioType = "AudioPlayer.ClearQueue";

	public String getAudioType() {
		return audioType;
	}

	public void setAudioType(String audioType) {
		this.audioType = audioType;
	}
}
