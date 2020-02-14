package SUPERNOID;

public class Main {

    //The Beginning of the game, and Interrupted when it finish
    public static void main(String[] args) throws InterruptedException {

        //will instance the game and initialise
        Game game = new Game(100);

        //draw the BackGround and start the game
        game.backGround();
        game.initLogos();
        game.start();
    }
}
