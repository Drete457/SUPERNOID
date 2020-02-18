package SUPERNOID.Sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Sound {

    Clip audioClipIntro;

    public void endIntroSoundForSure() {
        try {
            audioClipIntro.close();
        } catch (Exception e) {

        }
    }

    public void startIntroMusic() {
        try {
            InputStream audios = SoundClip.class.getResourceAsStream("/resources/Sound/mk-theme.wav");
            InputStream bufferedIn = new BufferedInputStream(audios);
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
}
