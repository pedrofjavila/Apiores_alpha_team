import org.academiadecodigo.apiores.Intro;
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
    private int numberOfObjects = 5;
    private Player p1;
    private int score;
    private int health;
    private Intro intro;


    public Game(int cols, int rows, int delay) {
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {

        grid.init();
        intro = new Intro(grid);
        gameobjects = new GameObject[numberOfObjects];
        System.out.println(grid.getWidth());
        System.out.println(grid.getHeigth());


        for (int i = 0; i < gameobjects.length; i++) {
            gameobjects[i] = GameElementsFactory.createNewGameObject(grid);
            gameobjects[i].setGrid(grid);
        }
    }

    public void start() throws InterruptedException {

        intro.init();
        createPlayer(intro.getKeyPressed());

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
                scoreChanger(gameobjects[i]);
                System.out.println(score);
                System.out.println(health);
            }
        }
    }



    private static boolean Collides(Picture p1, Picture p2){

        return ((p2.getX() >= p1.getX() && p2.getX() <= p1.getX()+p1.getWidth()) &&
                (p2.getY() >= p1.getY() && p2.getY() <= p1.getY()+p1.getHeight())) ||
                ((p2.getX()+p2.getWidth() >= p1.getX() && p2.getX()+p2.getWidth() <= p1.getX()+p1.getWidth())) &&
                 (p2.getY() >= p1.getY() && p2.getY() <= p1.getY()+p1.getHeight());

    }

    public void scoreChanger(GameObject obj){
        if(p1.getType() == PlayerType.JOJO){

            if(obj.getType() == ObjectType.BEER){
                score++;
            }
            if(obj.getType() == ObjectType.BRACKETS){
                health--;
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                score++;
            }
        }

        if(p1.getType() == PlayerType.RITA){

            if(obj.getType() == ObjectType.BEER){
                score++;
            }
            if(obj.getType() == ObjectType.CAR){
                score++;
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                health = 0;
            }
        }

        if(p1.getType() == PlayerType.RICARDO){

            if(obj.getType() == ObjectType.BEER){
                score++;
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                score++;
            }
            if(obj.getType() == ObjectType.BAD_DESIGN){
                health--;
            }
        }

        if(p1.getType() == PlayerType.SORAIA){

            if(obj.getType() == ObjectType.BEER){
                score++;
            }
            if(obj.getType() == ObjectType.CAR){
                health--;
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                score++;
            }
        }
    }



    public void createPlayer(int i){

        switch (i){
            case 1:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.JOJO);
                break;
            case 2:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.SORAIA);
                break;
            case 3:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.RICARDO);
                break;
            case 4:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.RITA);
                break;
        }
    }
}





