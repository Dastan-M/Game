import Units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Person> teamA = new ArrayList<Person>();
    public static ArrayList<Person> teamB = new ArrayList<Person>();
    public static ArrayList<Person> all = new ArrayList<>();

    public static void main(String[] args) {
        teamA = createTeam(10, 0);
        teamB = createTeam(10, 3);
        all.addAll(teamA);
        all.addAll(teamB);
//        all.sort(new PrioritySort());
        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));

//        for (int i = 0; i < 10; i++) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            View.view();
            for (Person hero : all) {
//            System.out.println(hero + " makes step");
                if (teamA.contains(hero)) {
                    hero.step(teamB, teamA);
                } else {
                    hero.step(teamA, teamB);
                }
            }
            scanner.nextLine();
            if (!isAlive(teamA)) {
                System.out.println("teamB is winner!");
                break;
            }
            if (!isAlive(teamB)) {
                System.out.println("teamA is winner!");
                break;
            }
        }
    }

    private static boolean isAlive(ArrayList<Person> team) {
        for (Person person : team) {
            if (person.getHealth() > 0)
                return true;
        }
        return false;
    }

    private static ArrayList<Person> createTeam(int val, int num){
        ArrayList<Person> team = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4) + num){
                case 0:
                    team.add(new Crossbowman(getName(), 0, i));
                    break;
                case 1:
                    team.add(new Pikeman(getName(), 0, i));
                    break;
                case 2:
                    team.add(new Wizard(getName(), 0, i));
                    break;
                case 3:
                    team.add(new Peasant(getName(), num*3, i));
                    break;
                case 4:
                    team.add(new Sniper(getName(), 9, i));
                    break;
                case 5:
                    team.add(new Monk(getName(),9, i));
                    break;
                case 6:
                    team.add(new Robber(getName(), 9, i));
                    break;
            }
        }
        return team;
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}