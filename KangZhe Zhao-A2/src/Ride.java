// src/Ride.java
import java.util.Queue;
import java.util.LinkedList;

// Implements RideInterface to handle queue and history operations (Part2 + Part3)
public class Ride implements RideInterface {
    // Ride basic info
    private String rideName;
    private int maxCapacity;
    private Employee operator;

    // Part2 + Part3: Waiting queue (stores visitors waiting for the ride)
    private Queue<Visitor> waitingQueue;
    // Part2: Ride history (stores visitors who have ridden)
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.maxCapacity = 4;
        this.operator = new Employee();
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, int maxCapacity, Employee operator) {
        this.rideName = rideName;
        this.maxCapacity = (maxCapacity >= 1) ? maxCapacity : 1;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // --- Part3: Enhanced Queue Management Methods ---
    // Check if the waiting queue is empty
    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }

    // Get current size of the waiting queue
    public int getQueueSize() {
        return waitingQueue.size();
    }

    // --- Implement RideInterface Methods (Part2 + Part3) ---
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingQueue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to " + rideName + "'s waiting queue");
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removedVisitor = waitingQueue.poll();
        if (removedVisitor != null) {
            System.out.println("Visitor " + removedVisitor.getName() + " removed from " + rideName + "'s waiting queue");
        } else {
            System.out.println(rideName + "'s waiting queue is empty - cannot remove");
        }
        return removedVisitor;
    }

    @Override
    public void printQueue() {
        System.out.println("\n" + rideName + "'s Waiting Queue (" + waitingQueue.size() + " visitors):");
        if (waitingQueue.isEmpty()) {
            System.out.println("  [Queue is empty]");
            return;
        }
        int index = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println("  " + index + ". " + visitor);
            index++;
        }
    }

    @Override
    public void addToRideHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public void printRideHistory() {
        System.out.println(rideName + "'s Ride History (" + rideHistory.size() + " total visitors):");
        for (Visitor visitor : rideHistory) {
            System.out.println("- " + visitor);
        }
    }

    @Override
    public int getRideHistoryCount() {
        return rideHistory.size();
    }

    // --- Getters & Setters ---
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + "', " +
                "maxCapacity=" + maxCapacity + ", " +
                "operator=" + operator +
                '}';
    }
}