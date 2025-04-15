package SystemRegestration;

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

public class LinkedList {
    private Node head, tail;
    private int size;

    public LinkedList() {
        tail = null;
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void add(Object info) {

        if (isEmpty()) {
            head = new Node(info);
            tail = head;
        } else {
            tail.next = new Node(info);
            tail = tail.next;
        }
        size++;
    }

    public boolean search(Object info) {
        if (isEmpty()) {
            System.out.println("list is empty! ");
            return false;
        } else {
            Node curr = head;
            while (curr != null) {
                if (curr.info.equals(info)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    public Object getObject(Object info) {
        if (isEmpty()) {

            return null;
        } else {
            Node curr = head;
            while (curr != null) {
                if (curr.info.equals(info)) {
                    return curr;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    public void remove(Object info) {
        if (isEmpty())
            System.out.println("list is empty! ");
        else {
            if (head.info.equals(info)) {
                head = head.next;
                size--;
            } else {
                Node curr = head;
                Node headnext = head.next;
                while (head.next != null) {
                    if (headnext.info.equals(info)) {
                        curr.next = headnext.next;
                        size--;
                        break;
                    } else {
                        curr = headnext;
                        headnext = headnext.next;
                    }
                    if (headnext == null) {
                        System.out.println("The element is not found in the list");
                        break;
                    }

                }
            }
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.info + " ");
                curr = curr.next;
            }
            System.out.println();
        }

    }

}
