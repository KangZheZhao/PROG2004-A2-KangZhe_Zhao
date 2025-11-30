// src/Visitor.java
public class Visitor extends Person { // Inherits from Person class, meets Document 1-45 requirements
    // 2 instance variables: ticket ID, whether is a member (meets Document 1-46 requirements)
    private String ticketId;
    private boolean isMember;

    // Default constructor (meets Document 1-47 requirements)
    public Visitor() {
        super(); // Call parent class default constructor
        this.ticketId = "TICKET-000";
        this.isMember = false;
    }

    // Parameterized constructor (initializes parent class variables + own variables, meets Document 1-47 requirements)
    public Visitor(String name, int age, String contactInfo, String ticketId, boolean isMember) {
        super(name, age, contactInfo); // Call parent class parameterized constructor
        this.ticketId = ticketId;
        this.isMember = isMember;
    }

    // Getter and Setter methods (for all Visitor instance variables, meets Document 1-48 requirements)
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    // Override toString(): integrates parent class information + own information
    @Override
    public String toString() {
        return "Visitor{" +
                "ticketId='" + ticketId + "', " +
                "isMember=" + isMember + ", " +
                "parent class info: " + super.toString() + // Call parent class toString()
                '}';
    }
}
