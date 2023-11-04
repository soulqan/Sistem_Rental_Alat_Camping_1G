import java.util.Scanner;

public class tugas2_P9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int NUM_PRODUCTS = 5;
        String[]produk = {"Tenda camping", "Sleeping Bag", "Kompor Portable", "tas gunung", "cooking set"};
        int[] jumlahid = {10, 15, 5, 8, 12};
        int[] hargaid={20000, 30000, 120000, 21000, 100000};

        System.out.println("Selamat datang di Sistem Rental Alat Camping");

        System.out.println("=================================================");
        System.out.println("                  Persediaan alat                ");
        System.out.println("=================================================");
        
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            System.out.print(produk[i]+"\t");
            if (jumlahid[i]==0) {
                System.out.print("sold out");
                
            }else{
                System.out.print(jumlahid[i]+"\t\t");
            }
            System.out.println(hargaid[i]);
        }
        
        
            
        }
    }

