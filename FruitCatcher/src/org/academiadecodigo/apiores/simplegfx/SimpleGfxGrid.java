package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid {

    public static final int PADDING = 10;
    public int cellSize = 30;
    private int cols;
    private int rows;

    private Picture picture;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        picture = new Picture();
        picture.draw();
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth(){
        return this.picture.getWidth();
    }

    public int getHeigth(){
        return this.picture.getHeight();
    }

    public int getX(){
        return this.picture.getWidth();
    }

    public int getY(){
        return this.picture.getWidth();
    }

    public SimpleGfxGridPosition makeGridPosition(int col, int row, String link) {
        return new SimpleGfxGridPosition(col, row, this, link);
    }

    public SimpleGfxGridPosition makeGridPosition(String link){
        return new SimpleGfxGridPosition(this, link);
    }

    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }

    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }


}
