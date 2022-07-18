public class BaristaTest {

    public static void main(String[] args) {

        // Menu Items
        Item item1 = new Item("Mocha", 3.00);
        Item item2 = new Item("Latte", 3.50);
        Item item3 = new Item("Drip Coffee", 2.00);
        Item item4 = new Item("Cappuccino", 4.00);

//         Order variables -- order1, order2, etc.
        Order order1 = new Order();
        order1.addItem(item1);
        order1.addItem(item2);
        Order order2 = new Order();
        order2.addItem(item3);
        order2.addItem(item4);
        Order order3 = new Order("Mike");
        order3.addItem(item1);
        order3.addItem(item3);
        Order order4 = new Order("Chris");
        order4.addItem(item2);
        order4.addItem(item4);
        Order order5 = new Order("Jeremy");
        order5.addItem(item1);
        order5.addItem(item1);

        //Aplication Simulations
//        order4.setReady(true);
//        System.out.println(order4.getOrderTotal());
//        order4.getStatusMessage();
        order1.display();
        order2.display();
        order3.display();
        order5.display();
    }
}
