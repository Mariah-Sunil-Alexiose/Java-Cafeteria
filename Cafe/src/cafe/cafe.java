package cafe;

import edible.meal;
import edible.drink;
import java.util.Scanner;

public class cafe {
    // Total number of items in the shop
    public static int n = 50;
    // Create objects of the classes
    meal[] meals = new meal[n];
    meal[] cartmeals = new meal[n];
    drink[] drinks = new drink[n];
    drink[] cartdrinks = new drink[n];

    Scanner scan = new Scanner(System.in);
    Scanner scanStr = new Scanner(System.in);
    public int drinkcounter = 0, mealcounter = 0, cartcounter = 0, drinkcartCounter = 0, mealcartCounter;

    // Check if the number of items entered by the user exceeds the number of items
    // present in the shop
    void check_quantity(int q, int q1) {
        while (q > q1) {
            System.out.println("Sorry! We only have " + q1 + "!");
            break;
        }
    }

    // Function that adds items into the shop
    void add_item() {
        int ch;
        System.out.println("Press 1 for meal or 0 for drink: ");
        ch = scan.nextInt();
        try {
            if (ch == 1) {
                meals[mealcounter].setDetails();
                mealcounter++;
            } else if (ch == 0) {
                drinks[drinkcounter].setDetails();
                drinkcounter++;
            } else
                System.out.println("Wrong choice!");
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    // Function that displays meals in the shop
    void display_meals() {
        if (mealcounter > 0) {
            System.out.println("MEALS");
            for (int i = 0; i < mealcounter; i++) {
                System.out.println("Meal ID: " + (i + 1));
                meals[i].Display();
                System.out.println("\n");
            }
        } else
            System.out.println("No meals in shop!");
    }

    /// Function that displays drinks in the shop
    void display_drinks() {
        if (drinkcounter > 0) {
            System.out.println("DRINKS");
            for (int i = 0; i < drinkcounter; i++) {
                System.out.println("Drink ID: " + (i + 1));
                drinks[i].Display();
                System.out.println("\n");
            }
        } else
            System.out.println("No drinks in shop!");
    }

    // Function that checks if the shop is empty
    int check_shop() {
        if (mealcounter == 0 && drinkcounter == 0) {
            System.out.println("Empty shop!");
            return 1;
        } else
            return 0;
    }

    // Function that checks whether the Item ID exists in the shop
    int check_id(int id, int counter) {
        int found = 0;
        for (int i = 0; i < counter; i++) {
            while (id == i) {
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("ID not found!");
            return 1;
        } else
            return 0;
    }

    // Function that deletes items in the shop
    void delete_item() {
        int d, ch;
        if (check_shop() == 0) {
            System.out.println("Press 1 to delete meal or 0 to delete drink: ");
            ch = scan.nextInt();
            if (ch == 1) {
                display_meals();
                System.out.println("Enter the Meal ID you want to delete: ");
                d = scan.nextInt();
                d = d - 1;
                if (check_id(d, mealcounter) == 0) {
                    for (int i = d; i < mealcounter; i++) {
                        meals[i] = meals[i + 1];
                    }
                    mealcounter--;
                    System.out.println("Meal deleted!");
                }
            } else if (ch == 0) {
                display_drinks();
                System.out.println("Enter the Drink ID you want to delete: ");
                d = scan.nextInt();
                d = d - 1;
                if (check_id(d, drinkcounter) == 0) {
                    for (int i = d; i < drinkcounter; i++) {
                        drinks[i] = drinks[i + 1];
                    }
                    drinkcounter--;
                    System.out.println("Drink deleted!");
                }
            } else
                System.out.println("Wrong choice!");
        }
    }

    // Function that updates items in the shop
    void update_item() {
        int ch, u;
        if (check_shop() == 0) {
            System.out.println("Press 1 to update meal or 0 to update drink: ");
            ch = scan.nextInt();
            if (ch == 1) {
                display_meals();
                if (mealcounter > 0) {
                    System.out.println("Enter the Meal ID you want to update: ");
                    u = scan.nextInt();
                    u = u - 1;
                    if (check_id(u, mealcounter) == 0) {
                        meals[u].setDetails();
                        meals[u].Display();
                        System.out.println("Meal updated!");
                    }
                }
            } else if (ch == 0) {
                display_drinks();
                if (drinkcounter > 0) {
                    System.out.println("Enter the Drink ID you want to update: ");
                    u = scan.nextInt();
                    u = u - 1;
                    if (check_id(u, drinkcounter) == 0) {
                        drinks[u].setDetails();
                        System.out.println("Drink updated!");
                    }
                }
            } else {
                System.out.println("Wrong choice!");
            }
        }
    }

    // Function that displays all the items in the shop
    void display_items() {
        if (check_shop() == 0) {
            if (mealcounter > 0) {
                display_meals();
            }
            if (drinkcounter > 0) {
                display_drinks();
            }
        }
    }

    // Function that searches whether the user entered string exists in the shop
    void search_item() {
        String find;
        Scanner scanstr = new Scanner(System.in);
        if (check_shop() == 0) {
            System.out.println("Search For An Item : ");
            find = scanstr.nextLine();
            for (int i = 0; i < mealcounter; i++) {
                if (meals[i].name.toLowerCase().contains(find.toLowerCase())) {
                    meals[i].Display();
                    System.out.println("\n");
                }
            }
            for (int i = 0; i < drinkcounter; i++) {
                if (drinks[i].name.toLowerCase().contains(find.toLowerCase())) {
                    drinks[i].Display();
                    System.out.println("\n");
                }
            }
        }
    }

    // Function that prints the admin menu
    void admin() {
        int choice = 0;
        do {
            System.out.println("\n********** MENU **********");
            System.out.println("1.Add An Item");
            System.out.println("2.Delete An Item");
            System.out.println("3.Update An Item");
            System.out.println("4.Display All Items");
            System.out.println("5.Display Item By Name");
            System.out.println("6.Exit");
            System.out.println("****************************");
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    add_item();
                    break;
                case 2:
                    delete_item();
                    break;
                case 3:
                    update_item();
                    break;
                case 4:
                    display_items();
                    break;
                case 5:
                    search_item();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        } while (choice != 6);
    }

    // Function that checks whether if the cart is empty
    int check_cart() {
        if (cartcounter == 0) {
            System.out.println("Empty Cart");
            return 1;
        } else
            return 0;
    }

    // Function that displays the meals in the cart
    void display_cartmeals() {
        if (mealcartCounter > 0) {
            for (int i = 0; i < mealcartCounter; i++) {
                System.out.println("Meal ID: " + (i + 1));
                cartmeals[i].Display();
                System.out.println("\n");
            }
        } else
            System.out.println("No meals in the cart!");
    }

    // Function that displays the drinks in the cart
    void display_cartdrinks() {
        if (drinkcartCounter > 0) {
            for (int i = 0; i < drinkcartCounter; i++) {
                System.out.println("Drink ID: " + (i + 1));
                cartdrinks[i].Display();
                System.out.println("\n");
            }
        } else
            System.out.println("No drinks in the cart!");
    }

    // Function that displays all the items in the cart
    void display_cart() {
        if (cartcounter > 0) {
            System.out.println("CART:");
            if (mealcartCounter > 0)
                display_cartmeals();
            if (drinkcartCounter > 0)
                display_cartdrinks();
        } else
            System.out.println("Empty Cart");
    }

    // Function that adds items to the cart
    void addto_cart() {
        int ch, id, quan;
        if (check_shop() == 0) {
            System.out.println("Press 1 to add meal to the cart or 0 to add drink to the cart: ");
            ch = scan.nextInt();
            if (ch == 1) {
                display_meals();
                System.out.println("Enter the Meal ID to be added to cart: ");
                id = scan.nextInt();
                id = id - 1;
                if (check_id(id, mealcounter) == 0) {
                    System.out.println("Enter The Quantity: ");
                    quan = scan.nextInt();
                    check_quantity(quan, meals[id].quantity);
                    cartmeals[mealcartCounter].quantity = quan;
                    cartmeals[mealcartCounter].name = meals[id].name;
                    cartmeals[mealcartCounter].price = meals[id].price;
                    mealcartCounter++;
                    cartcounter++;
                    meals[id].decrease_quantity(quan);
                    System.out.println("Meal added to your cart!");
                }
            } else if (ch == 0) {
                display_drinks();
                System.out.println("Enter the Drink ID to be added to cart: ");
                id = scan.nextInt();
                id = id - 1;
                if (check_id(id, drinkcounter) == 0) {
                    System.out.println("Enter The Quantity: ");
                    quan = scan.nextInt();
                    check_quantity(quan, drinks[id].quantity);
                    cartdrinks[drinkcartCounter].quantity = quan;
                    cartdrinks[drinkcartCounter].name = drinks[id].name;
                    cartdrinks[drinkcartCounter].price = drinks[id].price;
                    drinks[id].decrease_quantity(quan);
                    drinkcartCounter++;
                    cartcounter++;
                    System.out.println("Drink added to your cart!");
                }
            } else
                System.out.println("Wrong choice!");
        }
    }

    // Function that deletes items from the cart
    void deletefrom_cart() {
        int ch, id;
        if (check_cart() == 0) {
            System.out.println("Press 1 to delete meal or 0 to delete drink from the cart");
            ch = scan.nextInt();
            if (ch == 1) {
                display_cartmeals();
                System.out.println("Enter the Meal ID you want to delete: ");
                id = scan.nextInt();
                id = id - 1;
                if (check_id(id, mealcounter) == 0) {
                    for (int i = id; i < mealcounter; i++)
                        cartmeals[i] = cartmeals[i + 1];
                    mealcartCounter--;
                    cartcounter--;
                    System.out.println("Meal deleted from cart!");
                }
            } else if (ch == 0) {
                display_cartdrinks();
                System.out.println("Enter the Drink ID you want to delete: ");
                id = scan.nextInt();
                id = id - 1;
                if (check_id(id, mealcounter) == 0) {
                    for (int i = id; i < drinkcounter; i++)
                        cartdrinks[i] = cartdrinks[i + 1];
                    drinkcartCounter--;
                    cartcounter--;
                    System.out.println("Drink deleted from cart!");
                }
            } else
                System.out.println("Wrong choice!");
        }
    }

    // Function that prints the bill
    void print_bill() {
        if (check_cart() == 0) {
            double item_total = 0.0, total = 0.0;
            System.out.println("BILL: ");
            // Prints the meal items in the cart
            for (int i = 0; i < mealcartCounter; i++) {
                cartmeals[i].Display();
                item_total = cartmeals[i].quantity * cartmeals[i].price;
                total = total + item_total;
                // Prints if the items in the cart are more than one
                if (cartcounter > 1)
                    System.out.println("Item total: " + item_total);
                System.out.println("\n");
            }
            // Prints the drink items in the cart
            for (int i = 0; i < drinkcartCounter; i++) {
                cartdrinks[i].Display();
                item_total = cartdrinks[i].quantity * cartdrinks[i].price;
                total = total + item_total;
                // Prints if the items in the cart are more than one
                if (cartcounter > 1)
                    System.out.println("Item total: " + item_total);
                System.out.println("\n");
            }
            System.out.println("\nTotal: " + total);
        }
    }

    // Function that displays the customer menu
    void customer() {
        int choice = 0;
        do {
            System.out.println("\n************* MENU ***************");
            System.out.println("1.Add An Item to Cart");
            System.out.println("2.Delete An Item from Cart");
            System.out.println("3.Display All Items in Cart");
            System.out.println("4.Print Bill");
            System.out.println("5.Exit");
            System.out.println("************************************");
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    addto_cart();
                    break;
                case 2:
                    deletefrom_cart();
                    break;
                case 3:
                    display_cart();
                    break;
                case 4:
                    print_bill();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        } while (choice != 5);
    }

    // Function that checks the credentials of the administrator
    int check_credentials() {
        int welcome = 0;
        String username, password;
        boolean loggedIn = false;
        System.out.println("Enter Username: ");
        username = scanStr.nextLine();
        System.out.println("Enter Password: ");
        password = scanStr.nextLine();
        if (username.equals("Admin") && password.equals("1234")) {
            loggedIn = true;
            System.out.println("Welcome " + username + "!");
            welcome = 1;
        } else {
            System.out.println("Invalid Credentials!");
        }
        return welcome;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        cafe c = new cafe();
        for (int i = 0; i < n; i++) {
            c.meals[i] = new meal();
            c.cartmeals[i] = new meal();
            c.drinks[i] = new drink();
            c.cartdrinks[i] = new drink();
        }
        int choice = 0;
        do {
            System.out.println("********** MENU ************");
            System.out.println("1. Administration ");
            System.out.println("2. Customer ");
            System.out.println("3. Exit ");
            System.out.println("****************************");
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    if (c.check_credentials() == 1) {
                        c.admin();
                    }
                    break;
                case 2:
                    c.customer();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        } while (choice != 3);
    }
}