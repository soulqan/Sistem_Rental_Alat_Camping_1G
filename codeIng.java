import java.util.Scanner;

public class codeIng {

public static int NUM_PRODUCTS = 10;
    public static String[] product = { "Camping Tent", "Mountain Backpack", "Sleeping Bag", "Portable Stove", "Cooking Set", "Flashlight", "Thick Carpet", "Product 8", "Product 9", "Product 10" };
    public static int[] amount = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
    public static long[] price = { 250000, 35000, 0, 0, 0, 0, 0, 0, 0, 0 };
    public static long[] priceOfPostage = { 1000, 30000 };
    public static String name, address, input, notelp;
    public static String[] cartItems = new String[NUM_PRODUCTS];
    public static int[] cartItemQuantities = new int[NUM_PRODUCTS];
    public static long totalPrice = 0, balance = 0, deliveryCost, finalTotalPrice = 0;
    public static int estimate, deliveryOption;
    public static String[][] lostFines = {
        {"Camping Tent", "2.500.000"},
        {"Mountain Backpack", "800.000"},
        {"Sleeping Bag", "600.000"},
        {"Portable Stove", "200.000"},
        {"Cooking set", "150.000"},
        {"Flashlight", "50.000"},
        {"Thick Carpet", "30.000"},
    };
    public static int[] brokenFines = { 200000, 100000, 100000, 30000, 20000, 10000, 15000, 0, 5000, 10000};

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("  Welcome to the Camping Equipment Rental System  ");
        System.out.println("=================================================");
        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        System.out.print("Enter password: ");
        int password = scanner.nextInt();
    
