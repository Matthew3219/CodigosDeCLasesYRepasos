
public class Grafos {

    private boolean[][] adjMatrix;
    private int numVertices;

    public Grafos(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public void なくす(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    public void 見せる() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print((adjMatrix[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafos g = new Grafos(3);
        g.addEdge(1, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 3);
        g.なくす(3, 2);
        g.見せる();
    }
}
