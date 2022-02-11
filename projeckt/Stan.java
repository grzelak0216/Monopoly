package lab.projeckt;

import lab.projeckt.chance.Chance;
import lab.projeckt.chance.ChanceList;
import lab.projeckt.chance.IChance;
import lab.projeckt.field.Card;
import lab.projeckt.field.ICard;
import lab.projeckt.player.IPlayer;
import lab.projeckt.player.Player;

import java.util.HashMap;

public class Stan {

    private HashMap<Integer, ICard> cards;
    private HashMap<Integer, IPlayer> players;

    public void loadGame(IGameInitialization game) {
        game.setCards(cards);
        game.setPlayers(players);
    }

    public void saveGame(IGameInitialization games){
        cards = new HashMap<>();
        players = new HashMap<>();

        for (IPlayer player: games.getPlayers().values()) {
            players.put(
                    player.getNumber(),
                    new Player(
                            player.getNumber(),
                            player.getName(),
                            player.getWallet(),
                            player.getPropertyList(),
                            player.getPosition()
                    )
            );
        }

        for (ICard card: games.getCards().values()) {
            cards.put(
                    card.getCardNumber(),
                    new Card(
                            card.getCardNumber(),
                            card.getCardName(),
                            card.getCardPrice(),
                            card.getSpecial(),
                            card.getHouseNumber(),
                            card.getOwner()
                    )
            );
        }
    }

}
