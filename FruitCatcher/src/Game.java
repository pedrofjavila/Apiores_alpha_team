import org.academiadecodigo.apiores.gameelements.GameElementsFactory;
import org.academiadecodigo.apiores.gameelements.objects.GameObject;
import org.academiadecodigo.apiores.gameelements.objects.ObjectType;
import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.apiores.gameelements.players.PlayerType;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private SimpleGfxGrid grid;
    private GameObject[] gameobjects;
    private int delay;
    private int numberOfObjects = 20;
    private Player p1;
    private int counter;



    public Game(int cols, int rows, int delay) {
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {

        grid.init();
        gameobjects = new GameObject[numberOfObjects];
        System.out.println(grid.getWidth());
        System.out.println(grid.getHeigth());


        for (int i = 0; i < gameobjects.length; i++) {
            gameobjects[i] = GameElementsFactory.createNewGameObject(grid);
            gameobjects[i].setGrid(grid);
        }
        p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.JOJO);
    }

    public void start() throws InterruptedException {

        while (true) {
            Thread.sleep(delay);

            moveObjects();
        }
    }




    public void moveObjects()  {
        for (int i = 0; i < gameobjects.length; i++) {
            GameObject object = gameobjects[i];

            object.move();


            if(Game.Collides(p1.getPosition().getPicture(), object.getPos().getPicture()))           {
                counter++;
                System.out.println(counter);
            }

            /*System.out.println(gameobjects[i].picture.getX() + " objects");
            System.out.println(gameobjects[i].picture.getY() + " objects");
            System.out.println(p1.getPosition().getPicture().getX() + " player");
            System.out.println(p1.getPosition().getPicture().getY() +  " player")*/
            ;


        
           /* int p1MaxX = p1.getPosition().getPicture().getMaxX();
            int p1Y = p1.getPosition().getPicture().getY();
            int p1MaxY = p1.getPosition().getPicture().getMaxY();
            int objX = gameobjects[i].getPos().getPicture().getX();
            int objMaxX = gameobjects[i].getPos().getPicture().getMaxX();
            int objY = gameobjects[i].getPos().getPicture().getY();
            int objMaxY = gameobjects[i].getPos().getPicture().getMaxY(); */

        }
    }



    private static boolean Collides(Picture p1, Picture p2){

        return ((p2.getX() >= p1.getX() && p2.getX() <= p1.getX()+p1.getWidth()) &&
                (p2.getY() >= p1.getY() && p2.getY() <= p1.getY()+p1.getHeight())) ||
                ((p2.getX()+p2.getWidth() >= p1.getX() && p2.getX()+p2.getWidth() <= p1.getX()+p1.getWidth())) &&
                 (p2.getY() >= p1.getY() && p2.getY() <= p1.getY()+p1.getHeight());

    }
}





