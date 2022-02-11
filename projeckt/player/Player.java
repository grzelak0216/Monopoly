package lab.projeckt.player;

import lab.projeckt.field.Card;

import java.util.HashSet;
import java.util.Set;
import java.awt.Color;

public class Player implements IPlayer {
    private Integer number;
    private String name;
    private Integer wallet;
    private Set<Card> propertyList;
    private Integer position;

    public Player(
            Integer number,
            String name,
            Integer position) {
        this.number = number;
        this.name = name;
        this.wallet = 2500;
        this.propertyList = new HashSet<>();
        this.position = position;
    }

    public Player(
            Integer number,
            String name,
            Integer wallet,
            Set<Card> propertyList,
            Integer position) {
        this.number = number;
        this.name = name;
        this.wallet = wallet;
        this.propertyList = propertyList;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet += wallet;
    }

    public Set<Card> getPropertyList() {
        return propertyList;
    }

    public void addProperty(Card property) {
        this.propertyList.add(property);
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void movePlayer(Integer move) {
        this.position += move;
        if (this.position > 39){
            this.position = this.position%40;
            this.wallet += 400;
        }
    }
}
