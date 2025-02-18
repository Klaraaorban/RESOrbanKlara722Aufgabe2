import Modell.Charakteren;
import Modell.Produkten;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        String userChoice;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Welcome to the marvel univerzum!");
            System.out.println("0. Exit");
            System.out.println("1. Read Product");
            System.out.println("2. Create Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Get all Products");
            System.out.println("6. Read Character");
            System.out.println("7. Create Character");
            System.out.println("8. Update Character");
            System.out.println("9. Delete Character");
            System.out.println("10. Get all Characters");

userChoice = scanner.nextLine();
    switch (userChoice){
        case "0":
            System.out.println("Thanks for participating");
            break;
        case "1":
            System.out.println("Enter product ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Produkten product = controller.produktenRepo.readById(id);
            System.out.println(product);
            break;

        case "2":
            System.out.println("Enter product ID:");
            int productID = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter product name:");
            String productName = scanner.nextLine();
            System.out.println("Enter product price:");
            int productPrice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter product herkunftsregion:");
            String productHerkunftsregion = scanner.nextLine();
            Produkten newProduct = new Produkten(productID, productName, productPrice, productHerkunftsregion);
            controller.produktenRepo.create(newProduct);
            System.out.println("Product created: " + newProduct);
            break;

        case "3":
            System.out.println("Enter product ID:");
            int productIDToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter new product name:");
            String newProductName = scanner.nextLine();
            System.out.println("Enter new product price:");
            int newProductPrice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter new product herkunftsregion:");
            String newProductHerkunftsregion = scanner.nextLine();
            Produkten updatedProduct = new Produkten(productIDToUpdate, newProductName, newProductPrice, newProductHerkunftsregion);
            controller.produktenRepo.update(updatedProduct);
            System.out.println("Product updated: " + updatedProduct);
            break;

        case "4":
            System.out.println("Enter product ID:");
            int productIDToDelete = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            boolean deleteResult = controller.produktenRepo.delete(productIDToDelete);
            if (deleteResult) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not found");
            }
            break;

            case "5":
            System.out.println("All products:");
            controller.produktenRepo.getAll().forEach(System.out::println);
            break;

////
//        int id;
//        String Name;
//        String Region;
//        List<Produkten> produktens;
        case "6":
            System.out.println("Enter character ID:");
            int id1 = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Charakteren character = controller.charakterenRepo.readById(id1);
            System.out.println(character);
            break;

            case "7":
                System.out.println("Enter character ID:");
                int characterID = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter character name:");
                String characterName = scanner.nextLine();
                System.out.println("Enter character region:");
                String characterRegion = scanner.nextLine();

                // Prompt user to enter product IDs
                System.out.println("Enter the IDs of the products " + controller.produktenRepo.getAll()+ " (or type '0' to skip):");
                String productIDsInput = scanner.nextLine();

                List<Produkten> associatedProducts = new ArrayList<>();

                if (!productIDsInput.equals("0")) {
                    String[] productIDs = productIDsInput.split(",");
                    for (String productID7 : productIDs) {
                        int id7 = Integer.parseInt(productID7.trim()); // Parse product ID as an integer
                        Produkten product7 = controller.produktenRepo.readById(id7); // Fetch product
                        if (product7 != null) {
                            associatedProducts.add(product7);
                        } else {
                            System.out.println("No product found with ID: " + id7);
                        }
                    }
                }

                Charakteren newCharacter = new Charakteren(characterID, characterName, characterRegion, associatedProducts);
                controller.charakterenRepo.create(newCharacter);
                System.out.println("Character created: " + newCharacter);
                break;


                case "8":

                    System.out.println("Enter character ID:");
                    int characterID2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter character name:");
                    String characterName2 = scanner.nextLine();
                    System.out.println("Enter character region:");
                    String characterRegion2 = scanner.nextLine();

                    // Prompt user to enter product IDs
                    System.out.println("Enter the IDs of the products " + controller.produktenRepo.getAll()+ " (or type '0' to skip):");
                    String productIDsInput2 = scanner.nextLine();

                    List<Produkten> associatedProducts2 = new ArrayList<>();

                    if (!productIDsInput2.equals("0")) {
                        String[] productIDs = productIDsInput2.split(",");
                        for (String productID7 : productIDs) {
                            int id7 = Integer.parseInt(productID7.trim()); // Parse product ID as an integer
                            Produkten product7 = controller.produktenRepo.readById(id7); // Fetch product
                            if (product7 != null) {
                                associatedProducts2.add(product7);
                            } else {
                                System.out.println("No product found with ID: " + id7);
                            }
                        }
                    }

                    Charakteren newCharacter2 = new Charakteren(characterID2, characterName2, characterRegion2, associatedProducts2);
                    controller.charakterenRepo.create(newCharacter2);
                    System.out.println("Character created: " + newCharacter2);
                    break;
        case "9":
            System.out.println("Enter character ID:");
            int characterID3 = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Charakteren character1 = controller.charakterenRepo.readById(characterID3);
            controller.charakterenRepo.delete(characterID3);
            System.out.println("Character deleted: " + character1);
            break;

            case "10":
            System.out.println("All characters:");
            controller.charakterenRepo.getAll().forEach(System.out::println);
            break;

    }

        }while(!userChoice.equals("0"));
    }
}
