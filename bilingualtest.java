import java.util.Scanner;
public class bilingualtest {
    
    public static int NUM_PRODUCTS = 10;
    public static String[] produk = { "Camping Tent", "Mountain Backpack", "Sleeping Bag", "Portable Stove", "Cooking Set", "Flashlight", "Thick Carpet", "Product 8", "Product 9", "Product 10" };
    public static int[] jumlah = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
    public static long[] harga = { 250000, 35000, 0, 0, 0, 0, 0, 0, 0, 0 };
    public static long[] hargaOngkir = { 15000, 30000 };
    public static String nama, alamat, input, notelp;
    public static String[] cartItems = new String[NUM_PRODUCTS];
    public static int[] cartItemQuantities = new int[NUM_PRODUCTS];
    public static long totalPrice = 0, balance = 0, deliveryCost, finalTotalPrice = 0;
    public static int estimate, deliveryOption;
    public static String[] produkid = { "Tenda camping", "Tas Gunung", "Slepping Bag", "Kompor portable", "Cooking set", "FlashLight", "Karpet tebal", "product8", "Product9", "Product10" };
    public static int[] jumlahid = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
    public static long[] hargaid = { 250000, 35000, 0000, 0000, 0000, 0000, 0000, 0000, 0000, 0000 };
    public static long[] hargaOngkirid = { 15000, 30000 };
    public static String namaid, alamatid, masukkan, notelpid;
    public static String[] itemKeranjang = new String[NUM_PRODUCTS];
    public static int[] jmlBarangKeranjang = new int[NUM_PRODUCTS];
    public static long totalHarga = 0, saldo = 0, biayaPengiriman, totalHargaFinal = 0;
    public static int estimasi, pengiriman;
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("1. Bahasa Indonesia \n2. English Language");
        System.out.println("Select Language: ");
        int bahasa= scanner.nextInt();
        if (bahasa == 1) {
            mainid(args);
        }else if (bahasa ==2 ) {
            maineng(args);     
        }
    
    }

    public static void maineng(String[] args) {
        
        System.out.println("=================================================");
        System.out.println("  Welcome to the Camping Equipment Rental System  ");
        System.out.println("=================================================");
        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        user =scanner.nextLine();
        System.out.print("Enter password: ");
        int password = scanner.nextInt();

        if ((user.equalsIgnoreCase("customer")) && (password == 123) || user.equalsIgnoreCase("admin") && (password == 123)) {

            System.out.println("\n               Login Successful              ");
            System.out.println("\n");

            int choice;
            do {
                System.out.println("=================================================");
                System.out.println("                   Main Menu                   ");
                System.out.println("=================================================");
                System.out.println("\n1. Profile");
                System.out.println("2. Camping Equipment Inventory");
                System.out.println("3. Cart");
                System.out.println("4. Remove Product from Cart");
                System.out.println("5. Rent Equipment");
                System.out.println("6. Delivery Options");
                System.out.println("7. Payment");
                System.out.println("8. Customer Service");
                System.out.println("9. Return Equipment");
                System.out.println("10. Earnings and Feedback");
                System.out.println("11. Add New Item");
                System.out.println("12. Exit");
                System.out.print("\nSelect an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Profile(scanner);
                        break;
                    case 2:
                        Inventory(scanner);
                        break;
                    case 3:
                        Cart(scanner);
                        break;
                    case 4:
                        removeProduct(scanner);
                        break;
                    case 5:
                        RentEquipment(scanner);
                        break;
                    case 6:
                        DeliveryOptions(scanner);
                        break;
                    case 7:
                        Payment(scanner);
                        break;
                    case 8:
                        CustomerService(scanner);
                        break;
                    case 9:
                        ReturnEquipment(scanner);
                        break;
                    case 10:
                        EarningsAndFeedback(scanner);
                        break;
                    case 11:
                        AddNewItem(scanner);
                        break;
                    case 12:
                        Exit();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 12);

            scanner.close();
        } else {
            System.out.println("Login Failed");
            main(args);
        }
    }

    // Method for profile
    public static void Profile(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                 Customer Profile                 ");
        System.out.println("=================================================");
        System.out.print("Name    : ");
        nama = scanner.nextLine();
        nama = scanner.nextLine();
        System.out.print("Address : ");
        alamat = scanner.nextLine();
        System.out.print("Phone No: ");
        notelp = scanner.nextLine();
        System.out.println("=================================================");

    }

    // Method for camping equipment inventory
    public static void Inventory(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("            Camping Equipment Inventory           ");
        System.out.println("=================================================");
        System.out.println("Name\t\tAvailable\tPrice");

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            System.out.print(produk[i] + "\t");
            if (jumlah[i] == 0) {
                System.out.print("Sold out\t");
            } else {
                System.out.print(jumlah[i] + "\t\t");
            }
            System.out.println(harga[i]);
        }
        System.out.println("\nSelect an option to continue:");
        System.out.println("1. Cart\n2. Main Menu");
        int next = scanner.nextInt();
        if (next == 1) {
            Cart(scanner);
        } else if (next == 2) {

        } else {
            System.out.println("Option not available.");
            Inventory(scanner);
        }

    }

    // Method for the cart
    public static void Cart(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                    Cart                 ");
        System.out.println("=================================================");
        System.out.println("Enter the item to be rented:");
        String item = scanner.nextLine();
        item = scanner.nextLine();

        int itemIndex = -1;
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (produk[i].equalsIgnoreCase(item)) {
                itemIndex = i;
                break;
            }
        }
        if (itemIndex == -1) {
            System.out.println("Item not found");
        } else if (jumlah[itemIndex] == 0) {
            System.out.println("Sold out");
        } else {
            System.out.println("Enter the quantity to rent:");
            int quantity = scanner.nextInt();

            if (quantity > jumlah[itemIndex]) {
                System.out.println("Insufficient quantity available");
            } else {
                cartItems[itemIndex] = item;
                cartItemQuantities[itemIndex] += quantity;
                totalPrice += harga[itemIndex] * quantity;

                jumlah[itemIndex] -= quantity;
                System.out.println("Item added to the cart.");
            }

        }

    }
    //method untuking menghapus barang yang ada di keranjang
    public static void removeProduct(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("           Remove Product From Cart                 ");
        System.out.println("=================================================");
        System.out.print("Enter the product name: ");
        String productNameing = scanner.nextLine();
        productNameing= scanner.nextLine();

        int productindexing = -1;
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (cartItems[i] != null && cartItems[i].equalsIgnoreCase(productNameing)) {
                productindexing = i;
                break;
            }
        }

        if (productindexing == -1) {
            System.out.println("Product not found in cart.");
        } else {
            System.out.print("Enter the quantity: ");
            int jmlMasuking = scanner.nextInt();

            if (jmlMasuking > cartItemQuantities[productindexing]) {
                System.out.println("Invalid Amount.");
            } else {
                cartItemQuantities[productindexing] -= jmlMasuking;
                totalPrice -= harga[productindexing] * jmlMasuking;

                jumlah[productindexing] += jmlMasuking;
                System.out.println("Product Has been Remove from Cart.");
            }
        }
    }

    // Method for renting equipment
    public static void RentEquipment(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("            Rent Equipment               ");
        System.out.println("=================================================");
        System.out.println("*Rental is calculated per day*");
        System.out.println("Enter Rental Duration (days):");
        estimate = scanner.nextInt();
    }

    // Method for delivery options
    public static void DeliveryOptions(Scanner scanner) {
        System.out.println("======================================================");
        System.out.println("                Delivery Options                ");
        System.out.println("======================================================");
        System.out.println("1. JNT \n2. JNE");
        System.out.print("Select a delivery option: ");
        deliveryOption = scanner.nextInt();
        if (deliveryOption == 1) {
            deliveryOption = 0;
        }
        if (deliveryOption == 2) {
            deliveryOption = 1;
        }

        if (deliveryOption == 1 || deliveryOption == 2) {
            System.out.println("Delivery option set");
        } else {
            System.out.println("Invalid delivery option. Please select a valid option.");
        }
    }

    // Payment logic
    public static void Payment(Scanner scanner) {
        System.out.println("======================================================");
        System.out.println("            Payment Details                ");
        System.out.println("======================================================");
        System.out.println("Name   : " + nama);
        System.out.println("Address: " + alamat);
        System.out.println("Phone No: " + notelp);
        System.out.println("======================================================");
        System.out.println("Product\t\tQuantity\t\tPrice\t\tEstimate\tDelivery");

        boolean itemsInCart = false;

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (cartItems[i] != null && cartItemQuantities[i] > 0) {
                System.out.print(cartItems[i] + "\t");
                System.out.print(cartItemQuantities[i] + "\t\t");
                System.out.print(harga[i] + "\t\t");
                System.out.print(estimate + "\t\t");
                System.out.println(hargaOngkir[deliveryOption]);

                itemsInCart = true;
            }
        }

        if (itemsInCart) {
            finalTotalPrice = totalPrice * estimate + hargaOngkir[deliveryOption];
            System.out.println("Total Price: " + finalTotalPrice);
            System.out.println("Would you like to proceed with the displayed price? (y/n)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                balance += finalTotalPrice;
                System.out.println("Payment Successful");
            } else {
                System.out.println("Payment not valid");
            }
        } else {
            System.out.println("Your cart is empty. Please add items to the cart first.");
        }
        System.out.println("Thank you!");
    }

    // Method for customer service
    public static void CustomerService(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                 Customer Service                ");
        System.out.println("=================================================");
        System.out.println("Experiencing issues? Contact us at:");
        System.out.println("Phone No: 082178174040");
        System.out.println("Email   : hanifahkurniasari0512@gmail.com");
        System.out.println("Want to provide feedback? (y/n)");
        input = scanner.nextLine();
        input = scanner.nextLine();
        if (input.equals("y")) {
            System.out.println("Provide your feedback: ");
            input = scanner.nextLine();
            System.out.println("Thank you for your feedback!");
        } else if (input.equals("n")) {

        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Method for returning equipment
    public static void ReturnEquipment(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("              Return Equipment               ");
        System.out.println("=================================================");
        System.out.println("Do you want to return all items? (y/n)");
        input = scanner.next();

        if (input.equalsIgnoreCase("y")) {
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (cartItems[i] != null && cartItemQuantities[i] > 0) {
                    // Returning all items in the cart
                    jumlah[i] += cartItemQuantities[i];
                    totalPrice -= harga[i] * cartItemQuantities[i];
                    cartItemQuantities[i] = 0;
                }
            }
            System.out.println("All items have been returned successfully.");
        } else {
            System.out.println("Thank you!");
        }
    }

    // Method for earnings
    public static void EarningsAndFeedback(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("            Earnings and Feedback               ");
        System.out.println("=================================================");
        System.out.print("Enter username: ");
        String user = scanner.next();
        System.out.print("Enter password: ");
        int password = scanner.nextInt();

        if ((user.equalsIgnoreCase("admin")) && (password == 123)) {

            System.out.println("\n               Login Successful              ");
            System.out.println("\n");
            System.out.println("=================================================");
            System.out.println("            Check Earnings                ");
            System.out.println("Your earnings are Rp. " + balance);
            System.out.println("=================================================");
            System.out.println("Feedback: " + input);
        } else {
            System.out.println("Invalid username or password.");
        }

    }

    // Method to add a new item
    public static void AddNewItem(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("              Add New Item               ");
        System.out.println("=================================================");
        System.out.print("Enter username: ");
        String user = scanner.next();
        System.out.print("Enter password: ");
        int password = scanner.nextInt();

        if ((user.equalsIgnoreCase("admin")) && (password == 123)) {

            System.out.println("\n               Login Successful              ");
            System.out.println("\n");
            // Check if the produk array is full
            // Ensure that the length of the array is always greater than or equal to NUM_PRODUCTS
            if (NUM_PRODUCTS >= produk.length) {
                // If it's full, create a new array with a larger size
                int newLength = produk.length + 1;

                String[] newProduk = new String[newLength];
                int[] newJumlah = new int[newLength];
                long[] newHarga = new long[newLength];
                String[] newItem = new String[newLength];
                int[] newJmlBarang = new int[newLength];

                // Copy elements from the old array to the new array
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    newProduk[i] = produk[i];
                    newJumlah[i] = jumlah[i];
                    newHarga[i] = harga[i];
                    newItem[i] = cartItems[i];
                    newJmlBarang[i] = cartItemQuantities[i];
                }

                // Replace the old array with the new array
                produk = newProduk;
                jumlah = newJumlah;
                harga = newHarga;
                cartItemQuantities = newJmlBarang;
                cartItems = newItem;
            }

            // Proceed with adding a new item as you did before
            System.out.print("Do you want to add a new item? (y/n): ");
            String addNewItem = scanner.next();

            if (addNewItem.equalsIgnoreCase("y") && NUM_PRODUCTS < produk.length) {
                System.out.print("Enter the name of the new item: ");
                String newItemName = scanner.nextLine();
                newItemName = scanner.nextLine();

                System.out.print("Enter the quantity of the new item available: ");
                int newItemQuantity = scanner.nextInt();

                System.out.print("Enter the price of the new item: ");
                long newItemPrice = scanner.nextLong();

                // Add the new item to the produk array
                produk[NUM_PRODUCTS] = newItemName;
                jumlah[NUM_PRODUCTS] = newItemQuantity;
                harga[NUM_PRODUCTS] = newItemPrice;

                // Increment NUM_PRODUCTS
                NUM_PRODUCTS++;

                System.out.println("New item added to inventory successfully.");
            }
        }

    }

    // Exit method
    public static void Exit() {
        System.out.println("Thank you for using the Camping Equipment Rental System!");
        System.exit(0);
    }


    public static void mainid(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("  Selamat datang di sistem rental alat camping          ");
        System.out.println("=================================================");
        System.out.print("Masukan user: ");
        String user = scanner.nextLine();
        System.out.print("Masukan password: ");
        int password = scanner.nextInt();

        if ((user.equalsIgnoreCase("customer")) && (password == 123)|| user.equalsIgnoreCase("admin")&&(password == 123)) {

            System.out.println("\n               Login Berhasil              ");
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
                System.out.println("12.Exit");
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
                        pendapatan(scanner);
                        break;
                    case 11:
                        tambahBarang(scanner);
                        break;
                    case 12:
                        exit();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (pilihan != 12);

            scanner.close();
        } else {
            System.out.println("Login Gagal");
            main(args);
        }
    }

    // Method untuk profil
    public static void Profil(Scanner scanner) {
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

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            System.out.print(produkid[i] + "\t");
            if (jumlahid[i] == 0) {
                System.out.print("Sold out\t");
            } else {
                System.out.print(jumlahid[i] + "\t\t");
            }
            System.out.println(hargaid[i]);
        }
        System.out.println("\nPilih opsi untuk melanjutkan:");
        System.out.println("1.keranjang\n2.Menu utama");
        int next = scanner.nextInt();
        if (next == 1) {
            Keranjang(scanner);
        } else if (next == 2) {

        } else {
            System.out.println("Pilihan tidak tersedia");
            persediaan(scanner);
        }

    }

    // Method untuk keranjang
    public static void Keranjang(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                    keranjang                 ");
        System.out.println("=================================================");
        System.out.println("Masukkan barang yang akan disewa:");
        String barang = scanner.nextLine();
        barang = scanner.nextLine();

        int indexBarang = -1;
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (produkid[i].equalsIgnoreCase(barang)) {
                indexBarang = i;
                break;
            }
        }
        if (indexBarang == -1) {
            System.out.println("produk tidak ditemukan");
        } else if (jumlahid[indexBarang] == 0) {
            System.out.println("sold out");
        } else {
            System.out.println("Masukkan jumlah barang yang akan di sewa:");
            int jumlahBarang = scanner.nextInt();

            if (jumlahBarang > jumlahid[indexBarang]) {
                System.out.println("Barang yang di sewa tidak mencukupi");
            } else {
                itemKeranjang[indexBarang] = barang;
                jmlBarangKeranjang[indexBarang] += jumlahBarang;
                totalHarga += hargaid[indexBarang] * jumlahBarang;

                jumlahid[indexBarang] -= jumlahBarang;
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
        System.out.println("1. JNT \n2. JNE");
        System.out.print("Masukkan opsi pengiriman: ");
        pengiriman = scanner.nextInt();
        if (pengiriman == 1) {
            pengiriman = 0;
        }
        if (pengiriman == 2) {
            pengiriman = 1;
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

        if (kembali.equalsIgnoreCase("y")) {
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                if (itemKeranjang[i] != null && jmlBarangKeranjang[i] > 0) {
                    // Mengembalikan semua barang yang ada di keranjang
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

    // method untuk pendapatan
    public static void pendapatan(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                   login pendapatan          ");
        System.out.println("=================================================");
        System.out.print("masukan user: ");
        String user = scanner.next();
        System.out.print("masukan password: ");
        int password = scanner.nextInt();

        if ((user.equalsIgnoreCase("admin")) && (password == 123)) {

            System.out.println("\n               login berhasil              ");
            System.out.println("\n");
            System.out.println("=================================================");
            System.out.println("               Cek pendapatan                   ");
            System.out.println("       pendapatan Anda adalah Rp. " + saldo);
            System.out.println("=================================================");
            System.out.println("feedback:" + masukkan);
        } else {
            System.out.println("Username atau password anda salah");
        }

    }

    // method tambah barang
    public static void tambahBarang(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("              login penambahan barang         ");
        System.out.println("=================================================");
        System.out.print("masukan user: ");
        String user = scanner.next();
        System.out.print("masukan password: ");
        int password = scanner.nextInt();

        if ((user.equalsIgnoreCase("admin")) && (password == 123)) {

            System.out.println("\n               login berhasil              ");
            System.out.println("\n");
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

    }

    // method exit
    public static void exit() {
        System.out.println("Terima kasih telah menggunakan sistem rental alat camping!");
        System.exit(0);
        }
}



