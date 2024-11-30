package amazon;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;


public class AmazonManager {
    private ArrayList<AmazonProduct> products = new ArrayList<>();
    private ArrayList<AmazonCustomer> customers = new ArrayList<>();
    private ArrayList<AmazonCartItem> cart=new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private static final int NUMCOLS = 10;




    public static void main(String[] args) throws AmazonException, FileNotFoundException {
        AmazonManager manager = new AmazonManager();
        manager.showMenu();
    }

    public void showMenu() throws AmazonException, FileNotFoundException {
        String option;
        do {
            System.out.println("===========================================================================");
            System.out.println("||   ****    ****         ****    ****   *****      ALGONQUIN COLLEGE    ||");
            System.out.println("||  **  **  **      **   **  **  **  **  **  **  COURSE: OOP / CST8152   ||");
            System.out.println("||  ******  **      **   **  **  **  **  *****    PROF: PAULO            ||");
            System.out.println("||  **  **   ****         ****    ****   **       TERM: FALL / 2024      ||");
            System.out.println("===========================================================================");
            System.out.println("||                      [Menu A2 - Amazon Manager]                       ||");
            System.out.println("===========================================================================");
            System.out.println("||                                || USER                                ||");
            System.out.println("||                                || Credit options......................||");
            System.out.println("|| ADMIN                          || [F] Add credit to customer          ||");
            System.out.println("||                                || [G] Show credits to customer        ||");
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
                case "K":
                    addProductInCart();
                    break;
                case "L":
                    removeProductFromCart();
                    break;
                case "M":
                    showProductsFromCart();
                    break;
                case "N":
                    PayCart();
                    break;
                case "O":
                    addCommentToProduct();
                    break;
                case "P":
                    showComments();
                    break;
                case "Q":
                    System.out.println("===========================================================================");
                    System.out.println("||    [End of Application (Authors: Fouzi Haidar, Mohamed Amine Jmal)]   ||");
                    System.out.println("===========================================================================");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (!option.equals("Q"));
    }

    private void showComments() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }
        scanner.nextLine();
        for (AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                for(AmazonComment element: customer.getComments()){
                    System.out.println("Comment from this customer" + element.toString());
                }
            }
        }
    }

    private void showProductsFromCart() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }
        for(AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                customer.showCart();
            }
        }
    }

    private void addProductInWishlist() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }

        System.out.println("Enter Product ID: ");
        int productId;
        try {
            productId = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Product ID! Please try again.");
        }
        for(AmazonProduct product : products) {
            if(product.getId()==productId){
                for(AmazonCustomer customer : customers) {
                    if (customer.getId() == customerId) {
                        customer.addProductInWishList(product);
                        System.out.println("Added product in wishlist");
                    }

                }
            }
        }

    }

    private void removeProductFromWishlist() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }

        System.out.println("Enter Product ID: ");
        int productId;
        try {
            productId = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Product ID! Please try again.");
        }
        for(AmazonProduct product : products) {
            if(product.getId()==productId){
                for(AmazonCustomer customer : customers) {
                    if (customer.getId() == customerId) {
                        customer.removeProductFromWishList(productId);
                        System.out.println("Removed product from wishlist");
                    }

                }
            }
        }

    }
    private void showProductsFromWishlist() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }
        for(AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                customer.showWishList();
            }
        }

    }
    private void addProductInCart() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }

        System.out.println("Enter Product ID: ");
        int productId;
        try {
            productId = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Product ID! Please try again.");
        }
        int quantity;
        try{
            quantity=Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            throw new InputMismatchException("Invalid Quantity! Please try again.");
        }
        for(AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                for (AmazonProduct product : products) {
                    if (product.getId() == productId) {
                        AmazonCartItem cartItem=new AmazonCartItem(product, quantity);
                        customer.getCart().add(cartItem);
                        System.out.println("Item has been added to the cart.");
                    }

                }
            }
        }



    }
    private void removeProductFromCart() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }

        System.out.println("Enter Product ID: ");
        int productId;
        try {
            productId = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Product ID! Please try again.");
        }
        for (AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                for (AmazonProduct product : products) {
                    if (product.getId() == productId) {
                        customer.removeProductFromCart(productId);
                        System.out.println("Item has been removed from the cart.");
                    }
                }
            }
        }

    }


    private void PayCart() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }

        System.out.println("Select the payment method: ");

        int paymentMethod;
        try{
            paymentMethod=Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            throw new InputMismatchException("Invalid Payment Method! Please try again.");
        }
        for(AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                customer.pay(customer.getCredits().get(paymentMethod).getValue());
                System.out.println("Customer has been payed.");
            }
        }


    }


    private void addCommentToProduct() {
        System.out.println("Enter Customer ID: ");
        int customerId;
        try {
            customerId = scanner.nextInt();

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }
        System.out.println("Enter Product ID: ");
        int productId;
        try {
            productId = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            throw new InputMismatchException("Invalid Product ID! Please try again.");
        }
        for (AmazonCustomer customer : customers) {
            if(customer.getId()==customerId){
                for (AmazonProduct product : products) {
                    if (product.getId() == productId) {
                        System.out.println("Commenting product: " + productId + product.getName());
                        System.out.println("What is your feedback about this product ? ");
                        String text=scanner.nextLine();
                        System.out.println("How many stars you would rate it ?");
                        float stars;
                        try{
                            stars=Float.parseFloat(scanner.nextLine());
                        }catch (Exception e){
                            throw new InputMismatchException("Invalid Stars! Please try again.");
                        }
                        AmazonComment comment= new AmazonComment(product);
                        comment.setComment(text);
                        comment.setRating(stars);
                        customer.getComments().add(comment);
                        System.out.println("Comment has been added to the Product ratings.");
                    }
                }
            }
        }

    }


    public void loadProductList() throws AmazonException, FileNotFoundException{
        System.out.println("Input the file name");
        String local_temp=scanner.nextLine();
        FileReader fl;
        try{
            fl= new FileReader(local_temp);

        }catch(FileNotFoundException e) {
            throw new AmazonException("Error file not found");
        }
        try (BufferedReader br=new BufferedReader(fl)){
            String line=br.readLine();
            String[] title = line.split(",");
            while((line=br.readLine()) != null) {
                String[] temp=AmazonProductUtil.lineReader(line);
                if(temp.length==NUMCOLS) {
                    AmazonProduct product =AmazonProduct.createAmazonProduct(temp);
                    products.add(product);
                }
            }
        }catch(IOException ae) {
            throw new AmazonException("Error in reading the file");
        }
        System.out.println("Loading product list...");
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
        String productName;
        try{
            productName=scanner.nextLine();
        }catch(Exception e){
            throw new InputMismatchException("Invalid Product Name! Please try again.");
        }
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
        String customerId;
        try{
            customerId =scanner.nextLine();
        }catch (NumberFormatException e){
            throw new NumberFormatException("Invalid Customer ID! Please try again.");
        }
        System.out.print("Enter customer name: ");
        String name;
        try{
            name = scanner.nextLine();
        } catch (Exception e){
            throw new InputMismatchException("Invalid Customer Name! Please try again.");
        }
        System.out.print("Enter customer address: ");
        String address;
        try{
            address = scanner.nextLine();
        }catch (Exception e){
            throw new InputMismatchException("Invalid Customer Address! Please try again.");
        }
        String[] data= {customerId,name,address};
        AmazonCustomer Az = null;
        customers.add(AmazonCustomer.createAmazonCustomer(data));
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
        int customerId;
        try{
            customerId = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                System.out.print("Enter credit amount: ");
                float amount;
                try{
                    amount = Float.parseFloat(scanner.nextLine());
                }catch (Exception e){
                    throw new InputMismatchException("Invalid Credit Amount! Please try again.");
                }
                System.out.print("Enter payment method: ");
                String paymentMethod = scanner.nextLine();
                try{
                    paymentMethod = scanner.nextLine();
                }catch (Exception e){
                    throw new InputMismatchException("Invalid Payment Method! Please try again.");
                }
                AmazonCredit cash = null;
                AmazonCredit card =null;
                AmazonCredit check = null;
                if (paymentMethod.equalsIgnoreCase("CASH")) {
                    String[] data1 = {String.valueOf(amount)};
                    cash = AmazonCash.createCash(data1);
                    System.out.println("Cash added successfully.");
                    customer.addCredit(cash);

                }
                if(paymentMethod.equalsIgnoreCase("CARD")) {
                    System.out.println("Enter credit card number: ");
                    String cardNumber;
                    try{
                        cardNumber = scanner.nextLine();
                    }catch (Exception e){
                        throw new InputMismatchException("Invalid Credit Card Number! Please try again.");
                    }
                    System.out.println("Enter credit card expiration date: ");
                    String expirationDate;
                    try{
                        expirationDate = scanner.nextLine();
                    }catch (Exception e){
                        throw new InputMismatchException("Invalid Credit Expiration Date! Please try again.");
                    }
                    String[] data2={cardNumber,expirationDate, String.valueOf(amount)};
                    card=AmazonCard.createCard(data2);
                    System.out.println("Card added successfully.");
                    customer.addCredit(card);

                }
                if(paymentMethod.equalsIgnoreCase("CHECK")) {
                    System.out.println("Enter check number: ");
                    String checkNumber;
                    try{
                        checkNumber = scanner.nextLine();
                    }catch (Exception e){
                        throw new InputMismatchException("Invalid Check Number! Please try again.");
                    }
                    String[] data3 = {checkNumber, String.valueOf(amount)};
                    check=AmazonCheck.createCheck(data3);
                    System.out.println("Check added successfully.");
                    customer.addCredit(check);

                }
            }
        }
        return;
    }

    private void showCreditsFromCustomer() {
        System.out.print("Enter customer ID: ");
        int customerId;
        try{
            customerId = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            throw new InputMismatchException("Invalid Customer ID! Please try again.");
        }
        for (AmazonCustomer customer : customers) {
            if (customer.getId() == customerId) {
                customer.showCredits();
            }
        }
    }


}
