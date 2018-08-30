/*

Problem Statement:

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/

/*

Thought Process:

We maintain an actual stack that contains custom nodes. Each node contains their value, as well as the 
minimum value when this node was inserted.

*/

class MinStack {

    class Node {
        int val;
        int min;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<Node> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        min = Math.min(x, min);
        stack.push(new Node(x, min));
    }
    
    public void pop() {
        stack.pop();
        min = (stack.isEmpty()) ? Integer.MAX_VALUE : stack.peek().min;
    }
    
    public int top() {
        if(stack.isEmpty()) return Integer.MIN_VALUE;
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}


/*

Final thoughts:

Time complexity: O(1)
Space complexity: O(n)



*/