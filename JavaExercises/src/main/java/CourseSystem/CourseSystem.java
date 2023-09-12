package CourseSystem;

import java.util.Set;

public class CourseSystem {
    public void init() {
        DataCollector dataCollector = new DataCollector();
        dataCollector.collectData();

        Set<Student> students = dataCollector.getStudentDataSet();
        System.out.println("Total of students: " + students.size());
    }
}
