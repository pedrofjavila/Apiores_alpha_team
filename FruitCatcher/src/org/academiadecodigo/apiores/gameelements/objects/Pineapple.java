package org.academiadecodigo.apiores.gameelements.objects;

import org.academiadecodigo.apiores.Sound;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGridPosition;

public class Pineapple extends GameObject {

    public Pineapple(SimpleGfxGridPosition position, int speed, SimpleGfxGrid grid, ObjectType type, String hitSound){
        super(position, speed, grid, type, hitSound);
    }
}
