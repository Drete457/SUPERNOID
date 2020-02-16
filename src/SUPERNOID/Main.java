package SUPERNOID;

import SUPERNOID.Sound.SoundClip;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {


    //The Beginning of the game, and Interrupted when it finishes
    public static void main(String[] args) throws InterruptedException  {

        String BABYSHARK = "resources/Music/8-Bit_Songs/baby-shark.wav";
        String GHOSTBUSTERS = "resources/Music/8-Bit_Songs/ghostbusters.wav";
        String MK = "resources/Music/8-Bit_Songs/mk-theme.wav";
        
        //will instance the game and initialise
        Game game = new Game(125);

        //Game level
        int level = 1;

        SoundClip soundClip = new SoundClip();
        soundClip.playAudio();

        Picture instructions = new Picture(120, 400, "resources/Images/general/game_instructions.png");
        instructions.draw();

        Text startTimer = new Text(305,690, "5");
        startTimer.setColor(Color.DARK_GRAY);
        startTimer.grow(25,25);
        startTimer.draw();
        Thread.sleep(1000);
        startTimer.setText("4");
        Thread.sleep(1000);
        startTimer.setText("3");
        Thread.sleep(1000);
        startTimer.setText("2");
        Thread.sleep(1000);
        startTimer.setText("1");
        Thread.sleep(1000);
        //startMessage.delete();
        //startMessage2.delete();
        instructions.delete();
        startTimer.delete();

        //draw the BackGround and start the game
        //game.initScreen();
        game.backGround();

        //start the game
        game.start();
    }
}
