package EmployeeStreamExercise;

import EmployeeStreamExercise.DataCollector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class StreamSystem {

    private final List<Employee> employees = new ArrayList<>();

    public void setupSystem() {
        Locale.setDefault(Locale.US);
    }

    public void init(){
        this.setupSystem();

        Path filePath = Paths.get("JavaExercises","src","main","java","EmployeeStreamExercise").resolve("in.csv");
        this.addEmployeesToList(filePath);

        DataCollector dataCollector = new DataCollector();
        double salary = dataCollector.collectData();

        List<String> emails = this.filterEmails(this.employees, salary);

        System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
        emails.forEach(System.out::println);

        double sum = this.sumOfSalaries(this.employees);

        System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

    }

    protected List<String> filterEmails(List<Employee> employees, double salary){
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .map(Employee::getEmail)
                .sorted(this.sortEmail())
                .toList();
    }

    protected double sumOfSalaries(List<Employee> employees){
        return employees.stream()
                .filter(e -> e.getName().charAt(0) == 'M')
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    private Comparator<String> sortEmail(){
        return Comparator.comparing(String::toUpperCase);
    }

    private void addEmployeesToList(Path filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))){
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                double salary = Double.parseDouble(fields[2]);
                employees.add(new Employee(name, email, salary));

                line = br.readLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
