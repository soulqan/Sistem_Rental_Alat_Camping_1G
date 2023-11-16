import java.util.Scanner;

public class codeInd{
    //tempat deklarasi mulai variabel biasa hingga array
    public static int NUM_PRODUCTS = 10;
    public static String[] produkid = { "Tenda camping", "Tas Gunung", "Sleeping Bag", "Kompor portable", "Cooking set", "FlashLight", "Karpet tebal", "product8", "Product9", "Product10" };
    public static int[] jumlahid = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
    public static long[] hargaid = { 250000, 35000, 60000, 20000, 40000, 15000, 30000, 0000, 0000, 0000 };
    public static long[] hargaOngkirid = { 1000, 30000 };
    public static String namaid, alamatid, masukkan, notelpid;
    public static String[] itemKeranjang = new String[NUM_PRODUCTS];
    public static int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
    public static long totalHarga = 0, saldo = 0, biayaPengiriman, totalHargaFinal = 0;
    public static int estimasi, pengiriman;
    public static String[][] dendaHilang = {
        {"Tenda camping", "2.500.000"},
        {"Tas Gunung", "800.000"},
        {"Sleeping Bag", "600.000"},
        {"Kompor portable", "200.000"},
        {"Cooking set", "150.000"},
        {"Flashlight", "50.000"},
        {"Karpet tebal", "30.000"},
    };
    

//sebuah public static utama untuk login dan menampilkan menu
public static void 

main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("=================================================");
            System.out.println("  Selamat datang di sistem rental alat camping          ");
            System.out.println("=================================================");
            System.out.print("Masukan user: ");
            String user =scanner.nextLine();//untuk membaca sebuah user yang di masukkan
            System.out.print("Masukan password: ");
            int password = scanner.nextInt();//untuk membaca sebuah password yang di masukkan
        
