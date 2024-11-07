/*
    You are given an m x n integer matrix matrix with the following two properties:
    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.
    You must write a solution in O(log(m * n)) time complexity.

    Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true

    Example 2:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -104 <= matrix[i][j], target <= 104
 */

import java.util.Arrays;

public class search2DMatrix_74 {
    // Method to return boolean based on existence target value
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
            This problem is quite similar to the binary search problem. The only difference
            is that we will now be performing binary searches on rows of the matrix in order to find the
            target value. We will loop through the rows of the matrix and perform binary searches on each one.
            If the target is found we will return true, if we exit the loop then we know the target is not in the
            matrix and we can return false. The time complexity of this is O(log m*n) and space complexity is O(1).
         */
        // Loop through rows of the matrix
        for (int i=0; i<matrix.length; i++) {
            int l = 0;
            int r = matrix[i].length-1;
            // Perform binary search on row
            while (l<=r) {
                int mid = l + (r-l) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        // If we exit then the target does not exist and we can return false
        return false;
    }
    // Main method to run program
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
