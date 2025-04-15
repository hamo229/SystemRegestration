package SystemRegestration;

public class SystemRegestration {

    LinkedList allStudents;
    LinkedList allCourses;
    Stack RedoStack;
    Stack UndoStack;
    Student lastStudentID;
    Courses lastCourseID;

    public SystemRegestration() {
        allStudents = new LinkedList();
        allCourses = new LinkedList();
        RedoStack = new Stack();
        UndoStack = new Stack();
        lastStudentID = null;
        lastCourseID = null;
    }

    public boolean searchStudent(int id) {
        return allStudents.search(id);

    }

    public boolean searchCourse(int id) {
        return allCourses.search(id);
    }

    public void addStudent(int id) {
        if (allStudents.search(id)) {
            System.out.println("Student already exists");
        } else {

            allStudents.add(id);
            Student student = new Student(id);
            lastStudentID = student;
            System.out.println("Student added successfully");
            UndoStack.push(id);
            RedoStack.push(id);
        }
    }

    public void addCourse(int id) {
        if (allCourses.search(id)) {
            System.out.println("Course already exists");
        } else {
            Courses course = new Courses(id);
            allCourses.add(id);
            lastCourseID = course;
            System.out.println("Course added successfully");
        }
    }

    public void removeStudent(int StudentId) {
        if (allStudents.getObject(StudentId) != null) {
            allStudents.remove(StudentId);
            System.out.println("removed successfully!");
        } else
            System.out.println("Student not found");
    }
    
    public void removeCourse(int courseId) {
        if (allCourses.getObject(courseId) != null) {
            allCourses.remove(courseId);
            System.out.println("removed successfully!");
        } else
            System.out.println("Course not found");
    }

    public int getLastStudentID() {
        if (lastStudentID != null) {
            return lastStudentID.StudentId;
        } else {
            System.out.println("No last student ID found");
            return -1; 
        }
    }
    public int getLastCourseID() {
        if (lastCourseID != null) {
            return lastCourseID.Id;
        } else {
            System.out.println("No last course ID found");
            return -1; 
        }
    }

    public void enrollStudent(int studentID, int courseID) {
        if (searchStudent(studentID) && searchCourse(courseID)) {
            Student student = (Student) allStudents.getObject(studentID);
            Courses course = (Courses) allCourses.getObject(courseID);
            if (course.studentsOfcourse.search(studentID)) {
                System.out.println("Student already enroled course");

            } else if (course.studentsOfcourse.getSize() >= 30) {
                System.out.println("course is full!");

            } else if (student.coursesOfStudent.getSize() >= 7) {
                System.out.println("yoy enroled 7 courses!!! ");
            } else {
                course.studentsOfcourse.add(student);
                student.coursesOfStudent.add(course);
                UndoStack.push(new Operation("enroll", studentID, courseID));
                System.out.println("enroled Successfully!");
            }
        } else {
            System.out.println("student or course not added!!");
        }
    }

    public void removeEnrollmen(int studentID, int courseID) {
        if (searchStudent(studentID) && searchCourse(courseID)) {
            Student student = (Student) allStudents.getObject(studentID);
            Courses course = (Courses) allCourses.getObject(courseID);
            if (course.studentsOfcourse.search(studentID)) {
                student.coursesOfStudent.remove(course);
                course.studentsOfcourse.remove(student);
                System.out.println("removed successfully!");
                UndoStack.push(new Operation("remove", studentID, courseID));
            } else {
                System.out.println("Student not enrolled this course!!");
            }
        } else {
            System.out.println("student or course not added!!");
        }
    }
}
