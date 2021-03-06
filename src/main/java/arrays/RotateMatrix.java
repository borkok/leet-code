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
        int length = matrix.length;
        while (length > 1) {
            Matrix theMatrix = new Matrix(matrix, length);
            theMatrix.rotateOuterLayer();
            length = length - 2;
        }
    }

    private static class Matrix {
        private final int[][] matrix;
        private final int N;
        private final RowCol topLeft;
        private final int perimeter;

        Matrix(int[][] matrix, int length) {
            this.matrix = matrix;
            this.N = length;
            this.perimeter = 4 * (N - 1);

            int diff = (matrix.length - N) / 2;
            topLeft = new RowCol(diff, diff);
        }

        void rotateOuterLayer() {
            for (int i = 0; i < N-1; i++) {
                rotateByOneCell();
            }
        }

        private void rotateByOneCell() {
            int first = matrix[topLeft.row][topLeft.col];
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
            RowCol coords = convertTo2D(index);
            return matrix[coords.row][coords.col];
        }

        private void set(int index, int value) {
            RowCol coords = convertTo2D(index);
            matrix[coords.row][coords.col] = value;
        }

        private RowCol convertTo2D(int index) {
            return convertTo2DAbsolute(index).alignToTopLeft(topLeft);
        }

        private RowCol convertTo2DAbsolute(int index) {
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

        RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        RowCol alignToTopLeft(RowCol topLeft) {
            this.row = topLeft.row + row;
            this.col = topLeft.col + col;
            return this;
        }
    }
}
