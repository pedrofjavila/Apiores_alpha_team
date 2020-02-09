package org.academiadecodigo.apiores.gameelements;

import org.academiadecodigo.apiores.gameelements.objects.*;
import org.academiadecodigo.apiores.gameelements.players.*;

public class GameElementsFactory {

    public static GameObject createNewGameObject(){

        int randomObject = (int) (Math.random() * ObjectType.values().length);
        ObjectType objectType = ObjectType.values()[randomObject];
        GameObject object = null;

        switch(objectType) {
            case BEER:
                object = new Beer();
                break;
            case CAR:
                object = new Car();
                break;
            case BRACKETS:
                object = new Brackets();
                break;
            case PINEAPPLE:
                object = new Pineapple();
                break;
            case SUMARIZER:
                object = new Sumarizer();
                break;
            case BAD_DESIGN:
                object = new BadDesign();
                break;
        }
        return object;
    }

    public static Player createNewPlayer(){

        int randomPlayer = (int) (Math.random() * PlayerType.values().length);
        PlayerType playerType = PlayerType.values()[randomPlayer];
        Player player = null;

        switch (playerType) {
            case JOJO:
                player = new Jojo();
                break;
            case RICARDO:
                player = new Ricardo();
                break;
            case SORAIA:
                player = new Soraia();
                break;
            case RITA:
                player = new Rita();
                break;
        }
        return player;
    }
}
