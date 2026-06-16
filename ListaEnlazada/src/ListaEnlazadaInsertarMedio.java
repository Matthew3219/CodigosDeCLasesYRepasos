public class ListaEnlazadaInsertarMedio {

    private Node head;
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
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }


    public void insertEnPosicion(int data, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IllegalArgumentException("Posición fuera de rango: " + posicion);
        }

        Node newNode = new Node(data);

        if (posicion == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        for (int i = 0; i < posicion - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void eliminar(int key) {
        if (isEmpty()) {
            System.out.println("La lista está vacía. No se puede eliminar.");
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("El número " + key + " no se encuentra en la lista.");
            return;
        }

        if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }

        temp.next = null;
        size--;
        System.out.println("El número " + key + " ha sido eliminado.");
    }


    public void buscar(int key) {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node temp = head;
        int index = 0;

        while (temp != null && temp.data != key) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            System.out.println("El número " + key + " no se encuentra en la lista.");
            return;
        }

        System.out.println("ENCONTRADO: " + key + " en la posición " + index);
    }


    public void ordenarAscendente() {
        if (isEmpty() || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void ordenarDescendente() {
        if (isEmpty() || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data < current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }


    public void print() {
        System.out.println("--- ListaEnlazada (tamaño: " + size + ") ---");
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
}