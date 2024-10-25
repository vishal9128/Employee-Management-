package Beans;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private int id;

    @Column(name = "full_name")
    private String fullName;

//    @Column(name = "last_name")
//    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private int salary;

    @Column(name = "department")
    private String department;

    @Column(name = "Job_Position")
    private String jobPosition; // Corrected capitalization for consistency

    @Column(name = "location")
    private String location;

    public Employee() {}

    public Employee(int id, String fullName, String email, int salary, String department, String jobPosition, String location) {
        this.id = id;
        this.fullName = fullName;
//        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.jobPosition = jobPosition;
        this.location = location;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

//    public String getLastName() {
//        return lastName;
//    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setJobPosition(String jobPosition) { // Corrected method name
        this.jobPosition = jobPosition;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
