import greenfoot.*;

public class SmallerWall extends Actor {

    public SmallerWall() {
        GreenfootImage visible = new GreenfootImage("Wall1.png");
        setImage(visible);
    }

    public int getHitWidth()  { return 25; }
    public int getHitHeight() { return 50; }

    @Override
    public void act() { }
}
 