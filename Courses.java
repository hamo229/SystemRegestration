package SystemRegestration;

public class Courses {
     int Id;
    LinkedList studentsOfcourse;



    public Courses(int courseId) {
        this.Id = courseId;
        studentsOfcourse = new LinkedList();
    }

    public void addStudent(Student student) {
        studentsOfcourse.add(student);
    }
    public boolean isFull() {
        return studentsOfcourse.getSize() >= 20 && studentsOfcourse.getSize() <= 30;
    }

    
}
