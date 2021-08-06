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
        Matrix theMatrix = new Matrix(matrix, matrix.length);
        for (int i = 0; i < matrix.length-1; i++) {
            theMatrix.rotateByOneCell();
        }
    }

    /*
    * NOW - ADD RECURRENCE
    * from outer to most inner layer
    * without copying matrix
    * instead of 0,0 -> 4,4 => 1,1 -> 3,3
    * */
    private static class Matrix {
        private final int[][] matrix;
        private final int N;

        Matrix(int[][] matrix, int length) {
            this.matrix = matrix;
            this.N = length;
        }

        void rotateByOneCell() {
            int perimeter = getPerimeter();
            int first = get(0);
            for (int i = 0; i < perimeter - 1; i++) {
                set(i, get(i + 1));
            }
            set(perimeter - 1, first);
        }

        private int getPerimeter() {
            return 4 * (matrix.length - 1);
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
            RowCol coords = convert(index);
            return matrix[coords.row][coords.col];
        }

        private void set(int index, int value) {
            RowCol coords = convert(index);
            matrix[coords.row][coords.col] = value;
        }

        private RowCol convert(int index) {
            int dim = N - 1;
            if (index < dim)                return new RowCol(index, 0);
            if (index < 2 * dim)            return new RowCol(dim, index - dim);
            if (index < 3 * dim)            return new RowCol(3 * dim - index, dim);
            return new RowCol(0, 4 * dim - index);
        }
    }

    private static class RowCol {
        int row;
        int col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
