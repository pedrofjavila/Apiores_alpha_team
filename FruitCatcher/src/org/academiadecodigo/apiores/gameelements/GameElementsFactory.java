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
                object = new Beer(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BEER.getLink()), speed, grid);
                break;
            case CAR:
                object = new Car(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.CAR.getLink()), speed, grid);
                break;
            case BRACKETS:
                object = new Brackets(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BRACKETS.getLink()), speed, grid);
                break;
            case PINEAPPLE:
                object = new Pineapple(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.PINEAPPLE.getLink()), speed, grid);
                break;
            case SUMARIZER:
                object = new Sumarizer(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.SUMARIZER.getLink()), speed, grid);
                break;
            case BAD_DESIGN:
                object = new BadDesign(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BAD_DESIGN.getLink()), speed, grid);
                break;
        }
        return object;
    }

    public static Player createNewPlayer(SimpleGfxGrid grid, PlayerType player){

        Player p1 = null;

        switch (player) {
            case JOJO:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29), PlayerType.JOJO.getLink()), grid);
                break;
            case RICARDO:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29),PlayerType.RICARDO.getLink()), grid);
                break;
            case SORAIA:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29),PlayerType.SORAIA.getLink()), grid);
                break;
            case RITA:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29),PlayerType.RITA.getLink()), grid);
                break;
        }
        return p1;
    }
}
