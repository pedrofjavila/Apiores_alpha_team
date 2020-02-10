import org.academiadecodigo.apiores.gameelements.GameElementsFactory;
import org.academiadecodigo.apiores.gameelements.objects.GameObject;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;

public class Game {

    private SimpleGfxGrid grid;
    private GameObject[] gameobjects;
    private int delay;
    private int numberOfObjects = 20;


    public Game(int cols, int rows, int delay){
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {
        grid.init();
        gameobjects = new GameObject[numberOfObjects];

        for (int i = 0; i < gameobjects.length; i++){
            gameobjects[i] = GameElementsFactory.createNewGameObject(grid);
            gameobjects[i].setGrid(grid);
        }
    }

    public void start() throws InterruptedException{

        while (true){
            Thread.sleep(delay);
        }
    }
}
