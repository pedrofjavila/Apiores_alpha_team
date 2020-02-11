package org.academiadecodigo.apiores.gameelements;

import org.academiadecodigo.apiores.gameelements.objects.*;
import org.academiadecodigo.apiores.gameelements.players.*;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;

public class GameElementsFactory {

    public static GameObject createNewGameObject(SimpleGfxGrid grid){

        int randomObject = (int) (Math.random() * ObjectType.values().length);
        ObjectType objectType = ObjectType.values()[randomObject];
        int randomCol = (int) (Math.random() * grid.getCols());

        GameObject object = null;

        switch(objectType) {
            case BEER:
                object = new Beer(grid.makeGridPosition(randomCol, 0,ObjectType.BEER.getLink()));
                break;
            case CAR:
                object = new Car(grid.makeGridPosition(randomCol, 0,ObjectType.CAR.getLink()));
                break;
            case BRACKETS:
                object = new Brackets(grid.makeGridPosition(randomCol, 0,ObjectType.BRACKETS.getLink()));
                break;
            case PINEAPPLE:
                object = new Pineapple(grid.makeGridPosition(randomCol, 0,ObjectType.PINEAPPLE.getLink()));
                break;
            case SUMARIZER:
                object = new Sumarizer(grid.makeGridPosition(randomCol, 0,ObjectType.SUMARIZER.getLink()));
                break;
            case BAD_DESIGN:
                object = new BadDesign(grid.makeGridPosition(randomCol, 0,ObjectType.BAD_DESIGN.getLink()));
                break;
        }
        return object;
    }

    public static Player createNewPlayer(SimpleGfxGrid grid, PlayerType player){

        Player p1 = null;

        switch (player) {
            case JOJO:
                p1 = new Player(grid.makeGridPosition(20, 20, PlayerType.JOJO.getLink()));
                break;
            case RICARDO:
                p1 = new Player(grid.makeGridPosition(20,30,PlayerType.RICARDO.getLink()));
                break;
            case SORAIA:
                p1 = new Player(grid.makeGridPosition(20,30,PlayerType.SORAIA.getLink()));
                break;
            case RITA:
                p1 = new Player(grid.makeGridPosition(20,30,PlayerType.RITA.getLink()));
                break;
        }
        return p1;
    }
}
