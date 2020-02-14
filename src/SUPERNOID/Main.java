package SUPERNOID;

import SUPERNOID.GameObjects.ObjFactory;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Main implements KeyboardHandler{

    //The Beginning of the game, and Interrupted when it finish
    public static void main() throws InterruptedException {

        //will instance the game and initialise
        Game game = new Game(150);

        //draw the BackGround and start the game
        game.backGround();
        ObjFactory.getNewBlocks(11,5, 50,0,game);
        ObjFactory.getNewBlocks(11,5, 150,0, game);
        ObjFactory.getNewBlocks(5,3, 250, 120, game);
        game.initLogos();
        game.start();
    }

    //make start a new game or exit
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            //Start a new game
            case KeyboardEvent.KEY_N:
                //need to be created
                break;

            //exit the game
            case KeyboardEvent.KEY_E:
                System.exit(0);
                break;
        }
    }

    //disable method
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}

}
