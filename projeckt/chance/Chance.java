package lab.projeckt.chance;

import lab.projeckt.field.Card;

import java.util.Set;

public class Chance implements IChance {

    private Integer chanceCardNumber;
    private String contents;
    private Integer money;
    private Integer move;

    public Chance(Integer chanceCardNumber, String contents, Integer money, Integer move) {
        this.chanceCardNumber = chanceCardNumber;
        this.contents = contents;
        this.money = money;
        this.move = move;
    }


    public Integer getChanceCardNumber() {
        return chanceCardNumber;
    }

    public String getContents() {
        return contents;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getMove() {
        return move;
    }
}
