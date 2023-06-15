package DDA;

import java.util.NoSuchElementException;

public class QueueDemo<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty() {
        return head == null;
    }
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public static void main(String[] args) {
        QueueDemo<Integer> queue = new QueueDemo<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.peek()); // Output: 1

        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2

        System.out.println(queue.isEmpty()); // Output: false

        System.out.println(queue.dequeue()); // Output: 3

        System.out.println(queue.isEmpty()); // Output: true
    }
}
