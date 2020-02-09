package org.academiadecodigo.apiores.gameelements;

import org.academiadecodigo.apiores.gameelements.grid.GridPosition;
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
                object = new Beer(grid.makeGridPosition(randomCol, 0));
                break;
            case CAR:
                object = new Car(grid.makeGridPosition(randomCol, 0));
                break;
            case BRACKETS:
                object = new Brackets(grid.makeGridPosition(randomCol, 0));
                break;
            case PINEAPPLE:
                object = new Pineapple(grid.makeGridPosition(randomCol, 0));
                break;
            case SUMARIZER:
                object = new Sumarizer(grid.makeGridPosition(randomCol, 0));
                break;
            case BAD_DESIGN:
                object = new BadDesign(grid.makeGridPosition(randomCol, 0));
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
                player = new Ricardo(grid.makeGridPosition();
                break;
            case SORAIA:
                player = new Soraia(grid.makeGridPosition();
                break;
            case RITA:
                player = new Rita(grid.makeGridPosition();
                break;
        }
        return player;
    }
}
