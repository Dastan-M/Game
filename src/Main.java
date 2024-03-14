import Units.*;

public class Main {
    public static void main(String[] args) {
        Robber robber = new Robber("Ivan", 20);
        Peasant peasant = new Peasant("Vova", 20);
        Crossbowman crossbowman = new Crossbowman("Stepan", 30);
        Wizard wizard = new Wizard("Oleg", 50);
        Sniper sniper = new Sniper("Timur", 30);
        Monk monk = new Monk("Kiril", 60);
        Pikeman pikeman = new Pikeman("Maxim", 20);
        System.out.println(robber);
        System.out.println(peasant);
        System.out.println(crossbowman);
        System.out.println(wizard);
        System.out.println(sniper);
        System.out.println(monk);
        System.out.println(pikeman);
    }
}