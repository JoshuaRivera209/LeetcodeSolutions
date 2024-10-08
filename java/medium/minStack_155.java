/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:
        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.
        You must implement a solution with O(1) time complexity for each function.

        -231 <= val <= 231 - 1
        Methods pop, top and getMin operations will always be called on non-empty stacks.
        At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */

import java.util.Stack;

public class minStack_155 {
    /*
        The idea behind this approach revolves around using a global
        variable to keep track of the minimum value. Whenever we push,
        we first check if the value we are pushing is a minimum value.
        If it is, we will push the current minimum, and then assign the
        minimum value to the value that was passed in. This will act as a dummy variable. We will then
        push the actual value to the stack after.

        The other core idea to grasp is the pop function. Since we have a dummy variable
        we need to check if the value that is popped is equal to the current minimum.
        If it is, then we need to pop again and make this the new minimum value because we are
        pushing the dummy value whenever we have a new minimum. Calling this.stack.pop() will run
        this operation, so we can compare the values while calling the operation as seen in the implementation.

        Since these are all still stack operations, and stack operations run in O(1) runtime, this implentation is
        also O(1) runtime.
     */

    // Create global minimum value to keep track
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    // Constructor for min stack object
    public minStack_155() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (val <= min) {
            this.push(min);
            min = val;
        }
        this.push(val);
    }

    public void pop() {
        if(this.stack.pop() == min) min=this.stack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return min;
    }
}
