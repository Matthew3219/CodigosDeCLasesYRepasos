public class SinglyLinkedListC {

    private Node head = null;
    private Node tail = null;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
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
    }

    public void print() {
        System.out.println("--- SinglyLinkedListC ---");
        if (head == null) {
            System.out.println("LA LISTA ESTA VACIA!!");
            return;
        }

        Node tempC = head;
        System.out.println("Los nodos de la lista circular son: ");
        do {
            System.out.print(tempC.data + " -> ");
            tempC = tempC.next;
        } while (tempC != head);

        System.out.println("(vuelve a la cabeza: " + head.data + ")");
    }

    public void Eliminar(int key) {
        if (head == null) {
            System.out.println("La lista está vacía. No se puede eliminar.");
            return;
        }
        
        Node temp = head;
        Node prev = tail;
        
        do {
            if (temp.data == key) {
                // CASO 1: Solo hay un nodo
                if (temp == head && temp == tail) {
                    head = null;
                    tail = null;
                } 
                // CASO 2: Eliminar la cabeza
                else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } 
                // CASO 3: Eliminar la cola
                else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } 
                // CASO 4: Eliminar un nodo intermedio
                else {
                    prev.next = temp.next;
                }
                
                temp.next = null; // Aislar el nodo eliminado
                System.out.println("EL NUMERO: " + key + " HA SIDO ENCONTRADO Y ELIMINADO");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        
        System.out.println("NO SE ENCUENTRA EN LA LISTA");
    }

    public void Buscar(int key) {
        if (head == null) {
            System.out.println("La lista esta vacia!!");
            return;
        }
        
        Node temp = head;
        boolean encontrado = false;
        
        do {
            if (temp.data == key) {
                System.out.println("ENCONTRADO!!!");
                System.out.println("Numero: " + key);
                encontrado = true;
                break; 
            }
            temp = temp.next;
        } while (temp != head);

        if (!encontrado) {
            System.out.println("NO SE ENCUENTRA EN LA LISTA!!!!");
        }
    }
}