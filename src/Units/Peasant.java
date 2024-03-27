package Units;

import java.util.ArrayList;

public class Peasant extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Peasant (String name, int x, int y){
        super(name, 0, 20, 5, 20, 0, 20, "nothing", x, y);
    }

    public void giveArrows(int val){
        this.arrowsNum -= val;
        if(!isInGame()){
            inGame = false;
        }
    }
    public boolean isInGame(){
        return this.arrowsNum != 0;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
    }

    @Override
    public String toString() {
        return "Peasant{" + name +
                " ❤=" + health + ", " + position.getX() + ":" + position.getY() +
                '}';
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }
}
