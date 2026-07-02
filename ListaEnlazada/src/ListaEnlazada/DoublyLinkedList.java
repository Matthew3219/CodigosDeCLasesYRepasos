
package ListaEnlazada;

public class DoublyLinkedList {
    class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
        
    }
    Node head;
    Node tail;
    public void Insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    
    public void eliminar(int dato){
        if(head == null){
            System.out.println(dato + " No encontrado");
            return;
        }
        Node current = head;
        while (current!= null && current.data!= dato) {            
            current = current.next;
        }
        if(current == null){
            System.out.println(dato + " No encontrado!!");
            return;
        }
        if(current == head){
            head = current.next;
        }else{
            current.previous.next = current.next;      
        }
        if(current == tail){
            tail = current.previous;
        }else{
            current.next.previous = current.previous;
        }
        current.next = null;
        current.previous= null;
        System.out.println(dato + " Encontrado y eliminado");
    }
    
    public void modificar(int a, int b){
        if(head == null){
            System.out.println("LA LISTA ESTA VACIA");
            return;
        }
        Node current = head;
        while(current!= null && current.data!= a){
            current = current.next;
        }
        if(current == null){
            System.out.println("NO PUDO SER ENCONTRADO");
        }else{
            current.data = b;
        }

        
    }
    
    
    
        public void printCabeza(){
        Node current = head;
        if(head == null){
            System.out.println("LISTA VACIA");
            return;
        }
        System.out.println("Nodes de doble Linked");
        while (current != null) {            
            System.out.println(current.data+ " ");
            current = current.next;
        }
        System.out.println("\n");
    }
    public void printCola(){
        Node current = tail;
        if(head == null){
            System.out.println("LISTA VACIA");
            return;
        }
        System.out.println("Nodes de doble Linked");
        while (current != null) {            
            System.out.println(current.data+ " ");
            current = current.previous;
        }
        System.out.println("\n");
    }
}
