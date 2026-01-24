package models;
import java.util.Set;

public class Language {
    private Long id;
    private String name;
    private Set<Teacher> teachers;

    public Language(Long id, String name, Set<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<Teacher> getTeachers() {
        return teachers;
    }
}