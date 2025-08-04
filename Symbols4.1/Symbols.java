import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Symbols {
    public static void main(String[] args) {
        // Check if a filename was provided
        if (args.length != 1) {
            System.out.println("Usage: java Exercise20_11 filename");
            System.exit(1);
        }

        // Read the file
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist.");
            System.exit(2);
        }

        // Stack for grouping symbols
        Stack<Character> stack = new Stack<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Unmatched closing symbol: " + ch);
                            System.exit(3);
                        }
                        char open = stack.pop();
                        if (!isMatchingPair(open, ch)) {
                            System.out.println("Mismatched symbols: " + open + " and " + ch);
                            System.exit(4);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
        }

        if (stack.isEmpty()) {
            System.out.println("Correct grouping pairs");
        } else {
            System.out.println("Unmatched opening symbol(s) remain: " + stack);
        }
    }

    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}