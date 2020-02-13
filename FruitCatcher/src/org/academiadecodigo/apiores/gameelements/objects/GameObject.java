package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    public SimpleGfxGridPosition pos;
    public SimpleGfxGrid grid;
    public Picture picture;
    protected GridDirection direction;
    public int speed;
    private ObjectType type;

    public GameObject(SimpleGfxGridPosition position, int speed, SimpleGfxGrid grid, ObjectType type) {
        this.pos = position;
        this.picture = pos.getPicture();
        this.speed = speed;
        this.grid = grid;
        this.type = type;
    }

    public  SimpleGfxGridPosition getPos(){
        return pos;
    }


    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public int getSpeed() {
        return speed;
    }

    public ObjectType getType() {
        return type;
    }

    //boundaries and object movement!

    public void move(){
        if(this.pos.getRow() < 900) {
            picture.translate(0, speed);
            pos.setRow(pos.getRow() + speed);
        }else{
            int randomCol = (int) (Math.random()*(grid.getWidth() - 20) + 10);
            picture.translate(randomCol - pos.getCol(), -900);
            this.pos.setRow(10);
            this.pos.setCol(randomCol);
            speed = (int) (Math.random()*(65 - 20) + 20);
        }
    }
}
