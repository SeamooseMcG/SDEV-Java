import java.util.Scanner;

public class MatrixEqualityTest {

    public static void main(String[] args) {
        int[][] m1;
        int[][] m2;
        try (Scanner input = new Scanner(System.in)) {
            m1 = new int[3][3];
            m2 = new int[3][3];
            System.out.println("Enter matrix 1 (3x3):");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m1[i][j] = input.nextInt();
                }
            }   System.out.println("Enter matrix 2 (3x3):");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m2[i][j] = input.nextInt();
                }
            }
        }
        
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical.");
        } else {
            System.out.println("The two arrays are not identical.");
        }
    }
    
    
    public static boolean equals(int[][] m1, int[][] m2) {
    
        if (m1.length != m2.length) {
            return false;
        }
        
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}