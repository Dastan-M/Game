package Units;

import Units.Person;

import java.util.ArrayList;

public class Sniper extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Sniper (String name, int x, int y){
        super(name, 3, 70, 20, 30, 10, 50, "gun", x, y);
    }
    public void attack(Person person) {
        System.out.println(name + " attacked " + person.name);
        arrowsNum--;
        int damage = this.power;
        person.health -= this.power;
        int res = person.getDamage(damage);
        System.out.println(" and gives " + res + " damage.");
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
    @Override
    public void step(ArrayList<Person> enemies) {
        if (health <= 0 && arrowsNum <= 0) {
            if (arrowsNum <= 0){
                System.out.println(name + ": no arrows!");
            }
            return;
        }
        Person target = this.findNearestEnemy(enemies);
        if (target != null) {
            this.attack(target);
        }
    }

    public int getArrowsNum() {
        return arrowsNum;
    }
}
