// src/AssignmentTwo.java
public class AssignmentTwo {
    // Main method: Program entry point, used to test Part2 functionality
    public static void main(String[] args) {
        // Create an operator
        Employee operator = new Employee("Zhang San", 25, "138xxxx1234", "EMP-001", "Roller Coaster");

        // Create a ride instance
        Ride rollerCoaster = new Ride("Roller Coaster", 6, operator);

        // Create two visitor instances
        Visitor v1 = new Visitor("Li Si", 18, "139xxxx5678", "TICKET-001", true);
        Visitor v2 = new Visitor("Wang Wu", 20, "137xxxx9012", "TICKET-002", false);

        // Test: Add visitors to waiting queue and print the queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.printQueue();

        // Test: Add a visitor to ride history and print the history
        rollerCoaster.addToRideHistory(v1);
        rollerCoaster.printRideHistory();
        System.out.println("Total visitors in history: " + rollerCoaster.getRideHistoryCount());
    }

    // Placeholder for Part3: Waiting queue management
    public void partThree() {}

    // Placeholder for Part4A: Ride history management
    public void partFourA() {}

    // Placeholder for Part4B: Ride history sorting
    public void partFourB() {}

    // Placeholder for Part6: Export ride history to file
    public void partSix() {}

    // Placeholder for Part7: Import ride history from file
    public void partSeven() {}

    // Placeholder for Part5: Ride cycle operation
    public void partFive() {}
}