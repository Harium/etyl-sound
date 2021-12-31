package com.harium.etyl.sound;


import com.harium.etyl.commons.loader.LoaderImpl;
import paulscode.sound.Library;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecJLayerMP3;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryJavaSound;

public class MultimediaLoader extends LoaderImpl {

    private SoundSystem soundSystem;

    private static MultimediaLoader instance = null;

    public static MultimediaLoader getInstance() {
        if (instance == null) {
            instance = new MultimediaLoader();
        }

        return instance;
    }

    public MultimediaLoader() {
        folder = "assets/sounds/";

        try {
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            //SoundSystemConfig.setCodec( "ogg", CodecJOgg.class );
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("mp3", CodecJLayerMP3.class);

            SoundSystemConfig.addLibrary(LibraryJavaSound.class);
            //SoundSystemConfig.addLibrary(LibraryJOAL.class);
            //SoundSystemConfig.setSoundFilesPackage(folder);

            soundSystem = new SoundSystem(LibraryJavaSound.class);
            //soundSystem = new SoundSystem(LibraryJOAL.class);
        } catch (SoundSystemException e) {
            System.err.println("Error on " + this.getClass().getSimpleName());
        }
    }

    public SoundSystem setSoundLibrary(Class<? extends Library> library) {
        try {
            soundSystem = new SoundSystem(library);
        } catch (SoundSystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return soundSystem;
    }

    public boolean isPlaying(String path) {
        return soundSystem.playing(path);
    }

    public void loadSound(String path) {
        soundSystem.loadSound(fullPath(path));
    }

    public void playSound(String path) {

        soundSystem.quickPlay(false, fullPath(path), false,
                0, 0, 0,
                SoundSystemConfig.ATTENUATION_NONE,
                SoundSystemConfig.getDefaultRolloff());
    }

    //Loads ogg and mp3 too
    public void loadMusic(String path) {
        soundSystem.loadSound(fullPath(path));
    }

    public void playMusic(String path, boolean loop) {
        soundSystem.backgroundMusic(fullPath(path), fullPath(path), loop);
    }

    public void playMusicStream(String path) {
        playMusicStream(path, false);
    }

    public void playMusicStream(String path, boolean loop) {
        //soundSystem.newStreamingSource(true, fullPath()+path, fullPath()+path, loop, 0, 0, 0, SoundSystemConfig.ATTENUATION_NONE, 0);
        playMusic(path, loop);
    }

    public void stop(String path) {
        soundSystem.stop(fullPath(path));
    }

    public void dispose(String path) {
        if (!soundSystem.playing(path)) {
            return;
        }
        stop(path);
    }

    public boolean canLoad(String extension) {
        return SoundSystemConfig.getCodec(extension) != null;
    }
}
