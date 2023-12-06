import java.util.Scanner;

public class KasirrRestoran05 {
    static int nilai = 0;
    static int jumPorsi;
    static String makanan;
    // Deklarasi array untuk daftar makanan dan harganya
    static String[] daftarMakanan = {
            "Nasi Goreng",
            "Ayam Geprek",
            "Nasi Bakar",
            "Ikan Bakar",
            "Cumi Goreng"
    };
    static int[] hargaMakanan = { 12000, 10000, 13000, 20000, 20000 };
    static String[] keranjangMakan = new String[5];
    static int[] keranjangPorsi = new int[5];
    static int[][] porsi = new int[100][10];
    static String[][] makan = new String[100][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Selamat datang di Kasir Restoran");
        System.out.println("================================");
        System.out.print("Masukkan username: ");
        String username = sc.nextLine();
        System.out.print("Masukkan Password: ");
        String password = sc.nextLine();

        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
            System.out.println("Login Berhasil");
            System.out.println("\n");
        } else {
            System.out.println("Username atau Password salah!");
            main(args);
        }

        int pilihan;
        do {
            System.out.println("=== Menu Utama ===");
            System.out.println("1. Daftar Menu ");
            System.out.println("2. Transaksi ");
            System.out.println("3. Laporan Penjualan");
            System.out.println("4. Struk Pembayaran");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    menu(sc);
                    break;
                case 2:
                    transaksi(sc);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Terima kasih");
                default:
                    System.out.println("Menu tidak tersedia!");
                    break;
            }
        } while (pilihan != 5);

    }

    public static void menu(Scanner sc) {
        System.out.println("|================================|");
        System.out.println("|       PILIH MENU MAKANAN       |");
        System.out.println("|================================|");

        // Menampilkan daftar makanan dan harganya dari array
        for (int i = 0; i < daftarMakanan.length; i++) {
            System.out.printf("|%d. %-15s %-13s|\n", (i + 1), daftarMakanan[i], "Rp " + hargaMakanan[i]);
        }
        System.out.println("|================================|\n");
      
    }

    public static void transaksi(Scanner sc) {
        System.out.print("Pilih makanan: ");
        sc.nextLine(); // Membersihkan buffer
        String makanan = sc.nextLine();
        int indexBarang = -1;// deklarasi untuk sebuah indexBarang yang bernilai -1
        for (int i = 0; i < daftarMakanan.length; i++) {
            if (daftarMakanan[i].equalsIgnoreCase(makanan)) {// apabila isi dari array produkid sama dengan input barang maka
                                                       // akan dijalankan
                indexBarang = i;// index barang diganti menjadi i yaitu 0
                break;
            }
        }
        if (indexBarang == -1) {// jika indexbarang nya -1 maka akan dijalankan program ini
            System.out.println("produk tidak ditemukan");
        }else{
        System.out.print("Berapa porsi: ");
        int jumPorsi = sc.nextInt();

        keranjangMakan[nilai] = makanan; // Menambah pesanan ke array
        keranjangPorsi[nilai] = jumPorsi; // Menambah jumlah porsi ke array

        nilai++; // Pindah ke posisi berikutnya dalam array
        }
        System.out.println("Apakah ingin memesan lagi? (Y/N)");
        String pesanLagi = sc.next();

        if (pesanLagi.equalsIgnoreCase("y") && nilai < 5) {
            transaksi(sc);; // Jika ingin memesan lagi, panggil kembali method menu
        } else {

        }
        
    }
}