package SystemRegestration;

public class Operation {
    String oper;
    int studentID;
    int courseID;

    public Operation(String op, int studentID, int courseID) {
        this.oper = op;
        this.studentID = studentID;
        this.courseID = courseID;
    }
}
