package edible;
import java.util.Scanner;
public class meal extends edible {
    public meal(){
        name = "";
        price = 0.0;
        quantity = 0;
    }
    public void setDetails(){
        Scanner scan = new Scanner(System.in);
        Scanner scanVal = new Scanner(System.in);
        System.out.println("Enter Meal Name: ");
        name = scan.nextLine();
        System.out.println("Enter Meal Price: ");
        price = scanVal.nextDouble();
        System.out.println("Enter Meal Quantity: ");
        quantity = scanVal.nextInt();
    }
}
