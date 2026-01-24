package models;
import java.util.Set;

public class Doctor {
    private Long id;
    private String name;
    private Double salary;
    private Set<Patient> patients;

    public Doctor(Long id, String name, Double salary, Set<Patient> patients) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.patients = patients;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getSalary() {
        return salary;
    }
    public Set<Patient> getPatients() {
        return patients;
    }
}
