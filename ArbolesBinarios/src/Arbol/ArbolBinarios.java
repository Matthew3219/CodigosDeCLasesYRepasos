
public class ArbolBinarios {

    Node raiz;

    public ArbolBinarios() {
        this.raiz = null;
    }

    public boolean insertar(int indice, int frutas) {
        if (buscarPorIndice(indice) != null) {
            System.out.println("Ya existe un nodo con indice " + indice + ". No se inserto.");
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

    public boolean eliminarMenor(int indice) {
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

    private Node maximo(Node n) {
        while (n.derecha != null) {
            n = n.derecha;
        }
        return n;
    }

    public boolean eliminarMayor(int indice) {
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
            Node predecesor = maximo(n.izquierda);

            if (predecesor.padre != n) {
                reemplazar(predecesor, predecesor.izquierda);
                predecesor.izquierda = n.izquierda;
                predecesor.izquierda.padre = predecesor;
            }

            reemplazar(n, predecesor);
            predecesor.derecha = n.derecha;
            predecesor.derecha.padre = predecesor;
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

    public void traversePreOrder(Node n) {
        if (n != null) {
            System.out.println(" " + n.contenido);
            traversePreOrder(n.izquierda);
            traversePreOrder(n.derecha);
        }
    }

    public void traverseProOrder(Node n) {
        if (n != null) {
            System.out.println(" " + n.contenido);
            traversePreOrder(n.izquierda);
            traversePreOrder(n.derecha);
        }
    }

    public void createBalancedTree(int[] sortedArray) {
        raiz = createBalanceTreeRec(sortedArray, 0, sortedArray.length - 1);
    }

    public Node createBalanceTreeRec(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.izquierda = createBalanceTreeRec(array, start, mid - 1);
        node.derecha = createBalanceTreeRec(array, mid + 1, end);
        return node;
    }

}
