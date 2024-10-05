
package bttk;
import java.text.*;
import java.util.*;
public class Processor {
    final static PersonList psL = new PersonList();
    final static Scanner keyboard = new Scanner(System.in);
    final static SimpleDateFormat dF = new SimpleDateFormat("dd/mm/yyyy");
    public static void main(String[] args) throws ParseException {
        while (true) {
            System.out.println("1.add new student");
            System.out.println("2.add new teacher");
            System.out.println("3.update person by Id");
            System.out.println("4.delete person by Id");
            System.out.println("5.display all students and teachers");
            System.out.println("6.find student with highest Gpa");
            System.out.println("7.find teachers by department");
            System.out.println("8.check book borrowing status");
            System.out.println("9.exit");
            int c = keyboard.nextInt();
            keyboard.nextLine(); 
            switch (c) {
                case 1:
                    System.out.println("StudentID:");
                    String studentId = keyboard.nextLine();
                    System.out.println("StudentName:");
                    String studentName = keyboard.nextLine();
                    System.out.println("DateOfBirth:");
                    String dob = keyboard.nextLine();
                    Date dateOfBirth = dF.parse(dob);
                    System.out.println("GPA:");
                    float gpa = keyboard.nextFloat();
                    keyboard.nextLine(); 
                    System.out.println("Major:");
                    String major = keyboard.nextLine();
                    Date borrowDate = new Date();
                    Date returnDate = new Date(borrowDate.getTime() + (31L * 24 * 60 * 60 * 1000));
                    Student student = new Student(studentId, studentName, new Date(), borrowDate, returnDate, gpa, major);
                    psL.addStudent(student);
                    break;
                case 2:
                    System.out.println("TeacherID:");
                    String teacherId = keyboard.nextLine();
                    System.out.println("TeacherName:");
                    String teacherName = keyboard.nextLine();
                    System.out.println("Department:");
                    String department = keyboard.nextLine();
                    System.out.println("TeachingSubject:");
                    String subject = keyboard.nextLine();
                    Teacher teacher = new Teacher(teacherId, teacherName, new Date(), new Date(), new Date(), department, subject);
                    psL.addTeacher(teacher);
                    break;
                case 3:
                    psL.updatePersonById();
                    break;
                case 4:
                    System.out.println("PersonID to delete:");
                    String idToDelete = keyboard.nextLine();
                    psL.deletePersonById(idToDelete);
                    break;
                case 5:
                    psL.displayEveryone();
                    break;
                case 6:
                    Student topStudent = psL.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Sinh vien co diem GPA cao nhat:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("khong co sinh vien nao duoc tim thay!!!");
                    }
                    break;
                case 7:
                    System.out.println("Department:");
                    String dep = keyboard.nextLine();
                    Teacher teacherByDep = psL.findTeacherByDepartment(dep);
                    if (teacherByDep != null) {
                        teacherByDep.displayInfo();
                    } else {
                        System.out.println("No teacher found in department: " + dep);
                    }
                    break;
                case 8:
                    psL.checkBookBorrowing();
                    break;
                case 9:
                    System.out.println("Thoat!");
                    keyboard.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}
