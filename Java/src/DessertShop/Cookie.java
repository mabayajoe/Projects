package DessertShop;

public class Cookie extends DessertItem implements SameItem<Cookie>{
    //Attributes
    private int cookieQty;
    private double pricePerDozen;


    //Constructors
    public Cookie(){
        super();
        cookieQty = 0;
        pricePerDozen = 0.0;
        setPackaging("");
    }
    public Cookie(String n, int cq, double ppd){
        super(n);
        cookieQty = cq;
        pricePerDozen = ppd;
        setPackaging("Box");
    }




    //Methods 
    public int getCookieQty(){
        return cookieQty;
    }
    public double getPricePerDozen(){
        return pricePerDozen;
    }

    public void setCookieQty(int cq){
        cookieQty = cq;
    }
    public void setPricePerDozen(double ppd){
        pricePerDozen = ppd;
    }

    public double calculateCost(){
        return cookieQty * (pricePerDozen/12);
    }
    



    @Override
    public boolean isSameAs(Cookie other) {
        if(this.getName().equals(other.getName()) && (this.getPricePerDozen() == other.getPricePerDozen())){
            return true;
        }
        return false;
    }


    @Override
    public String toString(){
        String line1 = String.format("%s Cookies (%s)%n", this.getName(), getPackaging());
        String line2Pt1 = String.format("%d Cookies. @ $%.2f/Dozen.:", getCookieQty(), getPricePerDozen());
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        String line2 = String.format("%s\t%-45s%s%17s\n", line1, line2Pt1, line2Pt2, line2Pt3);

        return line2;
    }


    
    
   

    
}
