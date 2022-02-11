package lab.projeckt.field;

public interface ICard {
    void buyHouse();

    Integer getCardNumber();

    String getCardName();

    Integer getCardPrice();

    Integer getHouseNumber();

    String getOwner();

    void setOwner(String owner);

    Boolean getSpecial();

    Integer getPayment(Integer house);

    Integer getPayment();

}
