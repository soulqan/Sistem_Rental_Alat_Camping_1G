import java.util.Scanner;

public class main {
    public static int NUM_PRODUCTS = 10;
    public static String[] namaProduk = {"Tenda gunung", "Tas Gunung", "Sleeping Bag", "Kompor Portable", "Cookingset", "FlashLight ", "Karpet tebal", "product8", "Product9", "Product10"};
    public static int[] jmlBarang = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    public static long[] harga = {250000, 0000, 0000, 0000, 0000, 0000, 0000, 0000, 0000, 0000};
    public static String[] itemKeranjang = new String[NUM_PRODUCTS];
    public static int[] jmlKeranjang = new int[NUM_PRODUCTS];
    public static long totalHarga = 0;

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



        int pilihan;
        do {
            System.out.println("\n----- Menu Utama -----");
            System.out.println("1. Persediaan Alat ");
            System.out.println("2. Masukkan keranjang");
            System.out.println("3. Buang dari Keranjang");
            System.out.println("4. Rincian Pembelian");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    Persediaan();
                    break;
                case 2:
                    addProductToCart(scanner);
                    break;
                case 3:
                    removeProductFromCart(scanner);
                    break;
                case 4:
                    displayCartItems();
                    break;
                case 5:
                    System.out.println("Thank you for using Ali's Online Shop. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (pilihan != 5);

        scanner.close();}
    }

    // Method to display products in the shop
    public static void Persediaan() {
        System.out.println("\n----- Produk -----");
        System.out.println("Nama\t\tTersedia\tHarga");

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            System.out.print(namaProduk[i] + "\t");
            if (jmlBarang[i] == 0) {
                System.out.print("Sold out\t");
            } else {
                System.out.print(jmlBarang[i] + "\t\t");
            }
            System.out.println(harga[i]);
        }
    }

    // Method to add a product to the cart
    public static void addProductToCart(Scanner scanner) {
        System.out.println("\n----- Add Product to Cart -----");
        System.out.print("Enter the product name: ");
        String Produk = scanner.next();

        int productIndex = -1;
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (namaProduk[i].equalsIgnoreCase(Produk)) {
                productIndex = i;
                break;
            }
        }

        if (productIndex == -1) {
            System.out.println("Produk tidak ditemukan.");
        } else if (jmlBarang[productIndex] == 0) {
            System.out.println("Sold Out.");
        } else {
            System.out.print("Masukkan jumlah barang: ");
            int jumlah = scanner.nextInt();

            if (jumlah > jmlBarang[productIndex]) {
                System.out.println("Jumlah yang tersedia tidak mencukupi.");
            } else {
                itemKeranjang[productIndex] = Produk;
                jmlKeranjang[productIndex] += jumlah;
                totalHarga += harga[productIndex] * jumlah;

                jmlBarang[productIndex] -= jumlah;
                System.out.println("Produk ditambahkan ke keranjang.");
            }
        }
    }

    // Method to remove a product from the cart
    public static void removeProductFromCart(Scanner scanner) {
        System.out.println("\n----- Remove Product from Cart -----");
        System.out.print("Enter the product name: ");
        String productName = scanner.next();

        int productIndex = -1;
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (itemKeranjang[i] != null && itemKeranjang[i].equalsIgnoreCase(productName)) {
                productIndex = i;
                break;
            }
        }

        if (productIndex == -1) {
            System.out.println("Product not found in cart.");
        } else {
            System.out.print("Enter the quantity: ");
            int jumlah = scanner.nextInt();

            if (jumlah > jmlKeranjang[productIndex]) {
                System.out.println("Jumlah tidak valid.");
            } else {
                jmlKeranjang[productIndex] -= jumlah;
                totalHarga -= harga[productIndex] * jumlah;

                jmlBarang[productIndex] += jumlah;
                System.out.println("Produk telah dibuang dari keranjang.");
            }
        }
    }

    // Method to display cart items and total price
    public static void displayCartItems() {
        System.out.println("\n----- Cart Items -----");
        System.out.println("Name\t\tQuantity\tPrice");

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (itemKeranjang[i] != null) {
                System.out.print(itemKeranjang[i] + "\t");
                System.out.print(jmlKeranjang[i] + "\t\t");
                System.out.println(harga[i]);
            }
        }

        System.out.println("Total Price: " + totalHarga);
    }
}