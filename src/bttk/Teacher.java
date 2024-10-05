package bttk;
import java.util.*;

class Teacher extends Person {
    String department;
    String teachingSubject;
    public Teacher(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }
    @Override
    public void addPerson() {
    
    }
    @Override
    public void updatePerson(String id) {
    }
    @Override
    public void displayInfo() {
        System.out.println("TeacherID: " + id + ", Name: " + fullName + ", Department: " + department + ", TeachingSubject: " + teachingSubject);
        if (isBookOverdue()) {
            System.out.println("Book Status:Overdue");
        } else {
            System.out.println("Book Status:No overdue");
        }
    }
    
}
