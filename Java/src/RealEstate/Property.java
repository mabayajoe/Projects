package RealEstate;

public abstract class Property {
    //Attributes
    private String streetAddress;
    private int zip;
    private double listPrice = 0;
    private double appraisalPrice = 0;


    

    //Constructors
    public Property(){
        streetAddress = "";
        zip = 0;
        listPrice = 0;
        appraisalPrice = 0;
    }

    public Property(String sa, int zi, double lp, double appa){/*double lp, double appa*/
        streetAddress = sa;
        zip = zi;
        listPrice = lp;
        appraisalPrice = appa;
    }




    //Methods
    public String getStreetAddress(){
        return streetAddress;
    }
    public int getZip(){
        return zip;
    }
    public double getListPrice(){
        return listPrice;
    }
    public double getApraisalPrice(){
        return appraisalPrice;
    }



    public void setStreetAddress(String sa){
        streetAddress = sa;
    }
    public void setZip(int zi){
        zip = zi;
    }
    public void setListPrice(double lp){
        listPrice = lp;
    }
    protected void setAppraisalPrice(double appa){
        appraisalPrice = appa;
    }


    public abstract double calculateAppraisalPrice();

}
