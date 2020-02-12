package org.academiadecodigo.apiores;

import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Intro {

    private SimpleGfxGrid grid;
    private KeyboardListener keyboard;
    private SimpleGfxGridPosition position;
    private Picture backGroung;
    private int keyPressed = 0;

    public Intro(SimpleGfxGrid grid) {
        this.grid = grid;
        keyboard = new KeyboardListener();
        backGroung = new Picture(10,10, "resources/tela_abertura_900_930.png");
    }

    public void init() {
        while (keyPressed == 0) {
            backGroung.draw();
        }
    }

    public int getKeyPressed(){
        return keyPressed;
    }

    public class KeyboardListener implements KeyboardHandler {

        public KeyboardListener() {

            Keyboard keyboard = new Keyboard(this);

            //Choice 1
            KeyboardEvent one = new KeyboardEvent();
            one.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            one.setKey(KeyboardEvent.KEY_1);
            keyboard.addEventListener(one);

            //Choice 2
            KeyboardEvent two = new KeyboardEvent();
            two.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            two.setKey(KeyboardEvent.KEY_2);
            keyboard.addEventListener(two);

            //Choice 3
            KeyboardEvent three = new KeyboardEvent();
            three.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            three.setKey(KeyboardEvent.KEY_3);
            keyboard.addEventListener(three);

            //Choice 4
            KeyboardEvent four = new KeyboardEvent();
            four.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            four.setKey(KeyboardEvent.KEY_4);
            keyboard.addEventListener(four);

        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            switch (keyboardEvent.getKey()){
                case KeyboardEvent.KEY_1:
                    keyPressed = 1;
                    backGroung.delete();
                    break;
                case KeyboardEvent.KEY_2:
                    keyPressed = 2;
                    backGroung.delete();
                    break;
                case KeyboardEvent.KEY_3:
                    keyPressed = 3;
                    backGroung.delete();
                    break;
                case KeyboardEvent.KEY_4:
                    keyPressed = 4;
                    backGroung.delete();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
}
