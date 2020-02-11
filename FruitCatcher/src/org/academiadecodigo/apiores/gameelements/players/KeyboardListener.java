package org.academiadecodigo.apiores.gameelements.players;

import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {
    private Movable player;

    public KeyboardListener(Movable player) {
        this.player = player;


        Keyboard keyboard = new Keyboard(this);


        //Move UP
        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        //Move Down
        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        //Move right
        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        //Move left
        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                player.translate(0, 10);
                break;
            case KeyboardEvent.KEY_UP:
                player.translate(0, -10);
                break;
            case KeyboardEvent.KEY_LEFT:
                player.translate(-10, 0);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.translate(10, 0);

        }
    }
    @Override
    public void keyReleased (KeyboardEvent keyboardEvent){

    }

}
