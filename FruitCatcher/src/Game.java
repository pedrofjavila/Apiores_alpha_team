import org.academiadecodigo.apiores.gameelements.GameElementsFactory;
import org.academiadecodigo.apiores.gameelements.objects.GameObject;
import org.academiadecodigo.apiores.gameelements.objects.ObjectType;
import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.apiores.gameelements.players.PlayerType;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private SimpleGfxGrid grid;
    private GameObject[] gameobjects;
    private int delay;
    private int numberOfObjects = 1;
    private Player p1;


    public Game(int cols, int rows, int delay){
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {

        grid.init();
        gameobjects = new GameObject[numberOfObjects];
        p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.JOJO);
        System.out.println(p1.getPosition().getRow());


        for (int i = 0; i < gameobjects.length; i++){
            gameobjects[i] = GameElementsFactory.createNewGameObject(grid);
            gameobjects[i].setGrid(grid);
        }
    }

    public void start() throws InterruptedException{

        while (true){
            Thread.sleep(delay);

            moveObjects();
        }
    }

    public void moveObjects(){
        for(int i = 0; i < gameobjects.length; i++){
            gameobjects[i].move();
            System.out.println(gameobjects[i].picture.getX());
            System.out.println(gameobjects[i].picture.getY());
            System.out.println("player X "+p1.getPosition().getPicture().getX());
            System.out.println("player y "+p1.getPosition().getPicture().getY());
        if ((p1.getPosition().getPicture().getX()==1570 &&gameobjects[i].picture.getX()==1570) &&
        p1.getPosition().getPicture().getY()==gameobjects[i].picture.getY()){
            int randomCol = (int) (Math.random()*(1789 - 10) + 10);
            gameobjects[i].picture.translate(randomCol - gameobjects[i].picture.getY(), -900);
        }
        }

    }


}
