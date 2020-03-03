package SUPERNOID;

import SUPERNOID.Grid.Grid;
import SUPERNOID.Keyboard.KeyboardManager;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    //The Beginning of the game, and Interrupted when it finishes
    public static void main(String[] args) throws Exception {

        //Create the instruction image
        Picture firstMenu = new Picture(Grid.PADDING, Grid.PADDING, "Images/general/start_screen.jpg");

        //draw the first menu
        firstMenu.draw();

        //print the start time
        Text startTimer = new Text(firstMenu.getHeight()/2+15,firstMenu.getWidth()/2+100, "5");

        //make the start time white
        startTimer.setColor(Color.WHITE);

        //grow the start time in 25x
        startTimer.grow(25,25);

        //draw the timer
        startTimer.draw();

        //make the timer stay in the screen for 1 second
        Thread.sleep(1000);
        startTimer.setText("4");
        Thread.sleep(1000);
        startTimer.setText("3");
        Thread.sleep(1000);
        startTimer.setText("2");
        Thread.sleep(1000);
        startTimer.setText("1");
        Thread.sleep(1000);

        //delete the firstMenu
        firstMenu.delete();

        //delete the start timer
        startTimer.delete();

        //create the object menu
        Game game = new Game(125);

        //create the object that will control the game
        KeyboardManager keyboard = new KeyboardManager(game.getGame(), game.getPaddle(), game.getBall(), game.getEngine());

        //start the game
        game.start();

    }
}


