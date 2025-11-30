// src/Ride.java
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;

public class Ride implements RideInterface {
    // Ride basic information
    private String rideName;
    private int maxCapacity;
    private Employee operator;

    // Waiting queue (Part3)
    private Queue<Visitor> waitingQueue;
    // Ride history (Part2 + Part4)
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

    // --- Part3: Queue Management Methods ---
    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }

    public int getQueueSize() {
        return waitingQueue.size();
    }

    // --- Part4A: Ride History Management Methods ---
    // Find visitor in history by ticket ID
    public Visitor findVisitorInHistoryByTicketId(String ticketId) {
        for (Visitor visitor : rideHistory) {
            if (visitor.getTicketId().equals(ticketId)) {
                return visitor;
            }
        }
        return null;
    }

    // Clear all ride history
    public void clearRideHistory() {
        rideHistory.clear();
        System.out.println(rideName + "'s ride history has been cleared");
    }

    // Iterate history using Iterator
    public void iterateRideHistory() {
        System.out.println("\nIterating " + rideName + "'s ride history:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }

    // --- Part4B: Ride History Sorting Method ---
    // Sort history by age (ascending) → name (ascending)
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println(rideName + "'s ride history has been sorted (age → name)");
    }

    // --- Implement RideInterface Methods ---
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
        System.out.println("Visitor " + visitor.getName() + " added to " + rideName + "'s history");
    }

    @Override
    public void printRideHistory() {
        System.out.println("\n" + rideName + "'s Ride History (" + rideHistory.size() + " visitors):");
        if (rideHistory.isEmpty()) {
            System.out.println("  [History is empty]");
            return;
        }
        int index = 1;
        for (Visitor visitor : rideHistory) {
            System.out.println("  " + index + ". " + visitor);
            index++;
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