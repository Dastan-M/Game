package Units;

import java.util.Comparator;

public class PrioritySort implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o2.priority, o1.priority);
    }
}
