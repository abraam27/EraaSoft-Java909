import models.Doctor;
import models.Patient;
import models.Language;
import models.Teacher;
import models.Employee;
import models.Phone;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("TASK 2: Doctor and Patient Relationship (Many-to-Many)");
        System.out.println("=".repeat(80));
        
        //Task2: Create a class that represents a doctor and a patient and their relationship
        Doctor doctor = new Doctor(1L, "Dr. Abraam", 100000.0, new HashSet<>());
        Patient patient1 = new Patient(1L, "Patient John", 25, new HashSet<>());
        Patient patient2 = new Patient(2L, "Patient Sarah", 30, new HashSet<>());
        
        doctor.getPatients().add(patient1);
        doctor.getPatients().add(patient2);
        patient1.getDoctors().add(doctor);
        patient2.getDoctors().add(doctor);
        
        System.out.println("\nDoctor Information:");
        System.out.println("  ID: " + doctor.getId());
        System.out.println("  Name: " + doctor.getName());
        System.out.println("  Salary: $" + doctor.getSalary());
        System.out.println("  Patients: " + doctor.getPatients().size());
        for (Patient p : doctor.getPatients()) {
            System.out.println("    - " + p.getName() + " (ID: " + p.getId() + ", Age: " + p.getAge() + ")");
        }
        
        System.out.println("\nPatient Information:");
        for (Patient p : doctor.getPatients()) {
            System.out.println("  Patient: " + p.getName() + " (ID: " + p.getId() + ", Age: " + p.getAge() + ")");
            System.out.println("    Doctors: " + p.getDoctors().size());
            for (Doctor d : p.getDoctors()) {
                System.out.println("      - " + d.getName() + " (ID: " + d.getId() + ", Salary: $" + d.getSalary() + ")");
            }
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("TASK 3: Teacher and Language Relationship (Many-to-One / One-to-Many)");
        System.out.println("=".repeat(80));
        
        //Task3: Create a class that represents a teacher and a language and their relationship
        Language language = new Language(1L, "English", new HashSet<>());
        Teacher teacher1 = new Teacher(1L, "Teacher Ahmed", 100000.0, language);
        Teacher teacher2 = new Teacher(2L, "Teacher Ali", 90000.0, language);
        Teacher teacher3 = new Teacher(3L, "Teacher Mena", 95000.0, language);
        
        language.getTeachers().add(teacher1);
        language.getTeachers().add(teacher2);
        language.getTeachers().add(teacher3);
        
        System.out.println("\nLanguage Information:");
        System.out.println("  ID: " + language.getId());
        System.out.println("  Name: " + language.getName());
        System.out.println("  Teachers: " + language.getTeachers().size());
        for (Teacher t : language.getTeachers()) {
            System.out.println("    - " + t.getName() + " (ID: " + t.getId() + ", Salary: $" + t.getSalary() + ")");
        }
        
        System.out.println("\nTeachers Information:");
        for (Teacher t : language.getTeachers()) {
            System.out.println("  Teacher: " + t.getName() + " (ID: " + t.getId() + ", Salary: $" + t.getSalary() + ")");
            System.out.println("    Language: " + t.getLanguage().getName() + " (ID: " + t.getLanguage().getId() + ")");
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("TASK 4: Employee and Phone Relationship (One-to-Many / Many-to-One)");
        System.out.println("=".repeat(80));
        
        //Task4: Create a class that represents an employee and a phone and their relationship
        Employee employee = new Employee(1L, "Employee Peter", 28, new HashSet<>());
        Phone phone1 = new Phone(1L, "01010101010", employee);
        Phone phone2 = new Phone(2L, "01111111111", employee);
        Phone phone3 = new Phone(3L, "01222222222", employee);
        
        employee.getPhones().add(phone1);
        employee.getPhones().add(phone2);
        employee.getPhones().add(phone3);
        
        System.out.println("\nEmployee Information:");
        System.out.println("  ID: " + employee.getId());
        System.out.println("  Name: " + employee.getName());
        System.out.println("  Age: " + employee.getAge());
        System.out.println("  Phones: " + employee.getPhones().size());
        for (Phone p : employee.getPhones()) {
            System.out.println("    - " + p.getPhoneNumber() + " (ID: " + p.getId() + ")");
        }
        
        System.out.println("\nPhones Information:");
        for (Phone p : employee.getPhones()) {
            System.out.println("  Phone: " + p.getPhoneNumber() + " (ID: " + p.getId() + ")");
            System.out.println("    Employee: " + p.getEmployee().getName() + " (ID: " + p.getEmployee().getId() + ", Age: " + p.getEmployee().getAge() + ")");
        }
    }
}
