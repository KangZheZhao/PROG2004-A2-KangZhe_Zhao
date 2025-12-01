// src/Ride.java
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

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
    public Visitor findVisitorInHistoryByTicketId(String ticketId) {
        for (Visitor visitor : rideHistory) {
            if (visitor.getTicketId().equals(ticketId)) {
                return visitor;
            }
        }
        return null;
    }

    public void clearRideHistory() {
        rideHistory.clear();
        System.out.println(rideName + "'s ride history has been cleared");
    }

    public void iterateRideHistory() {
        System.out.println("\nIterating " + rideName + "'s ride history:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }

    // --- Part4B: Ride History Sorting Method ---
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println(rideName + "'s ride history has been sorted (age → name)");
    }

    // --- Part5: Ride Cycle Operation Method ---
    public void runOneCycle() {
        System.out.println("\n=== " + rideName + " Starting New Cycle ===");
        if (isQueueEmpty()) {
            System.out.println("No visitors in queue - cycle canceled");
            return;
        }

        int ridersThisCycle = 0;
        while (ridersThisCycle < maxCapacity && !isQueueEmpty()) {
            Visitor currentRider = removeVisitorFromQueue();
            addToRideHistory(currentRider);
            ridersThisCycle++;
        }

        System.out.println("Cycle completed: " + ridersThisCycle + " visitors rode the " + rideName);
        System.out.println("Updated ride history count: " + getRideHistoryCount());
    }

    // --- Part6: Export Ride History to Text File ---
    public void exportHistoryToFile(String filePath) {
        System.out.println("\n--- Exporting " + rideName + "'s History to File: " + filePath + " ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write file header
            writer.write(rideName + " Ride History (Total Visitors: " + getRideHistoryCount() + ")");
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();

            // Write each visitor's info
            for (Visitor visitor : rideHistory) {
                writer.write(String.format(
                        "Name: %s | Age: %d | Ticket ID: %s | Member: %s | Contact: %s",
                        visitor.getName(),
                        visitor.getAge(),
                        visitor.getTicketId(),
                        visitor.isMember() ? "Yes" : "No",
                        visitor.getContactInfo()
                ));
                writer.newLine();
            }

            System.out.println("Export successful! History saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    // --- Part7: Import Ride History from Text File ---
    public void importHistoryFromFile(String filePath) {
        System.out.println("\n--- Importing History to " + rideName + " from File: " + filePath + " ---");
        // Clear existing history before importing
        clearRideHistory();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header lines (first 2 lines)
            reader.readLine(); // Skip title line
            reader.readLine(); // Skip separator line

            // Read and parse each visitor line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length != 5) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                // Parse each field from the line
                String name = parts[0].split(": ")[1];
                int age = Integer.parseInt(parts[1].split(": ")[1]);
                String ticketId = parts[2].split(": ")[1];
                boolean isMember = parts[3].split(": ")[1].equals("Yes");
                String contactInfo = parts[4].split(": ")[1];

                // Create Visitor object and add to history
                Visitor importedVisitor = new Visitor(name, age, contactInfo, ticketId, isMember);
                addToRideHistory(importedVisitor);
            }

            System.out.println("Import successful! " + getRideHistoryCount() + " visitors imported");
        } catch (IOException e) {
            System.out.println("Import failed: File error - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Import failed: Invalid number format - " + e.getMessage());
        }
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