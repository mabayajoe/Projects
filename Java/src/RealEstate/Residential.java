package RealEstate;

public abstract class Residential extends Property {
    //Attributes
    private int bedCount;
    private double bathCount;
    private final int sqFootage;



    //Constructors
    public Residential(){
        super();
        bedCount = 0;
        bathCount = 0;
        sqFootage = 0;
    }
    public Residential(String sa, int zi,double lp, double appa, int bec, double bac, int sfa){
        super(sa, zi, lp, appa);
        bedCount = bec;
        bathCount = bac;
        sqFootage = sfa;
    }
 




    //Methods
    public int getBeds(){
        return bedCount;
    }
    public double getBaths(){
        return bathCount;
    }
    public int getSize(){
        return sqFootage;
    }




    public void setBeds(int bec){
        bedCount = bec;
    }
    public void setBaths(double d){
        bathCount = d;
    }


    public abstract double calculateAppraisalPrice();
}
