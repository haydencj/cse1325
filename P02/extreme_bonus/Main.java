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
        
        Clock clock1 = new Clock(hours, minutes, seconds);
        System.out.println("The time is " + clock1);
        
        System.out.println("Seconds to add?");
        int secondsToAdd = input.nextInt();
        Clock clock2 = clock1.add(secondsToAdd);
        System.out.println(clock2);

        System.out.println("Add to that...");
        System.out.print("Hours? ");
        int newHours = input.nextInt();
        System.out.print("Minutes? ");
        int newMinutes = input.nextInt();
        System.out.print("Seconds? ");
        int newSeconds = input.nextInt();

        Clock clockTest = new Clock(newHours, newMinutes, newSeconds);
        Clock clock3 = clock2.add(clockTest);
        
        System.out.println(clock2);
        System.out.println(clockTest);
        System.out.println("________ +");
        System.out.println(clock3);
        input.close();
    }
}