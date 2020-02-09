package org.academiadecodigo.apiores.gameelements.players;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player implements KeyboardHandler {

    private boolean alive = true;
    private Keyboard keyboard;
    private int score;
    private Picture picture;
    private PlayerType type;
    private SimpleGfxGridPosition position;
    private SimpleGfxGrid grid;
    private GridDirection currentDirection;
    private int speed;

    public Player (SimpleGfxGridPosition position){
        this.position= position;
        keyboard = new Keyboard(this);
        init();

    }

    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent faster = new KeyboardEvent();
        faster.setKey(KeyboardEvent.KEY_SPACE);
        faster.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent slower = new KeyboardEvent();
        slower.setKey(KeyboardEvent.KEY_SPACE);
        slower.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(faster);
        keyboard.addEventListener(slower);
    }

    public void move(){
        moveInDirection(currentDirection, speed);
    }

    public void moveInDirection(GridDirection direction, int speed) {
        // Our car doest crash
        // Accelerate in the chosen direction
        this.currentDirection = direction;
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(direction, 1);
        }
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
}



