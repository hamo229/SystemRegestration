package SystemRegestration;

public class Stack {

    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Object info) {
        top = new Node(info, top);
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty on pop");
            return null;
        }
        Object info = top.info;
        top = top.next;
        size--;
        if (top == null) {
            System.out.println("Stack is empty after pop");
        }
        return info;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty on peek");
            return null;
        }

        return top.info;
    }

    class Node {
        Object info;
        Node next;

        public Node(Object obj) {
            info = obj;
            next = null;
        }

        public Node(Object obj, Node head) {
            info = obj;
            next = head;
        }
    }
}
