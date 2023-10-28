package EmployeeStreamExercise;

import java.util.Scanner;

public class DataCollector {
    Scanner sc = new Scanner(System.in);
    public double salary;

    public void collectData() {
        System.out.print("Enter salary: ");
        this.salary = Double.parseDouble(this.sc.nextLine());
    }

    public double getSalary(){
        return this.salary;
    }
}
