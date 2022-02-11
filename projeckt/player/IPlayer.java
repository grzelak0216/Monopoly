package lab.projeckt.player;

import lab.projeckt.field.Card;

import java.util.Set;

public interface IPlayer {
    String getName();

    Integer getNumber();

    void setWallet(Integer wallet);

    Integer getWallet();

    Set<Card> getPropertyList();

    void addProperty(Card property);

    Integer getPosition();

    void setPosition(Integer position);

    void movePlayer(Integer move);
}
