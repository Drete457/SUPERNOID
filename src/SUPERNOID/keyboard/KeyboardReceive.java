package SUPERNOID.simplegraphics.keyboard;

public class KeyboardReceive implements KeyboardHandler{

    //create the object that will receive the keyboard
    private KeyboardHandler keyPressed = new KeyboardReceive();//put this in the class that will receive the keyboard input

    //create the object of the keyboard
    private Keyboard keyboard = new Keyboard(keyPressed);

    //create the object that will receive the input left
    private KeyboardEvent keyPressedLeft = new KeyboardEvent();

    //create the object that will receive the input right
    private KeyboardEvent keyPressedRight = new KeyboardEvent();

    //create the object that will receive the input space
    private KeyboardEvent keyPressedSpace = new KeyboardEvent();

    //method that will receive the input and choose the correct method to send
    @Override
    public void keyPressed(KeyboardEvent e) {

        //run the code for the left key
        keyPressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyPressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyPressedLeft);

        //run the code for the right key
        keyPressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyPressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyPressedRight);

        //run the code for the space key
        keyPressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyPressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyPressedSpace);
    }

    //ignore
    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}
