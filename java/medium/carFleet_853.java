/*
    There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
    You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
    A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
    A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
    If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
    Return the number of car fleets that will arrive at the destination.

    Example 1:
        Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        Output: 3
        Explanation:
        The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
        The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
        The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

    Example 2:
        Input: target = 10, position = [3], speed = [3]
        Output: 1
        Explanation:
        There is only one car, hence there is only one fleet.

    Example 3:
        Input: target = 100, position = [0,2,4], speed = [4,2,1]
        Output: 1
        Explanation:
        The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
        Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

    Constraints:
        n == position.length == speed.length
        1 <= n <= 105
        0 < target <= 106
        0 <= position[i] < target
        All the values of position are unique.
        0 < speed[i] <= 106
 */

import java.util.Arrays;
import java.util.Stack;

public class carFleet_853 {
    // Method to return number of car fleets
    public static int carFleet(int target, int[] position, int[] speed) {
        /*
            The intuition for this problem requires some basic graph/slope knowledge. We will use the amount of time it will take a car
            to reach the target  value (equation: (target - position) / speed) to determine if they will cross paths by the time they reach the target. If they do
            cross paths, then we know we have a car fleet. Because of the problem description providing a rule that no car
            is allowed to pass another, we know that once a car catches up to another it will not be able to pass it. This
            is what makes it a valid car fleet due to the fact that they must travel at the same speed for the remainder of
            the time. So, we will do comparisons using the car with the slowest speed because the cars will be reduced to this speed once they potentially catch up to
            another car.

            This problem will use a stack to accomplish this. We will add the amount of time it will take a car to reach the destination to the stack, and traverse the
            position and speed in reverse order. We do this in a sorted reverse order to ensure that there is no ambiguity with comparisons. If we were to traverse from left to right,
            there is a possibility that we reach a car that may have to slow down throughout runtime which means the speed that is calculated for it is not a constant speed.
            So, we traverse from right to left in order to ensure that the speed comparisons have consistency which will yield the most accurate results. Continuing, if a calculated
            time for a car reaches the target in a faster time than the top of the stack, then we know there is a car fleet because it will have to slow down eventually. We will
            pop this value from the top of the stack to maintain the amount of car fleets in the stack. This makes it easier to return the amount of car fleets, which will simply be
            the length of the stack because we are keeping cars that make a car fleet in the stack. Since we have to sort the arrays, the time complexity of this is O(nlogn) with a space complexity of O(n).
         */
        // We initialize a 2d array to create a 2 column table that holds the positions and speeds of cars
        int[][] pair = new int[position.length][2];
        for (int i=0; i<position.length; i++) {
            // Populating the 2d array with position and speed pairs
            // We know the ith position's corresponding speed is also at the ith value in the speed array.
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // Use built-in library to sort positions in descending order
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        // Since we sorted in descending order, we can traverse normally using an enhanced for loop
        for (int[] p : pair) {
            // Since the values in the arrays are int, we cast a double to it to convert the value from an int.
            // This is done because some calculations may not result in whole integers.
            stack.push((double) (target - p[0]) / p[1]);
            // Check if the stack has at least 2 elements, and the top of the stack is less than the value below it.
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                // If these conditions are true then we have an intersection with cars and can pop, signifying a valid car fleet.
                stack.pop();
            }
        }
        // By the end of runtime the stack should have cars that are the start of valid car fleets so we can just return this.
        return stack.size();
    }
    // Main method to run program
    public static void main(String[] args) {
        int target = 12;
        int[] position = new int[] {10,8,0,5,3};
        int[] speed = new int[] {2,4,1,1,3};
        System.out.println(carFleet(target, position, speed));
    }
}
