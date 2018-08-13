package models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    private int id;
    private int orderNumber;

    public Order(){
    }

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "order_number")
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
