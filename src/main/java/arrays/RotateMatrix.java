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
        int temp1, temp2;
        temp1 = matrix[0][0];
        matrix[0][0] = matrix[1][0];
        temp2 = matrix[0][1];
        matrix[0][1] = temp1;
        temp1 = matrix[1][1];
        matrix[1][1] = temp2;
        temp2 = matrix[1][0];
        matrix[1][0] = temp1;
    }
}
