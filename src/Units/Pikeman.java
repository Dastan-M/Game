package Units;

import java.util.ArrayList;

public class Pikeman extends Person {
    public Pikeman(String name, int x, int y) {

        super(name, 2, 100, 10, 20, 30, 40, "pike", x, y);
    }

    public void attack(Person person) {
        person.health -= super.power;
    }

    public void kick(Person person) {
//        System.out.println(name + " attacked " + person.name);
        int damage = this.power;
        person.health -= this.power;
        int res = person.getDamage(damage);
        definition = definition + "attack" + person.name + "set" + res + "damage";
//        System.out.println(" and gives " + res + " damage.");
    }

    public void move(Person person, ArrayList<Person> friends) {
        int[] px = {1, 0, -1, 0};
        int[] py = {0, 1, 0, -1};
//        Position delta = position.getDelta(person.position);
        Position newPos = new Position(position.getX(), position.getY());
        int minIdx = -1;
        float minDist = Float.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            newPos.setXY(position.getX() + px[i], position.getY() + py[i]);
            if (isMove(x, y)) {
                float dist = position.fastDistance(person.position, px[i], py[i]);
                if (dist < minDist) {
                    minIdx = i;
                    minDist = dist;
                }
            }
        }
        if (minIdx != -1) {
            position.increment(px[minIdx], py[minIdx]);
//            System.out.println(name + ": moved to (" + position.getX() + ", " + position.getY() + ")");
            definition = "move to " + position.getX() + ":" + position.getY();
        }
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        definition = "";
        Person target = this.findNearestEnemy(enemies);
        if (health <= 0 || target == null)
            return;
        if (position.distanceTo(target.position) < 1.5f)
            kick(target);
        else
            move(target, friends);
        if (position.distanceTo(target.position) < 1.5f) {
            kick(target);
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
        return "Pikeman " + definition;
    }
}
