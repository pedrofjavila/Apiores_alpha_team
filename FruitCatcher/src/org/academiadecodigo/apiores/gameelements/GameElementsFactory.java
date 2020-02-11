package org.academiadecodigo.apiores.gameelements;

import org.academiadecodigo.apiores.gameelements.objects.*;
import org.academiadecodigo.apiores.gameelements.players.*;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;

public class GameElementsFactory {

    public static GameObject createNewGameObject(SimpleGfxGrid grid){

        int randomObject = (int) (Math.random() * ObjectType.values().length);
        ObjectType objectType = ObjectType.values()[randomObject];
        int randomCol = (int) (Math.random() * grid.getCols());
        int speed = (int) (Math.random()*(65 - 20) + 20);

        GameObject object = null;

        switch(objectType) {
            case BEER:
                object = new Beer(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BEER.getLink()), speed);
                break;
            case CAR:
                object = new Car(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.CAR.getLink()), speed);
                break;
            case BRACKETS:
                object = new Brackets(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BRACKETS.getLink()), speed);
                break;
            case PINEAPPLE:
                object = new Pineapple(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.PINEAPPLE.getLink()), speed);
                break;
            case SUMARIZER:
                object = new Sumarizer(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.SUMARIZER.getLink()), speed);
                break;
            case BAD_DESIGN:
                object = new BadDesign(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BAD_DESIGN.getLink()), speed);
                break;
        }
        return object;
    }

    public static Player createNewPlayer(SimpleGfxGrid grid, PlayerType player){

        Player p1 = null;

        switch (player) {
            case JOJO:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(30), grid.rowToY(29), PlayerType.JOJO.getLink()));
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
