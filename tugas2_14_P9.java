import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class tugas2_14_P9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int NUM_PRODUCTS = 4;
        String[] produk = { "Tenda", "Sleeping Bag", "Kompor Portable", "Lampu", "Panci" };
        int[] jumlahid = { 10, 15, 5, 8, 12 };
        int[] hargaid = { 20000, 30000, 120000, 21000, 100000 };
        int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
        String[] itemKeranjang = new String[NUM_PRODUCTS];
        int totalHarga = 0, harga = 0;
        int estimasi = 0, jumlah;
        String pinjam;
        String inputPeminjaman = null;
        String inputPengembalian = null;

        System.out.println("Selamat datang di Sistem Rental Alat Camping");

        System.out.println("=================================================");
        System.out.println("                Peminjaman Barang               ");
        System.out.println("=================================================");
        System.out.println("pilih barang yang akan di pinjam: ");
        pinjam = input.nextLine();
        for (int i = 0; i < produk.length; i++) {
            if (pinjam.equalsIgnoreCase(produk[i])) {
               // System.out.println("Anda memesan " + produk[i] + ". Harga sewa adalah " + hargaid[i]);
                //System.out.println("Jumlah yang ingin Anda pesan?\t");
                //jumlah = input.nextInt();
                System.out.println("Masukkan Estimasi Waktu Peminjaman (hari):");
                estimasi = input.nextInt();

                // Input tanggal peminjaman
                System.out.print("Masukkan tanggal peminjaman (dd/MM/yyyy): ");
                // String inputPeminjaman = null;
                inputPeminjaman = input.next();

                // Input tanggal pengembalian
                // System.out.print("Masukkan tanggal pengembalian (dd/MM/yyyy): ");
                // String inputPengembalian = input.next();

                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date tanggalPeminjaman = dateFormat.parse(inputPeminjaman);

                    // Date tanggalPengembalian = dateFormat.parse(inputPengembalian);

                    // Memeriksa validitas tanggal
                    if (tanggalPeminjaman.after(tanggalPeminjaman)) {
                        System.out.println("Error: Tanggal pengembalian harus setelah tanggal peminjaman.");
                    } else {
                        // Proses peminjaman
                        System.out.println("Peminjaman berhasil! Terima kasih.");
                    }
                } catch (ParseException e) {
                    System.out.println("Error: Format tanggal salah. Gunakan format dd/MM/yyyy.");
                }

                //harga += jumlah * hargaid[i];
               // totalHarga = harga + (harga / 2 * estimasi);
                //System.out.println("Total biaya yang dibayar : " + totalHarga);
            }
        }

        System.out.println("=================================================");
        System.out.println("                Pengembalian Barang          ");
        System.out.println("=================================================");
        System.out.println("tanggal pinjam: " + inputPeminjaman);
        System.out.println("lama pinjam: " + estimasi);
        System.out.print("masukkan tanggal kembali: " );
        inputPengembalian = input.next();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date tanggalPengrmbalian = dateFormat.parse(inputPengembalian);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(e.hashCode());
        }
        System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang?(y/n)");
        String kembali = input.next();
        // Input tanggal pengembalian


        if (kembali.equalsIgnoreCase("y")) {
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                    jumlahid[i] += jmlBarangKeranjang[i];
                    totalHarga -= hargaid[i] * jmlBarangKeranjang[i];
                    jmlBarangKeranjang[i] = 0;
                }
            }
            System.out.println("Semua barang berhasil dikembalikan.");


        } else if (kembali != inputPeminjaman) {

        }


        System.out.println("=================================================");
        System.out.println("             Keterlambatan pengembalian          ");
        System.out.println("=================================================");
        System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang?(y/n)");

    }
}

// System.out.println("=================================================");
// System.out.println(" Pengembalian Barang ");
// System.out.println("=================================================");
// System.out.println("masukkan tanggal pinjam: ");
// System.out.println("masukkan lama pinjam: "+estimasi);
// System.out.println("masukkan tanggal kembali: ");
// System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang?(y/n)");
// String kembali = input.next();

// if (kembali.equalsIgnoreCase("y")) {
// for (int i=0; i < NUM_PRODUCTS; i++) {
// if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
// jumlahid[i] += jmlBarangKeranjang[i];
// totalHarga -= hargaid[i] * jmlBarangKeranjang[i];
// jmlBarangKeranjang[i] = 0;
// }}
// System.out.println("Semua barang berhasil dikembalikan.");
// } else {
// System.out.println("Terima kasih!");
// }