        if ((user.equalsIgnoreCase("customer") && password == 123)) {
            System.out.println("\n               Login Successful (Customer)              ");
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
                System.out.println("10. Fines");
                System.out.println("11. Exit");
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
                        fines(scanner);
                        break;
                    case 11:
                        Exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 10);
        } else if (user.equalsIgnoreCase("admin") && password == 123) {
            System.out.println("\n               Login Successful (Admin)              ");
            System.out.println("\n");
    
            int choice;
            do {
                System.out.println("=================================================");
                System.out.println ("                   Main Menu                   ");
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
                System.out.println("12. Fines");
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
                        EarningsAndFeedback();
                        break;
                    case 11:
                        AddNewItem(scanner);
                        break;
                    case 12:
                        fines(scanner);
                        break;
                    case 13:
                        Exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 12);
        } else {
            System.out.println("Login Failed");
        }
    }
    

    // Method for profile
    public static void Profile(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                 Customer Profile                 ");
        System.out.println("=================================================");
        System.out.print("Name    : ");
        name = scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Address : ");
        address = scanner.nextLine();
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
            System.out.print(product[i] + "\t");
            if (amount[i] == 0) {
                System.out.print("Sold out\t");
            } else {
                System.out.print(amount[i] + "\t\t");
            }
            System.out.println(price[i]);
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
            if (product[i].equalsIgnoreCase(item)) {
                itemIndex = i;
                break;
            }
        }
        if (itemIndex == -1) {
            System.out.println("Item not found");
        } else if (amount[itemIndex] == 0) {
            System.out.println("Sold out");
        } else {
            System.out.println("Enter the quantity to rent:");
            int quantity = scanner.nextInt();

            if (quantity > amount[itemIndex]) {
                System.out.println("Insufficient quantity available");
            } else {
                cartItems[itemIndex] = item;
                cartItemQuantities[itemIndex] += quantity;
                totalPrice += price[itemIndex] * quantity;

                amount[itemIndex] -= quantity;
                System.out.println("Item added to the cart.");
            }

        }

    }
    //method for delete items in the cart
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
                System.out.println("Invalid amount.");
            } else {
                cartItemQuantities[productindexing] -= jmlMasuking;
                totalPrice -= price[productindexing] * jmlMasuking;

                amount[productindexing] += jmlMasuking;
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
        System.out.println("1. Pick Up In Store     : 1000 \n2. Courier              : 30000");
        System.out.print("Select a delivery option: ");
        deliveryOption = scanner.nextInt(); 
        if (deliveryOption == 1) {
            deliveryOption = 0;
            System.out.println("Delivery option set");
        }
        else if (deliveryOption == 2) {
            deliveryOption = 1;
            System.out.println("Delivery option set");
        }

        else {
            System.out.println("Invalid delivery option. Please select a valid option.");
        }
    }


    // Payment logic
    public static void Payment(Scanner scanner) {
        System.out.println("======================================================");
        System.out.println("            Payment Details                ");
        System.out.println("======================================================");
        System.out.println("Name   : " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + notelp);
        System.out.println("======================================================");
        System.out.println("Product\t\tQuantity\t\tPrice\t\tEstimate\tDelivery");

        boolean itemsInCart = false;

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            if (cartItems[i] != null && cartItemQuantities[i] > 0) {
                System.out.print(cartItems[i] + "\t");
                System.out.print(cartItemQuantities[i] + "\t\t");
                System.out.print(price[i] + "\t\t");
                System.out.print(estimate + "\t\t");
                System.out.println(priceOfPostage[deliveryOption]);

                itemsInCart = true;
            }
        }

        if (itemsInCart) {
            finalTotalPrice = totalPrice * estimate + priceOfPostage[deliveryOption];
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
                    amount[i] += cartItemQuantities[i];
                    totalPrice -= price[i] * cartItemQuantities[i];
                    cartItemQuantities[i] = 0;
                }
            }
            System.out.println("All items have been returned successfully.");
        } else {
            System.out.println("Thank you!");
        }
    }

    // Method for earnings
    public static void EarningsAndFeedback() {
        System.out.println("=================================================");
        System.out.println("            Earnings and Feedback               ");
        System.out.println("=================================================");
        System.out.println("            Check Earnings                ");
        System.out.println("Your earnings are Rp. " + balance);
        System.out.println("=================================================");
        System.out.println("Feedback: " + input);
        }


    // Method to add a new item
    public static void AddNewItem(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("                  Add New Item                   ");
        System.out.println("=================================================");
            // Check if the product array is full
            // Ensure that the length of the array is always greater than or equal to NUM_PRODUCTS
            if (NUM_PRODUCTS >= product.length) {
                // If it's full, create a new array with a larger size
                int newLength = product.length + 1;

                String[] newproduct = new String[newLength];
                int[] newamount = new int[newLength];
                long[] newprice = new long[newLength];
                String[] newItem = new String[newLength];
                int[] newJmlBarang = new int[newLength];

                // Copy elements from the old array to the new array
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    newproduct[i] = product[i];
                    newamount[i] = amount[i];
                    newprice[i] = price[i];
                    newItem[i] = cartItems[i];
                    newJmlBarang[i] = cartItemQuantities[i];
                }

                // Replace the old array with the new array
                product = newproduct;
                amount = newamount;
                price = newprice;
                cartItemQuantities = newJmlBarang;
                cartItems = newItem;
            }

            // Proceed with adding a new item as you did before
            System.out.print("Do you want to add a new item? (y/n): ");
            String addNewItem = scanner.next();

            if (addNewItem.equalsIgnoreCase("y") && NUM_PRODUCTS < product.length) {
                System.out.print("Enter the name of the new item: ");
                String newItemName = scanner.nextLine();
                newItemName = scanner.nextLine();

                System.out.print("Enter the quantity of the new item available: ");
                int newItemQuantity = scanner.nextInt();

                System.out.print("Enter the price of the new item: ");
                long newItemPrice = scanner.nextLong();

                // Add the new item to the product array
                product[NUM_PRODUCTS] = newItemName;
                amount[NUM_PRODUCTS] = newItemQuantity;
                price[NUM_PRODUCTS] = newItemPrice;

                // Increment NUM_PRODUCTS
                NUM_PRODUCTS++;

                System.out.println("New item added to inventory successfully.");
            }
        }
        public static void fines(Scanner scanner) {
            String back;
            boolean fines = true;
            while (fines) {
                System.out.println("=================================================");
                System.out.println("|                      FINES                    |");
                System.out.println("=================================================");
                System.out.println("1. Late returning items");
                System.out.println("2. Lost Items");
                System.out.println("3. Broken Items");
                System.out.println("4. Exit ");
                System.out.print("\nPilihan : ");
                int finesOPtions = scanner.nextInt();
    
                if (finesOPtions == 1) {
                    System.out.println("");
                    System.out.println("Do you want to report the fines back? (y/n)");
                    back = scanner.next();
                    if (back.equalsIgnoreCase("y")) {
    
                    } else {
                        fines = false;
                    }
                    } else if (finesOPtions == 2) {
                    System.out.println("=====================================");
                    System.out.println("|    list of fines for lost items   |");
                    System.out.println("=====================================");
                    for (int i = 0; i < lostFines.length; i++) {
                        for (int j = 0; j < lostFines[i].length; j++) {
                            System.out.print(lostFines[i][j]);
                            if (j < lostFines[i].length - 1) {
                                System.out.print(" - ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("--------------------------------------");
                    System.out.println("What items are lost?");
                    String lost = scanner.nextLine();
                    lost = scanner.nextLine();
    
                    boolean found = false;
                    for (String[] item : lostFines) {
                        if (item[0].equalsIgnoreCase(lost)) {
                            System.out.println("You must pay for the loss of the item's value " + item[1]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item not found in lost list.");
                    }
    
                    System.out.println("Do you want to report the fines back? (y/n)");
                    back = scanner.next();
                    if (back.equalsIgnoreCase("y")) {
    
                    } else {
                        fines = false;
                    }
                    } else if (finesOPtions == 3) {
                        System.out.println("=======================================");
                        System.out.println("|    list of fines for broken items   |");
                        System.out.println("=======================================");
                        for (int i = 0; i < product.length; i++) {
                            System.out.println(product[i]);
                        }
                        System.out.println("--------------------------------------");
                        System.out.println("What items are broken?");
                        String rusak = scanner.nextLine();
                        rusak = scanner.nextLine();
                        for (int i = 0; i < brokenFines.length; i++) {
                            if (rusak.equalsIgnoreCase(product[i])) {
                                System.out.println("The broken fines you have to pay is "+ brokenFines[i]);
                                System.out.println("For more details, the price will be checked when returning the items");
                            }
                        }
                            System.out.println("Do you want to report the fines back? (y/n)");
                            back = scanner.next();
                            if (back.equalsIgnoreCase("y")) {
                                
                            } else {
                            fines = false;     
                            }
                    } else if (finesOPtions == 4) {
                    fines = false;
                    }
            }
        }
    // Exit method
    public static void Exit() {
        System.out.println("Thank you for using the Camping Equipment Rental System!");
        System.exit(0);
    }





}