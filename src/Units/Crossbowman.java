package Units;

import java.util.ArrayList;

public class Crossbowman extends Person {
    private int arrowsNum;
    boolean inGame = true;

    public Crossbowman(String name, int x, int y) {

        super(name, 3, 80, 10, 25, 20, 40, "crossbow", x, y);
        this.arrowsNum = 10;
    }

    public void attack(Person person) {
        System.out.println(name + " attacked " + person.name);
        arrowsNum--;
        int damage = this.power;
        person.health -= this.power;
        int res = person.getDamage(damage);
        System.out.println(" and gives " + res + " damage.");
    }

    public boolean isInGame() {
        return this.arrowsNum != 0;
    }

    public Person findNearestEnemy(ArrayList<Person> enemies) {
        Person target = null;
        double distance = Double.MAX_VALUE;
        for (Person hero : enemies) {
            if (hero.getDistance(this) < distance) {
                distance = hero.getDistance(this);
                target = hero;
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

