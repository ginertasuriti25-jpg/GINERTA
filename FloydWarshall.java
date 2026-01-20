import java.util.Arrays;

public class FloydWarshall {

    private static final int INF = 9999999;

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, 9, INF},
            {5, 0, 3, 1},
            {9, 3, 0, 1},
            {INF, 1, 1, 0},
        };

        int[][] result = floydWarshall(graph);

        // Menampilkan matriks hasil
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Inisialisasi matriks hasil dengan matriks input
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Proses algoritma Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Jika titik k menjadi titik perantara lebih baik
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }
}