package edible;
public class edible {
    public String name;
    public double price;
    public int quantity; 
    public void Display(){
        System.out.println("Name: "+ name);
        System.out.println("Price: "+ price);
        System.out.println("Quantity: "+ quantity);
    }
    public void decrease_quantity(int q){
        quantity = quantity - q;
    }
}