package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid {

    public static final int PADDING = 10;
    public int cellSize = 30;
    private int cols;
    private int rows;

    private Picture background;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        background = new Picture(PADDING, PADDING, "resources/tela_fundo_jogo_900x930_v02.png");
        background.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth(){
        return this.background.getWidth();
    }

    public int getHeigth(){
        return this.background.getHeight();
    }

    public SimpleGfxGridPosition makeGridPosition(int col, int row, String link) {
        return new SimpleGfxGridPosition(col, row, this, link);
    }

    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }

    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }


}
