package org.academiadecodigo.rapunshells.game;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

    private Clip clip;
    private URL soundURL;

    public Sound(String path) {
        this.initClip(path);
    }

    public void play(boolean init) {
        if (init) {
            this.clip.setFramePosition(0);
        }
        this.clip.start();
    }

    public void stop() {
        this.clip.stop();
    }

    public int getLength() {
        return this.clip.getFrameLength();
    }

    public void loop() {
        this.clip.setLoopPoints(0, (int) ((double) this.getLength() * 0.94D));
        this.clip.loop(-1);
    }

    private void initClip(String path) {
        this.soundURL = Sound.class.getResource(path);

        try {
            if (this.soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                this.soundURL = file.toURI().toURL();
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }

    }


}
