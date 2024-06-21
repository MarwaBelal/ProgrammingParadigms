package org.example;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void register(String name, Consumer<String> callback) {
        callback.accept(name + "@domain.com");
    }

    public static void sendWelcomeMail(String mail) {
        System.out.println("MAILING " + mail);
    }

    public static Function<Integer, Integer> multiplyBy(int x) {
        return y -> x * y;
    }

    public static void main(String[] args) {
        // Assigning functions to variables
        BinaryOperator<Integer> add = Integer::sum;
        System.out.println("Result of sum: " + add.apply(3, 4));

        // Functions as arguments
        register("Marwa.Belal", Main::sendWelcomeMail);

        // Function as a return type
        Function<Integer, Integer> doubleNumber = multiplyBy(2);
        Function<Integer, Integer> tripleNumber = multiplyBy(3);
        System.out.println("Double Number: " + doubleNumber.apply(4));
        System.out.println("Triple Number: " + tripleNumber.apply(4));
        System.out.println("Multiply Two Numbers: " + multiplyBy(5).apply(6));

        // Currying
        Function<Integer, Function<Integer, Integer>> multiply = a -> b -> a * b;
        System.out.println("Result of curried multiply: " + multiply.apply(5).apply(6));
    }
}