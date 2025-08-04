import java.util.Scanner;

public class TestTwoWayLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();

        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();

        for (int i = list.size() - 1; i >= 0; i--)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}