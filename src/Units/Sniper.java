package Units;

import Units.Person;

import java.util.ArrayList;

public class Sniper extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Sniper (String name, int x, int y){
        super(name, 70, 20, 30, 10, 50, "gun", 20, x, y);
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
            double n = p.getDistance(this);
            if (n < distance){
                distance = n;
                target = p;
            }
        }
        return target;
    }
}
