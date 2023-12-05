package DessertShop;

public class IceCream extends DessertItem{
    //Attributes
    private int scoopCount;
    private double pricePerScoop;

    

    //Constructor
    public IceCream(){
        super();
        scoopCount = 0;
        pricePerScoop = 0.0;
        setPackaging("");
    }
    public IceCream(String n, int sc, double pps){
        super(n);
        scoopCount = sc;
        pricePerScoop = pps;
        setPackaging("Bowl");
    }




    //Methods 
    public int getScoopCount(){
        return scoopCount;
    }
    public double getPricePerScoop(){
        return pricePerScoop;
    }


    public void setScoopCount(int sc){
        scoopCount = sc;
    }
    public void setPricePerScoop(double pps){
        pricePerScoop = pps;
    }

    public double calculateCost(){
        return scoopCount * pricePerScoop;
    }

    @Override
    public String toString(){
        String line1 = String.format("%s Ice Cream (%s)%n", this.getName(), getPackaging());
        String line2Pt1 = String.format("%d Scoops. @ $%.2f/Scoop.:", getScoopCount(), getPricePerScoop());
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        String line2 = String.format("%s\t%-45s%s%17s\n", line1, line2Pt1, line2Pt2, line2Pt3);

        return line2;

    }
}
