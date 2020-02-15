package SUPERNOID;

import SUPERNOID.Sound.SoundClip;

public class Main {


    //The Beginning of the game, and Interrupted when it finish
    public static void main(String[] args) throws InterruptedException  {

        String BABYSHARK = "resources/Music/8-Bit_Songs/baby-shark.wav";
        String GHOSTBUSTERS = "resources/Music/8-Bit_Songs/ghostbusters.wav";
        String MK = "resources/Music/8-Bit_Songs/mk-theme.wav";
        
        //will instance the game and initialise
        Game game = new Game(125);

        //Game level
        int level = 1;

        //draw the BackGround and start the game
        //game.initScreen();
        game.backGround();

        SoundClip soundClip = new SoundClip();
        soundClip.playMusic(BABYSHARK);
        //game.livesLost(1);
        //game.livesLost(2);
        //game.livesLost(3);
        //game.livesLost(4);
       // game.score("010");
        //game.score("020");

        //game.initScreen();
        if (level == 1) { game.loadLevel1(); }
        else if (level == 2){ game.loadLevel2(); }
        game.start();
    }
}
