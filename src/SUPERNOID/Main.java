package SUPERNOID;

public class Main {

    //The Beginning of the game, and Interrupted when it finish
    public static void main(String[] args) throws InterruptedException {

        //will instance the game and initialise
        Game game = new Game(125);

        //Game level
        int level = 1;

        //draw the BackGround and start the game
        game.backGround();

        if (level == 1) {
            game.loadLevel1();
        } else if (level == 2){
            game.loadLevel2();
        }

        game.initLogos();
        game.start();

    }
}
