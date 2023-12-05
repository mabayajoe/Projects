package DessertShop;

public interface Payable {

    enum PayType{
        CASH,
        CARD,
        PHONE
    }

    public PayType getPayType();
    
    public void setPayType(PayType pm);

}
