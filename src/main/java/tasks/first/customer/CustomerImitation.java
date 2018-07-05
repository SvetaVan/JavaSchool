package tasks.first.customer;

import tasks.first.Item;
import tasks.first.Order;

public class CustomerImitation {


    public static void main(String[] args) {
        Order order = new Order(new Item("Булочка"), new Item("Бублик"),new Item("Кексик"));
        order.addItem(new Item("Маффин"));
        order.addItem(new Item("Вода"));
        order.printOrder();
    }
}
