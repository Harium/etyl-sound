package com.harium.etyl.sound.model;

import com.harium.etyl.sound.MultimediaLoader;

/**
 * 
 * @author yuripourre
 * @license LGPLv3
 *
 */

public class Sound {

	protected String path = "";
	
	public Sound(String path) {
		super();
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public void play() {
		MultimediaLoader.getInstance().playSound(path);
	}
		
} 
