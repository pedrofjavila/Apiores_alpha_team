package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid {

    public static final int PADDING = 10;
    public int cellSize = 30;
    private int cols;
    private int rows;

    private Rectangle rectangle;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        rectangle.draw();
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
        return this.rectangle.getWidth();
    }

    public int getHeigth(){
        return this.rectangle.getHeight();
    }

    public int getX(){
        return this.rectangle.getWidth();
    }

    public int getY(){
        return this.rectangle.getWidth();
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
