import java.io.*;;
 
 
 public class sistem{
	 
	public static void main (String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int pilihan, pilihan2;
                		
			
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
				System.out.println("\n1.Persediaan alat camping");
				System.out.println("2.Pembayaran");
				System.out.println("3.Harga alat rental");
				System.out.println("4.Peminjaman barang");
				System.out.println("5.Pengembalian barang");
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
                                            System.out.println(x:"cooking set");
                                            System.out.println(x:"Stainless steel");
                                            System.out.println(x:"senter");
                                            System.out.println(x:"cutter");
                                            System.out.println(x:"headlamp");
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
					case 3:
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
					case 4:
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
					case 5:
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
	 
	 
 
