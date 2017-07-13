package com.harium.etyl.sound.model;

import com.harium.etyl.sound.MultimediaLoader;


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

    public void dispose() {
        MultimediaLoader.getInstance().dispose(path);
    }
		
} 
