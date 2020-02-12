package org.academiadecodigo.apiores.gameelements;

import org.academiadecodigo.apiores.gameelements.objects.*;
import org.academiadecodigo.apiores.gameelements.players.*;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;

public class GameElementsFactory {

    private PlayerType player;

    public static GameObject createNewGameObject(SimpleGfxGrid grid){

        int randomObject = (int) (Math.random() * ObjectType.values().length);
        ObjectType objectType = ObjectType.values()[randomObject];
        int randomCol = (int) (Math.random() * grid.getCols());
        int speed = (int) (Math.random()*(65 - 20) + 20);

        GameObject object = null;

        switch(objectType) {
            case BEER:
                object = new Beer(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BEER.getLink()), speed, grid, ObjectType.BEER);
                break;
            case CAR:
                object = new Car(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.CAR.getLink()), speed, grid, ObjectType.CAR);
                break;
            case BRACKETS:
                object = new Brackets(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BRACKETS.getLink()), speed, grid, ObjectType.BRACKETS);
                break;
            case PINEAPPLE:
                object = new Pineapple(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.PINEAPPLE.getLink()), speed, grid, ObjectType.PINEAPPLE);
                break;
            case SUMARIZER:
                object = new Sumarizer(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.SUMARIZER.getLink()), speed, grid, ObjectType.SUMARIZER);
                break;
            case BAD_DESIGN:
                object = new BadDesign(grid.makeGridPosition(grid.columnToX(randomCol), 10,ObjectType.BAD_DESIGN.getLink()), speed, grid, ObjectType.BAD_DESIGN);
                break;
        }
        return object;
    }

    public static Player createNewPlayer(SimpleGfxGrid grid, PlayerType player){

        Player p1 = null;

        switch (player) {
            case JOJO:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29), PlayerType.JOJO.getLink()), grid, PlayerType.JOJO);

                break;
            case RICARDO:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29),PlayerType.RICARDO.getLink()), grid, PlayerType.RICARDO);
                break;
            case SORAIA:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29),PlayerType.SORAIA.getLink()), grid, PlayerType.SORAIA);
                break;
            case RITA:
                p1 = new Player(grid.makeGridPosition(grid.columnToX(grid.getCols()/2), grid.rowToY(29),PlayerType.RITA.getLink()), grid, PlayerType.RITA);
                break;
        }
        return p1;
    }


}
