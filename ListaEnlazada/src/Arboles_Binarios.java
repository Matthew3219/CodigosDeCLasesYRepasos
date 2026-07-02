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

    // Busca el nodo con la llave dada, o null si no existe
    public Node buscar(int llave) {
        Node aux = raiz;
        while (aux != null && aux.llave != llave) {
            if (llave < aux.llave) {
                aux = aux.izquierda;
            } else {
                aux = aux.derecha;
            }
        }
        return aux;
    }

    // Reemplaza el subárbol que cuelga de "viejo" por el subárbol "nuevo",
    // acomodando el puntero del padre de "viejo" (o la raíz si no tiene padre)
    private void reemplazar(Node viejo, Node nuevo) {
        if (viejo.padre == null) {
            raiz = nuevo;
        } else if (viejo == viejo.padre.izquierda) {
            viejo.padre.izquierda = nuevo;
        } else {
            viejo.padre.derecha = nuevo;
        }
        if (nuevo != null) {
            nuevo.padre = viejo.padre;
        }
    }

    // Encuentra el nodo con la llave mínima dentro del subárbol que cuelga de n
    private Node minimo(Node n) {
        while (n.izquierda != null) {
            n = n.izquierda;
        }
        return n;
    }

    public boolean eliminar(int indice) {
        Node n = buscar(indice);
        if (n == null) {
            System.out.println("No existe un nodo con indice " + indice);
            return false;
        }

        if (n.izquierda == null) {
            // Caso 1: sin hijo izquierdo (incluye el caso de nodo hoja)
            reemplazar(n, n.derecha);
        } else if (n.derecha == null) {
            // Caso 2: sin hijo derecho
            reemplazar(n, n.izquierda);
        } else {
            // Caso 3: tiene los dos hijos -> usamos el sucesor
            // (el menor del subárbol derecho)
            Node sucesor = minimo(n.derecha);

            if (sucesor.padre != n) {
                // El sucesor no es hijo directo: lo desconectamos de su lugar
                reemplazar(sucesor, sucesor.derecha);
                sucesor.derecha = n.derecha;
                sucesor.derecha.padre = sucesor;
            }

            reemplazar(n, sucesor);
            sucesor.izquierda = n.izquierda;
            sucesor.izquierda.padre = sucesor;
        }
        return true;
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

        System.out.println("--- Arbol original ---");
        arbolB.recorrer(arbolB.raiz);

        System.out.println("\n--- Eliminando el 8 (nodo con dos hijos) ---");
        arbolB.eliminar(8);
        arbolB.recorrer(arbolB.raiz);

        System.out.println("\n--- Eliminando el 0 (nodo hoja) ---");
        arbolB.eliminar(0);
        arbolB.recorrer(arbolB.raiz);

        System.out.println("\n--- Eliminando el 6 (nodo con un solo hijo) ---");
        arbolB.eliminar(6);
        arbolB.recorrer(arbolB.raiz);
    }
}