import db.DBCustomer;
import db.DBOrder;
import models.Customer;
import models.Order;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Jo", "Brown");
        DBCustomer.save(customer1);
        Order order1 = new Order(01);
        DBOrder.save(order1);

        List<Customer> customers = DBCustomer.getAll();

        Customer foundCustomer = DBCustomer.findById(1);

        List<Order> orders = DBOrder.getAll();

        Order foundOrder = DBOrder.findById(1);
    }

}
