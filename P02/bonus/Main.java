import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hours? ");
        int hours = input.nextInt();
        System.out.print("Minutes? ");
        int minutes = input.nextInt();
        System.out.print("Seconds? ");
        int seconds = input.nextInt();
        input.close();
        
        Clock clock = new Clock(hours, minutes, seconds);
        System.out.println("The time is " + clock);
    }
}