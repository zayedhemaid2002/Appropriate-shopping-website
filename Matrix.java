import java.util.Scanner;

public class Matrix {

    public static double add(double o1, double o2) {
        return o1 + o2;
    }

    public static double multiply(double o1, double o2) {
        return o1 * o2;
    }

    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of user: ");
        int user = input.nextInt();
        System.out.print("Enter number of product the user need to buy : ");
        int product = input.nextInt();
        System.out.print("Enter number of supermarket  : ");
        int shop = input.nextInt();

        double[][] matrix1 = new double[user][product];
        double[][] matrix2 = new double[product][shop];
        System.out.println("Enter products number : ");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = input.nextDouble();

            }

        }
        System.out.println("Enter cost for evrey supermarket  : ");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = input.nextDouble();

            }

        }
        double[][] result = multiplyMatrix(matrix1, matrix2);
        for (int i = 0; i < result.length; i++) {
            double min = Double.MAX_VALUE;
            int storeId = -1;
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] < min) {
                    min = result[i][j];
                    storeId = j + 1;
                }
            }
            System.out.println("For user P" + (i + 1) + " better price will be on store : S" + storeId);
        }

    }
}
