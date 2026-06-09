
public class SinglyLinkedList {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }

        public void mostrarNodo() {
            System.out.println(this.data);
            System.out.println(this.next);
        }
    }
    Node head;

    public SinglyLinkedList insert(SinglyLinkedList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public void print(SinglyLinkedList list) {
        Node currNode = list.head;
        System.out.println("LinkedList");
        while (currNode != null) {
            System.out.println(currNode.data + "");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }
    
    
        public SinglyLinkedList insertInicio(SinglyLinkedList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            new_node.next = list.head;
            list.head = new_node;
                    }
        return list;
    }
        

}
