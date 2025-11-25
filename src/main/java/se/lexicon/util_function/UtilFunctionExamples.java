package se.lexicon.util_function;

import java.util.Random;
import java.util.function.*;

public class UtilFunctionExamples {
    public static void main(String[] args) {

        // Function<T, R>
        System.out.println("#### Function<T, R> Interface ####");

        // Function to calculate the length of a String

        Function <String, Integer> stringToLength = str -> str.length();

        // Function to convert fahrenheit to Celsius
        Function <Double, Double> fahrenheitToCelsius = f -> (f - 32) * 5 / 9;

        System.out.println("Length of the string is: " + stringToLength.apply("Java")); // Output: 4
        System.out.println("Celsius temperature is: " + fahrenheitToCelsius.apply(100.0)); // 37.77

        UnaryOperator<Double> fahrenheitToCelsius2 = f -> (f - 32) * 5 / 9;
        System.out.println(fahrenheitToCelsius2.apply(100.0));

        // Predicate<T>
        System.out.println("#### Predicate<T> Interface ####");

        //predicate to check if a number is even
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Predicate check if the string starts with A
        Predicate<String> startWithA = str -> str.startsWith("A");

        //Predicate to validate if a number > 100
        Predicate<Integer> isGreaterThan100= num -> num > 100;

        System.out.println("Is 10 even? " + isEven.test(10));

        System.out.println("Does 'Apple' starts with A? " + startWithA.test("Apple"));
        System.out.println("Does 'Banana' starts with A? " + startWithA.test("Banana"));

        System.out.println("Is 75 greater than 100? " + isGreaterThan100.test(75));

        //Consumer<T>
        System.out.println("#### Consumer<T> Interface ####");
      //Print a string in uppercase
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        // consumer to append a greeting
        Consumer<String> greet = name -> System.out.println("Hello " + name + "!");

        printUpperCase.accept("java programming");
        greet.accept("Alice");

        // Supplier<T>
        System.out.println("#### Supplier<T> Interface ####");
        //Supplier to generate random number
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
        System.out.println("Random number is: " + randomNumberSupplier.get());

        // UnaryOperator<T>
        UnaryOperator<Integer> square = num -> num * num;

        UnaryOperator<String> reverse = str -> new StringBuilder(str).reverse().toString();

        System.out.println("Square of 5: " + square.apply(5));
        System.out.println("Reverse 'java': " + reverse.apply("java"));
    }
}
