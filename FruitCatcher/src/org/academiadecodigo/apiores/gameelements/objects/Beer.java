package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;

public class Beer extends GameObject {

    public Beer(SimpleGfxGridPosition position,int speed, SimpleGfxGrid grid,ObjectType type) {
        super(position, speed, grid, type);
    }
}
