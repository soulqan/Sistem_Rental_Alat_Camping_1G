import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class bilingual {
    // tempat deklarasi mulai variabel biasa hingga array
    public static int NUM_PRODUCTS = 10;
    public static int jumlahPesanan = 0;
    static int[] nomorPesan = new int[100];
    static boolean telat = false, menu = true, bahasa = true;
    static Period keterlambatan;
    public static LocalDate tanggalPengembalian2;
    public static LocalDate tanggalPeminjaman;
    public static LocalDate tanggalPengembalian;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String[][] identitasMember = new String[100][3];
    public static String[][] member = new String[100][2];
    public static String[] riwayatNama = new String[100];
    public static String[] riwayatAlamat = new String[100];
    public static String[] riwayatNoHp = new String[100];
    public static String[][] riwayatBarang = new String[100][10];
    public static int[][] riwayatJumlah = new int[100][10];
    public static int[] riwayatEstimasi = new int[100];
    public static String[] statusPengembalian = new String[NUM_PRODUCTS];
    public static LocalDate[] riwayatTanggalPengembalian = new LocalDate[100];
    public static LocalDate[] riwayatTanggalPeminjaman = new LocalDate[100];
    public static int[] riwayatPengiriman = new int[100];
    public static long[] riwayatTotalHarga = new long[100];
    public static String[] produkid = { "Tenda camping", "Tas Gunung", "Sleeping Bag", "Kompor portable", "Alat memasak", "Senter", "Karpet tebal", "Obat obatan", "Pisau jelajah", "Sekop" };
    public static String[] productIng = {"Camping Tent", "Mountain Bag", "Sleeping Bag", "Portable Stove", "Cooking Utensils", "Flashlight", "Thick Carpet", "Medicine", "Hiking Knife", "Shovel"};
    public static int[] jumlahid = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
    public static long[] hargaid = { 250000, 75000, 60000, 20000, 40000, 15000, 30000, 15000, 10000, 20000 };
    public static long[] hargaOngkirid = { 1000, 30000 };
    public static String namaid, alamatid, masukkan, notelpid, user, password;
    public static String[] itemKeranjang = new String[NUM_PRODUCTS];
    public static int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
    public static long totalHarga = 0, saldo = 0, totalHargaFinal = 0, dendaTelat;
    public static int estimasi, pengiriman, saldoCst, hariTelat;
    public static int[] dendaHilang = { 2500000, 800000, 600000, 200000, 150000, 50000, 30000, 45000, 25000, 50000 };
    public static int[] dendaRusak = { 750000, 400000, 300000, 100000, 750000, 25000, 15000, 23000, 12000, 25000 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Bahasa Indonesia");
        System.out.println("2. English");
        System.out.print("Masukan pilihan bahasa: ");
        int bahasasc = scanner.nextInt();
        scanner.nextLine(); // consume newline not consumed by nextInt()

        if (bahasasc == 1) {
            bahasa = true;
        } else if (bahasasc == 2) {
            bahasa = false;
        }

        login(scanner);
    }

    // sebuah public static utama untuk login dan menampilkan menu
    public static void login(Scanner scanner) {
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|  Selamat datang di sistem rental alat camping  |");
            System.out.println("==================================================");
            System.out.print("Masukan username: ");
            user = scanner.nextLine();// untuk membaca sebuah user yang di masukkan
            System.out.print("Masukan password: ");
            password = scanner.nextLine();// untuk membaca sebuah password yang di masukkan
            for (int i = 0; i < member.length; i++) {
                if ((user.equalsIgnoreCase(member[i][0]) && password.equalsIgnoreCase(member[i][1]))
                        || (user.equalsIgnoreCase("customer") && (password.equalsIgnoreCase("123")))) {
                    System.out.println("==================================================");
                    System.out.println("|                 Login Berhasil                 |");
                    System.out.println("==================================================");
                    System.out.println("\n");
                    System.out.println("\t");
                    menu = true;
                    menu(scanner);

                } else if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
                    System.out.println("==================================================");
                    System.out.println("|             Login Berhasil (Admin)             |");
                    System.out.println("==================================================");
                    System.out.println("\n");
                    menu = false;
                    menu(scanner);
                } else {// apabila login tidak sesuai dengan kedua pemilihan maka pemilihan terakhir
                        // yang di gunakan
                    System.out.println("Login Gagal");
                    login(scanner);
                }
            }
        }

        if (!bahasa) {
            System.out.println("===================================================");
            System.out.println("| Welcome to the camping equipment rental system |");
            System.out.println("===================================================");
            System.out.print(" username: ");
            user = scanner.nextLine(); // Read the entered username
            System.out.print(" password: ");
            password = scanner.nextLine(); // Read the entered password

            for (int i = 0; i < member.length; i++) {
                if ((user.equalsIgnoreCase(member[i][0]) && password.equalsIgnoreCase(member[i][1]))
                        || (user.equalsIgnoreCase("customer") && (password.equalsIgnoreCase("123")))) {
                    System.out.println("==================================================");
                    System.out.println("|                 Login Successful               |");
                    System.out.println("==================================================");
                    System.out.println("\n");
                    System.out.println("\t");
                    menu = true;
                    menu(scanner);

                } else if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
                    // Another option that leads to the admin
                    System.out.println("==================================================");
                    System.out.println("|            Login Successful (Admin)            |");
                    System.out.println("==================================================");
                    System.out.println("\n");
                    menu = false;
                    menu(scanner);
                } else {
                    // If the login does not match the two options, then the last option is used

                    System.out.println("--- Login Failed ---");
                    login(scanner);
                }
            }

        }
    }

    // Method menu
    public static void menu(Scanner scanner) {
        int pilihan; // deklarasi untuk pilihan
        if (bahasa) {

            if (menu) {
                do {// apabila if sesuai maka akan di lakukan sebuah do while
                    System.out.println("==================================================");
                    System.out.println("|                   Menu Utama                   |");
                    System.out.println("==================================================");
                    System.out.println("\n1.Profil");
                    System.out.println("2.Persediaan alat camping");
                    System.out.println("3.Keranjang");
                    System.out.println("4.Hapus Produk Dari Keranjang ");
                    System.out.println("5.Peminjaman barang");
                    System.out.println("6.Opsi pengiriman");
                    System.out.println("7.Pembayaran");
                    System.out.println("8.Servis center");
                    System.out.println("9.Pengembalian barang");
                    System.out.println("10.Denda");
                    System.out.println("11.Membership");
                    System.out.println("12.Log Out");
                    System.out.println("13.Exit");
                    System.out.println();
                    System.out.println("==================================================");
                    System.out.print("Pilih Menu : ");
                    pilihan = scanner.nextInt();// untuk membaca inputan yang dimasukkan
                    scanner.nextLine();

                    switch (pilihan) {// sebuah fungsi switch case yag berguna untuk memilih method yang ingin dibuka
                                      // dengan sebuah inputan berupa angka
                        case 1:
                            Profil(scanner);// apabila pilihan yang di input itu 1 maka dia akan memanggil sebuah method
                                            // yaitu profil
                            break;
                        case 2:
                            persediaan(scanner);// apabila pilihan yang di input itu 2 maka dia akan memanggil sebuah
                                                // method
                                                // yaitu persediaan
                            break;
                        case 3:
                            Keranjang(scanner);// apabila pilihan yang di input itu 3 maka dia akan memanggil sebuah
                                               // method
                                               // yaitu keranjang
                            break;
                        case 4:
                            hapusProdukDariKeranjang(scanner); // apabila pilihan yang di input itu 4 maka dia akan
                                                               // memanggil sebuah method yaitu hapusProdukDariKeranjang
                            break;
                        case 5:
                            peminjamanBarang(scanner);// //apabila pilihan yang di input itu 5 maka dia akan memanggil
                                                      // sebuah method yaitu peminjamanBarang
                            break;
                        case 6:
                            pengiriman(scanner);// apabila pilihan yang di input itu 6 maka dia akan memanggil sebuah
                                                // method
                                                // yaitu pengiriman
                            break;
                        case 7:
                            pembayaran(scanner);// apabila pilihan yang di input itu 7 maka dia akan memanggil sebuah
                                                // method
                                                // yaitu pembayaran
                            break;
                        case 8:
                            service(scanner);// apabila pilihan yang di input itu 8 maka dia akan memanggil sebuah
                                             // method
                                             // yaitu service
                            break;
                        case 9:
                            pengembalian(scanner);// apabila pilihan yang di input itu 9 maka dia akan memanggil sebuah
                                                  // method yaitu pengembalian
                            break;
                        case 10:
                            denda(scanner);
                            break;
                        case 11:
                            membership(scanner);
                            break;
                        case 12:
                            LogOut(scanner);
                            break;
                        case 13:
                            exit();// apabila pilihan yang di input itu 10 maka dia akan memanggil sebuah method
                                   // yaitu exit
                            break;
                        default:// pilihan default
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (pilihan != 11);// ujung dari statement do-while
            }

            if (!menu) {

                do {
                    System.out.println("==================================================");
                    System.out.println("|                   Menu Utama                   |");
                    System.out.println("==================================================");
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
                    System.out.println("13.Riwayat Pemesanan");
                    System.out.println("14.Membership");
                    System.out.println("15.Log Out");
                    System.out.println("16.Exit");
                    System.out.println();
                    System.out.println("==================================================");
                    System.out.print("Pilih Menu : ");
                    pilihan = scanner.nextInt();
                    scanner.nextLine();

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
                            cetakRiwayatPemesanan();
                            break;
                        case 14:
                            membership(scanner);
                            break;
                        case 15:
                            LogOut(scanner);
                            break;
                        case 16:
                            exit();
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (pilihan != 15);
            }
        }

        if (!bahasa) {
            if (menu) {
                do {
                    // If 'menu' is true, execute a do-while loop
                    System.out.println("==================================================");
                    System.out.println("|                   Main Menu                    |");
                    System.out.println("==================================================");
                    System.out.println("\n1. Profile");
                    System.out.println("2. Camping Equipment Inventory");
                    System.out.println("3. Shopping Cart");
                    System.out.println("4. Remove Product from Cart");
                    System.out.println("5. Equipment Rental");
                    System.out.println("6. pengiriman Options");
                    System.out.println("7. Payment");
                    System.out.println("8. Service Center");
                    System.out.println("9. Equipment Return");
                    System.out.println("10. Fine");
                    System.out.println("11. Membership");
                    System.out.println("12. Log Out");
                    System.out.println("13. Exit");
                    System.out.println();
                    System.out.println("==================================================");
                    System.out.print("Select Menu : ");
                    pilihan = scanner.nextInt();
                    scanner.nextLine();
                    switch (pilihan) {// sebuah fungsi switch case yag berguna untuk memilih method yang ingin dibuka
                                      // dengan sebuah inputan berupa angka
                        case 1:
                            Profil(scanner);// apabila pilihan yang di input itu 1 maka dia akan memanggil sebuah method
                                            // yaitu profil
                            break;
                        case 2:
                            persediaan(scanner);// apabila pilihan yang di input itu 2 maka dia akan memanggil sebuah
                                                // method
                                                // yaitu persediaan
                            break;
                        case 3:
                            Keranjang(scanner);// apabila pilihan yang di input itu 3 maka dia akan memanggil sebuah
                                               // method
                                               // yaitu keranjang
                            break;
                        case 4:
                            hapusProdukDariKeranjang(scanner); // apabila pilihan yang di input itu 4 maka dia akan
                                                               // memanggil sebuah method yaitu hapusProdukDariKeranjang
                            break;
                        case 5:
                            peminjamanBarang(scanner);// //apabila pilihan yang di input itu 5 maka dia akan memanggil
                                                      // sebuah method yaitu peminjamanBarang
                            break;
                        case 6:
                            pengiriman(scanner);// apabila pilihan yang di input itu 6 maka dia akan memanggil sebuah
                                                // method
                                                // yaitu pengiriman
                            break;
                        case 7:
                            pembayaran(scanner);// apabila pilihan yang di input itu 7 maka dia akan memanggil sebuah
                                                // method
                                                // yaitu pembayaran
                            break;
                        case 8:
                            service(scanner);// apabila pilihan yang di input itu 8 maka dia akan memanggil sebuah
                                             // method
                                             // yaitu service
                            break;
                        case 9:
                            pengembalian(scanner);// apabila pilihan yang di input itu 9 maka dia akan memanggil sebuah
                                                  // method yaitu pengembalian
                            break;
                        case 10:
                            denda(scanner);
                            break;
                        case 11:
                            membership(scanner);
                            break;
                        case 12:
                            LogOut(scanner);
                            break;
                        case 13:
                            exit();// apabila pilihan yang di input itu 10 maka dia akan memanggil sebuah method
                                   // yaitu exit
                            break;
                        default:// pilihan default
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (pilihan != 11);// ujung dari statement do-while
            }
            if (!menu) {
                do {
                    System.out.println("==================================================");
                    System.out.println("|                    Main Menu                   |");
                    System.out.println("==================================================");
                    System.out.println("\n1. Profile");
                    System.out.println("2. Camping Equipment Inventory");
                    System.out.println("3. Shopping Cart");
                    System.out.println("4. Remove Product from Cart");
                    System.out.println("5. Equipment Rental");
                    System.out.println("6. pengiriman Options");
                    System.out.println("7. Payment");
                    System.out.println("8. Service Center");
                    System.out.println("9. Equipment Return");
                    System.out.println("10. Earnings and Feedback");
                    System.out.println("11. Add New Product");
                    System.out.println("12. Fine");
                    System.out.println("13. Order History");
                    System.out.println("14. Membership");
                    System.out.println("15. Log Out");
                    System.out.println("16. Exit");
                    System.out.println();
                    System.out.println("==================================================");
                    System.out.print("Select Menu : ");
                    pilihan = scanner.nextInt();
                    scanner.nextLine();
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
                            cetakRiwayatPemesanan();
                            break;
                        case 14:
                            membership(scanner);
                            break;
                        case 15:
                            LogOut(scanner);
                            break;
                        case 16:
                            exit();
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (pilihan != 15);
            }
        }
    }

    // Method untuk profil
    public static void Profil(Scanner scanner) {// (Scanner scanner) berfungsi untuk mendeklarasikan scanner yang ada
                                                // pada method tersebut itu ganti dari ddeklarasi scanner pada umum nya
                                                // pada method tersebut itu ganti dari ddeklarasi scanner pada umum nya
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|                 Profil Customer                |");
            System.out.println("==================================================");
            boolean memberid = true;
            for (int i = 0; i < member.length; i++) {
                if (user.equalsIgnoreCase(member[i][0]) && (password.equalsIgnoreCase(member[i][1]))) {
                    memberid = false;
                    System.out.println("Nama: " + identitasMember[i][0]);
                    System.out.println("Alamat: " + identitasMember[i][1]);
                    System.out.println("No HP: " + identitasMember[i][2]);
                    System.out.println("Selamat berbelanja sebagai member!");
                    namaid = identitasMember[i][0];
                    alamatid = identitasMember[i][1];
                    notelpid = identitasMember[i][2];
                    break;
                }
            }
            if (memberid) {
                System.out.print("Nama    :");
                namaid = scanner.nextLine();
                System.out.print("Alamat  :");
                alamatid = scanner.nextLine();
                System.out.print("No.Telp :");
                notelpid = scanner.nextLine();
                System.out.println("==================================================");
                System.out.println("Apakah anda sudah memiliki membership?");
                System.out.println("[Y] Ya / [N] Tidak");
                System.out.println("==================================================");
                System.out.print("pilihan: ");
                String pilihanMember = scanner.nextLine();
                if (pilihanMember.equalsIgnoreCase("n")) {
                    System.out.println("Apakah anda ingin join member?");
                    System.out.println("[Y] Ya / [N] Tidak");
                    System.out.println("==================================================");
                    System.out.print("pilihan: ");
                    String pilihanJoin = scanner.nextLine();
                    if (pilihanJoin.equalsIgnoreCase("y")) {
                        membership(scanner);
                    } else {
                        System.out.println("Selamat berbelanja sebagai customer reguler!");
                    }
                } else if (pilihanMember.equalsIgnoreCase("y")) {
                    main(itemKeranjang);
                }
            }
            System.out.println("==================================================");
            System.out.println("Tekan enter untuk ke menu selanjutnya...");
            System.out.println("Tekan selain enter untuk ke menu utama...");
            String input = scanner.nextLine();
            if (input.isEmpty()) { // Jika input kosong (hanya enter)
                persediaan(scanner);
            } else {

                // Kembali ke menu utama atau lakukan apa yang diperlukan
            }

        }
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                Customer Profile                |");
            System.out.println("==================================================");
            boolean isMemberId = true;

            for (int i = 0; i < member.length; i++) {
                if (user.equalsIgnoreCase(member[i][0]) && password.equalsIgnoreCase(member[i][1])) {
                    isMemberId = false;
                    System.out.println("Name: " + identitasMember[i][0]);
                    System.out.println("Address: " + identitasMember[i][1]);
                    System.out.println("Phone Number: " + identitasMember[i][2]);
                    System.out.println("Welcome, enjoy shopping as a member!");
                    namaid = identitasMember[i][0];
                    alamatid = identitasMember[i][1];
                    notelpid = identitasMember[i][2];
                    break;
                }
            }

            if (isMemberId) {
                System.out.print("Name    :");
                namaid = scanner.nextLine();
                System.out.print("Address  :");
                alamatid = scanner.nextLine();
                System.out.print("Phone Number :");
                notelpid = scanner.nextLine();

                System.out.println("==================================================");
                System.out.println("Do you already have a membership?");
                System.out.println("[Y] Yes / [N] No");
                System.out.println("==================================================");
                System.out.print("Choice: ");
                String memberChoice = scanner.nextLine();

                if (memberChoice.equalsIgnoreCase("n")) {
                    System.out.println("Do you want to join as a member?");
                    System.out.println("[Y] Yes / [N] No");
                    System.out.println("==================================================");
                    System.out.print("Choice: ");
                    String joinChoice = scanner.nextLine();

                    if (joinChoice.equalsIgnoreCase("y")) {
                        membership(scanner);
                    } else {
                        System.out.println("Welcome, enjoy shopping as a regular customer!");
                    }
                } else if (memberChoice.equalsIgnoreCase("y")) {
                    main(itemKeranjang);
                }
            }

            System.out.println("==================================================");
            System.out.println("Press Enter to proceed to the next menu...");
            System.out.println("Press any key other than Enter to return to the main menu...");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                persediaan(scanner);
            } else {
                // Return to the main menu or perform other actions as needed
            }

        }
    }

    // method untuk persediaan alat camping
    public static void persediaan(Scanner scanner) {
        if (bahasa) {
            System.out.println("=======================================================");
            System.out.println("|                   Persediaan Alat                   |");
            System.out.println("=======================================================");
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
        if (!bahasa) {
            System.out.println("=======================================================");
            System.out.println("|             Camping Equipment Inventory             |");
            System.out.println("=======================================================");
            System.out.println("------------------------------------------------------");
            System.out.printf("%-20s %-10s %-15s\n", "Name", "Available", "Price");
            System.out.println("------------------------------------------------------");

            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (jumlahid[i] == 0) {
                    System.out.printf("%-20s %-10s %-15s\n", productIng[i], "Sold out", hargaid[i]);
                } else {
                    System.out.printf("%-20s %-10d %-15d\n", productIng[i], jumlahid[i], hargaid[i]);
                }
            }
            System.out.println("------------------------------------------------------");

            System.out.println("\nPress Enter to proceed to the next menu...");
            System.out.println("Press any key other than Enter to return to the main menu...");

            String input = scanner.nextLine();
            if (input.isEmpty()) { // If the input is empty (only Enter)
                Keranjang(scanner);
            } else {
                // Return to the main menu or perform other necessary actions
            }

        }
    }

    // Method untuk keranjang
    public static void Keranjang(Scanner scanner) {
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|                     keranjang                  |");
            System.out.println("==================================================");
            System.out.println("Masukkan barang yang akan disewa:");
            String barang = scanner.nextLine();// inputan barang

            int indexBarang = -1;// deklarasi untuk sebuah indexBarang yang bernilai -1
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (produkid[i].equalsIgnoreCase(barang)) {// apabila isi dari array produkid sama dengan input barang
                                                           // maka
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
                    jmlBarangKeranjang[indexBarang] += jumlahBarang;// nilai awal array jumlahBarangKeranjang akan
                                                                    // ditambah
                                                                    // sama dengan jumlahBarang
                    totalHarga += hargaid[indexBarang] * jumlahBarang;// nilai awal total harga akan ditambah sama
                                                                      // dengan
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
                peminjamanBarang(scanner);
            } else if (input.equalsIgnoreCase("b")) {
                Keranjang(scanner);
            } else {

                // Kembali ke menu utama atau lakukan apa yang diperlukan
            }
        }
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                  Shopping Cart                 |");
            System.out.println("==================================================");
            System.out.println("Enter the item to rent:");
            String item = scanner.nextLine(); // item input

            int itemIndex = -1; // declaration for an itemIndex with a value of -1
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (productIng[i].equalsIgnoreCase(item)) { // if the content of the produkid array is the same as the
                                                          // input item, then
                                                          // it will be executed
                    itemIndex = i; // item index is changed to i, which is 0
                    break;
                }
            }
            if (itemIndex == -1) { // if the item index is -1, then this program will be executed
                System.out.println("Product not found");
            } else if (jumlahid[itemIndex] == 0) { // if the jumlahid array is 0, then it will execute the program
                System.out.println("Sold out");
            } else { // if there is no match with the previous selections, then this program will be
                     // executed
                System.out.println("Enter the quantity of the item to rent:");
                int itemQuantity = scanner.nextInt(); // used to input with the name itemQuantity
                scanner.nextLine();
                if (itemQuantity > jumlahid[itemIndex]) { // if itemQuantity is greater than the jumlahid array, then it
                                                          // will
                                                          // execute that program
                    System.out.println("Insufficient quantity for the selected item");
                } else { // if there are no suitable selections, then execute this program
                    itemKeranjang[itemIndex] = item; // the itemKeranjang array is filled with items
                    jmlBarangKeranjang[itemIndex] += itemQuantity; // the initial value of the jmlBarangKeranjang array
                                                                   // will be added
                                                                   // by itemQuantity
                    totalHarga += hargaid[itemIndex] * itemQuantity; // the initial value of the total cost will be
                                                                     // added by the
                                                                     // hargaid array multiplied by itemQuantity

                    jumlahid[itemIndex] -= itemQuantity; // the initial value of the jumlahid array will be subtracted
                                                         // by
                                                         // itemQuantity that is input
                    System.out.println("Item has been added to the cart");
                }
            }

            System.out.println("--------------------------------------------");
            System.out.println("\nPress enter to go to the next menu...");
            System.out.println("Press B to order again...");
            System.out.println("Press any other key to go to the main menu...");

            String input = scanner.nextLine();
            if (input.isEmpty()) { // If the input is empty (only enter)
                peminjamanBarang(scanner);
            } else if (input.equalsIgnoreCase("b")) {
                Keranjang(scanner);
            } else {
                // Return to the main menu or do what is needed
            }

        }
    }

    // method hapus barang dari keranjang
    public static void hapusProdukDariKeranjang(Scanner scanner) {
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|          Hapus Produk Dari Keranjang           |");
            System.out.println("==================================================");
            System.out.print("Masukan nama produk: ");
            String productName = scanner.nextLine();

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
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|            Remove Product From Cart            |");
            System.out.println("==================================================");
            System.out.print("Enter the product name: ");
            String productName = scanner.nextLine();

            int productIndex = -1;
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (itemKeranjang[i] != null && itemKeranjang[i].equalsIgnoreCase(productName)) {
                    productIndex = i;
                    break;
                }
            }
            if (productIndex == -1) {
                System.out.println("Product not found.");
            } else {
                System.out.print("Enter the quantity of the product: ");
                int quantityToRemove = scanner.nextInt();

                if (quantityToRemove > jmlBarangKeranjang[productIndex]) {
                    System.out.println("Invalid quantity.");
                } else {
                    jmlBarangKeranjang[productIndex] -= quantityToRemove;
                    totalHarga -= hargaid[productIndex] * quantityToRemove;

                    jumlahid[productIndex] += quantityToRemove;
                    System.out.println("Product has been removed from the cart.");
                    return;
                }
            }

        }
    }

    // Method untuk peminjaman barang
    public static void peminjamanBarang(Scanner scanner) {
        if (bahasa) {
            // Menampilkan judul layar untuk proses peminjaman barang
            System.out.println("==================================================");
            System.out.println("|               Peminjaman Barang                |");
            System.out.println("==================================================");

            // Menampilkan informasi bahwa peminjaman dihitung per hari
            System.out.println("Peminjaman Dihitung Perhari");

            // Meminta estimasi hari peminjaman dari pengguna
            System.out.println("Berapa hari anda ingin meminjam barang? ");
            estimasi = scanner.nextInt(); // Membaca input jumlah hari
            System.out.println("Estimasi Waktu Peminjaman : " + estimasi + " hari");

            // Menerima input tanggal peminjaman dari pengguna
            System.out.print("Masukkan Tanggal Peminjaman (dd/MM/yyyy): ");
            String inputTanggalPeminjaman = scanner.next(); // Membaca input tanggal
            // Parsing input tanggal peminjaman menjadi objek LocalDate

            tanggalPeminjaman = LocalDate.parse(inputTanggalPeminjaman, formatter);
            System.out.println("Tanggal Peminjaman: " + tanggalPeminjaman.format(formatter)); // Menampilkan tanggal
                                                                                              // peminjaman

            // Menghitung dan menampilkan tanggal pengembalian berdasarkan estimasi hari
            tanggalPengembalian = tanggalPeminjaman.plusDays(estimasi);
            System.out.println("Tanggal Pengembalian: " + tanggalPengembalian.format(formatter));

            // Memberikan instruksi kepada pengguna untuk melanjutkan atau kembali ke menu
            // utama
            System.out.println("------------------------------------------");
            System.out.println("\nTekan enter untuk ke menu selanjutnya...");
            System.out.println("Tekan selain enter untuk ke menu utama...");

            // Membaca input dari pengguna untuk menentukan aksi selanjutnya
            String input = scanner.nextLine(); // Membersihkan karakter baru yang tersisa
            input = scanner.nextLine(); // Membaca input pengguna
            if (input.isEmpty()) {
                pengiriman(scanner); // Jika input kosong (hanya enter), lanjut ke menu pengiriman
            } else {

                // Kembali ke menu utama atau lakukan apa yang diperlukan sesuai dengan logika
                // yang belum diimplementasikan di sini
            }
        }
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                  Rental Item                   |");
            System.out.println("==================================================");

            // Display information that rental is calculated per day
            System.out.println("Rental Calculated Per Day");

            // Ask for the estimated rental days from the user
            System.out.println("How many days do you want to rent the item? ");
            estimasi = scanner.nextInt(); // Read input number of days
            System.out.println("Rental Time Estimate: " + estimasi + " days");

            // Receive input for the rental date from the user
            System.out.print("Enter Rental Date (dd/MM/yyyy): ");
            String inputTanggalPeminjaman = scanner.next(); // Read input date
            // Parse the input rental date into a LocalDate object
            tanggalPeminjaman = LocalDate.parse(inputTanggalPeminjaman, formatter);
            System.out.println("Rental Date: " + tanggalPeminjaman.format(formatter)); // Display rental date

            // Calculate and display the return date based on the estimated days
            tanggalPengembalian = tanggalPeminjaman.plusDays(estimasi);
            System.out.println("Return Date: " + tanggalPengembalian.format(formatter));

            // Provide instructions to the user to proceed or go back to the main menu
            System.out.println("------------------------------------------");
            System.out.println("\nPress enter to go to the next menu...");
            System.out.println("Press any key other than enter to go back to the main menu...");

            // Read input from the user to determine the next action
            String input = scanner.nextLine(); // Clear any remaining new line characters
            input = scanner.nextLine(); // Read user input
            if (input.isEmpty()) {
                pengiriman(scanner); // If the input is empty (only enter), proceed to the pengiriman menu
            } else {
                // Return to the main menu or perform what is needed based on the logic
                // not implemented here
            }

        }
    }

    // method untuk opsi pengiriman
    public static void pengiriman(Scanner scanner) {
        if (bahasa) {
            System.out.println("=======================================================");
            System.out.println("|                      Pengiriman                     |");
            System.out.println("=======================================================");
            System.out.println("1. Ambil Di tempat   :1000 \n2. Kurir             :30000");
            System.out.print("Masukkan opsi pengiriman: ");
            pengiriman = scanner.nextInt();
            if (pengiriman == 1) {
                pengiriman = 0;
                System.out.println("Pengiriman sudah di tentukan");
            } else if (pengiriman == 2) {
                pengiriman = 1;
                System.out.println("Pengiriman sudah di tentukan");
            } else {
                System.out.println("Opsi pengiriman tidak valid. Silakan pilih opsi yang valid.");
            }
            System.out.println("------------------------------------------");
            System.out.println("\nTekan enter untuk ke menu selanjutnya...");
            System.out.println("Tekan selain enter untuk ke menu utama...");

            String input = scanner.nextLine();
            input = scanner.nextLine();
            if (input.isEmpty()) { // Jika input kosong (hanya enter)
                pembayaran(scanner);
            } else {

                // Kembali ke menu utama atau lakukan apa yang diperlukan
            }
        }
        if (!bahasa) {
            System.out.println("=======================================================");
            System.out.println("|                       Shipping                      |");
            System.out.println("=======================================================");
            System.out.println("1. Pick Up In-Store   : 1000 \n2. Courier            : 30000");
            System.out.print("Enter shipping option: ");
            pengiriman = scanner.nextInt();
            if (pengiriman == 1) {
                pengiriman = 0;
                System.out.println("Shipping option has been selected");
            } else if (pengiriman == 2) {
                pengiriman = 1;
                System.out.println("Shipping option has been selected");
            } else {
                System.out.println("Invalid shipping option. Please choose a valid option.");
            }
            System.out.println("------------------------------------------");
            System.out.println("\nPress enter to go to the next menu...");
            System.out.println("Press any key other than enter to go back to the main menu...");

            String input = scanner.nextLine();
            input = scanner.nextLine();
            if (input.isEmpty()) { // If the input is empty (only enter)
                pembayaran(scanner);
            } else {
                // Return to the main menu or perform what is needed
            }

        }
    }

    // Logika pembayaran
    public static void pembayaran(Scanner scanner) {
        boolean bayar=true;
        if (!bahasa) {
            System.out.println("=======================================================");
            System.out.println("|                   Payment Details                   |");
            System.out.println("=======================================================");
            if (namaid != null) {
                System.out.println("Name    : " + namaid);
                System.out.println("Address : " + alamatid);
                System.out.println("Phone Number : " + notelpid);
                System.out.println("=======================================================");
                System.out.printf("%-20s %-10s %-10s %-10s\n", "Product", "Amount", "Price", "Estimate");

                boolean adaBarangDalamKeranjang = false; // Menambahkan variabel ini untuk mengecek apakah ada barang
                                                         // dalam
                                                         // keranjang

                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                        System.out.printf("%-20s %-10d %-10d %-10s\n", itemKeranjang[i], jmlBarangKeranjang[i],
                                hargaid[i],
                                estimasi);
                        adaBarangDalamKeranjang = true;
                    }
                }
                System.out.println("=======================================================");
                System.out.println("Shipping Cost   : " + hargaOngkirid[pengiriman]);
                System.out.println("Rental Date     : " + tanggalPeminjaman.format(formatter));
                System.out.println("Return Date     : " + tanggalPengembalian.format(formatter));
                System.out.println("=======================================================");

                if (adaBarangDalamKeranjang) {
                    double diskon = 0;
                    totalHargaFinal = totalHarga * estimasi + hargaOngkirid[pengiriman];
                    for (int i = 0; i < 1; i++) {
                        if (user.equalsIgnoreCase(member[i][0]) && (password.equalsIgnoreCase(member[i][1]))) {
                            diskon += (0.1 * totalHargaFinal);
                            System.out.println(
                                    "You get a 10% discount because you are now a member");
                            System.out.println("---------------------------------------------------");
                            System.out.println("Total price before discount: " + totalHargaFinal);
                            System.out.println("Total price after discount: " + (totalHargaFinal - (int) diskon));
                            System.out.println("---------------------------------------------------");
                        } else if (user.equalsIgnoreCase("customer") && password.equalsIgnoreCase("123")
                                || user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
                            System.out.println("Total price: " + totalHargaFinal);
                        }
                    }
                    System.out.println("Do you want to pay the amount as listed? (y/n)");
                    String jawaban = scanner.nextLine();
                    if (jawaban.equalsIgnoreCase("y")) {
                        System.out.println("Enter your amount");
                        saldoCst = scanner.nextInt();
                        

                        if (saldoCst == (totalHargaFinal - (int) diskon)) {
                            System.out.println("Your money is enough");
                            saldo += ((totalHargaFinal - (int) diskon));
                        } else if (saldoCst > (totalHargaFinal - (int) diskon)) {
                            System.out.println("\nPress enter to see your remaining money");
                            String input = scanner.nextLine();
                            input = scanner.nextLine();
                            if (input.isEmpty()) { // Jika input kosong (hanya enter)
                                System.out.println(
                                        "Your change money : " + (saldoCst - (totalHargaFinal - (int) diskon)));
                                        saldo += ((totalHargaFinal - (int) diskon));
                            } else {
                                // ga ambil kembalian
                                System.out.println(
                                        "Your remaining balance: " + (saldoCst - (totalHargaFinal - (int) diskon)));
                                        saldo += ((totalHargaFinal - (int) diskon));
                            }
                        } else {
                            System.out.println(
                                    "Your money is not enough" + (saldoCst - (totalHargaFinal - (int) diskon)));
                                    bayar=false;
                        }
                        if (saldoCst == (totalHargaFinal - (int) diskon)
                                || saldoCst > (totalHargaFinal - (int) diskon)) {
                            System.out.println("---------------------------------------------------");
                            System.out.println("Payment Successful, your remaining balance is "
                                    + (saldoCst - (totalHargaFinal - (int) diskon)));
                            System.out.println("---------------------------------------------------");
                        }
                    }else{
                        System.out.println("Sorry, your payment is not valid.");
                        bayar=false;
                    }
                }
            } else {
                System.out.println("Please fill in your identity first.");
                System.out.println("\n\n");
            }
        }
        if (bahasa) {
            System.out.println("=======================================================");
            System.out.println("|                  Rincian Pembayaran                 |");
            System.out.println("=======================================================");
            if (namaid != null) {
                System.out.println("Nama   : " + namaid);
                System.out.println("Alamat : " + alamatid);
                System.out.println("No.Telp: " + notelpid);
                System.out.println("=======================================================");
                System.out.printf("%-20s %-10s %-10s %-10s\n", "Produk", "Jumlah", "Harga", "Estimasi");

                boolean adaBarangDalamKeranjang = false; // Menambahkan variabel ini untuk mengecek apakah ada barang
                                                         // dalam
                                                         // keranjang

                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                        System.out.printf("%-20s %-10d %-10d %-10s\n", itemKeranjang[i], jmlBarangKeranjang[i],
                                hargaid[i],
                                estimasi);
                        adaBarangDalamKeranjang = true;
                    }
                }
                System.out.println("=======================================================");
                System.out.println("Harga Ongkir : " + hargaOngkirid[pengiriman]);
                System.out.println("Tanggal Peminjaman: " + tanggalPeminjaman.format(formatter));
                System.out.println("Tanggal Pengembalian: " + tanggalPengembalian.format(formatter));
                System.out.println("=======================================================");

                if (adaBarangDalamKeranjang) {
                    double diskon = 0;
                    totalHargaFinal = totalHarga * estimasi + hargaOngkirid[pengiriman];
                    for (int i = 0; i < 1; i++) {
                        if (user.equalsIgnoreCase(member[i][0]) && (password.equalsIgnoreCase(member[i][1]))) {
                            diskon += (0.1 * totalHargaFinal);
                            System.out.println(
                                    "Anda mendapatkan diskon sebesar 10% karena sekarang anda adalah anggota member");
                            System.out.println("---------------------------------------------------");
                            System.out.println("Total harga Awal: " + totalHargaFinal);
                            System.out.println("Total harga potongan: " + (totalHargaFinal - (int) diskon));
                            System.out.println("---------------------------------------------------");
                        } else if (user.equalsIgnoreCase("customer") && password.equalsIgnoreCase("123")
                                || user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
                            System.out.println("Total harga: " + totalHargaFinal);
                        }
                    }
                    System.out.println("Apakah anda ingin membayar sesuai harga yang tertera? (y/n)");
                    String jawaban = scanner.nextLine();
                    if (jawaban.equalsIgnoreCase("y")) {
                        System.out.println("masukkan jumlah uang anda");
                        saldoCst = scanner.nextInt();
                        

                        if (saldoCst == (totalHargaFinal - (int) diskon)) {
                            System.out.println("uang anda pas");
                            saldo += ((totalHargaFinal - (int) diskon));
                        } else if (saldoCst > (totalHargaFinal - (int) diskon)) {
                            System.out.println("\nTekan enter untuk melihat sisa uang anda");
                            String input = scanner.nextLine();
                            input = scanner.nextLine();
                            if (input.isEmpty()) { // Jika input kosong (hanya enter)
                                System.out.println(
                                        "Uang kembalian Anda: " + (saldoCst - (totalHargaFinal - (int) diskon)));
                                        saldo += ((totalHargaFinal - (int) diskon));
                            } else {
                                // ga ambil kembalian
                                System.out.println("Sisa uang Anda: " + (saldoCst - (totalHargaFinal - (int) diskon)));
                                saldo += ((totalHargaFinal - (int) diskon));
                            }
                        } else {
                            System.out.println("Uang Anda kurang" + (saldoCst - (totalHargaFinal - (int) diskon)));
                            bayar=false;
                        }
                        if (saldoCst == (totalHargaFinal - (int) diskon)
                                || saldoCst > (totalHargaFinal - (int) diskon)) {
                            System.out.println("---------------------------------------------------");
                            System.out.println("Pembayaran Berhasil, sisa uang anda adalah "
                                    + (saldoCst - (totalHargaFinal - (int) diskon)));
                            System.out.println("---------------------------------------------------");
                        }
                    }else{
                        System.out.println("Maaf, pembayaran Anda tidak valid.");
                        bayar=false;
                    }
                }
            } else {
                System.out.println("Silahkan isi identitas terlebih dahulu.");
                System.out.println("\n\n");
            }
        }
        if (bayar) {
        riwayatNama[jumlahPesanan] = namaid;
        riwayatAlamat[jumlahPesanan] = alamatid;
        riwayatNoHp[jumlahPesanan] = notelpid;
        riwayatEstimasi[jumlahPesanan] = estimasi;
        riwayatPengiriman[jumlahPesanan] = pengiriman;
        riwayatTotalHarga[jumlahPesanan] = totalHargaFinal;
        riwayatTanggalPeminjaman[jumlahPesanan] = tanggalPeminjaman;
        riwayatTanggalPengembalian[jumlahPesanan] = tanggalPengembalian;

        for (int i = 0; i < itemKeranjang.length; i++) {
            riwayatBarang[jumlahPesanan][i] = itemKeranjang[i];
            riwayatJumlah[jumlahPesanan][i] = jmlBarangKeranjang[i];

        }

        jumlahPesanan++;

        nomorPesan[jumlahPesanan - 1] = jumlahPesanan;

        namaid = null;
        alamatid = null;
        notelpid = null;
        estimasi = 0;
        pengiriman = 0;
        totalHarga = 0;
        totalHargaFinal = 0;
        itemKeranjang = new String[NUM_PRODUCTS];
        jmlBarangKeranjang = new int[NUM_PRODUCTS];
        tanggalPeminjaman = null;
        tanggalPengembalian = null;
    }
    }

    // method untuk service center
    public static void service(Scanner scanner) {
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                Customer Service                |");
            System.out.println("==================================================");
            System.out.println("Do you have a problem? Contact us via:");
            System.out.println("Phone Number: 082178174040");
            System.out.println("Email: hanifahkurniasari0512@gmail.com");
            System.out.println("Do you want to provide feedback?(y/n)");
            String masukan = scanner.nextLine();

            if (masukan.equals("y")) {
                System.out.println("Please let us know what you want: ");
                masukkan = scanner.nextLine();
                System.out.println("Thank you for providing feedback");
            } else {

            }
        }
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|                Customer Service                |");
            System.out.println("==================================================");
            System.out.println("Ada masalah? Hubungi kami melalui:");
            System.out.println("No. Telpon : 082178174040");
            System.out.println("email      : hanifahkurniasari0512@gmail.com");
            System.out.println("ingin memberi masukkan?(y/n)");
            String masukan = scanner.nextLine();

            if (masukan.equals("y")) {
                System.out.println("Beri tahu kami apa yang anda inginkan: ");
                masukkan = scanner.nextLine();
                System.out.println("terima kasih telah memberi masukkan");
            } else {

            }
        }
    }

    public static void pengembalian(Scanner scanner) {
        // Menampilkan judul dan pilihan untuk pengembalian barang
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                   Return Items                 |");
            System.out.println("==================================================");
            System.out.println("Do you want to return all items? (y/n)");
            String kembali = scanner.next();

            if (kembali.equalsIgnoreCase("y")) {
                // Menampilkan daftar pesanan yang tersedia untuk pengembalian
                System.out.println("List of Orders Available for Return:");
                for (int i = 0; i < jumlahPesanan; i++) {
                    if (nomorPesan[i] == 0) {

                    } else {
                        System.out.println("Order Number : " + (nomorPesan[i]));
                    }
                    // Tampilkan informasi lainnya yang relevan jika diperlukan
                }

                // Meminta pengguna memilih nomor pesanan yang ingin dikembalikan
                System.out.print("Select the order number you want to return: ");
                int nomorPesanan = scanner.nextInt();

                // Memastikan nomor pesanan yang dipilih valid

                if (nomorPesanan <= 0 || nomorPesanan != nomorPesan[nomorPesanan - 1]) {
                    System.out.println("Order number is not valid.");
                    return;
                }

                // Ambil informasi dari array riwayat peminjaman sesuai nomor pesanan yang
                // dipilih
                String[] barangDipinjam = riwayatBarang[nomorPesanan - 1];
                int[] jumlahDipinjam = riwayatJumlah[nomorPesanan - 1];
                LocalDate estimasiPeminjaman = riwayatTanggalPengembalian[nomorPesanan - 1];
                dendaTelat = riwayatTotalHarga[nomorPesanan - 1];

                // Menampilkan informasi pesanan sesuai nomor yang dipilih
                System.out.println("Information for Order Number " + nomorPesanan + ":");
                System.out.println("-------------------------------------");
                System.out.println("Items       :");
                for (int i = 0; i < barangDipinjam.length; i++) {
                    if (barangDipinjam[i] != null) {
                        System.out.println("   - " + barangDipinjam[i] + " (Quantity: " + jumlahDipinjam[i] + ")");
                        jumlahid[i] += jumlahDipinjam[i];
                    }
                }
                System.out.println(
                        "--if the item is damaged or if the item is lost please press ENTER to report it to us-- \n--if not press ANYTHING to continue the return process--");
                String input1 = scanner.nextLine();
                input1 = scanner.nextLine();
                if (input1.isEmpty()) { // Jika input kosong (hanya enter)
                    denda(scanner);
                    ;
                } else {

                    System.out.println("-------------------------------------");
                    // Meminta pengguna memasukkan tanggal pengembalian
                    System.out.print("\nEnter the return date (dd/MM/yyyy): ");
                    String tanggalKembali = scanner.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    tanggalPengembalian2 = LocalDate.parse(tanggalKembali, formatter);

                    nomorPesan[nomorPesanan - 1] = 0;

                    // Perbandingan tanggal pengembalian dengan estimasi waktu peminjaman
                    if (estimasiPeminjaman.isEqual(tanggalPengembalian2)) {
                        // Barang dikembalikan tepat waktu
                        System.out.println("You have returned the item on time.");
                    } else if (estimasiPeminjaman.isBefore(tanggalPengembalian2)) {
                        // Barang dikembalikan terlambat
                        System.out.println("You are late in returning the item.");
                        telat = true;
                        keterlambatan = Period.between(estimasiPeminjaman, tanggalPengembalian2);
                        int tahunKeterlambatan = keterlambatan.getYears();
                        int bulanKeterlambatan = keterlambatan.getMonths();
                        int hariKeterlambatan = keterlambatan.getDays();
                        hariTelat = (tahunKeterlambatan * 365) + (bulanKeterlambatan * 30) + hariKeterlambatan;
                        System.out.println("Press enter to go to the Fines menu");
                        String input = scanner.nextLine();
                        input = scanner.nextLine();
                        if (input.isEmpty()) { // Jika input kosong (hanya enter)
                            denda(scanner);
                        }
                    } else {
                        // Barang dikembalikan sebelum waktu yang ditentukan
                        System.out.println("You have returned the item before the specified time.");
                    }
                    // untuk perintah pada status
                    if (estimasiPeminjaman.isEqual(tanggalPengembalian2)
                            || estimasiPeminjaman.isAfter(tanggalPengembalian2)) {
                        // Barang dikembalikan tepat waktu atau sebelumnya
                        statusPengembalian[nomorPesanan - 1] = "You have returned the item on time.";
                    } else {
                        // Barang dikembalikan terlambat
                        statusPengembalian[nomorPesanan - 1] = "You have returned the item past the due date.";
                    }
                }
            }
        }
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|              Pengembalian Barang               |");
            System.out.println("==================================================");
            System.out.println("Apakah Anda Ingin Mengembalikan Semua Barang? (y/n)");
            String kembali = scanner.next();

            if (kembali.equalsIgnoreCase("y")) {
                // Menampilkan daftar pesanan yang tersedia untuk pengembalian
                System.out.println("Daftar Pesanan yang Tersedia untuk Pengembalian:");
                for (int i = 0; i < jumlahPesanan; i++) {
                    if (nomorPesan[i] == 0) {

                    } else {
                        System.out.println("Nomor Pesanan: " + (nomorPesan[i]));
                    }
                    // Tampilkan informasi lainnya yang relevan jika diperlukan
                }

                // Meminta pengguna memilih nomor pesanan yang ingin dikembalikan
                System.out.print("Pilih nomor pesanan yang ingin Anda kembalikan: ");
                int nomorPesanan = scanner.nextInt();

                // Memastikan nomor pesanan yang dipilih valid

                if (nomorPesanan <= 0 || nomorPesanan != nomorPesan[nomorPesanan - 1]) {
                    System.out.println("Nomor pesanan tidak valid.");
                    return;
                }

                // Ambil informasi dari array riwayat peminjaman sesuai nomor pesanan yang
                // dipilih
                String[] barangDipinjam = riwayatBarang[nomorPesanan - 1];
                int[] jumlahDipinjam = riwayatJumlah[nomorPesanan - 1];
                LocalDate estimasiPeminjaman = riwayatTanggalPengembalian[nomorPesanan - 1];
                dendaTelat = riwayatTotalHarga[nomorPesanan - 1];

                // Menampilkan informasi pesanan sesuai nomor yang dipilih
                System.out.println("Informasi Pesanan Nomor " + nomorPesanan + ":");
                System.out.println("-------------------------------------");
                System.out.println("Barang       :");
                for (int i = 0; i < barangDipinjam.length; i++) {
                    if (barangDipinjam[i] != null) {
                        System.out.println("   - " + barangDipinjam[i] + " (Jumlah: " + jumlahDipinjam[i] + ")");
                        jumlahid[i] += jumlahDipinjam[i];
                    }
                }
                System.out.println(
                        "--jika barang dalam keadaan rusak atau jika barang hilang silahkan tekan ENTER untuk melaporkannya pada kami-- \n--jika tidak tekan SELAIN ENTER untuk melanjutkan proses pengembalian--");
                String input1 = scanner.nextLine();
                input1 = scanner.nextLine();
                if (input1.isEmpty()) { // Jika input kosong (hanya enter)
                    denda(scanner);
                    ;
                } else {

                    System.out.println("-------------------------------------");
                    // Meminta pengguna memasukkan tanggal pengembalian
                    System.out.print("\nMasukkan tanggal pengembalian (dd/MM/yyyy): ");
                    String tanggalKembali = scanner.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    tanggalPengembalian2 = LocalDate.parse(tanggalKembali, formatter);

                    nomorPesan[nomorPesanan - 1] = 0;

                    // Perbandingan tanggal pengembalian dengan estimasi waktu peminjaman
                    if (estimasiPeminjaman.isEqual(tanggalPengembalian2)) {
                        // Barang dikembalikan tepat waktu
                        System.out.println("Anda telah mengembalikan barang tepat waktu.");
                    } else if (estimasiPeminjaman.isBefore(tanggalPengembalian2)) {
                        // Barang dikembalikan terlambat
                        System.out.println("Anda telat mengembalikan barang.");
                        telat = true;
                        keterlambatan = Period.between(estimasiPeminjaman, tanggalPengembalian2);
                        int tahunKeterlambatan = keterlambatan.getYears();
                        int bulanKeterlambatan = keterlambatan.getMonths();
                        int hariKeterlambatan = keterlambatan.getDays();
                        hariTelat = (tahunKeterlambatan * 365) + (bulanKeterlambatan * 30) + hariKeterlambatan;
                        System.out.println("Tekan enter untuk ke menu denda");
                        String input = scanner.nextLine();
                        input = scanner.nextLine();
                        if (input.isEmpty()) { // Jika input kosong (hanya enter)
                            denda(scanner);
                        }
                    } else {
                        // Barang dikembalikan sebelum waktu yang ditentukan
                        System.out.println("Anda telah mengembalikan barang sebelum waktu yang ditentukan.");
                    }
                    // untuk perintah pada status
                    if (estimasiPeminjaman.isEqual(tanggalPengembalian2)
                            || estimasiPeminjaman.isAfter(tanggalPengembalian2)) {
                        // Barang dikembalikan tepat waktu atau sebelumnya
                        statusPengembalian[nomorPesanan - 1] = "Dikembalikan tepat waktu";
                    } else {
                        // Barang dikembalikan terlambat
                        statusPengembalian[nomorPesanan - 1] = "Dikembalikan terlambat";
                    }
                }
            }
        }
    }

    // method untuk pendapatan
    public static void pendapatan() {
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|               Income & Feedback                |");
            System.out.println("==================================================");
            System.out.println("                  Cek pendapatan                 ");
            System.out.println("          Your Income is Rp. " + saldo);
            System.out.println("==================================================");
            System.out.println("feedback:" + masukkan);
        }
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|             Pendapatan & Feedback              |");
            System.out.println("==================================================");
            System.out.println("               Cek pendapatan                   ");
            System.out.println("       pendapatan Anda adalah Rp. " + saldo);
            System.out.println("==================================================");
            System.out.println("feedback:" + masukkan);
        }
    }

    // method tambah barang
    public static void tambahBarang(Scanner scanner) {
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                Product Addition                |");
            System.out.println("==================================================");
            System.out.print("Do you need to add a new product? (y/n): ");
            String tambahBarang = scanner.next();

            if (tambahBarang.equalsIgnoreCase("y")) {
                if (NUM_PRODUCTS >= productIng.length) {
                    int newLengthid = productIng.length + 1;

                    String[] newProductIng = new String[newLengthid];
                    int[] newJumlahid = new int[newLengthid];
                    long[] newHargaid = new long[newLengthid];
                    String[] newItem = new String[newLengthid];
                    int[] newJmlBarang = new int[newLengthid];

                    for (int i = 0; i < NUM_PRODUCTS; i++) {
                        newProductIng[i] = productIng[i];
                        newJumlahid[i] = jumlahid[i];
                        newHargaid[i] = hargaid[i];
                        newItem[i] = itemKeranjang[i];
                        newJmlBarang[i] = jmlBarangKeranjang[i];

                    }

                    productIng = newProductIng;
                    jumlahid = newJumlahid;
                    hargaid = newHargaid;
                    jmlBarangKeranjang = newJmlBarang;
                    itemKeranjang = newItem;
                }

                System.out.print("Enter the name of the new product: ");
                String namaBarangBaru = scanner.nextLine();
                namaBarangBaru = scanner.nextLine();

                int indexBarang = -1;
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (productIng[i].equalsIgnoreCase(namaBarangBaru)) {
                        indexBarang = i;
                        break;
                    }
                }

                if (indexBarang != -1) {
                    System.out.print("The product is already in the inventory. Enter the new quantity: ");
                    int jumlahBarangBaru = scanner.nextInt();
                    jumlahid[indexBarang] += jumlahBarangBaru;

                    System.out.print("Enter the new price of the product: ");
                    long hargaBarangBaru = scanner.nextLong();
                    hargaid[indexBarang] = hargaBarangBaru;

                    System.out.println("Quantity and price of product successfully updated.");
                } else {
                    System.out.print("Enter the quantity of the product: ");
                    int jumlahBarangBaru = scanner.nextInt();

                    System.out.print("Enter the price of the new product: ");
                    long hargaBarangBaru = scanner.nextLong();

                    productIng[NUM_PRODUCTS] = namaBarangBaru;
                    jumlahid[NUM_PRODUCTS] = jumlahBarangBaru;
                    hargaid[NUM_PRODUCTS] = hargaBarangBaru;

                    NUM_PRODUCTS++;

                    System.out.println("New product successfully added to inventory.");
                }
            } else {
                System.out.println("Product addition canceled.");
            }
        }
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|               Penambahan Barang                |");
            System.out.println("==================================================");
            System.out.print("perlu menambahkan barang baru? (y/n): ");
            String tambahBarang = scanner.next();

            if (tambahBarang.equalsIgnoreCase("y")) {
                if (NUM_PRODUCTS >= produkid.length) {
                    int newLengthid = produkid.length + 1;

                    String[] newProdukid = new String[newLengthid];
                    int[] newJumlahid = new int[newLengthid];
                    long[] newHargaid = new long[newLengthid];
                    String[] newItem = new String[newLengthid];
                    int[] newJmlBarang = new int[newLengthid];

                    for (int i = 0; i < NUM_PRODUCTS; i++) {
                        newProdukid[i] = produkid[i];
                        newJumlahid[i] = jumlahid[i];
                        newHargaid[i] = hargaid[i];
                        newItem[i] = itemKeranjang[i];
                        newJmlBarang[i] = jmlBarangKeranjang[i];

                    }

                    produkid = newProdukid;
                    jumlahid = newJumlahid;
                    hargaid = newHargaid;
                    jmlBarangKeranjang = newJmlBarang;
                    itemKeranjang = newItem;
                }

                System.out.print("Masukkan nama barang baru: ");
                String namaBarangBaru = scanner.nextLine();
                namaBarangBaru = scanner.nextLine();

                int indexBarang = -1;
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (produkid[i].equalsIgnoreCase(namaBarangBaru)) {
                        indexBarang = i;
                        break;
                    }
                }

                if (indexBarang != -1) {
                    System.out.print("Barang sudah ada dalam inventaris. Masukkan jumlah barang baru: ");
                    int jumlahBarangBaru = scanner.nextInt();
                    jumlahid[indexBarang] += jumlahBarangBaru;

                    System.out.print("Masukkan harga barang baru: ");
                    long hargaBarangBaru = scanner.nextLong();
                    hargaid[indexBarang] = hargaBarangBaru;

                    System.out.println("Jumlah dan harga barang berhasil diperbarui.");
                } else {
                    System.out.print("Masukkan jumlah barang yang tersedia: ");
                    int jumlahBarangBaru = scanner.nextInt();

                    System.out.print("Masukkan harga barang baru: ");
                    long hargaBarangBaru = scanner.nextLong();

                    produkid[NUM_PRODUCTS] = namaBarangBaru;
                    jumlahid[NUM_PRODUCTS] = jumlahBarangBaru;
                    hargaid[NUM_PRODUCTS] = hargaBarangBaru;

                    NUM_PRODUCTS++;

                    System.out.println("Barang baru berhasil ditambahkan ke persediaan.");
                }
            } else {
                System.out.println("Penambahan barang dibatalkan.");

            }
        }
    }

    public static void denda(Scanner scanner) {
        if (!bahasa) {
            String back;
            boolean denda = true, notelat = true;
            while (denda) {
                System.out.println("==================================================");
                System.out.println("|                      Fines                    |");
                System.out.println("==================================================");
                System.out.println("1. Late return items");
                System.out.println("2. Lost Items");
                System.out.println("3. Damaged Items");
                System.out.println("4. Exit ");
                System.out.print("\nChoices : ");
                int pilihanDenda = scanner.nextInt();

                if (pilihanDenda == 1) {
                    if (telat) {
                        System.out.println("You are late to return the item for: " + hariTelat + " days");
                        long terlambat = dendaTelat * hariTelat;
                        System.out.println("The late fee you must pay is: " + terlambat);
                        System.out.println("Enter the amount you want to pay: ");
                        long jumlahDenda = scanner.nextLong();
                        if (jumlahDenda >= terlambat) {
                            System.out.println("The late fee has been paid.");
                            System.out.println("Your change is: " + (jumlahDenda - terlambat));
                            saldo += jumlahDenda;
                            telat = false;
                        } else {
                            System.out.println("The amount you entered is not enough");
                            telat = true;
                        }
                        notelat = false;
                    }
                    if (notelat) {
                        System.out.println("There are no late items, please return the items first.");
                    }
                } else if (pilihanDenda == 2) {
                    System.out.println("=====================================");
                    System.out.println("|    list of fines for lost items   |");
                    System.out.println("=====================================");
                    System.out.println("Fines list : \n");
                    for (int i = 0; i < dendaHilang.length; i++) {
                        System.out.printf("%-20s %-10d\n", productIng[i], dendaHilang[i]);
                        System.out.println();
                    }
                    System.out.println("What items are lost?");
                    String hilang = scanner.nextLine();
                    hilang = scanner.nextLine();

                    boolean found = false;
                    for (int i = 0; i < dendaHilang.length; i++) {
                        if (hilang.equalsIgnoreCase(productIng[i])) {
                            System.out.println("You must pay for the loss of the item's value " + dendaHilang[i]);
                            found = true;
                            System.out.println("Enter the amount of money you want to pay: ");
                            long bayar = scanner.nextLong();
                            if (bayar >= dendaHilang[i]) {
                                System.out.println(
                                        "Your payment is successful, your change is:" + (bayar - dendaHilang[i]));
                                saldo += dendaHilang[i];
                                jumlahid[i] -= 1;
                            } else {
                                System.out.println("Your money is not enough, your payment is invalid");
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("The item is not found in the lost and found list");
                    }

                    System.out.println("Do you want the fine for the mistake back? (y/n)");
                    back = scanner.next();
                    if (back.equalsIgnoreCase("y")) {

                    } else {
                        denda = false;
                    }
                } else if (pilihanDenda == 3) {
                    System.out.println("=====================================");
                    System.out.println("|  List of fines for damaged items  |");
                    System.out.println("=====================================");
                    for (int i = 0; i < productIng.length; i++) {
                        System.out.println(productIng[i]);
                    }
                    System.out.println("--------------------------------------");
                    System.out.println("What items are damaged?");
                    String rusak = scanner.nextLine();
                    rusak = scanner.nextLine();
                    for (int i = 0; i < dendaRusak.length; i++) {
                        if (rusak.equalsIgnoreCase(productIng[i])) {
                            System.out.println("The fine for the damaged item is " + dendaRusak[i]);
                            System.out.println("Enter the amount you paid: ");
                            long bayarDenda = scanner.nextLong();
                            if (bayarDenda >= dendaRusak[i]) {
                                System.out.println("Payment successful, your change is: "
                                        + (bayarDenda - dendaRusak[i]));
                                saldo += dendaRusak[i];
                                jumlahid[i] -= 1;
                            } else {
                                System.out.println("Your payment is invalid!");
                            }
                        }
                    }
                    System.out.println("Do you want the fine for the mistake back? (y/n)");
                    back = scanner.next();
                    if (back.equalsIgnoreCase("y")) {

                    } else {
                        denda = false;

                    }
                } else if (pilihanDenda == 4) {
                    denda = false;

                }
            }
        }
        if (bahasa) {
            String back;
            boolean denda = true, notelat = true;
            while (denda) {
                System.out.println("==================================================");
                System.out.println("|                      Denda                     |");
                System.out.println("==================================================");
                System.out.println("1. Telat mengembalikan barang");
                System.out.println("2. Kehilangan barang");
                System.out.println("3. Kerusakan barang");
                System.out.println("4. Keluar ");
                System.out.print("\nPilihan : ");
                int pilihanDenda = scanner.nextInt();

                if (pilihanDenda == 1) {
                    if (telat) {
                        System.out.println("Anda telat mengembalikan barang selama: " + hariTelat + " hari");
                        long terlambat = dendaTelat * hariTelat;
                        System.out.println("denda yang harus anda bayar kan adalah: " + terlambat);
                        System.out.println("Masukkan jumlah uang yang ingin anda bayarkan: ");
                        long jumlahDenda = scanner.nextLong();
                        if (jumlahDenda >= terlambat) {
                            System.out.println("Denda telah dibayarkan.");
                            System.out.println("Kembalian anda adalah: " + (jumlahDenda - terlambat));
                            saldo += jumlahDenda;
                            telat = false;
                        } else {
                            System.out.println("Jumlah yang anda masukkan tidak cukup");
                            telat = true;
                        }
                        notelat = false;
                    }
                    if (notelat) {
                        System.out
                                .println(
                                        "Tidak ada barang yang terlambat, silahkan mengembalikan barang terlebih dahulu.");
                    }
                } else if (pilihanDenda == 2) {
                    System.out.println("=====================================");
                    System.out.println("|   List denda barang yang hilang   |");
                    System.out.println("=====================================");
                    System.out.println("List denda : \n");
                    for (int i = 0; i < dendaHilang.length; i++) {
                        System.out.printf("%-20s %-10d\n", produkid[i], dendaHilang[i]);
                        System.out.println();
                    }
                    System.out.println("Barang apa saja yang hilang?");
                    String hilang = scanner.nextLine();
                    hilang = scanner.nextLine();

                    boolean found = false;
                    for (int i = 0; i < dendaHilang.length; i++) {
                        if (hilang.equalsIgnoreCase(produkid[i])) {
                            System.out.println(
                                    "Anda harus membayar kehilangan barang tersebut senilai " + dendaHilang[i]);
                            found = true;
                            System.out.println("Masukkan uang yang ingin anda bayarkan: ");
                            long bayar = scanner.nextLong();
                            if (bayar >= dendaHilang[i]) {
                                System.out.println(
                                        "Pembayaran anda Berhasil, kembalian anda: " + (bayar - dendaHilang[i]));
                                saldo += dendaHilang[i];
                                jumlahid[i] -= 1;
                            } else {
                                System.out.println("Uang anda kurang, Pembayaran anda invalid");
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Barang tidak ditemukan dalam daftar kehilangan.");
                    }

                    System.out.println("Apakah anda ingin denda kesalahan kembali? (y/n)");
                    back = scanner.next();
                    if (back.equalsIgnoreCase("y")) {

                    } else {
                        denda = false;
                    }
                } else if (pilihanDenda == 3) {
                    System.out.println("=====================================");
                    System.out.println("|    List denda barang yang rusak   |");
                    System.out.println("=====================================");
                    for (int i = 0; i < produkid.length; i++) {
                        System.out.println(produkid[i]);
                    }
                    System.out.println("--------------------------------------");
                    System.out.println("Barang apa saja yang rusak?");
                    String rusak = scanner.nextLine();
                    rusak = scanner.nextLine();
                    for (int i = 0; i < dendaRusak.length; i++) {
                        if (rusak.equalsIgnoreCase(produkid[i])) {
                            System.out.println("Denda kerusakan yang harus anda bayar sebesar " + dendaRusak[i]);
                            System.out.println("Masukkan nilai yang anda bayarkan: ");
                            long bayarDenda = scanner.nextLong();
                            if (bayarDenda >= dendaRusak[i]) {
                                System.out.println("Pembayaran telah berhasil, kembalian anda adalah: "
                                        + (bayarDenda - dendaRusak[i]));
                                saldo += dendaRusak[i];
                                jumlahid[i] -= 1;
                            } else {
                                System.out.println("Pembayaran anda tidak valid!");
                            }
                        }
                    }
                    System.out.println("Apakah anda ingin denda kesalahan kembali? (y/n)");
                    back = scanner.next();
                    if (back.equalsIgnoreCase("y")) {

                    } else {
                        denda = false;

                    }
                } else if (pilihanDenda == 4) {
                    denda = false;

                }
            }
        }
    }

    public static void membership(Scanner scanner) {
        if (!bahasa) {
            System.out.println("==================================================");
            System.out.println("|                   Membership                  |");
            System.out.println("==================================================");
            boolean join = true;
            for (int i = 0; i < member.length; i++) {
                if ((user.equalsIgnoreCase(member[i][0]) && password.equalsIgnoreCase(member[i][1]))) {
                    System.out.println("You've already as a member");
                    join = false;
                    break;
                }
            }
            if (join) {
                if (namaid != null) {
                    System.out.println("Name: " + namaid);
                    System.out.println("Address: " + alamatid);
                    System.out.println("Phone Number: " + notelpid);
                    for (int i = 0; i < identitasMember.length; i++) {
                        identitasMember[i][0] = namaid;
                        identitasMember[i][1] = alamatid;
                        identitasMember[i][2] = notelpid;
                    }
                    System.out.print("Enter your new username: ");
                    String userMember = scanner.nextLine();
                    System.out.print("Enter your new password: ");
                    String passwordMember = scanner.nextLine();
                    for (int i = 0; i < member.length; i++) {
                        member[i][0] = userMember;
                        member[i][1] = passwordMember;
                    }
                    double diskon = 0.1;
                    System.out.println("\nCongratulations! You have successfully registered as a member.");
                    System.out.println("Thank you, " + namaid + "! You will get a discount of " + (diskon * 100)
                            + "% \non your next purchase by entering \nyour member username and password.");
                    System.out.println("==================================================");
                    System.out.println("      Entering Username & Password again     ");
                    login(scanner);
                } else {
                    System.out.println("Please fill out your profile first!");
                    Profil(scanner);
                }
            }

        }
        if (bahasa) {
            System.out.println("==================================================");
            System.out.println("|                   Membership                  |");
            System.out.println("==================================================");
            boolean join = true;
            for (int i = 0; i < member.length; i++) {
                if ((user.equalsIgnoreCase(member[i][0]) && password.equalsIgnoreCase(member[i][1]))) {
                    System.out.println("Anda sudah menjadi member!");
                    join = false;
                    break;
                }
            }
            if (join) {
                if (namaid != null) {
                    System.out.println("Nama: " + namaid);
                    System.out.println("Alamat: " + alamatid);
                    System.out.println("No.Hp: " + notelpid);
                    for (int i = 0; i < identitasMember.length; i++) {
                        identitasMember[i][0] = namaid;
                        identitasMember[i][1] = alamatid;
                        identitasMember[i][2] = notelpid;
                    }
                    System.out.print("Masukkan username baru anda: ");
                    String userMember = scanner.nextLine();
                    System.out.print("Masukkan password baru anda: ");
                    String passwordMember = scanner.nextLine();
                    for (int i = 0; i < member.length; i++) {
                        member[i][0] = userMember;
                        member[i][1] = passwordMember;
                    }
                    double diskon = 0.1;
                    System.out.println("\nSelamat! Anda berhasil bergabung sebagai anggota.");
                    System.out.println("Terima kasih, " + namaid + "! Anda mendapatkan diskon " + (diskon * 100)
                            + "% \npada pembelian berikutnya dengan memasukkan \nusername dan password member anda.");
                    System.out.println("==================================================");
                    System.out.println("      Memasukkan Username & Password kembali     ");
                    login(scanner);
                } else {
                    System.out.println("Silahkan isi profil terlebih dahulu!");
                    Profil(scanner);
                }
            }
        }
    }

    // Method untuk Log Out
    public static void LogOut(Scanner scanner) {
        if (!bahasa) {
            System.out.println("Do you want to log out? (y/n) ");
            String logout = scanner.next();
            if (logout.equalsIgnoreCase("y")) {
                System.out.println("See you later!");
                System.out.println();
                System.out.println();
                main(new String[] {});
            } else if (logout.equalsIgnoreCase("n")) {

            } else {
                System.out.println("Invalid Choices");
                LogOut(scanner);
            }
        }
        if (bahasa) {
            System.out.println("Apakah anda ingin Log Out? (y/n) ");
            String logout = scanner.next();
            if (logout.equalsIgnoreCase("y")) {
                System.out.println("Sampai jumpa lagi !");
                System.out.println();
                System.out.println();
                main(new String[] {});
            } else if (logout.equalsIgnoreCase("n")) {

            } else {
                System.out.println("pilihan tidak tersedia");
                LogOut(scanner);
            }
        }
    }

    // method riwayat pesanan
    public static void cetakRiwayatPemesanan() {
        if (!bahasa) {
            System.out.println("=======================================");
            System.out.println("|             Order History           |");
            System.out.println("=======================================");
            for (int i = 0; i < jumlahPesanan; i++) {
                System.out.println("---------------------------------------");
                System.out.println("Order Number: " + (i + 1));
                System.out.println("Name: " + riwayatNama[i]);
                System.out.println("Address: " + riwayatAlamat[i]);
                System.out.println("Phone Number: " + riwayatNoHp[i]);
                System.out.println("Items:");
                for (int j = 0; j < riwayatBarang[i].length; j++) {
                    if (riwayatBarang[i][j] != null) {
                        System.out.println("   - " + riwayatBarang[i][j] + " (Jumlah: " + riwayatJumlah[i][j] + ")");
                    }
                }
                System.out.println("Estimated Days: " + riwayatEstimasi[i]);
                System.out.println("Rental Date: " + riwayatTanggalPeminjaman[i].format(formatter));
                System.out.println("Return Date: " + riwayatTanggalPengembalian[i].format(formatter));
                System.out.println("Shipping: " + (riwayatPengiriman[i] == 1 ? "Courier" : "Pick Up"));
                System.out.println("---------------------------------------");
                System.out.println("Total Price: " + riwayatTotalHarga[i]);
                System.out.println("---------------------------------------");
                if (statusPengembalian[i] != null) {
                    System.out.println("Return status: " + statusPengembalian[i]);
                } else {
                    System.out.println("Return Status: Not Returned");
                }
                System.out.println("---------------------------------------");
            }
        }
        if (bahasa) {
            System.out.println("=======================================");
            System.out.println("|          Riwayat Pemesanan          |");
            System.out.println("=======================================");
            for (int i = 0; i < jumlahPesanan; i++) {
                System.out.println("---------------------------------------");
                System.out.println("Nomor Pesanan: " + (i + 1));
                System.out.println("Nama         : " + riwayatNama[i]);
                System.out.println("Alamat       : " + riwayatAlamat[i]);
                System.out.println("No. HP       : " + riwayatNoHp[i]);
                System.out.println("Barang       :");
                for (int j = 0; j < riwayatBarang[i].length; j++) {
                    if (riwayatBarang[i][j] != null) {
                        System.out.println("   - " + riwayatBarang[i][j] + " (Jumlah: " + riwayatJumlah[i][j] + ")");
                    }
                }
                System.out.println("Estimasi Hari: " + riwayatEstimasi[i]);
                System.out.println("Tanggal Peminjaman: " + riwayatTanggalPeminjaman[i].format(formatter));
                System.out.println("Tanggal Pengembalian: " + riwayatTanggalPengembalian[i].format(formatter));
                System.out.println("Pengiriman   : " + (riwayatPengiriman[i] == 1 ? "Kurir" : "Ambil Di Tempat"));
                System.out.println("---------------------------------------");
                System.out.println("Total Harga  : " + riwayatTotalHarga[i]);
                System.out.println("---------------------------------------");
                if (statusPengembalian[i] != null) {
                    System.out.println("Status Pengembalian: " + statusPengembalian[i]);
                } else {
                    System.out.println("Status Pengembalian: Belum Dikembalikan");
                }
                System.out.println("---------------------------------------");
            }
        }
    }

    // method exit
    public static void exit() {
        System.out.println("Thank you for using the camping rental system!");
        System.exit(0);
    }
}