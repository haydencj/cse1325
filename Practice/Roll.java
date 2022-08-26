import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        String nl = System.lineSeparator();
        
        if(args.length != 2) {
            System.err.println("usage: java Roll #dice #sides");
            System.exit(-2);
        }
        
        int numDice = Integer.parseInt(args[0]);
        int numSides = Integer.parseInt(args[1]);
        
        int dice[] = new int[numDice];

        for(int i=0; i<numDice; ++i)
            dice[i] = 1 + (int) (numSides * Math.random()); //typecasting a double to an int
        

        Arrays.sort(dice);

        int sum=0;
        for(int d : dice) { //for-each loop. used to loop through elements in an array
            sum += d;
            System.out.print(" " + d);
        }

        System.out.println(nl + " Sum = " + sum);
        System.out.println(" Average = " + ((double) sum / (double) numDice));
    }
}
