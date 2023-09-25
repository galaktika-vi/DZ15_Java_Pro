import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер квадрата (от 1 до 10):");

        int size = scanner.nextInt();

        if (size < 1 || size > 10) {
            System.out.println("Недопустимый размер квадрата. Введите число от 1 до 10.");
            return;
        }

        Function<Integer, Integer> squareLambda = x -> x * x;

        IntStream.rangeClosed(1, size).forEach(x -> System.out.println("Square of " + x + " is " + squareLambda.apply(x)));
    }
}
