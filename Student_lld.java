class Department {
    int departmentId;
    String departmentName;

    Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    void displayDepartment() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
    }
}

class Course {
    int courseId;
    String courseName;

    Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    void displayCourse() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
    }
}

class Student {
    int studentId;
    String studentName;
    Department department;
    Course course;

    Student(int studentId, String studentName,
            Department department, Course course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.course = course;
    }

    void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);

        department.displayDepartment();
        course.displayCourse();
    }
}

public class Student_lld {
    public static void main(String[] args) {

        Department dept = new Department(101, "AI & Data Science");

        Course course =
            new Course(201, "Machine Learning");

        Student student =
            new Student(
                1,
                "Sakunthala",
                dept,
                course
            );

        student.displayStudentDetails();
    }
}