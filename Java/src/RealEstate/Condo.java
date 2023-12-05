package RealEstate;

public class Condo extends Residential {
    // Attributes
    private int floorLvl;

    // Constructors
    public Condo() {
        super();
        floorLvl = 0;
    }

    public Condo(String sa, int zi, double lp, double appart, int bec, double bac, int sfa, int fo) {
        super(sa, zi, lp, appart, bec, bac, sfa);
        floorLvl = fo;
    }

    // Methods
    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int fo) {
        floorLvl = fo;
    }

    @Override
    public double calculateAppraisalPrice() {
        double price = (8000 * getBeds()) + (10000 * getBaths()) + (88 * getSize()) + (5000 * (floorLvl - 1));
        super.setAppraisalPrice(price);
        return super.getApraisalPrice();
    }

    @Override
    public String toString() {
        String line1 = "----------------------------------------------------------------------";
        String line2Pt1 = "Residence Type: Condo";
        String line2Pt2 = String.format("Address: %s", getStreetAddress());
        String line2Pt3 = String.format("Zip Code: %d", getZip());
        String line2Pt4 = String.format("Sq Footage: %d", getSize());
        String line2Pt5 = String.format("Bedrooms: %d", getBeds());
        String line2Pt6 = String.format("Bathrooms: %.1f", getBaths());
        String line2Pt7 = String.format("Floor: %d", floorLvl);
        String line3 = "-----------------------------";
        String line3Pt1 = String.format("Appraisal Price: $%,.2f", getApraisalPrice());
        String line3Pt2 = String.format("List Price: $%,.2f", getListPrice());

        return String.format("%s\n%-25s%-20s%20s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", line1, line2Pt1,
                line2Pt2, line2Pt3, line1, line2Pt4, line2Pt5, line2Pt6, line2Pt7, line3, line3Pt1, line3Pt2, line3);
    }
}
