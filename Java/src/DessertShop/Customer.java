package DessertShop;

import java.util.ArrayList;

public class Customer {
    //Attributes
    String custName;
    ArrayList<Order> orderHistory;
    int custID;
    static int nextCustID = 1000;


    //Constructors
    public Customer(String cn){
        custName = cn;
        orderHistory = new ArrayList<>();
        custID = nextCustID;
        nextCustID++;
    }

    //Methods
    public String getName(){
        return custName;
    }
    public int getID(){
        return custID;
    }
    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }



    public void setName(String n){
        custName = n;
    }
    public void addToHistory(Order o){
        orderHistory.add(o);
    }

    
}
