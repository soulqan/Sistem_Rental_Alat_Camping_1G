import java.io.*;;
 
 
 public class sistem{
	 
	public static void main (String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int i=0;
		int pilihan, pilihan2;
                		for(i=0; i<=2; i++){
			
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
			
			i=5;	
			
			
			while(true){
				System.out.println("=================================================");
				System.out.println("                   Menu Utama                   ");
				System.out.println("=================================================");
				System.out.println("\n1.Persediaan alat");
				System.out.println("2.Pembayaran");
				System.out.println("3.Harga");
				System.out.println("4.Peminjaman");
				System.out.println("5.Pengembalian");
				System.out.println("6.Laporan");
				System.out.print("\nPilih Menu : ");
				pilihan = Integer.parseInt(br.readLine());
				switch (pilihan) {
					case 1:
                                        do{
                                            System.out.println("=================================================");
                                            System.out.println("                 Persediaan Alat                    ");
                                            System.out.println("Tenda");
                                            System.out.println("Tas Gunung");
                                            System.out.println("Kompor portable");
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
                                            System.out.println("   Masukan Jumlah Uang Yang Ingin Anda Simpan    ");
                                            System.out.print("     Rp. ");
                                            
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
                                            System.out.println("    Masukan Jumlah Uang Yang Ingin Anda Ambil    ");
                                            System.out.print("     Rp. ");
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
                                            System.out.println("                History Transaksi                ");
                                            System.out.println("History Masukan");
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
                                            System.out.println("                      Help                       ");
                                            System.out.println("1. Gunakan Menu ke-1 jika anda ingin melihat saldo anda");
                                            System.out.println("2. Gunakan Menu ke-2 jika anda ingin mengisi saldo");
                                            System.out.println("3. Gunakan Menu ke-3 jika anda ingin melakukan penarikan saldo");
                                            System.out.println("4. Gunakan Menu ke-4 jika anda ingin melihat history transaksi");
                                            System.out.println("6. Gunakan Menu ke-6 jika anda selesai menggunakan mesin ATM");
                                            System.out.println("7. Saat penarikan, saldo minimal anda adalah Rp.50000");
                                            System.out.println("8. Jika terdapat masalah pada mesin ATM hubungi 021-5437xxx");
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
	 
	 
 }
