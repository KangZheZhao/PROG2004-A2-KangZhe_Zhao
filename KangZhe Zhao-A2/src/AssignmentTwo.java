// src/AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        // Run Part3 demo
        AssignmentTwo app = new AssignmentTwo();
        app.partThree();
    }

    // --- Part3: Demonstrate Waiting Queue Management ---
    public void partThree() {
        System.out.println("=== Part3: Theme Park Ride Queue Management Demo ===");

        // 1. Create ride operator
        Employee ferrisWheelOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Ferris Wheel"
        );

        // 2. Create Ferris Wheel ride instance
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisWheelOperator);

        // 3. Create 3 test visitors
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

        // 4. Add visitors to the queue
        System.out.println("\n--- Adding Visitors to Queue ---");
        ferrisWheel.addVisitorToQueue(visitor1);
        ferrisWheel.addVisitorToQueue(visitor2);
        ferrisWheel.addVisitorToQueue(visitor3);

        // 5. Print initial queue
        System.out.println("\n--- Initial Queue State ---");
        ferrisWheel.printQueue();

        // 6. Check queue status
        System.out.println("\n--- Queue Status Check ---");
        System.out.println("Queue size: " + ferrisWheel.getQueueSize());
        System.out.println("Is queue empty? " + ferrisWheel.isQueueEmpty());

        // 7. Remove one visitor from queue
        System.out.println("\n--- Removing One Visitor ---");
        ferrisWheel.removeVisitorFromQueue();

        // 8. Print updated queue
        System.out.println("\n--- Updated Queue State ---");
        ferrisWheel.printQueue();

        // 9. Final queue status
        System.out.println("\n--- Final Queue Status ---");
        System.out.println("Queue size: " + ferrisWheel.getQueueSize());
    }

    // Placeholder methods for other parts
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}