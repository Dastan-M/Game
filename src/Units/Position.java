package Units;

import java.util.ArrayList;
import java.util.List;

public class Position {
    protected int x, y;
    private static int width;
    private static int height;
    static {width = 10; height = 10;}
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
//    public void setX(int curX){
//        this.curX = curX;
//    }
//    public void setY(int curY){
//        this.curY = curY;
//    }
//    public void setXY(int x, int y){
//        curX = x;
//        curY = y;
//    }
//    public int getX(){
//        return curX;
//    }
//    public int getY(){
//        return curY;
//    }
//    public static void setWidth(int width){
//        Position.width = width;
//    }
//    public static void setHeight(int height){
//        Position.height = height;
//    }
//    public static int getWidth(){
//        return width;
//    }
//    public static int getHeight(){
//        return height;
//    }
    public boolean isMove(int x, int y){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public void moveTo(int dx, int dy){
        if(isMove(this.x+dx, this.y+dy)){
            this.x += dx;
            this.y += dy;
        }
    }
    public float distanceTo(Position target){
        float x = this.x - target.getY();
        float y = this.y - target.getX();
        return (float) Math.sqrt(x*x + y*y);
    }
    public Position getDelta (Position target){
        return new Position(target.getX() - getX(), target.getX() - getY());
    }
    public boolean check(Position pt){
        return this.x == pt.getX() && this.y == pt.getY();
    }
    public List<Integer> getPosition(){
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        return list;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void add(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
