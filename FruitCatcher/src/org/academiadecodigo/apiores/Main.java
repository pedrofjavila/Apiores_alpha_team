package org.academiadecodigo.apiores;

import org.academiadecodigo.apiores.simplegfx.Game;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Game game = new Game(30, 31, 150);

        game.init();
        game.start();
    }
}
