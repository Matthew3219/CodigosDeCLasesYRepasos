
public class Arboles_Binarios {

    Node raiz;

    public Arboles_Binarios() {
        this.raiz = null;
    }

    public void insertar(int indice, Object frutas) {
        Node n = new Node(indice);
        n.contenido = frutas;

        if (raiz == null) {
            raiz = n;
            return;
        } else {
            Node aux = raiz;
            while (aux != null) {
                n.padre = aux;
                if (n.llave >= aux.llave) {
                    aux = aux.derecha;
                } else {
                    aux = aux.izquierda;
                }
            }
            if (n.llave < n.padre.llave) {
                n.padre.izquierda = n;
                return;
            } else {
                n.padre.derecha = n;
                return;
            }
        }
    }

    public void recorrer(Node n) {
        if (n != null) {
            recorrer(n.izquierda);
            System.out.println("Indice " + n.llave + " Contenido: " + n.contenido);
            recorrer(n.derecha);
        }
    }

    private class Node {

        public Node padre;
        public Node derecha;
        public Node izquierda;
        public int llave;
        public Object contenido;

        public Node(int indice) {
            llave = indice;
            derecha = null;
            izquierda = null;
            padre = null;
            contenido = null;
        }
    }

    public static void main(String[] args) {
        Arboles_Binarios arbolB = new Arboles_Binarios();

        arbolB.insertar(3, "Melocoton");
        arbolB.insertar(2, "Mango");
        arbolB.insertar(1, "Melon");
        arbolB.insertar(6, "Sandia");
        arbolB.insertar(8, "Fresa");
        arbolB.insertar(5, "Cereza");
        arbolB.insertar(0, "Uva");
        arbolB.insertar(4, "Manzana Verde");
        arbolB.insertar(9, "Limon");
        arbolB.insertar(11, "Guayaba");
        arbolB.insertar(10, "Cebolla");
        arbolB.insertar(7, "Mango verde");

        arbolB.recorrer(arbolB.raiz);
    }

}
