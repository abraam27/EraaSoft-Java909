package models;
import java.util.Set;

public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private Set<Phone> phones;


    public Employee(Long id, String name, Integer age, Set<Phone> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phones = phones;
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
    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
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
    public Set<Phone> getPhones() {
        return phones;
    }
}
