import java.util.Scanner;

public class tugas2_P9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int NUM_PRODUCTS = 4;
        String[]produk = {"Tenda", "Sleeping Bag", "Kompor Portable", "Lentera", "Panci"};
        int[] jumlahid = {10, 15, 5, 8, 12};
        int[] hargaid={20000, 30000, 120000, 21000, 100000};
        int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
        String[] itemKeranjang = new String[NUM_PRODUCTS];
        int totalHarga=0,harga=0;
        int estimasi,jumlah;
        String pinjam;


        System.out.println("Selamat datang di Sistem Rental Alat Camping");

        System.out.println("=================================================");
        System.out.println("                Peminjaman Barang               ");
        System.out.println("=================================================");
        System.out.println("pilih barang yang akan di pinjam: ");
        pinjam = input.nextLine();
                for (int i = 0; i < produk.length; i++) {
            if (pinjam.equalsIgnoreCase(produk[i])){
                System.out.println("Anda memesan "+produk[i]+". Harga sewa adalah "+hargaid[i]);
                System.out.println("Jumlah yang ingin Anda pesan?\t");
                jumlah =input.nextInt();
                System.out.println("Masukkan Estimasi Waktu Peminjaman :");
                estimasi = input.nextInt();
                harga += jumlah*hargaid[i];
                totalHarga=harga*estimasi;
                System.out.println("Total biaya yang dibayar : "+totalHarga);
        
            
        }
    }
    
        System.out.println("=================================================");
        System.out.println("                Pengembalian Barang          ");
        System.out.println("=================================================");
        System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang?(y/n)");
        String kembali = input.next();

        if (kembali.equalsIgnoreCase("y")) {
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                    jumlahid[i] += jmlBarangKeranjang[i];
                    totalHarga -= hargaid[i] * jmlBarangKeranjang[i];
                    jmlBarangKeranjang[i] = 0;

                }
            }
            System.out.println("Semua barang berhasil dikembalikan.");
        } else {
            System.out.println("Terima kasih!");
}

}
}