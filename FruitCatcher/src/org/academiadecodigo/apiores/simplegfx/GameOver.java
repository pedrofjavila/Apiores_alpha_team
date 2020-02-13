package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.apiores.Intro;
import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

        private SimpleGfxGrid grid;
        private KeyboardListener keyboard;
        private Picture backGroung = new Picture(10,10, "resources/tela_game_over_900_930.png");;
        private boolean keyPressed = false;

        public GameOver(SimpleGfxGrid grid) {
            this.grid = grid;
            keyboard = new KeyboardListener();
        }

        public void init() {
            while (!keyPressed) {
                backGroung.draw();
            }
            keyPressed = true;
        }


        public class KeyboardListener implements KeyboardHandler {

            public KeyboardListener() {

                Keyboard keyboard = new Keyboard(this);

                //Choice 1
                KeyboardEvent keyR = new KeyboardEvent();
                keyR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyR.setKey(KeyboardEvent.KEY_R);
                keyboard.addEventListener(keyR);


            }

            @Override
            public void keyPressed(KeyboardEvent keyboardEvent) {
                    switch(keyboardEvent.getKey()){
                        case KeyboardEvent.KEY_R:
                            keyPressed = true;
                            backGroung.delete();
                            break;
                    }
            }

            @Override
            public void keyReleased(KeyboardEvent keyboardEvent) {
                /*switch(keyboardEvent.getKey()){
                    case KeyboardEvent.KEY_R:
                        keyPressed = false;
                        break;
                }*/

            }
        }
    }