package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject implements Catchable {

    public SimpleGfxGridPosition pos;
    public SimpleGfxGrid grid;
    public Picture picture;
    protected GridDirection direction;
    public int points;
    public int speed;


    public GameObject(SimpleGfxGridPosition position, int speed) {
        this.pos = position;
        this.picture = pos.getPicture();
        this.speed = speed;
    }

    public SimpleGfxGridPosition getPos() {
        return pos;
    }

    public GridDirection getDirection() {
        return direction;
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public int getSpeed() {
        return speed;
    }

    //boundaries and object movement!


    public void move() {
        if (this.pos.getRow() < 890) {
            picture.translate(0, speed);
            pos.setRow(pos.getRow() + speed);
            //System.out.println(pos.getRow());
            //System.out.println(pos.getCol());
        } else {
            int randomCol = (int) (Math.random() * (1789 - 10) + 10);
            picture.translate(randomCol - pos.getCol(), -900);
            this.pos.setRow(10);
            this.pos.setCol(randomCol);
            speed = (int) (Math.random() * (65 - 20) + 20);

        }
    }

}
