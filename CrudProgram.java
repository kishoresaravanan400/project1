import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class CrudProgram {

    static ArrayList<Product> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // ADD PRODUCT
    public static void add() {
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(sc.nextLine());

        // Check duplicate ID
        for (Product p : list) {
            if (p.id == id) {
                System.out.println("Product ID already exists! Cannot add duplicate.");
                return;
            }
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        list.add(new Product(id, name));
        System.out.println("Product Added Successfully!");
    }

    // UPDATE PRODUCT
    public static void update() {
        System.out.print("Enter Product ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Product p : list) {
            if (p.id == id) {
                System.out.print("Enter New Product Name: ");
                String newName = sc.nextLine();
                p.name = newName;
                System.out.println("Product Updated Successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // DELETE PRODUCT
    public static void delete() {
        System.out.print("Enter Product ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Product p : list) {
            if (p.id == id) {
                list.remove(p);
                System.out.println("Product Deleted Successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // DISPLAY SPECIFIC PRODUCT
    public static void displaySpecific() {
        System.out.print("Enter Product ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Product p : list) {
            if (p.id == id) {
                System.out.println("Product Found: " + p);
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // DISPLAY ALL PRODUCTS
    public static void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("\nAll Products:");
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Specific Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    displaySpecific();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 6);
    }
}