package edible;
import java.util.Scanner;
public class drink extends edible {
    public drink(){
        name = "";
        price = 0.0;
        quantity = 0;
    }
    public void setDetails(){
        Scanner scan = new Scanner(System.in);
        Scanner scanVal = new Scanner(System.in);
        System.out.println("Enter Drink Name: ");
        name = scan.nextLine();
        System.out.println("Enter Drink Price: ");
        price = scanVal.nextDouble();
        System.out.println("Enter Drink Quantity: ");
        quantity = scanVal.nextInt();
    }
}