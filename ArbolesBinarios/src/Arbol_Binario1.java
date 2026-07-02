public class Arbol_Binario1 {

    Node raiz;

    public Arbol_Binario1() {
        this.raiz = null;
    }

public boolean insertar(int indice, int frutas) {
    if (buscarPorIndice(indice) != null) {
        System.out.println("Ya existe un nodo con indice " + indice + ". No se insertó.");
        return false;
    }

    Node n = new Node(indice);
    n.contenido = frutas;

    if (raiz == null) {
        raiz = n;
        return true;
    } else {
        Node aux = raiz;
        while (aux != null) {
            n.padre = aux;
            // Ordenamos por CONTENIDO, no por índice
            if (n.contenido >= aux.contenido) {
                aux = aux.derecha;
            } else {
                aux = aux.izquierda;
            }
        }
        if (n.contenido < n.padre.contenido) {
            n.padre.izquierda = n;
        } else {
            n.padre.derecha = n;
        }
        return true;
    }
}

    // Como el árbol ahora está ordenado por CONTENIDO y no por índice,
    // buscar un índice ya no puede usar el atajo izquierda/derecha:
    // hay que recorrer todo el árbol, nodo por nodo (O(n)).
    public Node buscarPorIndice(int indice) {
        return buscarPorIndice(raiz, indice);
    }

    private Node buscarPorIndice(Node n, int indice) {
        if (n == null) {
            return null;
        }
        if (n.llave == indice) {
            return n;
        }
        Node enIzquierda = buscarPorIndice(n.izquierda, indice);
        if (enIzquierda != null) {
            return enIzquierda;
        }
        return buscarPorIndice(n.derecha, indice);
    }

    // Este SÍ puede usar el atajo, porque el árbol está ordenado por contenido
    public Node buscarPorContenido(int contenido) {
        Node aux = raiz;
        while (aux != null && aux.contenido != contenido) {
            if (contenido < aux.contenido) {
                aux = aux.izquierda;
            } else {
                aux = aux.derecha;
            }
        }
        return aux;
    }

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

    private Node minimo(Node n) {
        while (n.izquierda != null) {
            n = n.izquierda;
        }
        return n;
    }

    public boolean eliminar(int indice) {
        Node n = buscarPorIndice(indice);
        if (n == null) {
            System.out.println("No existe un nodo con indice " + indice);
            return false;
        }

        if (n.izquierda == null) {
            reemplazar(n, n.derecha);
        } else if (n.derecha == null) {
            reemplazar(n, n.izquierda);
        } else {
            Node sucesor = minimo(n.derecha);

            if (sucesor.padre != n) {
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
        public int contenido;

        public Node(int indice) {
            llave = indice;
            derecha = null;
            izquierda = null;
            padre = null;
            contenido = 0;
        }
    }

    public static void main(String[] args) {
        Arbol_Binario1 arbolB = new Arbol_Binario1();

        // insertar(indice, contenido) -> el ÁRBOL se ordena por "contenido"
        arbolB.insertar(3, 80);
        arbolB.insertar(2, 45);
        arbolB.insertar(1, 12);
        arbolB.insertar(6, 60);
        arbolB.insertar(8, 90);
        arbolB.insertar(5, 55);
        arbolB.insertar(0, 5);
        arbolB.insertar(4, 40);
        arbolB.insertar(9, 95);
        arbolB.insertar(11, 100);
        arbolB.insertar(10, 99);
        arbolB.insertar(7, 70);

        System.out.println("--- Probando insertar un indice duplicado (2) ---");
        arbolB.insertar(2, 999);

        System.out.println("\n--- Arbol original ---");
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