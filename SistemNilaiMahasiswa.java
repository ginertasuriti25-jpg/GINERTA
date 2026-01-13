import java.util.Arrays;
import java.util.Scanner;

public class SistemNilaiMahasiswa {

    public static void main(String[] args) {
        // 1. Menyimpan array nilai terurut
        int[] nilaiMahasiswa = {45, 55, 60, 70, 75, 80, 85, 90, 95, 100};
        
        System.out.println("Daftar Nilai: " + Arrays.toString(nilaiMahasiswa));
        
        // Input nilai yang dicari
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nilai yang dicari: ");
        int target = scanner.nextInt();
        
        // Panggil fungsi pencarian
        binarySearchNilai(nilaiMahasiswa, target);
        
        scanner.close();
    }

    public static void binarySearchNilai(int[] data, int key) {
        int low = 0;
        int high = data.length - 1;
        int langkah = 0;
        boolean ditemukan = false;
        
        System.out.println("\n--- Proses Pencarian ---");
        
        while (low <= high) {
            langkah++; // Menghitung langkah
            int mid = (low + high) / 2;
            
            // 2. Menampilkan langkah pencarian (Visualisasi)
            System.out.println("Langkah ke-" + langkah + ": Low=" + low + ", High=" + high + ", Mid=" + mid + ", Nilai Check=" + data[mid]);
            
            if (data[mid] == key) {
                // 3. Menampilkan Indeks, Jumlah Langkah, Status
                System.out.println("\n--- Hasil Akhir ---");
                System.out.println("Status: Ditemukan");
                System.out.println("Nilai " + key + " ada di indeks ke-" + mid);
                System.out.println("Total langkah yang dibutuhkan: " + langkah);
                ditemukan = true;
                return;
            } else if (key < data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        if (!ditemukan) {
            System.out.println("\n--- Hasil Akhir ---");
            System.out.println("Status: Tidak Ditemukan");
            System.out.println("Total langkah yang dilalui: " + langkah);
        }
    }
}