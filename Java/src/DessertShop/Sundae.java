package DessertShop;

import java.util.function.Supplier;

public class Sundae extends IceCream {
    //Attributes
    private String toppingName;
    private double toppingPrice;


    // Constructors
    public Sundae(){
        super();
        toppingName = "";
        toppingPrice = 0.0;
        setPackaging("");
    }
    public Sundae(String n, int sc, double pps, String tn, double tp){
        super(n, sc, pps);
        toppingName = tn;  
        toppingPrice = tp;
        setPackaging("Boat");
    }



    //Methods 
    public String getToppingName(){
        return toppingName;
    }
    public double getToppingPrice(){
        return toppingPrice;
    }

    public void setToppingName(String tn){
        toppingName = tn;
    }
    public void setToppingPrice(double tp){
        toppingPrice = tp;
    }

    public double calculateCost(){
        return getToppingPrice() + (getPricePerScoop()*getScoopCount());//<<<<<<
        
        //return ((double) Math.round((((double) Math.round(getPricePerScoop() * getScoopCount() * 100))/100 + toppingPrice)*100)) / 100;
    }

    @Override
    public String toString(){
        String line1 = String.format("%s Sundae (%s)%n", this.getToppingName(), getPackaging());
        String line2Pt1 = String.format("%s Scoops of %s ice cream @ $%.2f/Scoop.:%n\t%s topping @ $%.2f:", super.getScoopCount(), super.getName(), super.getPricePerScoop(), toppingName, toppingPrice);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        String line2 = String.format("%s\t%-45s%24s%17s\n", line1, line2Pt1, line2Pt2, line2Pt3);
        return line2;
    }
}
