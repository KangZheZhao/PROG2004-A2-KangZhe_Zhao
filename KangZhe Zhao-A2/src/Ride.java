// src/Ride.java
public class Ride {
    // 3 instance variables: ride name, maximum capacity, responsible operator (Employee type, meets Document 1-50 requirements)
    private String rideName;
    private int maxCapacity;
    private Employee operator; // Key: associates with Employee class to mark if there is an operator

    // Default constructor (meets Document 1-54 requirements)
    public Ride() {
        this.rideName = "Unknown Ride";
        this.maxCapacity = 4; // Default maximum capacity is 4 people
        this.operator = new Employee(); // Initialize an empty operator by default
    }

    // Parameterized constructor (initializes all instance variables, meets Document 1-54 requirements)
    public Ride(String rideName, int maxCapacity, Employee operator) {
        this.rideName = rideName;
        // Data validation: maximum capacity must be at least 1 (complies with ride logic)
        this.maxCapacity = (maxCapacity >= 1) ? maxCapacity : 1;
        this.operator = operator;
    }

    // Getter and Setter methods (for all Ride instance variables, including the assignment method for operator, meets Document 1-55 requirements)
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity >= 1) {
            this.maxCapacity = maxCapacity;
        } else {
            System.out.println("Maximum capacity must be at least 1!");
        }
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Override toString(): prints complete ride information
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + "', " +
                "maxCapacity=" + maxCapacity + ", " +
                "operator=" + operator + // Call Employee's toString()
                '}';
    }
}
