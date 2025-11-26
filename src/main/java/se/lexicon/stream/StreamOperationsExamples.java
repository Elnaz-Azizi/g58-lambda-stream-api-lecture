package se.lexicon.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamOperationsExamples {

    // Steps 2: Create a list to store employee data:
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

       // Step1:Sample Data- List of Integers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // filter this list to include only even numbers
      List<Integer> evenNumbers  = numbers.stream() // .stream() converts the collection into a stream- a pipeline for processing elements
              .filter(num -> num % 2 == 0)// Intermediate operation: filters out only even numbers
              //.filter(num -> num > 6)
              .toList(); // Terminal operation: collects the filtered results into a new list

        System.out.println("Even Numbers: " + evenNumbers);

        // distinct()
        // Remove duplicates
        List<Integer> distinctNumber = Arrays.asList(1,2,3,3,3,4,5,5).stream().distinct().toList();
        System.out.println("Distinct Numbers: " + distinctNumber);// output will be the unique numbers

       // forEach()
        numbers.forEach(System.out::println); //Prints each number to the console

        // findFirst()

        Optional<Integer> firstNumber = numbers.stream().findFirst();// findFirst() retrieves the first number in the list
        firstNumber.ifPresent(num -> System.out.println("First number is: " + num));

        // Count() returns total number of elements in the stream
        long count = numbers.stream().count();
        System.out.println("Total number of elements in the stream: " + count);

        // Step 2: Initialize sample employees data:

        employees.addAll(Arrays.asList(
                new Employee("Alice", "Engineering", 30, 60000),
                new Employee("Bob", "Engineering", 35, 70000),
                new Employee("Charlie", "HR", 28, 50000),
                new Employee("David", "HR", 40, 45000),
                new Employee("Eve", "Finance", 32, 65000),
                new Employee("Frank", "Finance", 25, 55000),
                new Employee("Grace", "Engineering", 45, 80000)
        ));

        // 1. Filter employees in the "Engineering" department earning more than 60k
          List<Employee> filtered = employees.stream()
                  .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 60000)
                 // .filter(e -> e.getSalary() > 60000)
                  .toList();
        // System.out.println(filtered);
        filtered.forEach(System.out::println);

        // 2. Get unique departments
        System.out.println("Unique departments: ");
        List<String> departments = employees.stream()
                .map(Employee :: getDepartment)
                .distinct()
                .toList();
        departments.forEach(System.out::println);

        // Calculate total salary expense

        System.out.println("Total salary expense");
        double totalSalaryExpenese = employees.stream()
                .mapToDouble(Employee::getSalary)// employee -> employee.getSalary()
                .sum();
        System.out.println(totalSalaryExpenese);


    }
}
