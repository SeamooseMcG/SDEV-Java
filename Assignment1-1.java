public class ConversionUtility {

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        // Feet to meters counting from 1 to 10
        System.out.println("Feet to Meters:");
        for (int foot = 1; foot <= 10; foot++) {
            double meter = footToMeter(foot);
            System.out.printf("%d ft = %.3f m%n", foot, meter);
        }

        System.out.println();

        // Meters to feet: starting at 20, counting by 5 up to 65
        System.out.println("Meters to Feet:");
        for (int meter = 20; meter <= 65; meter += 5) {
            double foot = meterToFoot(meter);
            System.out.printf("%d m = %.3f ft%n", meter, foot);
        }
    }
}