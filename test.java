import java.util.Scanner;
public class test {
    public static int NUM_PRODUCTS = 10;
    public static String []produk ={"Tenda camping","Tas Gunung","Slepping Bag","Kompor portable","cooking set","FlashLight", "Karpet tebal", "product8", "Product9", "Product10"};
    public static int [] jumulah={5,5,5,5,5,5,5,5,5,5};
    public static long[] harga = {250000, 0000, 0000, 0000, 0000, 0000, 0000, 0000, 0000, 0000};
    public static String nama,alamat;
    public static long notelp;



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
                    persediaan();  
                    break;
                case 3:
                    Keranjang(scanner);
                    break;
                case 4:
                    peminjamanBarang();
                    break;
                case 5:
                    pengiriman();
                    break;
                case 6:
                    pembayaran();
                    break;
                case 7 :
                    service();
                    break;
                case 8 :
                    pengembalian();
                case 9 :
                    pendapatan(scanner);
                case 10:
                    exit();
                    break;
                default:  
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (pilihan != 10);

        scanner.close();}

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
        public static void persediaan(){
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
                        //itemKeranjang[indexBarang]=barang;
                        //jmlBarangKeranjang[indexBarang]+=jumlahBarang;
                        //totalHarga += harga[indexBarang]*jumlahBarang;

                        jumulah[indexBarang] -= jumlahBarang;
                        System.out.println("barang telah dimasukkan kedalam keranjang");
                    }
                     
                    }



        }

        //Method untuk peminjaman barang
        public static void peminjamanBarang(){

        }
        
        //method untuk opsi pengiriman
        public static void pengiriman(){

        }

        //method untuk pembayaran
        public static void pembayaran() {
            
        }
        // method untuk service center
        public static void service() {
            System.out.println("=================================================");
            System.out.println("                 Customer Service                ");
            System.out.println("=================================================");
            System.out.println();
            System.out.println();
            System.out.println();
        }
        // method untuk pengembalian barang
        public static void pengembalian(){

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
			System.out.println("                    pendapatan          ");
            System.out.println("=================================================");
            System.out.println();  
        }else {
            System.out.println("Username atau password anda salah");
        }
        
}
public static void exit() {
    System.out.println("Thank you for using Alat Rental Camping. Goodbye!");
    
}
}
