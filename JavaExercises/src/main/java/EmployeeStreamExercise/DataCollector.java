package EmployeeStreamExercise;

import java.util.Scanner;

public class DataCollector {
    Scanner sc = new Scanner(System.in);

    public double collectData() {
        System.out.print("Enter salary: ");
        return Double.parseDouble(this.sc.nextLine());
    }
}
