package SUPERNOID.Sound;


import java.io.File;
import javax.sound.sampled.*;


public class SoundClip {

    public void playMusic(String musicfile) {
        try {
            final Clip clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP)
                        clip.close();
                }
            });
            File music = new File(musicfile);
            clip.open(AudioSystem.getAudioInputStream(music));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

}
