package org.academiadecodigo.apiores.gameelements.players;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.gameelements.objects.ObjectType;
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
    private int health;
    private Picture picture;
    private PlayerType type;
    private SimpleGfxGridPosition position;
    private SimpleGfxGrid grid;
    private ObjectType itemScorer;
    private ObjectType itemScorer2;
    private ObjectType killerItem;





    public Player (SimpleGfxGridPosition position, SimpleGfxGrid grid, PlayerType type,ObjectType itemScorer, ObjectType itemScorer2, ObjectType killerItem){
        this.position= position;
        this.keyboard = new KeyboardListener(this.position.getPicture());
        this.grid = grid;
        this.type = type;
        this.itemScorer = itemScorer;
        this.itemScorer2 = itemScorer2;
        this.killerItem = killerItem;


    }



    public void moveInDirection(GridDirection direction, int speed) {

    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }


    public ObjectType getItemScorer() {
        return itemScorer;
    }

    public ObjectType getItemScorer2() {
        return itemScorer2;
    }

    public ObjectType getKillerItem() {
        return killerItem;
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

    public void healthDecrement() {
        health--;
    }

    public int getHealth() {
        return health;
    }

    public void killRita(){
        health = 0;
    }

    public void setScore() {
        score++;
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
                        position.rectangle.translate(-30, 0);
                        position.setPos(position.getCol() - 30, 0);
                        break;
                    }
                case KeyboardEvent.KEY_RIGHT:
                    if(position.getCol() < grid.getWidth() - 20 ) {
                        player.translate(30, 0);
                        position.rectangle.translate(30, 0);
                        position.setPos(position.getCol() + 30, 0);
                        break;
                    }

            }
        }
        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }


    }


}






