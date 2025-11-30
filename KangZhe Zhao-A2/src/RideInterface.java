// src/RideInterface.java
import java.util.Queue;
import java.util.LinkedList;

// Interface required by Part2: Defines queue operations and history management for rides
public interface RideInterface {
    // Add a visitor to the waiting queue
    void addVisitorToQueue(Visitor visitor);
    // Remove a visitor from the waiting queue (dequeue)
    Visitor removeVisitorFromQueue();
    // Print the waiting queue
    void printQueue();

    // Add a visitor to the ride history
    void addToRideHistory(Visitor visitor);
    // Print the ride history
    void printRideHistory();
    // Get the total number of visitors in the ride history
    int getRideHistoryCount();
}