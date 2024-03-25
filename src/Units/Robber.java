package Units;

import java.util.ArrayList;

public class Robber extends Person {
    public Robber (String name, int x, int y) {

        super(name, 2, 100, 10, 25, 20, 40, "knife", x, y);
    }

    public void attack(Person person){
        person.health -= super.power;
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
    public void kick (Person person){
        System.out.println(name + " attacked " + person.name);
        int damage = this.power;
        person.health -= this.power;
        int res = person.getDamage(damage);
        System.out.println(" and gives " + res + " damage.");
    }
    public void move (Person person, ArrayList<Person> friends){
        Position delta = position.getDelta(person.position);
        Position newPos = new Position(position.getX(), position.getY());
        int dx = delta.getX();
        if (dx != 0)
            dx = Math.abs(dx)/dx;
        int dy = delta.getY();
        if (dy != 0)
            dy = Math.abs(dy)/dy;
        if (dx != 0 && dy != 0)
            dy = 0;
        newPos.add(dx, dy);
        for (Person val : friends){
            if(val.position.check(newPos))
                return;
        }
        position = newPos;
        System.out.println(this);
    }
    @Override
    public void step (ArrayList < Person > enemies, ArrayList<Person> friends) {
        Person target = this.findNearestEnemy(enemies);
        if (health <= 0 || target == null)
            return;
        if (position.distanceTo(target.position) < 2)
            kick(target);
        else
            move(target, friends);
    }
}
