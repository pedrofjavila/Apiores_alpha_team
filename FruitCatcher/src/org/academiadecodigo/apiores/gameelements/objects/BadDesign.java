package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;

public class BadDesign extends GameObject {

    private ObjectType type;


    public BadDesign(SimpleGfxGridPosition position, int speed, SimpleGfxGrid grid, ObjectType type){

        super(position, speed, grid, type);

    }

}
