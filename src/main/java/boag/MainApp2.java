package boag;

import boag.enums.Gender;
import boag.enums.Religion;
import boag.models.Employee;
import boag.models.Person;
import boag.repository.EmployeeRepository;
import boag.repository.PersonRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class MainApp2 {

  private static List<Person> persons = PersonRepository.getPersons();
  private static List<Employee> employees = EmployeeRepository.getEmployees();

    public static void main(String[] args) {

        //Terminal Operations: count,  max, min



                 // count all Employees paid above 60,000


      long countOfEmployeesWithSalaryGreaterThan60K = employees.stream()
              .filter(employee -> employee.getSalary().compareTo(BigDecimal.valueOf(70_000.00)) > 0)
              .count();

      System.out.println("countOfEmployeesWithSalaryGreaterThan60K: "+ countOfEmployeesWithSalaryGreaterThan60K);


               // what  the Employee with max salary paid

      Employee employee = employees
              .stream()
              .max(Comparator.comparing(Employee::getSalary))
              .orElse(null);

      System.out.println("Employee with the highest salary is: "+ employee);


      // what is the min salary paid an employee

      Employee employeeWithTheMinimumSalary = employees.stream()
              .min(Comparator.comparing(Employee::getSalary))
              .orElse(null);


      System.out.println("employeeWithTheMinimumSalary: "+employeeWithTheMinimumSalary);

      // Collect to List

            // get all persons that have pvc and collect them to List
      List<Person> personsWithPVC = persons.stream()
              .distinct()
              .filter(person -> person.isHasPVC())
              .collect(toList());

      System.out.println();
      personsWithPVC.forEach(System.out::println);
      System.out.println();



      //get all Christians that have pvc and put them into a list

      List<Person> christiansWithPVC = persons.stream()
              .distinct()
              .filter(person -> Religion.CHRISTIANITY.equals(person.getReligion()) && person.isHasPVC())
              .collect(toCollection(LinkedList::new));


      System.out.println("Christians With PVC");
      christiansWithPVC.forEach(System.out::println);


      //Collect to Set

            //get all peoples religion
      LinkedHashSet<Religion> religions = persons.stream()
              .distinct()
              .map(person -> person.getReligion())
              .collect(toCollection(LinkedHashSet::new));


      // get all peoples states

      persons
              .stream()
              .distinct()
              .map(Person::getState)
              .collect(toCollection(LinkedHashSet::new))
              .forEach(System.out::println);


        //Collect to Map : collection.toMap, collections.groupBy(), collections.partionBy


        //Grouping By operations
           //state to Persons every one with PVC

      Map<String, List<Person>> stateToPersonsMap = persons
              .stream()
              .distinct()
              .collect(groupingBy(Person::getState));


      stateToPersonsMap
              .get("Lagos")
              .stream()
//              .filter(Person::isHasPVC)
              .forEach(System.out::println);


      //specify map implementation

      Map<String, Map<Gender, List<Person>>> mapOfGenderInStateThatHasPVC = persons
              .stream()
              .distinct()
              .filter(Person::isHasPVC)
              .collect(groupingBy(Person::getState, groupingBy(Person::getGender)));


      mapOfGenderInStateThatHasPVC
              .get("Lagos")
              .get(Gender.MALE)
              .forEach(System.out::println);


      Map<String, Map<Gender, List<Person>>> mapOfGenderInStateThatWithPVC = persons
              .stream()
              .distinct()
              .filter(Person::isHasPVC)
              .collect(groupingBy(Person::getState,LinkedHashMap::new,groupingBy(Person::getGender)));






    }
}
