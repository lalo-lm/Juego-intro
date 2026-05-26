import greenfoot.*;

public class MyWorld extends World {

    private static GreenfootSound musica = new GreenfootSound("Juego.mp3");

    public MyWorld() {
        super(609, 644, 1);
        setBackground("fondo_nivel1.png");
        prepare();
    }

    @Override
    public void started() {
        musica.playLoop();
    }

    @Override
    public void stopped() {
        musica.pause();
    }

    public static void reiniciarMusica() {
        musica.stop();
        musica.playLoop();
    }

    private void prepare() {
        WallH wallH = new WallH();
        addObject(wallH, 155, 84);
        WallH wallH2 = new WallH();
        addObject(wallH2, 157, 565);
        WallH wallH3 = new WallH();
        addObject(wallH3, 243, 564);
        WallH wallH4 = new WallH();
        addObject(wallH4, 327, 564);
        WallH wallH5 = new WallH();
        addObject(wallH5, 399, 565);
        WallH wallH6 = new WallH();
        addObject(wallH6, 449, 565);
        WallH wallH7 = new WallH();
        addObject(wallH7, 245, 172);
        WallH wallH8 = new WallH();
        addObject(wallH8, 311, 178);
        WallH wallH9 = new WallH();
        addObject(wallH9, 384, 179);
        WallH wallH10 = new WallH();
        addObject(wallH10, 434, 177);

        Wall wall = new Wall();
        addObject(wall, 107, 156);
        Wall wall2 = new Wall();
        addObject(wall2, 106, 273);
        Wall wall3 = new Wall();
        addObject(wall3, 107, 404);
        Wall wall4 = new Wall();
        addObject(wall4, 107, 497);
        Wall wall5 = new Wall();
        addObject(wall5, 482, 506);
        Wall wall6 = new Wall();
        addObject(wall6, 483, 413);
        Wall wall7 = new Wall();
        addObject(wall7, 481, 326);
        Wall wall8 = new Wall();
        addObject(wall8, 482, 243);

        SmallerWall smallerWall = new SmallerWall();
        addObject(smallerWall, 201, 132);

        SafeZone safeZone = new SafeZone();
        addObject(safeZone, 293, 370);

        Player player = new Player();
        addObject(player, 293, 370);

        Coin coin = new Coin();
        addObject(coin, 153, 137);

        addObject(new Enemy(250, 233, 1, 3), 250, 233);
        addObject(new Enemy(340, 233, 1, 3), 340, 233);
        addObject(new Enemy(434, 303, 2, 3), 434, 303);
        addObject(new Enemy(434, 374, 2, 3), 434, 374);
        addObject(new Enemy(434, 445, 2, 3), 434, 445);
        addObject(new Enemy(364, 516, 3, 3), 364, 516);
        addObject(new Enemy(293, 516, 3, 3), 293, 516);
        addObject(new Enemy(222, 516, 3, 3), 222, 516);
        addObject(new Enemy(153, 445, 0, 3), 153, 445);
        addObject(new Enemy(153, 374, 0, 3), 153, 374);
        addObject(new Enemy(153, 303, 0, 3), 153, 303);
        addObject(new Enemy(434, 516, 3, 3), 434, 516);
        addObject(new Enemy(153, 516, 0, 3), 153, 516);
        addObject(new Enemy(153, 233, 1, 3), 153, 233);
    }
}