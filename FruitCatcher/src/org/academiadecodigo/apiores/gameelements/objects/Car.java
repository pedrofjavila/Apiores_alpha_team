package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;

public class Car extends GameObject {

    public Car(SimpleGfxGridPosition position, int speed, SimpleGfxGrid grid, ObjectType type, String hitSound){
        super(position, speed, grid, type, hitSound);
    }
}
