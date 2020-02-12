public class Main {

    public static void main(String[] args) throws InterruptedException{

        Game game = new Game(60, 31, 300);

        System.out.println();

        game.init();
        game.start();
    }


}
