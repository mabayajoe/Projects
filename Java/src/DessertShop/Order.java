package DessertShop;

import java.util.ArrayList;

public class Order implements Payable{
    //Attributes
    ArrayList<DessertItem> order;
    private PayType payMethond;


    

    //Constructor
    public Order(){
        order = new ArrayList<>();
        payMethond = PayType.CASH;
    }
    


    //Methods
    public ArrayList<DessertItem> getOrderList(){
        return order;
    }

    public void addDessertItem(DessertItem o){
        /* if(o instanceof Candy || o instanceof Cookie){
            for(DessertItem i : order){
                if(i instanceof Candy || i instanceof Cookie){
                    if(((Candy)o).isSameAs((Candy)i) || ((Cookie)o).isSameAs((Cookie)i)){
                        ((Candy)i).setCandyWeight(((Candy)i).getCandyWeight() + ((Candy)o).getCandyWeight());
                        ((Cookie)i).setCookieQty(((Cookie)i).getCookieQty() + ((Cookie)o).getCookieQty());
                        break;
                    }
                }
            }
        } */
       
        /*if(o instanceof Candy || o instanceof Cookie){
            for(DessertItem i : order){
                if(i instanceof Candy){
                    if(((Candy)o).isSameAs((Candy)i)){
                        ((Candy)i).setCandyWeight(((Candy)i).getCandyWeight() + ((Candy)o).getCandyWeight());
                        
                    }
                } else if (i instanceof Cookie){
                    if(((Cookie)o).isSameAs((Cookie)i)){
                        ((Cookie)i).setCookieQty(((Cookie)i).getCookieQty() + ((Cookie)o).getCookieQty());
                        
                }
            }
        }
    }*/


        if(o instanceof Candy){
            for(DessertItem i : order){
                if(i instanceof Candy){
                    if(((Candy)i).isSameAs((Candy)o)){
                        ((Candy)i).setCandyWeight(((Candy)i).getCandyWeight() + ((Candy)o).getCandyWeight());
                        return;
                    }
                }
            }
        } 

        if(o instanceof Cookie){
            for(DessertItem i : order){
                if(i instanceof Cookie){
                    if(((Cookie)i).isSameAs((Cookie)o)){
                        ((Cookie)i).setCookieQty(((Cookie)i).getCookieQty() + ((Cookie)o).getCookieQty());
                        return;
                    }
                }
            }
        }
        
        else{
             order.add(o);
        }
    }

    public int itemCount(){
        return order.size();
    }

    public double orderCost(){
        double totalCost = 0.0;
        for(DessertItem o: order){
            totalCost += o.calculateCost();
        }
        return totalCost;
    }

    public double orderTax(){
        double totalTax = 0.0;
        for(DessertItem o : order){
            totalTax += o.calculateTax();
        }
        return totalTax;
    }

    public Object calculateCost() {
        return null;
    }

    public PayType getPayType(){
        return payMethond;
    }

    public void setPayType(PayType pm){
        payMethond = pm;
    }


    @Override    
    public String toString(){
        String  finalOutput = "";
        finalOutput += "------------------------------------Receipt-------------------------------\n";
        
        for(DessertItem o : order){
            finalOutput += o + "\n";
        }

        finalOutput += "--------------------------------------------------------------------------\n";
        finalOutput += "Total number of items in order: " + itemCount() + "\n";
        String line1_1 = String.format("Order Subtotals:");
        String line1_2 = String.format("$%.2f", orderCost());
        String line1_3 = String.format("[Tax: $%.2f]", orderTax());
        String line1_4 = String.format("Order Total: ");
        String line1_5 = String.format("$%.2f", orderCost() + orderTax());
        String line3 = String.format("-----------------------------------------------------------------------------\n");
        String line3_1 = String.format("Paid for with: %s", getPayType());


        String line1 = String.format("%s%42s%17s\n%s%45s%n%s%s%n", line1_1, line1_2, line1_3, line1_4, line1_5, line3, line3_1);

       

        return finalOutput + line1;

    }
 


    
}
