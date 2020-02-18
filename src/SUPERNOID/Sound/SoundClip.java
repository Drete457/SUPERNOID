package SUPERNOID.Sound;

import java.io.*;
import javax.sound.sampled.*;

public class SoundClip {

    public void playAudio() {

        //create the variable
        Clip audioClipIntro;

        try {
            InputStream audiosrc = getClass().getResourceAsStream("/SUPERNOID/resources/mk-theme.wav");
            InputStream bufferedIn = new BufferedInputStream(audiosrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClipIntro = (Clip) AudioSystem.getLine(info);
            audioClipIntro.open(audioStream);
            audioClipIntro.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void close() {
        try {
            //audioClip.close();
        } catch (Exception e) {
        }
    }
}
