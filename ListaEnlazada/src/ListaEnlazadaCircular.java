public class ListaEnlazadaCircular {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }


    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void insertEnPosicion(int data, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IllegalArgumentException("Posición fuera de rango: " + posicion);
        }

        Node newNode = new Node(data);

        if (head == null || posicion == 0) {
            if (head == null) {
                // Lista vacía
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                // Insertar al inicio
                newNode.next = head;
                tail.next = newNode;
                head = newNode;
            }
            size++;
            return;
        }

        Node current = head;
        for (int i = 0; i < posicion - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        if (current == tail) {
            tail = newNode;
        }

        size++;
    }


    public void eliminar(int key) {
        if (isEmpty()) {
            System.out.println("La lista está vacía. No se puede eliminar.");
            return;
        }

        Node temp = head;
        Node prev = tail;

        do {
            if (temp.data == key) {
                if (temp == head && temp == tail) {
                    // Único nodo
                    head = null;
                    tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                temp.next = null;
                size--;
                System.out.println("El número " + key + " ha sido eliminado.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("El número " + key + " no se encuentra en la lista.");
    }


    public void buscar(int key) {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node temp = head;
        int index = 0;

        do {
            if (temp.data == key) {
                System.out.println("ENCONTRADO: " + key + " en la posición " + index);
                return;
            }
            temp = temp.next;
            index++;
        } while (temp != head);

        System.out.println("El número " + key + " no se encuentra en la lista.");
    }


    public void ordenarAscendente() {
        if (isEmpty() || head == tail) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            do {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            } while (current != tail); 
        } while (swapped);
    }


    public void ordenarDescendente() {
        if (isEmpty() || head == tail) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            do {
                if (current.data < current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            } while (current != tail); 
        } while (swapped);
    }


    public void print() {
        System.out.println("--- ListaEnlazadaCircular (tamaño: " + size + ") ---");
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head: " + head.data + ")");
    }
}