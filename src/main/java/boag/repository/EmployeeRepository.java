package boag.repository;

import boag.enums.Gender;
import boag.models.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static List<Employee> employees = new ArrayList<>();


    static {
        employees.add(new Employee("Alex", 23, BigDecimal.valueOf(20_000.00), Gender.MALE));
        employees.add(new Employee("Ben", 63, BigDecimal.valueOf(25_000.00), Gender.MALE));
        employees.add(new Employee("Dave", 34, BigDecimal.valueOf(56_000.00), Gender.MALE));
        employees.add(new Employee("Jodi", 43, BigDecimal.valueOf(67_000.00), Gender.FEMALE));
        employees.add(new Employee("Juliet", 53, BigDecimal.valueOf(54_000), Gender.FEMALE));
        employees.add(new Employee("Janet", 23, BigDecimal.valueOf(120_000), Gender.FEMALE));
        employees.add(new Employee("Paul", 27, BigDecimal.valueOf(100_000), Gender.MALE));

    }

    public static List<Employee> getEmployees(){
        return employees;
    }
}
