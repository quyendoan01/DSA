package DDA;
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    Node head;
    public void displayList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
            return;
        }
        System.out.println("Node not found in the list.");
    }
}

public class LinkedList2 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        System.out.println("Before deletion:");
        linkedList.displayList();
        linkedList.deleteNode(3);  // Deleting node with value 3
        System.out.println("After deletion:");
        linkedList.displayList();
    }
}
