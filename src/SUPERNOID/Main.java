package SUPERNOID;

public class Main {

    //The Beginning of the game, and Interrupted when it finish
    public static void main(String[] args) throws InterruptedException {

        //will instance the game and initialise
        Game game = new Game(125);

        //Game level
        int level = 1;

        //draw the BackGround and start the game
        game.initScreen();
        game.backGround();
        game.scoreDraw();
        //game.livesLost(1);
        //game.livesLost(2);
        //game.livesLost(3);
        //game.livesLost(4);
        game.score("010");

        if (level == 1) {
            game.loadLevel1();
        } else if (level == 2){
            game.loadLevel2();
        }

        game.initScreen();
        game.start();

    }
}
