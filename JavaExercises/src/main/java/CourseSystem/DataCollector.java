package CourseSystem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataCollector {
    Scanner sc = new Scanner(System.in);
    Set<Student> studentDataSet = new HashSet<>();

    public void collectData() {
        System.out.print("How many students for course A? ");
        readStudents(Integer.parseInt(this.sc.nextLine()));

        System.out.print("How many students for course B? ");
        readStudents(Integer.parseInt(this.sc.nextLine()));

        System.out.print("How many students for course C? ");
        readStudents(Integer.parseInt(this.sc.nextLine()));
    }

    public Set<Student> getStudentDataSet(){
        return this.studentDataSet;
    }

    private void readStudents(int quantity){
        for (int i = 0; i < quantity; i++) {
            int id = Integer.parseInt(this.sc.nextLine());
            studentDataSet.add(new StudentData(id));
        }
    }
}

class StudentData extends Student{
    public int id;
    public StudentData(int id) {
        super(id);
    }
}
