package se.lexicon.functional_lambda;

import java.util.ArrayList;
import java.util.List;

public abstract class LambdaDemo {
    // Functional interface implementation using lambda expression as fields:
    static DoStringStuff concatenate = (s1, s2) -> s1.concat(" ").concat(s2);
    static DoStringStuff getBiggestString = (str1,str2) -> str1.length() >= str2.length() ? str1 : str2;
    static DoubleOperator addition = (firstNumber, secondNumber) -> firstNumber + secondNumber;
    static DoubleOperator subtraction = (firstNumber, secondNumber) -> firstNumber - secondNumber;

    // Define a static method duStringStuff to pass a logic as a method parameter
    public static String duStringStuff (String s1, String s2, DoStringStuff stringStuff) {
        return stringStuff.operate(s1, s2);
    }

    public static Double calcOperator(Double a, Double b, DoubleOperator operator){
        return operator.apply(a,b);
    }



    public static void main(String[] args) {
        //Conncatenate two Strings
        //DoStringStuff concatenate = (s1, s2) -> s1.concat(" ").concat(s2);

        //Find the longer of two Strings
        /* DoStringStuff getBiggestString = (str1, str2) -> {
             if (str1.length() >= str2.length()){
                 return str1;
             } else {
                 return str2;
             }
         };*/
        // Simplified version
        //DoStringStuff getBiggestString = (str1,str2) -> str1.length() >= str2.length() ? str1 : str2;

        System.out.println(concatenate.operate("Mehrdad","Javan")); // OutPut: Mehrdad Javan

        System.out.println("The biggest string is: " + getBiggestString.operate("ABC", "ABCDEFG")); // OutPut: ABCDEFG

        System.out.println("----------------------------------------");
        // Method takes functional interface as parameter
        System.out.println(duStringStuff("Mehrdad", "Javan", concatenate));
        System.out.println(duStringStuff("ABC", "ABCDEFG", getBiggestString));

        System.out.println("-----------------------------------------");

        System.out.println(calcOperator(12.0, 25.9, addition));
        System.out.println(calcOperator(12.0, 25.9, subtraction));


        // simulate list of tasks
        List<Todo> inMemoryStorage = new ArrayList<>();
        inMemoryStorage.add(new Todo("Buy groceries", false, 1));
        inMemoryStorage.add(new Todo("Finish assignment", true, 1));
        inMemoryStorage.add(new Todo("Call mom", false, 3));
        inMemoryStorage.add(new Todo("Go to the gym", true, 2));
        inMemoryStorage.add(new Todo("Read a book", false, 1));

        // find completed tasks
        TaskFilter completedFilter = task -> task.isCompleted();
        List<Todo> completedTasks = findTasks(inMemoryStorage, completedFilter);
        System.out.println("Completed tasks:" + completedTasks);

        // Find incompleted tasks
        TaskFilter incompletedFilter = task -> !task.isCompleted();
        List<Todo> incompletedTasks = findTasks(inMemoryStorage, incompletedFilter);
        System.out.println("Incompleted tasks:" + incompletedTasks);

        // High priority tasks
        TaskFilter highPriorityFilter = task -> task.getPriority()== 1;
        List<Todo> highPriorityTasks = findTasks(inMemoryStorage, highPriorityFilter);
        System.out.println("High priority tasks:" + highPriorityTasks);

        // High priority and incompleted tasks
        TaskFilter highIncompletedFilter= task -> !task.isCompleted() && task.getPriority()==1;
        List<Todo> highPriorityIncompletedTasks= findTasks(inMemoryStorage, highIncompletedFilter);
        System.out.println("High priority and incompleted tasks:" + highPriorityIncompletedTasks);

    }

    public static List<Todo> findTasks (List<Todo> todoList, TaskFilter filter){
        List<Todo> result = new ArrayList<>();
        for (Todo task : todoList){
            if (filter.matches(task)){
                result.add(task); // add matching task to result list
            }
        }
        return result;
    }



}
