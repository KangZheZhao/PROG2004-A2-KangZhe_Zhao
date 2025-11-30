// src/AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo app = new AssignmentTwo();
        app.partFive();
    }

    // --- Part5: Ride Cycle Operation Demo ---
    public void partFive() {
        System.out.println("=== Part5: Ride Cycle Operation Demo ===");

        // 1. Create operator and ride (max capacity = 4)
        Employee rollerCoasterOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Roller Coaster"
        );
        Ride rollerCoaster = new Ride("Roller Coaster", 4, rollerCoasterOperator);

        // 2. Add 6 visitors to the queue (more than max capacity)
        System.out.println("\n--- Adding 6 Visitors to Queue ---");
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Qian Qi",
                25,
                "135-4444-3333",
                "TICKET-004",
                false
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Sun Ba",
                19,
                "134-2222-1111",
                "TICKET-005",
                true
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Zhou Jiu",
                21,
                "133-6666-5555",
                "TICKET-006",
                false
        ));

        // 3. Print initial queue
        System.out.println("\n--- Initial Queue ---");
        rollerCoaster.printQueue();

        // 4. Run first cycle (max 4 visitors)
        System.out.println("\n--- Running First Cycle ---");
        rollerCoaster.runOneCycle();

        // 5. Print queue and history after first cycle
        System.out.println("\n--- Queue After First Cycle ---");
        rollerCoaster.printQueue();
        System.out.println("\n--- Ride History After First Cycle ---");
        rollerCoaster.printRideHistory();

        // 6. Run second cycle
        System.out.println("\n--- Running Second Cycle ---");
        rollerCoaster.runOneCycle();

        // 7. Print final state
        System.out.println("\n--- Final Queue ---");
        rollerCoaster.printQueue();
        System.out.println("\n--- Final Ride History ---");
        rollerCoaster.printRideHistory();
    }

    // Placeholder methods for other parts
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partSix() {}
    public void partSeven() {}
}