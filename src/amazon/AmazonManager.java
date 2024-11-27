package amazon;

import java.util.ArrayList;
import java.util.Scanner;

public class AmazonManager {
    private ArrayList<AmazonProduct> products = new ArrayList<>();
    private ArrayList<AmazonCustomer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AmazonManager manager = new AmazonManager();
        manager.showMenu();
    }

    public void showMenu() {
        String option;
        do {
   
        	        System.out.println("===========================================================================");
        	        System.out.println("||   ****    ****         ****      ****   *****      ALGONQUIN COLLEGE  ||");
        	        System.out.println("||  **  **  **      **   **  **    **  **  **  **  COURSE: OOP / CST8152 ||");
        	        System.out.println("||  ******  **      **   **  **    **  **  *****    PROF: PAULO          ||");
        	        System.out.println("||  **  **   ****         ****      ****   **       TERM: FALL / 2024    ||");
        	        System.out.println("===========================================================================");
        	        System.out.println("||                      [Menu A2 - Amazon Manager]                       ||");
        	        System.out.println("===========================================================================");
        	        System.out.println("|| ADMIN                          || USER                                ||");
        	        System.out.println("|| Credit options.................|| Credit options......................||");
        	        System.out.println("|| [F] Add credit to customer     || [G] Show credits from customer      ||");
        	        System.out.println("|| Product options................|| Wishlist options....................||");
        	        System.out.println("|| [A] Load product list          || [H] Add product in wishlist         ||");
        	        System.out.println("|| [B] Show product list          || [I] Remove product from wishlist    ||");
        	        System.out.println("|| [C] Search products            || [J] Show products from wishlist     ||");
        	        System.out.println("||                                || Cart options........................||");
        	        System.out.println("|| Customer options...............|| [K] Add product in cart             ||");
        	        System.out.println("|| [D] Add customer               || [L] Remove product from cart        ||");
        	        System.out.println("|| [E] Show customers             || [M] Show products from cart         ||");
        	        System.out.println("||                                || [N] Buy products from cart          ||");
        	        System.out.println("||                                || Comment options.....................||");
        	        System.out.println("|| ...............................|| [O] Comment products bought         ||");
        	        System.out.println("|| [Q] Exit                       || [P] List comments from products     ||");
        	        System.out.println("===========================================================================");
        	   

            System.out.print("Choose an option: ");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    loadProductList();
                    break;
                case "B":
                    showProductList();
                    break;
                case "C":
                    searchProducts();
                    break;
                case "D":
                    addCustomer();
                    break;
                case "E":
                    showCustomers();
                    break;
                case "F":
                    addCreditToCustomer();
                    break;
                case "G":
                    showCreditsFromCustomer();
                    break;
                case "H":
                    addProductInWishlist();
                    break;
                case "I":
                    removeProductFromWishlist();
                    break;
                case "J":
                    showProductsFromWishlist();
                    break;
                case "Q":
                    System.out.println("==============================================================================================");
                    System.out.println("|| [End of Application (Authors: Fouzi Haidar, Mohamed Amine Jmal)]                          ||");
                    System.out.println("===============================================================================================");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (!option.equals("Q"));
    }

    private void loadProductList() {
        products.add(new AmazonProduct(1, "Laptop", "Electronics", 1200.00));
        products.add(new AmazonProduct(2, "Headphones", "Electronics", 150.00));
        System.out.println("Product list loaded successfully.");
    }

    private void showProductList() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product List:");
            for (AmazonProduct product : products) {
                System.out.println(product);
            }
        }
    }

    private void searchProducts() {
        System.out.print("Enter product name to search: ");
        String productName = scanner.nextLine();
        boolean found = false;
        for (AmazonProduct product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with the name: " + productName);
        }
    }

    private void addCustomer() {
        System.out.print("Enter customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();
        customers.add(new AmazonCustomer(id, name, address));
        System.out.println("Customer added successfully.");
    }

    private void showCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            System.out.println("Customer List:");
            for (AmazonCustomer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private void addCreditToCustomer() {
        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                System.out.print("Enter payment method (cash/check/card): ");
                String paymentMethod = scanner.nextLine();
                System.out.print("Enter credit amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                customer.addCredit(paymentMethod, amount);
                System.out.println("Credit added successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private void showCreditsFromCustomer() {
        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                customer.showCredits();
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private void addProductInWishlist() {
        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product ID to add to wishlist: ");
        int productId = Integer.parseInt(scanner.nextLine());
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                customer.addProductInWishList(productId);
                System.out.println("Product added to wishlist.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private void removeProductFromWishlist() {
        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product ID to remove from wishlist: ");
        int productId = Integer.parseInt(scanner.nextLine());
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                customer.removeProductFromWishList(productId);
                System.out.println("Product removed from wishlist.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private void showProductsFromWishlist() {
        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                customer.showWishList();
                return;
            }
        }
        System.out.println("Customer not found.");
    }
}
