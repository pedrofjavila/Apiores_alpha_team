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


    }

    public void start() throws InterruptedException {

        intro.init();
        createPlayer(intro.getKeyPressed());
        itemSetter(p1);

        while (true) {
            Thread.sleep(delay);

            moveObjects();
        }
    }



    public void itemFiller(ObjectType scorer, ObjectType scorer2, ObjectType killer){

        for (int i = 0; i < gameobjects.length; i++) {

            gameobjects[i] = GameElementsFactory.createNewGameObject(grid, scorer, scorer2, killer);
            gameobjects[i].setGrid(grid);
        }


    }

    public void itemSetter(Player player){
        if(player.getType() == PlayerType.JOJO){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }

        if(player.getType() == PlayerType.SORAIA){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }
        if(player.getType() == PlayerType.RICARDO){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }
        if(player.getType() == PlayerType.RITA){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
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




    public void moveObjects()  {
        for (int i = 0; i < gameobjects.length; i++) {
            GameObject object = gameobjects[i];

            object.move();


            if(Game.Collides(p1.getPosition().getPicture(), object.getPos().getPicture()))           {
                scoreChanger(gameobjects[i]);
                System.out.println(p1.getScore());
                System.out.println(p1.getHealth());
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
                p1.setScore();
            }
            if(obj.getType() == ObjectType.BRACKETS){
                p1.healthDecrement();
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                p1.setScore();
            }
        }

        if(p1.getType() == PlayerType.RITA){

            if(obj.getType() == ObjectType.BEER){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.CAR){
                p1.healthDecrement();
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                p1.killRita();
            }
        }

        if(p1.getType() == PlayerType.RICARDO){

            if(obj.getType() == ObjectType.BEER){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.BAD_DESIGN){
                p1.healthDecrement();
            }
        }

        if(p1.getType() == PlayerType.SORAIA){

            if(obj.getType() == ObjectType.BEER){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.CAR){
                p1.healthDecrement();
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                p1.setScore();
            }
        }
    }


}





