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
    private int counter;
    private boolean hit;


    public Game(int cols, int rows, int delay) {
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {

        grid.init();
        gameobjects = new GameObject[numberOfObjects];


        for (int i = 0; i < gameobjects.length; i++) {
            gameobjects[i] = GameElementsFactory.createNewGameObject(grid);
            gameobjects[i].setGrid(grid);
        }
        p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.JOJO);
        System.out.println(p1.getPosition().getRow());
    }

    public void start() throws InterruptedException {

        while (true) {
            Thread.sleep(delay);

            moveObjects();
        }
    }

    public void moveObjects() {
        for (int i = 0; i < gameobjects.length; i++) {
            gameobjects[i].move();

            /*System.out.println(gameobjects[i].picture.getX() + " objects");
            System.out.println(gameobjects[i].picture.getY() + " objects");
            System.out.println(p1.getPosition().getPicture().getX() + " player");
            System.out.println(p1.getPosition().getPicture().getY() +  " player")*/
            ;


            int p1X = p1.getPosition().getPicture().getX();
            int p1MaxX = p1.getPosition().getPicture().getMaxX();
            int p1Y = p1.getPosition().getPicture().getY();
            int p1MaxY = p1.getPosition().getPicture().getMaxY();
            int objX = gameobjects[i].getPos().getPicture().getX();
            int objMaxX = gameobjects[i].getPos().getPicture().getMaxX();
            int objY = gameobjects[i].getPos().getPicture().getY();
            int objMaxY = gameobjects[i].getPos().getPicture().getMaxY();

         /* if(p1X<=objX && p1MaxX>=objMaxX && p1Y<=objY && p1MaxY>=objMaxY){
              System.out.println(counter++);
          }*/

            for (int q = p1X; q < p1X + p1.getPosition().getPicture().getWidth(); q++) {
                for (int w = p1Y; w < p1Y + p1.getPosition().getPicture().getHeight(); w++) {

                    if (q < objX + gameobjects[i].getPos().getPicture().getWidth() && p1X + p1.getPosition().getPicture().getWidth() > objX + gameobjects[i].getPos().getPicture().getWidth() &&
                            w < objY + gameobjects[i].getPos().getPicture().getHeight())  {
                        hit = true;
                        if(hit){
                            System.out.println(counter++);
                            hit = false;
                            break;
                        }

                    }


                }
            }
        }
    }
}





