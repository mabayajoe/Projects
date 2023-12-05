package DessertShop;

public class Candy extends DessertItem implements SameItem<Candy>{
    //Attributes 
    private double candyWeight;
    private double pricePerPound;
    

    //Constructor
    public Candy(){
        super();
        candyWeight = 0.0;
        pricePerPound = 0.0;
        setPackaging("");
    }

    public Candy(String n, double cw, double ppp){
        super(n);
        candyWeight = cw;
        pricePerPound = ppp;
        setPackaging("Bag");
        
    }


    //Methods 
    public double getCandyWeight(){
        return candyWeight;
    }
    public double getPricePerPound(){
        return pricePerPound;
    }


    public void setCandyWeight(double cw){
        candyWeight = cw;
    }
    public void setPricePerPound(double ppp){
        pricePerPound = ppp;
    }

    public double calculateCost(){
        return candyWeight * pricePerPound;
    }




    @Override
        public boolean isSameAs(Candy other) {
            if(this.getName().equals(other.getName()) && (this.getPricePerPound() == other.getPricePerPound())){
                return true;
            }
            return false;
        }


    @Override
    public String toString(){
        String line1 = String.format("%s (%s)%n" , this.getName(), getPackaging());
        String line2Pt1 = String.format("%.2f lbs. @ $%.2f/lbs.:", candyWeight, pricePerPound);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());
        
        String line2 = String.format("%s\t%-45s%s%17s\n", line1, line2Pt1, line2Pt2, line2Pt3);

        return line2;
    }

    

}
