package com.harium.etyl.sound;

import org.junit.Assert;
import org.junit.Test;

public class MultimediaLoaderTest {

    @Test
    public void testAddExtensions() {
        Assert.assertTrue(MultimediaLoader.getInstance().canLoad("mp3"));
        Assert.assertTrue(MultimediaLoader.getInstance().canLoad("ogg"));
        Assert.assertTrue(MultimediaLoader.getInstance().canLoad("wav"));

        Assert.assertFalse(MultimediaLoader.getInstance().canLoad("pcm"));
    }

}