import java.util.Scanner;
public class test {
    public static int NUM_PRODUCTS = 10;
    public static String []produk ={"Tenda camping","Tas Gunung","Slepping Bag","Kompor portable","cooking set","FlashLight", "Karpet tebal", "product8", "Product9", "Product10"};
    public static int [] jumulah={5,5,5,5,5,5,5,5,5,5};
    public static long[] harga = {250000, 35000, 0000, 0000, 0000, 0000, 0000, 0000, 0000, 0000};
    public static long[] hargaOngkir ={15000, 30000};
    public static String nama,alamat, masukkan;
    public static long notelp;
    public static String[] itemKeranjang = new String[NUM_PRODUCTS];
    public static int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
    public static long totalHarga=0,saldo=0,biayaPengiriman,totalHargaFinal=0;
    public static int estimasi,pengiriman;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
			System.out.println("  Selamat datang di sistem rental alat camping          ");
                        System.out.println("=================================================");
			System.out.print("masukan user: ");
			String user =scanner.nextLine();
			System.out.print("masukan password: ");
			int password = scanner.nextInt();
			
			if( (user.equalsIgnoreCase("admin")) && (password==123) ){
			
			System.out.println("\n               Login Berhasil              ");
			System.out.println("\n");


            }
        int pilihan;
        do {
            System.out.println("=================================================");
            System.out.println("                   Menu Utama                   ");
            System.out.println("=================================================");
            System.out.println("\n1.Profil");
            System.out.println("2.Persediaan alat camping");
            System.out.println("3.Keranjang");
            System.out.println("4.Peminjaman barang");
            System.out.println("5.Opsi pengiriman");
            System.out.println("6.Pembayaran");
            System.out.println("7.Servis center");
                            System.out.println("8.Pengembalian barang");
                            System.out.println("9.pendapatan");
                            System.out.println("10.exit");
            System.out.print("\nPilih Menu : ");
            pilihan = scanner.nextInt();
            

            switch (pilihan) {
                case 1:
                    Profil(scanner);
                    break;
                case 2:
                    persediaan(scanner);  
                    break;
                case 3:
                    Keranjang(scanner);
                    break;
                case 4:
                    peminjamanBarang(scanner);
                    break;
                case 5:
                    pengiriman(scanner);
                    break;
                case 6:
                    pembayaran(scanner);
                    break;
                case 7 :
                    service();
                    break;
                case 8 :
                    pengembalian(scanner);
                    break;
                case 9 :
                    pendapatan(scanner);
                    break;
                case 10:
                    exit(scanner);
                    break;
                default:  
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (pilihan != 10);

        scanner.close();
    }

        //Method untuk profil
        public static void Profil(Scanner scanner) {
            System.out.println("=================================================");
            System.out.println("                 Profil Customer                 ");
            System.out.println("=================================================");
            System.out.print("Nama    :");
            nama= scanner.nextLine();
            nama = scanner.nextLine();
            System.out.print("Alamat  :");
            alamat = scanner.nextLine();
            System.out.print("No.Telp :");
            notelp = scanner.nextLong();
            System.out.println("=================================================");
            
        }

        //method untuk persediaan alat camping
        public static void persediaan(Scanner scanner){
            System.out.println("=================================================");
            System.out.println("                 Persediaan Alat                    ");  
            System.out.println("=================================================");      
            System.out.println("Nama\t\tTersedia\tHarga");
            

            for (int i = 0; i < NUM_PRODUCTS; i++) {
                System.out.print(produk[i] + "\t");
                if (jumulah[i] == 0) {
                    System.out.print("Sold out\t");
                } else {
                    System.out.print(jumulah [i] + "\t\t");
                }
                System.out.println(harga[i]);
            }
            System.out.println("\nPilih opsi untuk melanjutkan:");
            System.out.println("1.keranjang\n2.Menu utama");
            int next= scanner.nextInt();
            if (next==1) {
                Keranjang(scanner);
            }else if (next==2) {
            
            }else{
                System.out.println("Pilihan tidak tersedia");
                persediaan(scanner);
            }

        }
        //Method untuk keranjang
        public static void Keranjang(Scanner scanner){
            System.out.println("=================================================");
            System.out.println("                    keranjang                 ");
            System.out.println("=================================================");
            System.out.println("Masukkan barang yang akan disewa:");
            String barang= scanner.nextLine();
            barang=scanner.nextLine();

            int indexBarang =-1;
            for(int i = 0; i < NUM_PRODUCTS; i++){
                if (produk[i].equalsIgnoreCase(barang)) {
                    indexBarang = i;
                    break;
                }
                }
                if (indexBarang ==-1) {
                    System.out.println("produk tidak ditemukan");
                    }else if(jumulah[indexBarang]==0){
                        System.out.println("sold out");
                    }else{
                        System.out.println("Masukkan jumlah barang yang akan di sewa:");
                        int jumlahBarang=scanner.nextInt();
                    
                    if (jumlahBarang > jumulah[indexBarang]) {
                        System.out.println("Barang yang di sewa tidak mencukupi");
                    }else {
                        itemKeranjang[indexBarang]=barang;
                        jmlBarangKeranjang[indexBarang]+=jumlahBarang;
                        totalHarga += harga[indexBarang]*jumlahBarang;

                        jumulah[indexBarang] -= jumlahBarang;
                        System.out.println("barang telah dimasukkan kedalam keranjang");
                    }
                     
                    }



        }

        //Method untuk peminjaman barang
        public static void peminjamanBarang(Scanner scanner){
             System.out.println("=================================================");
            System.out.println("                Peminjaman Barang               ");
            System.out.println("=================================================");
            System.out.println("*Peminjaman Dihitung Perhari*");
            System.out.println("Masukkan Estimasi Waktu Peminjaman :");
            estimasi=scanner.nextInt();
        }
        
        //method untuk opsi pengiriman
public static void pengiriman(Scanner scanner) {
    System.out.println("======================================================");
    System.out.println("                      Pengiriman                ");
    System.out.println("======================================================");
    System.out.println("1. JNT \n2. JNE");
    System.out.print("Masukkan opsi pengiriman: ");
    pengiriman = scanner.nextInt();
    if (pengiriman ==1 ) {
        pengiriman =0 ;
    }
    if (pengiriman == 2) {
        pengiriman =1;
    }

    if (pengiriman == 1 || pengiriman == 2) {
        System.out.println("Pengiriman sudah di tentukan");
    } else {
        System.out.println("Opsi pengiriman tidak valid. Silakan pilih opsi yang valid.");
    }
}

       // Logika pembayaran
public static void pembayaran(Scanner scanner) {
    System.out.println("======================================================");
    System.out.println("                Rincian Pembayaran                ");
    System.out.println("======================================================");
    System.out.println("Nama   : " + nama);
    System.out.println("Alamat : " + alamat);
    System.out.println("No.Telp: " + notelp);
    System.out.println("======================================================");
    System.out.println("Produk\t\tJumlah\t\tHarga\t\tEstimasi\tPengiriman");

    boolean adaBarangDalamKeranjang = false; // Menambahkan variabel ini untuk mengecek apakah ada barang dalam keranjang

    for (int i = 0; i < NUM_PRODUCTS; i++) {
        if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
            System.out.print(itemKeranjang[i] + "\t");
            System.out.print(jmlBarangKeranjang[i] + "\t\t");
            System.out.print(harga[i] + "\t\t");
            System.out.print(estimasi + "\t\t");
            System.out.println(hargaOngkir[pengiriman]);

            adaBarangDalamKeranjang = true; // Setel ke true jika ada barang dalam keranjang
        }
    }

    if (adaBarangDalamKeranjang) {
        totalHargaFinal = totalHarga * estimasi + hargaOngkir[pengiriman];
        System.out.println("Total Harga: " + totalHargaFinal);
        System.out.println("Apakah anda ingin membayar sesuai harga yang tertera? (y/n)");
        String jawaban = scanner.next();
        if (jawaban.equalsIgnoreCase("y")) {
            saldo += totalHargaFinal;
            System.out.println("Pembayaran Berhasil");
        } else {
            System.out.println("Pembayaran tidak valid");
        }
    } else {
        System.out.println("Keranjang Anda kosong. Silakan tambahkan barang ke keranjang terlebih dahulu.");
    }
    System.out.println("Terima kasih!");
}

        
        // method untuk service center
        public static void service() {
            System.out.println("=================================================");
            System.out.println("                 Customer Service                ");
            System.out.println("=================================================");
            System.out.println("Ada masalah? Hubungi kami melalui:");
            System.out.println("No. Telpon : 082178174040");
            System.out.println("email      : hanifahkurniasari0512@gmail.com");
            System.out.println("");
        }
        // method untuk pengembalian barang
        public static void pengembalian(Scanner scanner) {
            System.out.println("=================================================");
            System.out.println("                Pengembalian Barang          ");
            System.out.println("=================================================");
            System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang?(y/n)");
            String kembali = scanner.next();
        
            if (kembali.equalsIgnoreCase("y")) {
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                        // Mengembalikan semua barang yang ada di keranjang
                        jumulah[i] += jmlBarangKeranjang[i];
                        totalHarga -= harga[i] * jmlBarangKeranjang[i];
                        jmlBarangKeranjang[i] = 0;
                    
                    }
                }
                System.out.println("Semua barang berhasil dikembalikan.");
            } else {
                System.out.println("Terima kasih!");
            }
        }
        
            
            
        // method untuk pendapatan
        public static void pendapatan(Scanner scanner) {
            System.out.println("=================================================");
			System.out.println("                   login pendapatan          ");
            System.out.println("=================================================");
			System.out.print("masukan user: ");
			String user =scanner.next();
			System.out.print("masukan password: ");
			int password = scanner.nextInt();
			
			if( (user.equalsIgnoreCase("admin")) && (password==123) ){
			
			System.out.println("\n               login berhasil              ");
			System.out.println("\n");  
            System.out.println("=================================================");
            System.out.println("               Cek pendapatan                   ");
            System.out.println("       pendapatan Anda adalah Rp. " +   saldo     );
            System.out.println("=================================================");
            System.out.println("feedback:" + masukkan);  
        }else {
            System.out.println("Username atau password anda salah");
        }
        
}
//method exit
public static void exit(Scanner scanner) {
    System.out.println("apakah anda puas?(y/n)");
    String puas = scanner.next ();
    if (puas=="y")
     {    
    }

    else if(puas=="n"){
        System.out.println("beri kami masukkan");
        masukkan= scanner.nextLine();
    }
    System.out.println("Thank you for using Alat Rental Camping. Goodbye!");
    
}
}
