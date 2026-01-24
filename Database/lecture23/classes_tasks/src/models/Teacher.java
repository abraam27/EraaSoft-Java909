package models;
    
public class Teacher {
    private Long id;
    private String name;
    private Double salary;
    private Language language;

    public Teacher(Long id, String name, Double salary, Language language) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.language = language;
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
    public void setLanguage(Language language) {
        this.language = language;
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
    public Language getLanguage() {
        return language;
    }
}
