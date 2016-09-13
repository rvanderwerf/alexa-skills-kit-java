package com.amazon.speech.ui;

/**
 * Created by rvanderwerf on 9/13/16.
 */
public class Stream {
    String token = "";
	String url = "";
	int offsetInMilliseconds = 0;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOffsetInMilliseconds() {
		return offsetInMilliseconds;
	}

	public void setOffsetInMilliseconds(int offsetInMilliseconds) {
		this.offsetInMilliseconds = offsetInMilliseconds;
	}
}

