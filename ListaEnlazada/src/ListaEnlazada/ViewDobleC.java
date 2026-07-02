
package ListaEnlazada;


public class ViewDobleC {
    public static void main(String[] args) {
        ListaDobleC listc = new ListaDobleC();
        listc.Insertar(11);
        listc.Insertar(32);
        listc.Insertar(12);
        listc.print();
        
        
        System.out.println("MODIFICAR DATOS");
        listc.modificar(12, 8);
        listc.print();
    }
}
