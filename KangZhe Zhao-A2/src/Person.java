// src/Person.java
public abstract class Person { // 修正为抽象类声明
    // 3 instance variables: name, age, contact information (meets Document 1-36 requirements)
    private String name;
    private int age;
    private String contactInfo;

    // Default constructor (meets Document 1-37 requirements)
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.contactInfo = "No Contact";
    }

    // Parameterized constructor (initializes all instance variables, meets Document 1-37 requirements)
    public Person(String name, int age, String contactInfo) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
    }

    // Getter and Setter methods (for all instance variables, meets Document 1-38 requirements)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Simple data validation: age must be a positive number
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be a positive number!");
        }
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Override toString(): facilitates printing object information (for subsequent debugging/demonstration)
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", contactInfo='" + contactInfo + "'}";
    }
}