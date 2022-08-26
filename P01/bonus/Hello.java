import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Enter your name.");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();

        System.out.println("Hello, " + name);
    }
}