package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.Sound;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    public SimpleGfxGridPosition pos;
    public SimpleGfxGrid grid;
    public Picture picture;
    public int speed;
    private ObjectType type;
    private Sound hitSound;

    public GameObject(SimpleGfxGridPosition position, int speed, SimpleGfxGrid grid, ObjectType type, String hitSound) {
        this.pos = position;
        this.picture = pos.getPicture();
        this.speed = speed;
        this.grid = grid;
        this.type = type;
        this.hitSound = new Sound(hitSound);
    }

    public  SimpleGfxGridPosition getPos(){
        return pos;
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public ObjectType getType() {
        return type;
    }

    public Sound getHitSound(){
        return hitSound;
    }

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
