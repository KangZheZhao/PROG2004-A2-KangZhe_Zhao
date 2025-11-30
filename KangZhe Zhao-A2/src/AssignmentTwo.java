// src/AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo app = new AssignmentTwo();
        app.partSix();
    }

    // --- Part6: Export Ride History to File Demo ---
    public void partSix() {
        System.out.println("=== Part6: Export Ride History to File Demo ===");

        // 1. Create operator and ride
        Employee ferrisWheelOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Ferris Wheel"
        );
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisWheelOperator);

        // 2. Add test visitors to ride history
        System.out.println("\n--- Adding Visitors to History ---");
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
        ferrisWheel.addToRideHistory(new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        ));

        // 3. Print current ride history (for reference)
        System.out.println("\n--- Current Ride History ---");
        ferrisWheel.printRideHistory();

        // 4. Export history to file (saved in project root directory)
        String exportFilePath = "ride_history.txt";
        ferrisWheel.exportHistoryToFile(exportFilePath);
    }

    // Placeholder methods for other parts
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSeven() {}
}