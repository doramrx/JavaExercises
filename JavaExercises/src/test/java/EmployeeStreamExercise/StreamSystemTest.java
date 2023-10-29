package EmployeeStreamExercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamSystemTest {
    static StreamSystem streamSystem = new StreamSystem();
    static List<Employee> list;

    @BeforeAll
    static void setUp() {
        streamSystem.setupSystem();
        list = new ArrayList<>(5);
        list.add(new Employee("Maria", "maria@gmail.com", 3200.0));
        list.add(new Employee("Alex", "alex@gmail.com", 1900.0));
        list.add(new Employee("Marco", "marco@gmail.com", 1700.0));
        list.add(new Employee("Bob", "bob@gmail.com", 3500.0));
        list.add(new Employee("Anna", "anna@gmail.com", 2800.0));
    }

    @Test
    @DisplayName("Should calculate sum of salaries of employees whose names begin with the letter M.")
    void testSumOfSalaries(){
        double sum = streamSystem.sumOfSalaries(list);
        assertEquals(sum, 4900.0);
    }

    @Test
    @DisplayName("Should filter employee emails in natural order which employee salary is more than an entered salary.")
    void testFilterEmployeeEmail(){
        List<String> filterEmails = streamSystem.filterEmails(list, 2000.0);

        assertEquals(filterEmails.size(), 3);
        assertEquals(filterEmails.get(0), "anna@gmail.com");
        assertEquals(filterEmails.get(1), "bob@gmail.com");
        assertEquals(filterEmails.get(2), "maria@gmail.com");
    }

}
