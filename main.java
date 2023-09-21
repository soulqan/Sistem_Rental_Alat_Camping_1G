import java.util.Scanner;
<<<<<<< HEAD
public class main{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
int jumlahBarang; 
int barangSewa;
int totalPembayaran;

System.out.print("Masukkan Jumlah barang: ");
jumlahBarang = sc14.nextInt();
System.out.print("Masukkan Barang sewa: ");
barangSewa = sc.nextInt();
totalPembayaran = jumlahBarang * barangSewa ;
System.out.println("total pembayaran: "+ totalPembayaran);

}
=======

public class main{
    public static void main(String[] args) {
        
    Scanner sc= new Scanner(System.in);
    long total;
    


    System.out.println("menu barang");
    System.out.println("Tenda");
    System.out.println("a.Tenda Besar:    300000 \nb.Tenda Sedang:     200000 \nc.Tenda Kecil:     150000");
    System.out.println("Masukkan harga pilihan:");
    long benda = sc.nextLong();
    System.out.println("Masukkan jumlah barang:");
    int jumlah = sc.nextInt();
    System.out.println("Masukkan jumlah hari:");
    int hari = sc.nextInt();
    

    total=benda*jumlah*hari;
    System.out.println("Total:"+total);
    }

>>>>>>> bd4d2838fe938faa48a547fac13ed5f7c5f87d08
}