package SUPERNOID;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    //The Beginning of the game, and Interrupted when it finishes
    public static void main(String[] args) throws Exception {

        Picture firstMenu = new Picture(Grid.PADDING, Grid.PADDING, "Images/general/start_screen_900x900.jpg");
        firstMenu.draw();

        //print the start time
        Text startTimer = new Text(firstMenu.getHeight()/2+15,firstMenu.getWidth()/2+100, "5");
        startTimer.setColor(Color.WHITE);
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
        firstMenu.delete();
        startTimer.delete();

        Game game = new Game(125);
        KeyboardManager keyboard = new KeyboardManager(game.getGame(), game.getPaddle(), game.getBall(), game.getEngine());
        game.start();

    }
}


