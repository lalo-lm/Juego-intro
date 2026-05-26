import greenfoot.*;

public class WallH extends Actor {

    public WallH() {
        GreenfootImage visible = new GreenfootImage("WallH.png");
        setImage(visible);
    }

    public int getHitWidth()  { return 64; }
    public int getHitHeight() { return 25; }

    @Override
    public void act() { }
}