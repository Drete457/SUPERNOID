package SUPERNOID;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    //The Beginning of the game, and Interrupted when it finishes
    public static void main(String[] args) throws Exception {

        //will instance the game and initialise
        Game game = new Game(125);
        KeyboardManager keyboard = new KeyboardManager(game.getGame(), game.getPaddle(), game.getBall(), game.getEngine());

        //Print the menu game
        Picture instructions = new Picture(10,10, "Images/general/start_screen_900x900.jpg");

        //draw the menu game
        instructions.draw();

        //print the start time
        Thread.holdsLock(game);
        instructions.delete();

        //start the game cycle
        game.start();
    }
}


