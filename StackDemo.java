package DDA;

import java.util.EmptyStackException;

public class StackDemo<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    private Node<T> top;
    public boolean isEmpty() {
        return top == null;
    }
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    public static void main(String[] args) {
        StackDemo<Integer> stack = new StackDemo<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // Output: 3

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2

        System.out.println(stack.isEmpty()); // Output: false

        System.out.println(stack.pop()); // Output: 1

        System.out.println(stack.isEmpty()); // Output: true
    }
}
