package SystemRegestration;

public class Student  {

     int StudentId;
    LinkedList coursesOfStudent;
    
    public Student(int StudentId) {
        this.StudentId = StudentId;
        coursesOfStudent = new LinkedList();
    }

    public void addCourse(Courses course) {
        coursesOfStudent.add(course);
    }

    public boolean isNormal() {
        return coursesOfStudent.getSize() >= 2 &&coursesOfStudent.getSize() <= 7;
    }
}
