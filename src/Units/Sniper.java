package Units;

import Units.Person;

public class Sniper extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Sniper (String name, int age){
        super(name, 70, 20, age, 10, 50, "gun", 20);
    }
    public void attack(Person person){
        person.health -= this.power;
    }
    public boolean isInGame(){
        return this.arrowsNum != 0;
    }
}
