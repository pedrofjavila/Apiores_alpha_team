import org.academiadecodigo.apiores.Intro;
import org.academiadecodigo.apiores.gameelements.GameElementsFactory;
import org.academiadecodigo.apiores.gameelements.objects.GameObject;
import org.academiadecodigo.apiores.gameelements.objects.ObjectType;
import org.academiadecodigo.apiores.gameelements.players.Player;
import org.academiadecodigo.apiores.gameelements.players.PlayerType;
import org.academiadecodigo.apiores.simplegfx.GameOver;
import org.academiadecodigo.apiores.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private SimpleGfxGrid grid;
    private GameObject[] gameObjects;
    private int delay;
    private int numberOfObjects = 20;
    private Player p1;
    private Intro intro;
    private GameOver gameOver;
    private Picture sky;
    private Picture grass;
    private Text health;
    private Text score;

    public Game(int cols, int rows, int delay) {
        this.grid = new SimpleGfxGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {

        grid.init();
        intro = new Intro(grid);
        gameOver = new GameOver(grid);


    }

    public void start() throws InterruptedException {

        intro.init();
        gameObjects = new GameObject[numberOfObjects];



        sky = new Picture(10,10, "resources/top.png");
        grass = new Picture(10, grid.getHeigth() -10, "resources/bottom.png");

        sky.draw();
        grass.draw();

        createPlayer(intro.getKeyPressed());
        itemSetter(p1);



            while (true) {
                if (gameWin()) {
                    restart(); //WIN RESTART
                    p1 = null;
                    break;
                } else if(gameOver()){
                    restart();
                    p1 = null;
                    break;
                }
                health =  new Text(20,20, "HEALTH: " + p1.getHealth());
                score = new Text(120,20, "SCORE " + p1.getScore());
                health.draw();
                score.draw();
                Thread.sleep(delay);
                moveObjects();
            }
    }



    public void itemFiller(ObjectType scorer, ObjectType scorer2, ObjectType killer){

        for (int i = 0; i < gameObjects.length; i++) {

            gameObjects[i] = GameElementsFactory.createNewGameObject(grid, scorer, scorer2, killer);
            gameObjects[i].setGrid(grid);
        }


    }

    public void itemSetter(Player player){
        if(player.getType() == PlayerType.SORAIA){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }

        if(player.getType() == PlayerType.JOJO){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }
        if(player.getType() == PlayerType.RITA){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }
        if(player.getType() == PlayerType.RICARDO){
            itemFiller(player.getItemScorer(), player.getItemScorer2(), player.getKillerItem());
        }

    }

    public void createPlayer(int i){

        switch (i){
            case 1:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.SORAIA);
                break;
            case 2:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.JOJO);
                break;
            case 3:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.RITA);
                break;
            case 4:
                p1 = GameElementsFactory.createNewPlayer(grid, PlayerType.RICARDO);
                break;
        }
    }




    public void moveObjects()  {
        for (int i = 0; i < gameObjects.length; i++) {
            GameObject object = gameObjects[i];

            object.move();


            if(Game.Collides(p1.getPosition().getPicture(), object.getPos().getPicture()))           {
                scoreChanger(gameObjects[i]);
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
                p1.kill();
            }
            if(obj.getType() == ObjectType.SUMARIZER){
                p1.healthDecrement();
            }
        }

        if(p1.getType() == PlayerType.RITA){

            if(obj.getType() == ObjectType.BEER){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.SUMARIZER){
                p1.healthDecrement();
            }
            if(obj.getType() == ObjectType.PINEAPPLE){
                p1.kill();
            }
        }

        if(p1.getType() == PlayerType.RICARDO){

            if(obj.getType() == ObjectType.BEER){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.SUMARIZER){
                p1.healthDecrement();
            }
            if(obj.getType() == ObjectType.BAD_DESIGN){
                p1.kill();
            }
        }

        if(p1.getType() == PlayerType.SORAIA){

            if(obj.getType() == ObjectType.BEER){
                p1.setScore();
            }
            if(obj.getType() == ObjectType.CAR){
                p1.kill();
            }
            if(obj.getType() == ObjectType.SUMARIZER){
                p1.healthDecrement();
            }
        }
    }

    public boolean gameWin(){
        return p1.getScore() >= 200;
    }

    public boolean gameOver(){
        return p1.getHealth() <= 0;
    }

    public void restart() throws InterruptedException {

        for(GameObject object : gameObjects){
            object.picture.delete();
        }

        gameOver.init();
        init();
        start();

    }
}





