package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameOver {


    private SimpleGfxGrid grid;
    private Rectangle rectangle;


    public GameOver(){

        rectangle = new Rectangle(10,10, grid.getWidth(), grid.getHeigth());
    }

    public void endGame(){

    }
}
