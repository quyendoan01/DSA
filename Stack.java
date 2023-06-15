package DDA;

public class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push item: " + item);
            return;
        }
        stackArray[++top] = item;
    }
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty. Cannot pop element.");
        }
        return stackArray[top--];
    }
    public int top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty. No top element.");
        }
        return stackArray[top];
    }
    public int size() {
        return top + 1;
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.size());  // Output: 3
        System.out.println(stack.top());   // Output: 30

        stack.pop();
        System.out.println(stack.top());   // Output: 20
        System.out.println(stack.isEmpty());  // Output: false

        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());  // Output: true

    }
}
