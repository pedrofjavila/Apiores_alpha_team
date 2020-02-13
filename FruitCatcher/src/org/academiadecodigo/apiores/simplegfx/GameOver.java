package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.apiores.Intro;
import org.academiadecodigo.apiores.Sound;
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
    private Picture backGroung = new Picture(10, 10, "resources/tela_game_over_900_930_v02.png");
    private Picture winBackground = new Picture (10, 10, "resources/tela_you_win.png");
    private Sound soundgameover = new Sound(" resources/sounds/gameover_ok.wav");
    private Sound soundWin = new Sound (" resources/sounds/475148__rezyma__victoryff-swf_OK.wav");

    private boolean keyPressed = false;

    public GameOver(SimpleGfxGrid grid) {
        this.grid = grid;
        keyboard = new KeyboardListener();
    }

    public void init() {
        soundgameover.setLoop(2);

        while (!keyPressed) {
            backGroung.draw();

        }
        soundgameover.stop();
        backGroung.delete();
    }

    public void winInit(){
        soundWin.setLoop(2);

        while (!keyPressed) {
            winBackground.draw();
        }
        soundWin.stop();
        winBackground.delete();


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
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_R:
                    keyPressed = true;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
}