        if ((user.equalsIgnoreCase("customer") && password == 123))//sebuah pemilihan yang akan dilakukan jika user dan password sama dengan yang tertera 
         {
            System.out.println("\n               Login Berhasil (Customer)              ");
            System.out.println("\n");
    
            int pilihan; // deklarasi untuk pilihan 
            do{//apabila if sesuai maka akan di lakukan sebuah do while
               System.out.println("=================================================");
                    System.out.println("                   Menu Utama                   ");
                    System.out.println("=================================================");
                    System.out.println("\n1.Profil");
                    System.out.println("2.Persediaan alat camping");
                    System.out.println("3.Keranjang");
                    System.out.println("4.Hapus Produk Dari Keranjang ");
                    System.out.println("5.Peminjaman barang");
                    System.out.println("6.Opsi pengiriman");
                    System.out.println("7.Pembayaran");
                    System.out.println("8.Servis center");
                    System.out.println("9.Pengembalian barang");
                    System.out.println("10.Exit");
                    System.out.print("\nPilih Menu : ");
                pilihan = scanner.nextInt();// untuk membaca inputan yang dimasukkan
                
                switch (pilihan) {// sebuah fungsi switch case yag berguna untuk memilih method yang ingin dibuka dengan sebuah inputan berupa angka
                    case 1:
                        Profil(scanner);//apabila pilihan yang di input itu 1 maka dia akan memanggil sebuah method yaitu profil
                        break;
                    case 2:
                        persediaan(scanner);//apabila pilihan yang di input itu 2 maka dia akan memanggil sebuah method yaitu persediaan
                        break;
                    case 3:
                        Keranjang(scanner);//apabila pilihan yang di input itu 3 maka dia akan memanggil sebuah method yaitu keranjang
                        break;
                    case 4:
                        hapusProdukDariKeranjang(scanner);  //apabila pilihan yang di input itu 4 maka dia akan memanggil sebuah method yaitu hapusProdukDariKeranjang
                        break;
                    case 5:
                        peminjamanBarang(scanner);// //apabila pilihan yang di input itu 5 maka dia akan memanggil sebuah method yaitu peminjamanBarang
                        break;
                    case 6:
                        pengiriman(scanner);//apabila pilihan yang di input itu 6 maka dia akan memanggil sebuah method yaitu pengiriman
                        break;
                    case 7:
                        pembayaran(scanner);//apabila pilihan yang di input itu 7 maka dia akan memanggil sebuah method yaitu pembayaran
                        break;
                    case 8:
                        service(scanner);//apabila pilihan yang di input itu 8 maka dia akan memanggil sebuah method yaitu service
                        break;
                    case 9:
                        pengembalian(scanner);//apabila pilihan yang di input itu 9 maka dia akan memanggil sebuah method yaitu pengembalian
                        break;
                    case 10:
                        denda(scanner);//apabila pilihan yang di input itu 9 maka dia akan memanggil sebuah method yaitu denda
                        break;
                    case 11:
                        exit();//apabila pilihan yang di input itu 10 maka dia akan memanggil sebuah method yaitu exit
                        break;
                    default:// pilihan default
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (pilihan != 10);//ujung dari statement do-while
        } else if (user.equalsIgnoreCase("admin") && password == 123) {//sebuah pemilihan lain yang menuju ke admin
            System.out.println("\n               Login Berhasil (Admin)              ");
            System.out.println("\n");
    
            int pilihan;
            do {
                System.out.println("=================================================");
                    System.out.println("                   Menu Utama                   ");
                    System.out.println("=================================================");
                    System.out.println("\n1.Profil");
                    System.out.println("2.Persediaan alat camping");
                    System.out.println("3.Keranjang");
                    System.out.println("4.Hapus Produk Dari Keranjang ");
                    System.out.println("5.Peminjaman barang");
                    System.out.println("6.Opsi pengiriman");
                    System.out.println("7.Pembayaran");
                    System.out.println("8.Servis center");
                    System.out.println("9.Pengembalian barang");
                    System.out.println("10.Pendapatan dan feedback");
                    System.out.println("11.Penambahan barang baru");
                    System.out.println("12.Denda");
                    System.out.println("13.Exit");
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
                        hapusProdukDariKeranjang(scanner);
                        break;
                    case 5:
                        peminjamanBarang(scanner);
                        break;
                    case 6:
                        pengiriman(scanner);
                        break;
                    case 7:
                        pembayaran(scanner);
                        break;
                    case 8:
                        service(scanner);
                        break;
                    case 9:
                        pengembalian(scanner);
                        break;
                    case 10:
                        pendapatan();
                        break;
                    case 11:
                        tambahBarang(scanner);
                        break;
                    case 12:
                        denda(scanner);
                        break;
                    case 13:
                        exit();
                        break;
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (pilihan != 12);
        } else {//apabila login tidak sesuai dengan kedua pemilihan maka pemilihan terakhir yang di gunakan
            System.out.println("Login Gagal");
        }
    }

    // Method untuk profil
    public static void Profil(Scanner scanner) {//(Scanner scanner) berfungsi untuk mendeklarasikan scanner yang ada pada method tersebut itu ganti dari ddeklarasi scanner pada umum nya 
        System.out.println("=================================================");
        System.out.println("                 Profil Customer                 ");
        System.out.println("=================================================");
        System.out.print("Nama    :");
        namaid = scanner.nextLine();
        namaid = scanner.nextLine();
        System.out.print("Alamat  :");
        alamatid = scanner.nextLine();
        System.out.print("No.Telp :");
        notelpid = scanner.nextLine();
        System.out.println("=================================================");

    }

    // method untuk persediaan alat camping
    public static void persediaan(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                 Persediaan Alat                    ");
        System.out.println("=================================================");
        System.out.println("Nama\t\tTersedia\tHarga");

        for (int i = 0; i < NUM_PRODUCTS; i++) {// sebuah perulangan yang nilai NUM_PRODUCT nya adalah 10
            System.out.print(produkid[i] + "\t");
            if (jumlahid[i] == 0) {//jika jumlahid mempunyai nilai 0 maka akan dijalankan program tersebut
                System.out.print("Sold out\t");
            } else {//jika tidak sama dengan 0 maka akan dijalankan program berikut
                System.out.print(jumlahid[i] + "\t\t");
            }
            System.out.println(hargaid[i]);
        }
        System.out.println("\nPilih opsi untuk melanjutkan:");
        System.out.println("1.keranjang\n2.Menu utama");
        int next = scanner.nextInt();
        if (next == 1) {//sebuah pemilihan untuk menuju ke method selanjutnya
            Keranjang(scanner);
        } else if (next == 2) {

        } else {
            System.out.println("Pilihan tidak tersedia");
            persediaan(scanner);//untuk kembali ke method persediaan
        }

    }

    // Method untuk keranjang
    public static void Keranjang(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                    keranjang                 ");
        System.out.println("=================================================");
        System.out.println("Masukkan barang yang akan disewa:");
        String barang = scanner.nextLine();
        barang = scanner.nextLine();//inputan barang

        int indexBarang = -1;//deklarasi untuk sebuah indexBarang yang bernilai -1 
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (produkid[i].equalsIgnoreCase(barang)) {// apabila isi dari array produkid sama dengan input barang maka akan dijalankan
                indexBarang = i;//index barang diganti menjadi i yaitu 0
                break;
            }
        }
        if (indexBarang == -1) {//jika indexbarang nya -1 maka akan dijalankan program ini
            System.out.println("produk tidak ditemukan");
        } else if (jumlahid[indexBarang] == 0) {//apabila jika array jumlahid =0 maka dia akan menjalan kan program
            System.out.println("sold out");
        } else {//jika tidak ada yang sesuai dengan pemilihan-pemilihan sebelumnya maka akan dijalankan program ini
            System.out.println("Masukkan jumlah barang yang akan di sewa:");
            int jumlahBarang = scanner.nextInt();//berguna untuk menginput dengan nama jumlahBarang

            if (jumlahBarang > jumlahid[indexBarang]) {//jika jumlahBarang lebih dari array jumlahid maka akan dejalankan program tersebut
                System.out.println("Barang yang di sewa tidak mencukupi");
            } else {//jika tiidak ada pemilihan yang sesuai maka jalankan program tersebut
                itemKeranjang[indexBarang] = barang;//array itemKeranjang diisi dengan barang
                jmlBarangKeranjang[indexBarang] += jumlahBarang;//nilai awal array jumlahBarangKeranjang akan ditambah sama dengan jumlahBarang 
                totalHarga += hargaid[indexBarang] * jumlahBarang;//nilai awal total harga akan ditambah sama dengan array hargaid di kali jumlahBarang

                jumlahid[indexBarang] -= jumlahBarang;//nilai awal array jumlahid akan dikurang sama dengan jumlahBarang yang di input
                System.out.println("barang telah dimasukkan kedalam keranjang");
            }

        }

    }
     //method hapus barang dari keranjang
     public static void hapusProdukDariKeranjang(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("           Hapus Produk Dari Keranjang                 ");
        System.out.println("=================================================");
        System.out.print("Masukan nama produk: ");
        String productName = scanner.nextLine();  
        productName=scanner.nextLine();

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
    
                if (jmlBarang > jmlBarangKeranjang [productIndex]) {
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
    

    // Method untuk peminjaman barang
    public static void peminjamanBarang(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                Peminjaman Barang               ");
        System.out.println("=================================================");
        System.out.println("*Peminjaman Dihitung Perhari*");
        System.out.println("Masukkan Estimasi Waktu Peminjaman :");
        estimasi = scanner.nextInt();
    }

    // method untuk opsi pengiriman
    public static void pengiriman(Scanner scanner) {
        System.out.println("======================================================");
        System.out.println("                      Pengiriman                ");
        System.out.println("======================================================");
        System.out.println("1. Ambil Di tempat   :1000 \n2. Kurir             :30000");
        System.out.print("Masukkan opsi pengiriman: ");
        pengiriman = scanner.nextInt();
        if (pengiriman == 1) {
            pengiriman = 0;
            System.out.println("Pengiriman sudah di tentukan");
        }else if (pengiriman == 2) {
            pengiriman = 1;
            System.out.println("Pengiriman sudah di tentukan");
        }
         else {
            System.out.println("Opsi pengiriman tidak valid. Silakan pilih opsi yang valid.");
        }
    }


    // Logika pembayaran
    public static void pembayaran(Scanner scanner) {
        System.out.println("======================================================");
        System.out.println("                Rincian Pembayaran                ");
        System.out.println("======================================================");
        System.out.println("Nama   : " + namaid);
        System.out.println("Alamat : " + alamatid);
        System.out.println("No.Telp: " + notelpid);
        System.out.println("======================================================");
        System.out.println("Produk\t\tJumlah\t\tHarga\t\tEstimasi\tPengiriman");

        boolean adaBarangDalamKeranjang = false; // Menambahkan variabel ini untuk mengecek apakah ada barang dalam
                                                 // keranjang

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                System.out.print(itemKeranjang[i] + "\t");
                System.out.print(jmlBarangKeranjang[i] + "\t\t");
                System.out.print(hargaid[i] + "\t\t");
                System.out.print(estimasi + "\t\t");
                System.out.println(hargaOngkirid[pengiriman]);

                adaBarangDalamKeranjang = true; // Setel ke true jika ada barang dalam keranjang
            }
        }

        if (adaBarangDalamKeranjang) {
            totalHargaFinal = totalHarga * estimasi + hargaOngkirid[pengiriman];
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
    public static void service(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                 Customer Service                ");
        System.out.println("=================================================");
        System.out.println("Ada masalah? Hubungi kami melalui:");
        System.out.println("No. Telpon : 082178174040");
        System.out.println("email      : hanifahkurniasari0512@gmail.com");
        System.out.println("ingin memberi masukkan?(y/n)");
        String masukan=scanner.nextLine();
        masukan=scanner.nextLine();
        if (masukan.equals("y")) {
            System.out.println("Beri Masukkan Anda: ");
            masukkan= scanner.nextLine();
            System.out.println("terima kasih telah memberi masukkan");

        }else if(masukan =="n"){          
        
        }else{
            System.out.println("pemilihan tidak tersedia!");
        }
    }

    // method untuk pengembalian barang
    public static void pengembalian(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                Pengembalian Barang          ");
        System.out.println("=================================================");
        System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang?(y/n)");
        String kembali = scanner.next();

        if (kembali.equalsIgnoreCase("y")) { //jika setuju untuk mengembalikan barang maka akan menjalankan program
            for (int i = 0; i < NUM_PRODUCTS; i++) { //jika sudah melakukan peminjaman atau transaksi maka program baru bisa berjalan dg syarat:
                if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) { //item keranjang tidak kosong
                    // Mengembalikan semua barang yang ada di keranjang
                    jumlahid[i] += jmlBarangKeranjang[i];
                    totalHarga -= hargaid[i] * jmlBarangKeranjang[i];//sudah melakukan pembayaran
                    jmlBarangKeranjang[i] = 0;//barang dikeranjang sudah tidak ada atau sudah dibayar

                }
            }
            System.out.println("Semua barang berhasil dikembalikan.");
        } else {
            System.out.println("Terima kasih!");
        }//code  untuk penambahan jumlah hari lagi otw, hanifah masih bingung mwehe
    }


    // method untuk pendapatan
    public static void pendapatan() {
        System.out.println("=================================================");
        System.out.println("               pendapatan & feedback             ");
        System.out.println("=================================================");
            System.out.println("               Cek pendapatan                   ");
            System.out.println("       pendapatan Anda adalah Rp. " + saldo);
            System.out.println("=================================================");
            System.out.println("feedback:" + masukkan);
        } 

    // method tambah barang
    public static void tambahBarang(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("              penambahan barang         ");
        System.out.println("=================================================");
            // Periksa apakah array produk sudah penuh
            // Memastikan panjang array selalu lebih besar atau sama dengan NUM_PRODUCTS
            if (NUM_PRODUCTS >= produkid.length) {
                // Jika sudah penuh, buat array baru dengan ukuran yang lebih besar
                int newLengthid = produkid.length + 1;

                String[] newProdukid = new String[newLengthid];
                int[] newJumlahid = new int[newLengthid];
                long[] newHargaid = new long[newLengthid];
                String[] newItem = new String[newLengthid];
                int[]newJmlBarang= new int[newLengthid];
                //array

                // Salin elemen-elemen dari array lama ke array baru
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    newProdukid[i] = produkid[i];
                    newJumlahid[i] = jumlahid[i];
                    newHargaid[i] = hargaid[i];
                    newItem[i]= itemKeranjang[i];
                    newJmlBarang[i]= jmlBarangKeranjang[i];


                }

                // Ganti array lama dengan array baru
                produkid = newProdukid;
                jumlahid = newJumlahid;
                hargaid = newHargaid;
                jmlBarangKeranjang= newJmlBarang;
                itemKeranjang=newItem;
            }

            // Lanjutkan dengan menambahkan barang seperti yang sudah Anda lakukan
            System.out.print("Apakah Anda ingin menambahkan barang baru? (y/n): ");
            String tambahBarang = scanner.next();

            if (tambahBarang.equalsIgnoreCase("y") && NUM_PRODUCTS < produkid.length) {
                
                // ... kode penambahan barang ...
                System.out.print("Masukkan nama barang baru: ");
                String namaBarangBaru = scanner.nextLine();
                namaBarangBaru = scanner.nextLine();

                System.out.print("Masukkan jumlah barang yang tersedia: ");
                int jumlahBarangBaru = scanner.nextInt();

                System.out.print("Masukkan harga barang baru: ");
                long hargaBarangBaru = scanner.nextLong();

                // Menambahkan barang baru ke array produk
                produkid[NUM_PRODUCTS] = namaBarangBaru;
                jumlahid[NUM_PRODUCTS] = jumlahBarangBaru;
                hargaid[NUM_PRODUCTS] = hargaBarangBaru;

                // Menginkrementasi NUM_PRODUCTS
                NUM_PRODUCTS++;

                System.out.println("Barang baru berhasil ditambahkan ke persediaan.");
            }
        }
        public static void denda(Scanner scanner) {
            String back;
            while (true) {
                System.out.println("=================================================");
                System.out.println("              Denda         ");
                System.out.println("=================================================");
                System.out.println("1. Telat mengembalikan barang");
                System.out.println("2. Kehilangan barang");
                System.out.println("3. Kerusakan barang");
                System.out.print("\nPilihan : ");
                int pilihanDenda = scanner.nextInt();
    
                switch (pilihanDenda) {
                    case 1:
                        do {
                            System.out.println("");
                            System.out.println("Apakah anda ingin melaporkan kesalahan kembali? (y/n)");
                            back = scanner.next();
                        } while (back.equalsIgnoreCase("y"));
                        break;
                    case 2:
                        do {
                            System.out.println("List denda barang yang hilang : \n");
                            for (int i = 0; i < dendaHilang.length; i++) {
                               for (int j = 0; j < dendaHilang[i].length; j++) {
                                System.out.print(dendaHilang[i][j]);
                                
                               }
                               System.out.println();
                            }
                            System.out.println("Barang apa saja yang hilang?");
                            String hilang = scanner.nextLine();
                            hilang = scanner.nextLine();
    
                            boolean found = false;
                            for (String[] item : dendaHilang) {
                                if (item[0].equalsIgnoreCase(hilang)) {
                                    System.out.println("Anda harus membayar kehilangan barang tersebut senilai " + item[1]);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Barang tidak ditemukan dalam daftar kehilangan.");
                            }
    
                            System.out.println("Apakah anda ingin melaporkan kesalahan kembali? (y/n)");
                            back = scanner.next();
                        } while (back.equalsIgnoreCase("y"));
                        break;
                    case 3:
                        do {
                            System.out.println("Barang apa saja yang rusak?");
                            System.out.println("Apakah anda ingin melaporkan kesalahan kembali? (y/n)");
                            back = scanner.next();
                        } while (back.equalsIgnoreCase("y"));
                        break;
                }
            }
        }
 

    // method exit
    public static void exit() {
        System.out.println("Terima kasih telah menggunakan sistem rental alat camping!");
        System.exit(0);
        }
}