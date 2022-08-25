import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        String s = "";
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        j = scanner.nextInt();
        s = scanner.nextLine();
        System.out.println(s + " " + i + " " + j);
    }
}