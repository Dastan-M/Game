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
//        System.out.println(name + " attacked " + person.name);
        arrowsNum--;
        int damage = this.power;
        person.health -= this.power;
        int res = person.getDamage(damage);
//        System.out.println(" and gives " + res + " damage.");
    }

    public boolean isInGame() {
        return this.arrowsNum != 0;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        if (health <= 0 && arrowsNum <= 0) {
//            if (arrowsNum <= 0){
//                System.out.println(name + ": no arrows!");
//            }
            return;
        }
        Person target = this.findNearestEnemy(enemies);
        if (target != null) {
            this.attack(target);
        }
    }
    @Override
    public String toString() {
        return "Peasant{" + name +
                " ❤=" + health + ", " + position.getX() + ":" + position.getY() +
                '}';
    }

    @Override
    public String getInfo() {
        return "Crossbowman " + definition;
    }

    public int getArrowsNum() {
        return arrowsNum;
    }
}

