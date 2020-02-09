package org.academiadecodigo.apiores.gameelements.players;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player implements KeyboardHandler {

    private boolean alive = true;
    private Keyboard keyboard;
    private int score;
    private Picture picture;


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
        this.score = score;
    }

    public void setPicture(Picture picture){

    }


}



