public class Clock {
    //Constructor
    public Clock(int hours, int minutes, int seconds){
        //The field hours in the current object is equal to the parameter hours.
        //Keyword 'This' references the current object (Clock).
        this.hours = hours; 
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Method
    private String twoDigit(int i) {
        String res = (i<10) ? String.format("%02d", i) : String.valueOf(i); // 0 + "i" also works
        return res;
    }

    //toString
    @Override
    public String toString() {
        return twoDigit(hours) + ":" + twoDigit(minutes) + ":" + twoDigit(seconds);
    }

    //Fields
    private int hours;
    private int minutes;
    private int seconds;
}
