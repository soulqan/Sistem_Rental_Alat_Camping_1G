import java.io.*;
import java.util.Scanner;  ;
 
 
 public class sistem{
	 
	public static void main (String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner=new Scanner(System.in);
		
		int pilihan, pilihan2, tabung, saldo =0, index=0;
                String nama = "default", alamat ="default";
                long notelp=0;
                int[] tambah_saldo=new int[20];
                
                		
			
			System.out.println("=================================================");
			System.out.println("  Selamat datang di sistem rental alat camping          ");
                        System.out.println("=================================================");
			System.out.print("masukan user: ");
			String user = br.readLine();
			System.out.print("masukan password: ");
			int password = Integer.parseInt(br.readLine());
			
			if( (user.equalsIgnoreCase("admin")) && (password==123) ){
			
			System.out.println("\n               Login Berhasil              ");
			System.out.println("\n");
			
				
			
			
			while(true){
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
				System.out.print("\nPilih Menu : ");
				pilihan = Integer.parseInt(br.readLine());
                                switch (pilihan) {
                                case 1:
					do{
                                            System.out.println("=================================================");
                                            System.out.println("                 Profil Customer                 ");
                                            System.out.println("=================================================");
                                            System.out.print("Nama    :");
                                            nama = scanner.nextLine();
                                            System.out.print("Alamat  :");
                                            alamat = scanner.nextLine();
                                            System.out.print("No.Telp :");
                                            notelp = scanner.nextLong();
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					
					break;
				
					case 2:
                                        do{
                                            System.out.println("=================================================");
                                            System.out.println("                 Persediaan Alat                    ");
                                            System.out.println("Tenda:");
                                            System.out.println("Tas Gunung");
                                            System.out.println("Kompor portable");
                                            System.out.println("cooking set");
                                            System.out.println("Stainless steel");
                                            System.out.println("senter");
                                            System.out.println("cutter");
                                            System.out.println("headlamp");
                                            System.out.println("karpet");
                                            System.out.println("k");
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					 break;
					case 3:
					do{
                                            System.out.println("=================================================");
                                            System.out.println("       ");
                                            System.out.print("      ");
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					
					break;
					case 4:
					do{
                                            System.out.println("=================================================");
                                            System.out.println("        ");
                                            System.out.print("      ");
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					break;
					case 5:
					do{
                                            System.out.println("=================================================");
                                            System.out.println("                ");
                                            System.out.println("");
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					
					break;
					case 7:
					do{
                                            System.out.println("=================================================");
                                            System.out.println("                      Help                       ");
                                            System.out.println("1. ");
                                            System.out.println("2. ");
                                            System.out.println("3. ");
                                            System.out.println("4. ");
                                            System.out.println("6. ");
                                            System.out.println("7. ");
                                            System.out.println("8. ");
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
                                            break;
                                            case 6:
					do{
                                            System.out.println("=================================================");
                                            System.out.println("Masukan Total Nominal Barang yang akan di pinjam ");
                                            System.out.println("=================================================");
                                            System.out.print("     Rp. ");
                                            tabung = Integer.parseInt(br.readLine());
                                            tambah_saldo[index]=tabung;
                                            index++;
                                            saldo += tabung;
                                            System.out.println("  pembayaran anda berhasil ");
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					
					break;
                                        case 8:
					do{
                                            System.out.println("=================================================");
                                            System.out.println(notelp);;
                                            System.out.println("Nama: "+ nama );
                                            System.out.println("alamat :"+ alamat);
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					
					break;
                                        
					case 9:
                                        do{
                                            System.out.println("=================================================");
                                            System.out.println("               Cek pendapatan                   ");
                                            System.out.println("       pendapatan Anda adalah Rp. " + saldo       );
                                            System.out.println("=================================================");
                                            System.out.println("\n1.keluar");
                                            System.out.println("2.Kembali");
                                            System.out.print("\nPilih Menu : ");
                                            pilihan2 = Integer.parseInt(br.readLine());
                                            switch (pilihan2) {
                                                    case 1:
                                                    System.exit(0);
                                                    break;
                                                    
                                                    }
                                            }while(pilihan2!=2);
					 break;
					case 10:
					System.exit(0);
					break;
					default:
					System.exit(0);
					break;
					}
                                        
				}
				
			} else {
				System.out.println("user atau password Salah silakan coba lagi");
			}
			
			
			
		}
	
	} 
	 
	 
 
