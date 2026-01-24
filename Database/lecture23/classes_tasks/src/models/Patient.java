package models;
import java.util.Set;

public class Patient {
    private Long id;
    private String name;
    private Integer age;
    private Set<Doctor> doctors;

    public Patient(Long id, String name, Integer age, Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctors = doctors;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
    
    // getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Set<Doctor> getDoctors() {
        return doctors;
    }
}
