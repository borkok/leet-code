package arrays;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees
 (clockwise).

You have to rotate the image in-place, which means you have to modify the
input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Constraints:

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }
        Matrix theMatrix = new Matrix(matrix);

        int perimeter = theMatrix.getPerimeter(matrix);
        int first = theMatrix.get(0);
        for (int i = 0; i < perimeter-1; i++) {
            theMatrix.set(i, theMatrix.get(i+1));
        }
        theMatrix.set(perimeter-1, first);
    }

    private static class Matrix {
        private final int[][] matrix;

        Matrix(int[][] matrix) {
            this.matrix = matrix;
        }

        /**
         * Counter-clockwise index of perimeter cells.
         * For example for 2x2 matrix
         * 0,0 => index=0
         * 1,0 => index=1
         * 1,1 => index=2
         * 0,1 => index=3
         */

        int get(int index) {
            switch (index) {
                case 0:
                    return matrix[0][0];
                case 1:
                    return matrix[1][0];
                case 2:
                    return matrix[1][1];
                case 3:
                    return matrix[0][1];
                default:
                    return 99999;
            }
        }

        void set(int index, int value) {
            switch (index) {
                case 0:
                    matrix[0][0] = value; return;
                case 1:
                    matrix[1][0] = value; return;
                case 2:
                    matrix[1][1] = value; return;
                case 3:
                    matrix[0][1] = value; return;
                default:
                    return;
            }
        }

        private int getPerimeter(int[][] matrix) {
            return 4 * (matrix.length - 1);
        }
    }
}
