package org.academiadecodigo.apiores.gameelements.players;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
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
    private GridDirection currentDirection;
    private int speed;


    public Player (SimpleGfxGridPosition position){
        this.position= position;
        keyboard = new KeyboardListener(this.position.getPicture());

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
}



