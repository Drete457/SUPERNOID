package SUPERNOID;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    //The Beginning of the game, and Interrupted when it finishes
    public static void main(String[] args) throws Exception {


        FirstMenu firstMenu = new FirstMenu();

        //will instance the game and initialise
        Game game = new Game(125);
        KeyboardManager keyboard = new KeyboardManager(game.getGame(), game.getPaddle(), game.getBall(), game.getEngine(), firstMenu);

       // firstMenu.draw();
      /*  //print the instructions image
        Picture instructions = new Picture(120, 400, "resources/Images/general/game_instructions.png");
        instructions.draw();

        //print the start time
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
        instructions.delete();
        startTimer.delete(); */

        //start the game
        game.start();

    }
}
