package Units;

import java.util.ArrayList;

public class Crossbowman extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Crossbowman (String name, int x, int y){
        super(name, 80, 10, 25, 20, 40, "crossbow", 30, x, y);
    }
    public void attack(Person person){
        person.health -= this.power;
    }
    public boolean isInGame(){
        return this.arrowsNum != 0;
    }
    public Person findNearestEnemy(ArrayList<Person> enemies){
        Person target = null;
        double distance = Integer.MAX_VALUE;
        for (Person p : enemies){
            if (p.getDistance(this) < distance){
                distance = p.getDistance(this);
                target = p;
            }
        }
        return target;
    }
}

