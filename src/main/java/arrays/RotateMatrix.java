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
        Matrix theMatrix = new Matrix(matrix);
        for (int i = 0; i < matrix.length-1; i++) {
            theMatrix.rotateByOneCell();
        }
    }

    private static class Matrix {
        private final int[][] matrix;
        private final int N;

        Matrix(int[][] matrix) {
            this.matrix = matrix;
            this.N = matrix.length;
        }

        void rotateByOneCell() {
            int perimeter = getPerimeter();
            int first = get(0);
            for (int i = 0; i < perimeter - 1; i++) {
                set(i, get(i + 1));
            }
            set(perimeter - 1, first);
        }

        /**
         * Counter-clockwise index of perimeter cells.
         * For example for 2x2 matrix
         * 0,0 => index=0
         * 1,0 => index=1
         * 1,1 => index=2
         * 0,1 => index=3
         */
        private int get(int index) {
            int dim = N - 1;
            if (index < dim)
                return matrix[index][0];
            if (index < 2 * dim)
                return matrix[dim][index - dim];
            if (index < 3 * dim)
                return matrix[3 * dim - index][dim];
            return matrix[0][4 * dim - index];
        }

        private void set(int index, int value) {
            int dim = N - 1;
            if (index < dim) {
                matrix[index][0] = value;
            } else if (index < 2 * dim) {
                matrix[dim][index - dim] = value;
            } else if (index < 3 * dim) {
                matrix[3 * dim - index][dim] = value;
            } else {
                matrix[0][4 * dim - index] = value;
            }
        }

        private int getPerimeter() {
            return 4 * (matrix.length - 1);
        }
    }
}
