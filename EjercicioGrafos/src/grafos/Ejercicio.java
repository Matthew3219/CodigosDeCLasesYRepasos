
package grafos;

public class Ejercicio {
    
    private int[][] adjMatrix;
    private int numVertices;

    public Ejercicio(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j, int peso) {
        adjMatrix[i][j] = peso;
        adjMatrix[j][i] = peso;
    }

    public void なくす(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void 見せる() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print("\t" + adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Ejercicio g = new Ejercicio(5);
        g.addEdge(1, 0, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 0, 4);
        g.addEdge(2, 4, 2);
        g.addEdge(3, 1, 3);
        g.addEdge(3, 4, 4);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 0, 1);
        g.addEdge(4, 3, 4);
        System.out.println("MATRIZ CREADA");
        System.out.println("\t0\t1\t2\t3\t4");
        g.見せる();
    }
}
