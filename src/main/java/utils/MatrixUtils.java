package utils;

import java.util.Arrays;

public class MatrixUtils {

    public static int[][] copyOf(int[][] matrix) {
        int[][] arr2 = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            arr2[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        return arr2;
    }
}
