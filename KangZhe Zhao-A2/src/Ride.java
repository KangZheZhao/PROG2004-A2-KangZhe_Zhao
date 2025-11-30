// src/Ride.java
import java.util.Queue;
import java.util.LinkedList;

public class Ride implements RideInterface {
    // Name of the ride
    private String rideName;
    // Maximum number of riders per cycle
    private int maxCapacity;
    // Employee responsible for operating the ride
    private Employee operator;

    // Part2 addition: Queue to store waiting visitors
    private Queue<Visitor> waitingQueue;
    // Part2 addition: LinkedList to store ride history (visited visitors)
    private LinkedList<Visitor> rideHistory;

    // Default constructor: Initializes default values and collections
    public Ride() {
        this.rideName = "Unknown Ride";
        this.maxCapacity = 4;
        this.operator = new Employee();
        // Initialize waiting queue (LinkedList implements Queue)
        this.waitingQueue = new LinkedList<>();
        // Initialize ride history (LinkedList for easy traversal/sorting later)
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor: Initializes ride details + operator, then collections
    public Ride(String rideName, int maxCapacity, Employee operator) {
        this.rideName = rideName;
        // Validate: Max capacity must be at least 1
        this.maxCapacity = (maxCapacity >= 1) ? maxCapacity : 1;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // --- Implement methods from RideInterface ---
    // Add a visitor to the waiting queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingQueue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to " + rideName + "'s waiting queue");
    }

    // Remove the front visitor from the waiting queue (dequeue)
    @Override
    public Visitor removeVisitorFromQueue() {
        return waitingQueue.poll(); // Returns null if queue is empty
    }

    // Print all visitors in the waiting queue
    @Override
    public void printQueue() {
        System.out.println(rideName + "'s waiting queue (" + waitingQueue.size() + " visitors):");
        for (Visitor v : waitingQueue) {
            System.out.println("- " + v);
        }
    }

    // Add a visitor to the ride history
    @Override
    public void addToRideHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    // Print all visitors in the ride history
    @Override
    public void printRideHistory() {
        System.out.println(rideName + "'s ride history (" + rideHistory.size() + " total visitors):");
        for (Visitor v : rideHistory) {
            System.out.println("- " + v);
        }
    }

    // Get the total number of visitors in the ride history
    @Override
    public int getRideHistoryCount() {
        return rideHistory.size();
    }

    // --- Getter and Setter methods ---
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    // Override toString: Print full ride details
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + "', " +
                "maxCapacity=" + maxCapacity + ", " +
                "operator=" + operator +
                '}';
    }
}
