// src/AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo app = new AssignmentTwo();
        app.partFourA();
        app.partFourB();
    }

    // --- Part4A: Ride History Management Demo ---
    public void partFourA() {
        System.out.println("=== Part4A: Ride History Management Demo ===");

        // Create operator and ride
        Employee rollerCoasterOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Roller Coaster"
        );
        Ride rollerCoaster = new Ride("Roller Coaster", 6, rollerCoasterOperator);

        // Create test visitors
        Visitor visitor1 = new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        );
        Visitor visitor2 = new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        );
        Visitor visitor3 = new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        );

        // Add visitors to history
        System.out.println("\n--- Adding Visitors to History ---");
        rollerCoaster.addToRideHistory(visitor1);
        rollerCoaster.addToRideHistory(visitor2);
        rollerCoaster.addToRideHistory(visitor3);

        // Print initial history
        System.out.println("\n--- Initial Ride History ---");
        rollerCoaster.printRideHistory();

        // Find visitor by ticket ID
        System.out.println("\n--- Find Visitor by Ticket ID (TICKET-002) ---");
        Visitor foundVisitor = rollerCoaster.findVisitorInHistoryByTicketId("TICKET-002");
        System.out.println("Found: " + (foundVisitor != null ? foundVisitor : "No visitor found"));

        // Iterate history with Iterator
        System.out.println("\n--- Iterate Ride History ---");
        rollerCoaster.iterateRideHistory();
    }

    // --- Part4B: Ride History Sorting Demo ---
    public void partFourB() {
        System.out.println("\n\n=== Part4B: Ride History Sorting Demo ===");

        // Create operator and ride
        Employee ferrisWheelOperator = new Employee(
                "Li Si",
                26,
                "135-9999-0000",
                "EMP-002",
                "Ferris Wheel"
        );
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisWheelOperator);

        // Add unsorted visitors to history
        ferrisWheel.addToRideHistory(new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        ));
        ferrisWheel.addToRideHistory(new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        ));
        ferrisWheel.addToRideHistory(new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        ));

        // Print history before sorting
        System.out.println("\n--- Ride History (Before Sorting) ---");
        ferrisWheel.printRideHistory();

        // Sort the history
        System.out.println("\n--- Sorting Ride History ---");
        ferrisWheel.sortRideHistory();

        // Print history after sorting
        System.out.println("\n--- Ride History (After Sorting) ---");
        ferrisWheel.printRideHistory();
    }

    // Placeholder methods for other parts
    public void partThree() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}