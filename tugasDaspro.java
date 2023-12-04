import java.util.Scanner;

public class tugasDaspro {
   static Scanner sc=new Scanner(System.in);
   static int total=0,i;

    public static void main(String[] args) {
        int jum;
        int[] dataArray;

        System.out.print("input jumlah: ");
        jum = sc.nextInt();
        dataArray = isianArray(jum);
        tampilanArray(dataArray);
        hitTot(dataArray);
        System.out.println("total: "+ total);
    }

    static int[]isianArray(int angka) {
       
        int array[]=new int[angka];
        for (int i = 0; i < array.length; i++) {
            System.out.print("masukkan nilai: ");
            array[i] =sc.nextInt();
            
        }
        return array;
    }

    static void tampilanArray(int []array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("data ke-"+(i+1)+": "+array[i]);
        }
        return;
    }

    static int hitTot(int[]array){
        for (int i = 0; i < array.length; i++) {
            total+=array[i];
        }
        return total;
    }

    
}
