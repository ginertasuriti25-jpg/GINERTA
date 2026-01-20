public class FloydWarshallStudiKasus {
    final static int INF = 9999;
    final static int V = 5; // Jumlah Simpul: 5 Gedung

    void runFloydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        // 1. Copy Graph ke Matriks Solusi
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // 2. Loop Utama (Jalankan Algoritma)
        for (k = 0; k < V; k++) { // Pivot k (Titik Perantara)
            for (i = 0; i < V; i++) { // Titik Asal
                for (j = 0; j < V; j++) { // Titik Tujuan
                    // Rumus: Jika lewat K lebih kecil dari jarak sekarang, update!
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            // Opsional: Buka komentar di bawah jika ingin lihat proses per langkah
            // printStep(dist, k); 
        }

        // 3. Tampilkan Hasil
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("=== Hasil Akhir Jarak Tercepat Antar Gedung ===");
        System.out.println("      A     B     C     D     E");
        System.out.println("   -------------------------------");
        
        char[] gedung = {'A', 'B', 'C', 'D', 'E'};
        
        for (int i = 0; i < V; i++) {
            System.out.print(gedung[i] + " | ");
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.printf("%4s  ", "INF");
                else
                    System.out.printf("%4d  ", dist[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshallStudiKasus fw = new FloydWarshallStudiKasus();
        
        // Matriks Graph (0=A, 1=B, 2=C, 3=D, 4=E)
        int graph[][] = {
            {0,   2, INF,   5, INF}, // Baris A
            {2,   0,   3,   2, INF}, // Baris B
            {INF, 3,   0, INF,   4}, // Baris C
            {5,   2, INF,   0,   1}, // Baris D
            {INF, INF, 4,   1,   0}  // Baris E
        };

        fw.runFloydWarshall(graph);
    }
}