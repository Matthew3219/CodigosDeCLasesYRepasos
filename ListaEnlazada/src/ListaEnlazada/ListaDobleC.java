package ListaEnlazada;

public class ListaDobleC {

    class Node {
        int data;
        Node previos;
        Node next;

        public Node(int data) {
            this.data = data;
            this.previos = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void Insertar(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            head.previos = tail;
        } else {
            tail.next = newNode;
            newNode.previos = tail;
            newNode.next = head; // El nuevo nodo apunta a la cabeza
            head.previos = newNode; // La cabeza apunta hacia atrás al nuevo nodo
            tail = newNode; // Ahora el nuevo nodo es la cola
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("LA CABEZA ESTA VACIA!!!");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.next != head) {
                System.out.print("Nodo: " + current.data + " -> ");
                current = current.next;
            } else {
                System.out.println("Nodo: " + current.data + " (Apunta a Head)");
                return;
            }
        }
    }

    public void eliminar(int key) {
        if (head == null) {
            System.out.println("NO EXISTE UNA LISTA ENLAZADA");
            return;
        }
        Node current = head;
        do {
            if (current.data == key) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } // Eliminar la cabeza
                else if (current == head) {
                    head = head.next;
                    head.previos = tail;
                    tail.next = head;
                } else if (current == tail) {
                    tail = tail.previos;
                    tail.next = head;
                    head.previos = tail;
                } else {
                    current.previos.next = current.next;
                    current.next.previos = current.previos;
                }
                current.next = null;
                current.previos = null;
                System.out.println("\n" + key + " ENCONTRADO Y ELIMINADO!!");
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("NO PUDO SER ENCONTRADO");
    }

    public void modificar(int a, int b) {
        if (head == null) {
            System.out.println("LA LISTA ESTA VACIA");
            return;
        }
        Node current = head;
        boolean encontrado = false;
        
        do {
            if (current.data == a) {
                current.data = b;
                encontrado = true;
                System.out.println("Valor " + a + " modificado por " + b);
                return; 
            }
            current = current.next;
        } while (current != head);

        if (!encontrado) {
            System.out.println("NO PUDO SER ENCONTRADO EL VALOR: " + a);
        }
    }
}