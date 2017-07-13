package com.harium.etyl.sound.model;

import com.harium.etyl.sound.MultimediaLoader;


public class Music extends Sound {

    private boolean loop = true;

    public Music(String path) {
        super(path);
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void play() {
        MultimediaLoader.getInstance().playMusic(path, loop);
    }

    public void playStream() {
        MultimediaLoader.getInstance().playMusicStream(path, loop);
    }

    public boolean isPlaying() {
        return MultimediaLoader.getInstance().isPlaying(path);
    }

    public void stop() {
        MultimediaLoader.getInstance().stop(path);
    }

    public void dispose() {
        MultimediaLoader.getInstance().dispose(path);
    }

}
