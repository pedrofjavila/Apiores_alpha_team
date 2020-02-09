package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject implements Catchable {

    public SimpleGfxGridPosition pos;

    public SimpleGfxGrid grid;

    public Picture picture;

    protected GridDirection direction;

    public int points;



    public GameObject(SimpleGfxGridPosition position, ObjectType objectType) {

        this.pos = position;

        this.picture = picture;

    }


    public  SimpleGfxGridPosition getPos(){

        return pos;
    }

    public GridDirection getDirection() {

        return direction;
    }
}
