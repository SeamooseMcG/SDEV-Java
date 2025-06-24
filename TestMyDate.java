import java.util.Calendar;
import java.util.GregorianCalendar;

class MyDate {
    private int year;
    private int month;
    private int day;

    //Constructor for Current Date

    public MyDate() {
        Calendar calendar = new GregorianCalendar();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    //Constructor with elapsedTime

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    //Constructor with Specific Year, Month, and Day

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //Getters

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    //Set Date with elapsedTime

    private void setDate(long elapsedTime) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}

public class TestMyDate {
    public static void main(String[] args) {

        //Current Date

        MyDate date1 = new MyDate();
        System.out.println("Date 1 (Current Date):");
        System.out.println("Year: " + date1.getYear());
        System.out.println("Month: " + (date1.getMonth() + 1));
        System.out.println("Day: " + date1.getDay());

        //Elapsed Time

        long elapsedTime = 34355555133101L;
        MyDate date2 = new MyDate(elapsedTime);
        System.out.println("\nDate 2 (Elapsed time " + elapsedTime + "):");
        System.out.println("Year: " + date2.getYear());
        System.out.println("Month: " + (date2.getMonth() + 1));
        System.out.println("Day: " + date2.getDay());
    }
}