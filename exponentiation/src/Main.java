import java.util.Scanner;
import java.util.function.Function;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Выберите операцию:");
            System.out.println("1 - Возведение в квадрат");
            System.out.println("2 - Возведение в куб");
            System.out.println("3 - Квадратный корень");
            System.out.println("4 - Обратное число");
            System.out.println("5 - Площадь треугольника по формуле Герона");
            System.out.println("0 - Выйти из программы");

            choice = scanner.nextInt();

            DoubleFunction<Double> square = x -> Math.pow(x, 2);
            DoubleFunction<Double> cube = x -> Math.pow(x, 3);
            DoubleFunction<Double> squareRoot = x -> Math.sqrt(x);
            DoubleFunction<Double> inverse = x -> 1 / x;

            Function<Triple, Double> heronsFormula = sides -> {
                double s = (sides.a + sides.b + sides.c) / 2.0;
                return Math.sqrt(s * (s - sides.a) * (s - sides.b) * (s - sides.c));
            };

            switch (choice) {
                case 1:
                    System.out.println("Введите число для возведения в квадрат:");
                    double num1 = scanner.nextDouble();
                    System.out.println("Квадрат числа " + num1 + " равен " + square.apply(num1));
                    break;
                case 2:
                    System.out.println("Введите число для возведения в куб:");
                    double num2 = scanner.nextDouble();
                    System.out.println("Куб числа " + num2 + " равен " + cube.apply(num2));
                    break;
                case 3:
                    System.out.println("Введите число для вычисления квадратного корня:");
                    double num3 = scanner.nextDouble();
                    System.out.println("Квадратный корень числа " + num3 + " равен " + squareRoot.apply(num3));
                    break;
                case 4:
                    System.out.println("Введите число для вычисления обратного значения:");
                    double num4 = scanner.nextDouble();
                    System.out.println("Обратное число " + num4 + " равно " + inverse.apply(num4));
                    break;
                case 5:
                    System.out.println("Введите стороны треугольника a, b и c:");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    double c = scanner.nextDouble();
                    Triple triangleSides = new Triple(a, b, c);
                    System.out.println("Площадь треугольника равна " + heronsFormula.apply(triangleSides));
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        } while (choice != 0);
    }

    public static class Triple {
        public final double a, b, c;

        public Triple(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
