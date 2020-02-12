package org.academiadecodigo.apiores.gameelements.players;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

//turned public
public class Player  {

    private boolean alive = true;
    private KeyboardListener keyboard;
    private int score;
    private Picture picture;
    private PlayerType type;
    private SimpleGfxGridPosition position;
    private SimpleGfxGrid grid;




    public Player (SimpleGfxGridPosition position){
        this.position= position;
        this.keyboard = new KeyboardListener(this.position.getPicture());


    }



    public void moveInDirection(GridDirection direction, int speed) {

    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    // check if needed, if not to delete
    public void setPicture(Picture picture){

    }

    public SimpleGfxGrid getGrid() {
        return grid;
    }

    public SimpleGfxGridPosition getPosition() {
        return position;
    }

    public PlayerType getType() {
        return type;
    }


        //nested keyboardListener Class;

    public class KeyboardListener implements KeyboardHandler {
        private Movable player;

        public KeyboardListener(Movable player) {
            this.player = player;


            Keyboard keyboard = new Keyboard(this);

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

                case KeyboardEvent.KEY_LEFT:
                    if(position.getCol()> 10) {
                        player.translate(-30, 0);
                        position.setPos(position.getCol() - 30, 0);
                        //System.out.println(position.getCol());
                        break;
                    }
                case KeyboardEvent.KEY_RIGHT:
                    if(position.getCol()< 1780) {
                        player.translate(30, 0);
                        position.setPos(position.getCol() + 30, 0);
                        //System.out.println(position.getCol());
                        break;
                    }

            }
        }
        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }


    }


}






