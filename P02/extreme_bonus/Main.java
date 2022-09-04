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

        System.out.print("Seconds to tic? ");
        int secondsToTic = input.nextInt();
    
        Clock clock2 = clock1.add(secondsToTic);
        Clock clock3 = clock1.add(clock2);
        System.out.println(clock1);
        System.out.println(clock2);
        System.out.println(clock3);

        input.close();
    }
}