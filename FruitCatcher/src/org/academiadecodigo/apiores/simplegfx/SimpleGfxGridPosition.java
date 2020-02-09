package org.academiadecodigo.apiores.simplegfx;

import org.academiadecodigo.apiores.gameelements.grid.GridDirection;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGridPosition {

    private int col;
    private int row;
    private SimpleGfxGrid grid;
    private Picture picture;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxGridPosition(SimpleGfxGrid grid, String link){
        this.col = (int)(Math.random() * grid.getCols());
        this.row = (int)(Math.random() * grid.getRows());

        simpleGfxGrid = grid;

        int x = simpleGfxGrid.columnToX(col);
        int y = simpleGfxGrid.rowToY(row);

        picture = new Picture(col, row, link);

        show();
    }

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, String link){
        this.col = col;
        this.row = row;

        simpleGfxGrid = grid;

        int x = simpleGfxGrid.columnToX(this.col);
        int y = simpleGfxGrid.rowToY(this.row);

        picture = new Picture(col, row, link);
        show();

    }

    public void setPos(int col, int row){
        this.col = col;
        this.row = row;
        show();
    }



    public void show() {
        this.picture.draw();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
