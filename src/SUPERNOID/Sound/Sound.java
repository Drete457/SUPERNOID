package SUPERNOID.Sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Sound {

    //create the variable
    Clip audioClipIntro;

    //end the sound of music
    public void endIntroSoundForSure() {
        try { audioClipIntro.close(); } catch (Exception e) { e.getMessage(); }
    }

    //start the music
    public void startIntroMusic() {
        try {
            //tell what music to play
            InputStream audios = Sound.class.getResourceAsStream("/resources/Sound/mk-theme.wav");
            InputStream bufferedIn = new BufferedInputStream(audios);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClipIntro = (Clip) AudioSystem.getLine(info);
            audioClipIntro.open(audioStream);
            //start the music
            audioClipIntro.start();
            //make the music play in infinity cycle
            audioClipIntro.loop(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
