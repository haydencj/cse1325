public class RandomExample {
    public static void main(String[] args) {
        int numberOfRandoms = (args.length > 0) ? Integer.parseInt(args[0]) : 24; //if ? then : else
        double sum = 0;
        double min = 1.0;
        double max = 0.0;

        for(int i=0; i<numberOfRandoms; ++i) {
            double random = Math.random();
            if(random < min) min = random;
            if(random > max) max = random;
            sum += random;
            System.out.println(random);
        }

        System.out.println("Statistics:"
                        + "\n\tPopulation: " + numberOfRandoms
                        + "\n\tMinimum: " + min
                        + "\n\tAverage: " + (sum/numberOfRandoms)
                        + "\n\tMaximum: " + max);
    }
}
