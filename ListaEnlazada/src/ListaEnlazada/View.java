package ListaEnlazada;

public class View {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.Insert(3);
        list.Insert(6);
        list.Insert(9);
        list.Insert(12);
        System.out.print("Imprimir de Cabeza a Cola");
        list.printCabeza();
        System.out.print("Imprimir de Cola a Cabeza");
        list.printCola();
        
        /**
         *        System.out.println("Eliminar elementos");
        list.eliminar(3);
        
        System.out.println("Eliminar en mitad");
        list.eliminar(9);
        
        System.out.println("Eliminar final");
        list.eliminar(12);
        
        System.out.println("Eliminar elemento inexistente");
        list.eliminar(243);
        
        list.printCabeza();
         */

        
        
        System.out.println("Modificar");
        list.modificar(6, 18);
        list.printCabeza();
    }
}
