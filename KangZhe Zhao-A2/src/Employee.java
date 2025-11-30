// src/Employee.java
public class Employee extends Person { // Inherits from Person class, meets Document 1-40 requirements
    // 2 instance variables: employee ID, responsible ride (meets Document 1-41 requirements)
    private String employeeId;
    private String responsibleRide;

    // Default constructor (meets Document 1-42 requirements)
    public Employee() {
        super(); // Call parent class default constructor
        this.employeeId = "EMP-000";
        this.responsibleRide = "None";
    }

    // Parameterized constructor (initializes parent class variables + own variables, meets Document 1-42 requirements)
    public Employee(String name, int age, String contactInfo, String employeeId, String responsibleRide) {
        super(name, age, contactInfo); // Call parent class parameterized constructor
        this.employeeId = employeeId;
        this.responsibleRide = responsibleRide;
    }

    // Getter and Setter methods (for all Employee instance variables, meets Document 1-43 requirements)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getResponsibleRide() {
        return responsibleRide;
    }

    public void setResponsibleRide(String responsibleRide) {
        this.responsibleRide = responsibleRide;
    }

    // Override toString(): integrates parent class information + own information
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + "', " +
                "responsibleRide='" + responsibleRide + "', " +
                "parent class info: " + super.toString() + // Call parent class toString()
                '}';
    }
}
