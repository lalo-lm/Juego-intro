import greenfoot.*;

public class Wall extends Actor {

    public Wall() {
        GreenfootImage visible = new GreenfootImage("Wall.png");
        setImage(visible);
    }

    public int getHitWidth()  { return 25; }
    public int getHitHeight() { return 136; }

    @Override
    public void act() { }
}