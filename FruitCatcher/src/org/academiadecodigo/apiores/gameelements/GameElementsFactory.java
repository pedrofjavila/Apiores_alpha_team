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

    public static Player createNewPlayer(SimpleGfxGrid grid){

        int randomPlayer = (int) (Math.random() * PlayerType.values().length);
        PlayerType playerType = PlayerType.values()[randomPlayer];
        int randomCol = (int) (Math.random() * grid.getCols());

        Player player = null;

        switch (playerType) {
            case JOJO:
                player = new Jojo(grid.makeGridPosition(20, 20, PlayerType.JOJO.getLink()));
                break;
            case RICARDO:
                player = new Ricardo(grid.makeGridPosition(20,30,PlayerType.RICARDO.getLink());
                break;
            case SORAIA:
                player = new Soraia(grid.makeGridPosition(20,30,PlayerType.SORAIA.getLink());
                break;
            case RITA:
                player = new Rita(grid.makeGridPosition(20,30,PlayerType.RITA.getLink());
                break;
        }
        return player;
    }
}
