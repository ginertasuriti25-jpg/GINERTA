public class FloydWarshallTrace {
    final static int INF = 9999;
    final static int V = 4;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        // Copy graph ke dist
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        System.out.println("Status Awal:");
        printMatrix(dist);

        // Loop Utama dengan Print
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            // Print setelah setiap pivot selesai
            System.out.println("\nSetelah Iterasi Pivot " + (char)('A' + k) + ":");
            printMatrix(dist);
        }
    }

    void printMatrix(int dist[][]) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) System.out.print("INF\t");
                else System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshallTrace fw = new FloydWarshallTrace();
        int graph[][] = { {0, 5, 9, INF}, {5, 0, 3, 1}, {9, 3, 0, 1}, {INF, 1, 1, 0} };
        fw.floydWarshall(graph);
    }
}