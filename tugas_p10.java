import java.util.Scanner;

public class tugas_p10 {
    public static String[][] dendaHilang = {
        {"Tenda camping", " 2.500.000"},
        {"Tas Gunung", " 800.000"},
        {"Sleeping Bag", " 600.000"},
        {"Kompor portable", " 200.000"},
        {"Cooking set", " 150.000"},
        {"Flashlight", " 50.000"},
        {"Karpet tebal", " 30.000"},
    };
    public static void main(String[]args) {
        Scanner scanner = new Scanner (System.in);
            String back;
            while (true) {
                System.out.println("=================================================");
                System.out.println("              Denda         ");
                System.out.println("=================================================");
                System.out.println("1. Telat mengembalikan barang (diluar estimasi yang sudah ditentukan)");
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
}
