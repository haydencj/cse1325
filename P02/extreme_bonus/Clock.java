public class Clock {
    //Constructor
    public Clock(int hours, int minutes, int seconds){
        //The field hours in the current object is equal to the parameter hours.
        //Keyword 'This' references the current object (Clock).
        this.hours = hours; 
        this.minutes = minutes;
        this.seconds = seconds;
        rationalize();
    }

    //Methods
    public Clock add(int seconds) {
        Clock addClock = new Clock(this.hours, this.minutes, this.seconds + seconds);
        return addClock;
    }

    public Clock add(Clock clock) {
        Clock addClock = new Clock(this.hours+clock.hours, this.minutes+clock.minutes, 
                                   this.seconds + clock.seconds);
        return addClock;
    }

    private String twoDigit(int i) {
        return (i<10) ? String.format("%02d", i) : String.valueOf(i);
    }

    private void rationalize() {
        //rationalize seconds
        while(seconds<0) {
            seconds+=60;
            minutes--;
        }
        
        while(seconds>59) {
            seconds-=60;
            minutes++;
        }

        //rationalize minutes
        while(minutes<0) {
            minutes+=60;
            hours--;
        }
        while(minutes>59) {
            minutes-=60;
            hours++;
        }

        //rationalize hours
        while(hours<0) hours+=24;
        while(hours>23) hours-=24;
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
