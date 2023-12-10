import java.util.Scanner;

public class tugas_P13 {
    public static int NUM_PRODUCTS = 10;
    public static long totalHarga = 0;
    public static String[] produkid = { "Tenda camping", "Tas Gunung", "Sleeping Bag", "Kompor portable",
            "Alat memasak", "Senter", "Karpet tebal", "Obat obatan & P3K", "Pisau jelajah", "Sekop" };
    public static int[] jumlahid = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
    public static long[] hargaid = { 250000, 75000, 60000, 20000, 40000, 15000, 30000, 15000, 10000, 20000 };
    public static long[] hargaOngkirid = { 1000, 30000 };
    public static String namaid, alamatid, masukkan, notelpid;
    public static String[] itemKeranjang = new String[NUM_PRODUCTS];
    public static int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("  Selamat datang di sistem rental alat camping          ");
        System.out.println("=================================================");
        System.out.print("Masukan user: ");
        String user = scanner.nextLine();// untuk membaca sebuah user yang di masukkan
        System.out.print("Masukan password: ");
        int password = scanner.nextInt();// untuk membaca sebuah password yang di masukkan

        if ((user.equalsIgnoreCase("customer") && password == 123))// sebuah pemilihan yang akan dilakukan jika user dan
                                                                   // password sama dengan yang tertera
        {
            System.out.println("\n               Login Berhasil (Customer)              ");
            System.out.println("\n");

            int pilihan; // deklarasi untuk pilihan
            do {// apabila if sesuai maka akan di lakukan sebuah do while
                System.out.println("=================================================");
                System.out.println("                   Menu Utama                   ");
                System.out.println("=================================================");
                System.out.println("\n1.Profil");
                System.out.println("2.Persediaan alat camping");
                System.out.println("3.Keranjang");
                System.out.println("4.Hapus Produk Dari Keranjang ");
                System.out.print("\nPilih Menu : ");
                pilihan = scanner.nextInt();// untuk membaca inputan yang dimasukkan
                scanner.nextLine();

                switch (pilihan) {// sebuah fungsi switch case yag berguna untuk memilih method yang ingin dibuka
                                  // dengan sebuah inputan berupa angka
                    case 1:
                        Profil(scanner);// apabila pilihan yang di input itu 1 maka dia akan memanggil sebuah method
                                        // yaitu profil
                        break;
                    case 2:
                        persediaan(scanner);// apabila pilihan yang di input itu 2 maka dia akan memanggil sebuah method
                                            // yaitu persediaan
                        break;
                    case 3:
                        Keranjang(scanner);// apabila pilihan yang di input itu 3 maka dia akan memanggil sebuah method
                                           // yaitu keranjang
                        break;
                    case 4:
                        hapusProdukDariKeranjang(scanner); // apabila pilihan yang di input itu 4 maka dia akan
                                                           // memanggil sebuah method yaitu hapusProdukDariKeranjang
                        break;
                        default:// pilihan default
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (pilihan != 11);
}
            }

            public static void Profil(Scanner scanner) {// (Scanner scanner) berfungsi untuk mendeklarasikan scanner yang ada
                // pada method tersebut itu ganti dari ddeklarasi scanner pada umum nya
System.out.println("=================================================");
System.out.println("                 Profil Customer                 ");
System.out.println("=================================================");
System.out.print("Nama    :");
namaid = scanner.nextLine();
System.out.print("Alamat  :");
alamatid = scanner.nextLine();
System.out.print("No.Telp :");
notelpid = scanner.nextLine();
System.out.println("=================================================");
System.out.println();
System.out.println("Tekan enter untuk ke menu selanjutnya...");
System.out.println("Tekan selain enter untuk ke menu utama...");

String input = scanner.nextLine();
if (input.isEmpty()) { // Jika input kosong (hanya enter)
persediaan(scanner);
} else {
// Kembali ke menu utama atau lakukan apa yang diperlukan
}
}

// method untuk persediaan alat camping
public static void persediaan(Scanner scanner) {
System.out.println("======================================================");
System.out.println("                 Persediaan Alat                    ");
System.out.println("======================================================");
System.out.println("------------------------------------------------------");
System.out.printf("%-20s %-10s %-15s\n", "Nama", "Tersedia", "Harga");
System.out.println("------------------------------------------------------");

for (int i = 0; i < NUM_PRODUCTS; i++) {
if (jumlahid[i] == 0) {
System.out.printf("%-20s %-10s %-15s\n", produkid[i], "Sold out", hargaid[i]);
} else {
System.out.printf("%-20s %-10d %-15d\n", produkid[i], jumlahid[i], hargaid[i]);
}
}
System.out.println("------------------------------------------------------");

System.out.println("\nTekan enter untuk ke menu selanjutnya...");
System.out.println("Tekan selain enter untuk ke menu utama...");

String input = scanner.nextLine();
if (input.isEmpty()) { // Jika input kosong (hanya enter)
Keranjang(scanner);
} else {
// Kembali ke menu utama atau lakukan apa yang diperlukan
}
}

// Method untuk keranjang
public static void Keranjang(Scanner scanner) {
System.out.println("=================================================");
System.out.println("                    keranjang                 ");
System.out.println("=================================================");
System.out.println("Masukkan barang yang akan disewa:");
String barang = scanner.nextLine();// inputan barang

int indexBarang = -1;// deklarasi untuk sebuah indexBarang yang bernilai -1
for (int i = 0; i < NUM_PRODUCTS; i++) {
if (produkid[i].equalsIgnoreCase(barang)) {// apabila isi dari array produkid sama dengan input barang maka
                       // akan dijalankan
indexBarang = i;// index barang diganti menjadi i yaitu 0
break;
}
}
if (indexBarang == -1) {// jika indexbarang nya -1 maka akan dijalankan program ini
System.out.println("produk tidak ditemukan");
} else if (jumlahid[indexBarang] == 0) {// apabila jika array jumlahid =0 maka dia akan menjalan kan program
System.out.println("sold out");
} else {// jika tidak ada yang sesuai dengan pemilihan-pemilihan sebelumnya maka akan
// dijalankan program ini
System.out.println("Masukkan jumlah barang yang akan di sewa:");
int jumlahBarang = scanner.nextInt();// berguna untuk menginput dengan nama jumlahBarang
scanner.nextLine();
if (jumlahBarang > jumlahid[indexBarang]) {// jika jumlahBarang lebih dari array jumlahid maka akan
                       // dejalankan program tersebut
System.out.println("Barang yang di sewa tidak mencukupi");
} else {// jika tiidak ada pemilihan yang sesuai maka jalankan program tersebut
itemKeranjang[indexBarang] = barang;// array itemKeranjang diisi dengan barang
jmlBarangKeranjang[indexBarang] += jumlahBarang;// nilai awal array jumlahBarangKeranjang akan ditambah
                                // sama dengan jumlahBarang
totalHarga += hargaid[indexBarang] * jumlahBarang;// nilai awal total harga akan ditambah sama dengan
                                  // array hargaid di kali jumlahBarang

jumlahid[indexBarang] -= jumlahBarang;// nilai awal array jumlahid akan dikurang sama dengan
                      // jumlahBarang yang di input
System.out.println("barang telah dimasukkan kedalam keranjang");
}

}
System.out.println("--------------------------------------------");
System.out.println("\nTekan enter untuk ke menu selanjutnya...");
System.out.println("Tekan B untuk memesan lagi...");
System.out.println("Tekan lainnya untuk ke menu utama...");

String input = scanner.nextLine();
if (input.isEmpty()) { // Jika input kosong (hanya enter)
hapusProdukDariKeranjang(scanner);
} else if (input.equalsIgnoreCase("b")) {
Keranjang(scanner);
} else {
// Kembali ke menu utama atau lakukan apa yang diperlukan
}
}

// method hapus barang dari keranjang
public static void hapusProdukDariKeranjang(Scanner scanner) {
System.out.println("=================================================");
System.out.println("           Hapus Produk Dari Keranjang                 ");
System.out.println("=================================================");
System.out.print("Masukan nama produk: ");
String productName = scanner.nextLine();
productName = scanner.nextLine();

int productIndex = -1;
for (int i = 0; i < NUM_PRODUCTS; i++) {
if (itemKeranjang[i] != null && itemKeranjang[i].equalsIgnoreCase(productName)) {
productIndex = i;
break;
}
}
if (productIndex == -1) {
System.out.println("Produk tidak di temukan.");
} else {
System.out.print("Masukan jumlah produk : ");
int jmlBarang = scanner.nextInt();

if (jmlBarang > jmlBarangKeranjang[productIndex]) {
System.out.println("Jumlah tidak valid.");
} else {
jmlBarangKeranjang[productIndex] -= jmlBarang;
totalHarga -= hargaid[productIndex] * jmlBarang;

jumlahid[productIndex] += jmlBarang;
System.out.println("Produk telah dibuang dari keranjang.");
return;
}
}
}
}
 
