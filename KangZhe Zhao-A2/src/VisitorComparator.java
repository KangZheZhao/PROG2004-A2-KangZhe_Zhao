// src/VisitorComparator.java
import java.util.Comparator;

// Comparator to sort Visitors by age (ascending), then name (ascending)
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare by age first
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        // If ages are equal, compare by name
        return v1.getName().compareTo(v2.getName());
    }
}
