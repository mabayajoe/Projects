package DessertShop;

public abstract class DessertItem implements Packaging, Comparable<DessertItem> {

    //Attributes 
    private String name;
    private double taxPercent = 7.25;
    private String packaging = "";


    //Constructors
    public DessertItem(){
        name = "";
    }
    public DessertItem(String n){
        name = n;
    }


    //Methods
    public String getName(){
        return name;
    }
    public double getTaxPercent(){
        return taxPercent;
    }

    public void setName(String n){
        name = n;
    }
    public void setTaxPercent(double tax){
        taxPercent = tax;
    }

    public abstract double calculateCost();

    public double calculateTax(){
        return (taxPercent/100) * calculateCost();
    }



    
    public String getPackaging(){
        return packaging;
    }
    
    public void setPackaging(String pac){
        packaging = pac;
    }

    @Override
    public int compareTo(DessertItem other){
        if(this.calculateCost() > other.calculateCost()){
            return 1;
        } else if (this.calculateCost() < other.calculateCost()){
                return -1;
            }
            return 0;
    }


    //@Override
    /*public int compareTo(DessertItem other){
        return (this.calculateCost().compareTo(other.calculateCost()));
    }*/


   

}
