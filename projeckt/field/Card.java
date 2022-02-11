package lab.projeckt.field;


public class Card implements ICard {

    private final Integer cardNumber;
    private final String cardName;
    private final Integer cardPrice;
    private final Boolean special;
    private Integer houseNumber;
    private String owner;

    public Card(Integer cardNumber, String cardName, Integer cardPrice, Boolean special) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardPrice = cardPrice;
        this.houseNumber = 0;
        this.owner = "free";
        this.special = special;
    }

    public Card(Integer cardNumber, String cardName, Integer cardPrice, Boolean special, Integer houseNumber, String owner) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardPrice = cardPrice;
        this.special = special;
        this.houseNumber = houseNumber;
        this.owner = owner;
    }

    public void buyHouse() {
        this.houseNumber = this.houseNumber + 1;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public Integer getCardPrice() {
        return cardPrice;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if(this.owner.equals("free")){
            this.owner = owner;
        }
    }

    public Boolean getSpecial() {
        return special;
    }

    public Integer getPayment(Integer house){
        Integer payment = (int) cardPrice/4 * (house + 1);
        return payment;
    }

    public Integer getPayment(){
        Integer payment = (int) cardPrice/4 * (houseNumber + 1);
        return payment;
    }
}
