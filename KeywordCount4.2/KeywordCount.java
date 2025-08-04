import java.io.File;
import java.io.IOException;
import java.util.*;

public class KeywordCount {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise21_03 SourceFile.java");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist.");
            System.exit(2);
        }

        System.out.println("The program is");
        Scanner displayScanner = new Scanner(file);
        while (displayScanner.hasNextLine()) {
            System.out.println(displayScanner.nextLine());
        }

        System.out.println("The number of keywords in the program is " + countKeywords(file));
    }

    public static int countKeywords(File file) throws IOException {
        String[] keywordArray = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new",
            "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while", "true", "false", "null"
        };

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordArray));
        int count = 0;

        Scanner input = new Scanner(file);
        boolean inBlockComment = false;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            // Remove string literals
            line = line.replaceAll("\"(\\\\.|[^\"\\\\])*\"", "");  // Regex for string literals

            // Remove single-line comments
            int lineCommentIndex = line.indexOf("//");
            if (lineCommentIndex != -1) {
                line = line.substring(0, lineCommentIndex);
            }

            // Handle block comments
            while (true) {
                if (inBlockComment) {
                    int endIndex = line.indexOf("*/");
                    if (endIndex != -1) {
                        line = line.substring(endIndex + 2);
                        inBlockComment = false;
                    } else {
                        line = "";  // Entire line is inside block comment
                        break;
                    }
                }

                int startIndex = line.indexOf("/*");
                if (startIndex != -1) {
                    int endIndex = line.indexOf("*/", startIndex + 2);
                    if (endIndex != -1) {
                        line = line.substring(0, startIndex) + line.substring(endIndex + 2);
                    } else {
                        line = line.substring(0, startIndex);
                        inBlockComment = true;
                    }
                } else {
                    break;
                }
            }

            // Tokenize remaining line and count keywords
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
        }

        return count;
    }
}