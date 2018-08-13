import db.DBCustomer;
import models.Customer;

public class Runner {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Jo", "Brown");
        DBCustomer.save(customer1);
    }

}
