import java.text.NumberFormat;
import java.util.*;

public class Order {

    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        this.items = new ArrayList<Item>();
    }

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public boolean isReady() {
        return ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // Methods
    public void addItem(Item newItem) {
        this.items.add(newItem);
    }

    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready.";
        }
        return "Thank you for waiting. Your order will be ready soon.";
    }

    public String getOrderTotal() {
        double sum = 0;

        for (Item eachItem : this.items) {
            sum += eachItem.getPrice();
        }

        NumberFormat formattedSum = NumberFormat.getCurrencyInstance();
        String sumString = formattedSum.format(sum);

        return sumString;
    }

    public void display() {
        System.out.printf("Customer Name: %s \n", this.name);

        for (Item eachItem : this.items) {
            NumberFormat formattedPrice = NumberFormat.getCurrencyInstance();
            String priceString = formattedPrice.format(eachItem.getPrice());

            System.out.printf("%s - %s\n", eachItem.getName(), priceString);
        }

        System.out.printf("Total: %s\n\n", this.getOrderTotal());
    }
}
