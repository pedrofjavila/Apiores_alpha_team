package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject implements Catchable {

    public GridPosition pos;

    public SimpleGfxGrid grid;

    public Picture picture;

    protected GridDirection direction;

    public GameObject(GridPosition position, Picture picture) {

        this.pos = position;

        this.picture = picture;

    }


    public  GridPosition getPos(){

        return pos;
    }

    public GridDirection getDirection() {
        return direction;
    }
}
