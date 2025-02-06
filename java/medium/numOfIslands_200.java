/*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:
        Input: grid = [
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
        ]
        Output: 1

    Example 2:
        Input: grid = [
          ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
        ]
        Output: 3

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 300
        grid[i][j] is '0' or '1'.
 */

/*
    *******************************MY INITIAL THOUGHT PROCESS/APPROACH:*********************************************
    I think what we can do is have a global counter for the number of islands. We can loop through the whole grid,
    and at each position we will check the surrounding area to see if it is an island. Whenever we have a case where
    '1' is surrounded by all '0's, then we know it is an island and we will increment the result counter. we will skip
    over all '0's in the grid as we know that they are water.

    - ***concern with this approach*** what about when we are on the edges of the grid? the check may go out of bounds?
        - well, we are allowed to assume that all 4 edges are surrounded by water. so based on this, can we implement some sort
        of check to circumvent this? if the index we are trying to access is out of bounds, we assume it is water aka disregard it.
    - we can use helper methods to break up the functionality of this problem in order for it to be more modular, which in turn makes it more readable.

    * time complexity? - O(m*n)? we know what positions we are checking for verification, but we still need a nested loop to go through the m x n size grid.
    * space complexity? - O(1) because the only thing we need is a counter, and we are performing operations within the grid itself.
 */

/*
    *******************************CORRECT THOUGHT PROCESS/APPROACH:*********************************************
    * This problem will involve the use of a common graph algorithm, Depth-First Search (Breadth-First Search works too).
    * The idea is to recursively perform DFS whenever a '1' is encountered to find the whole island. The island counter will be incremented,
    * and when the whole grid has been looped through, then the method will return the number of islands counted throughout runtime.
    * We know that when at a particular piece of land, we can only move in 4 directions. Up, down, left or right. We can generalize this
    * by creating a 2D int array that represents each direction. This would look like:
                                                   int[][] directions = {{1, 0}, {-1, 0},
                                                                          {0, 1}, {0, -1}};
    * From this it will be easier to shift positions to perform DFS.
    * In the DFS function, our base case will be to make sure that the current coordinates are valid points in the grid, and if the current position is water or land (We want it to be land).
    * If the current position passes these checks, then we will set the current position to '0'. This will mark it as a visited position. From there, we will traverse the piece of land
    * by performing DFS in each of the 4 directions of the current position. This is where the directions 2D array comes in handy because we can loop through this array to shift each point
    * in the 4 different directions.
 */


public class numOfIslands_200 {
    // Private variable to setup Up, Down, Left, Right directions
    private static final int[][] directions = {{-1, 0}, {1, 0},
                                                {0, -1}, {0, 1}};

    // Method to perform DFS on passed in point
    private static void dfs(char[][] grid, int row, int col) {
        // since this function is recursive we will need a base case
        if (row < 0 || col < 0 || row >= grid.length ||
                col >= grid[0].length || grid[row][col] == '0') return;

        // mark position as visited by setting it to 0
        // this works because when we traverse in each direction a 0 will be reached where it was once a 1.
        // this is our way of letting the program know that the position has been visited.
        grid[row][col] = '0';
        // now we peform DFS in all possible directions
        for (int[] direction : directions) {
            dfs(grid, row + direction[0], col + direction[1]);
        }
    }

    // Method to traverse grid and return number of islands
    public static int numIslands(char[][] grid) {
        int islands = 0;
        // traverse grid while performing dfs
        for (int row = 0; row< grid.length; row++) {
            for (int col = 0; col<grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    // Main method to run program
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }
}
