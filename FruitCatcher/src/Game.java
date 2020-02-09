import org.academiadecodigo.apiores.gameelements.objects.GameObject;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;

public class Game {

    private SimpleGfxGrid grid;
    private GameObject[] gameobjects;
    private int delay;

    public Game(int cols, int rows, int delay){
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {
        grid.init();
    }
}
