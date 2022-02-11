package lab.projeckt;

import lab.projeckt.chance.IChance;
import lab.projeckt.field.ICard;
import lab.projeckt.player.IPlayer;

import java.util.HashMap;

public interface IGameInitialization {
    HashMap<Integer, ICard> getCards();

    void setCards(HashMap<Integer, ICard> card);

    HashMap<Integer, IChance> getChance();

    void setChance(HashMap<Integer, IChance> chance);

    HashMap<Integer, IPlayer> getPlayers();

    void setPlayers(HashMap<Integer, IPlayer> players);

    HashMap<Integer, Integer[]> getPlayerPosition();


}
