package models;

public class Phone {
    private Long id;
    private String phoneNumber;
    private Employee employee;

    public Phone(Long id, String phoneNumber, Employee employee) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.employee = employee;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Employee getEmployee() {
        return employee;
    }
}
