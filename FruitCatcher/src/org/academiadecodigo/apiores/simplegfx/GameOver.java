package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameOver {


    private SimpleGfxGrid grid;
    private Rectangle rectangle;


    public GameOver() {

        rectangle = new Rectangle(10, 10, grid.getWidth(), grid.getHeigth());
    }

    public void endGame() {

    }

    public class KeyboardListener implements KeyboardHandler {

        public KeyboardListener() {

            Keyboard keyboard = new Keyboard(this);

            //Restart
            KeyboardEvent r = new KeyboardEvent();
            r.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            r.setKey(KeyboardEvent.KEY_R);
            keyboard.addEventListener(r);

        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            if (keyboardEvent.getKey() == 1) {
                rectangle.delete();
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }

}
