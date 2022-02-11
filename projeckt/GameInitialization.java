package lab.projeckt;

import lab.projeckt.chance.Chance;
import lab.projeckt.chance.IChance;
import lab.projeckt.chance.ChanceList;
import lab.projeckt.field.Card;
import lab.projeckt.field.ICard;
import lab.projeckt.field.CardList;
import lab.projeckt.player.IPlayer;
import lab.projeckt.player.Player;
import lab.projeckt.player.PlayerMap;

import java.util.HashMap;
import java.util.Scanner;


public class GameInitialization implements IGameInitialization {

    private HashMap<Integer, ICard> cards = new HashMap<>();;
    private HashMap<Integer, IChance> chance = new HashMap<>();
    private HashMap<Integer, IPlayer> players = new HashMap<>();
    private HashMap<Integer, Integer[]> playerPosition = new HashMap<>();

    public GameInitialization() {
        for (ChanceList chanceList: ChanceList.values()) {
            chance.put(
                    chanceList.getCardNumber(),
                    new Chance(
                            chanceList.getCardNumber(),
                            chanceList.getContents(),
                            chanceList.getMoney(),
                            chanceList.getMove()
                    )
            );
        }

        for (CardList cardList: CardList.values()) {
            cards.put(
                    cardList.getNumber(),
                    new Card(
                            cardList.getNumber(),
                            cardList.getName(),
                            cardList.getPrice(),
                            cardList.getSpecial()
                    )
            );
        }

        for (PlayerMap playerMap: PlayerMap.values()) {
            Integer[] tmp = {playerMap.getPositionX(), playerMap.getPositionY()};
            playerPosition.put(playerMap.getCardNumber(), tmp);
        }

        setPlayers();
    }

    public void setPlayers(){
        String playerName;
        Integer playerNumber = 0;

        do{
            Scanner number = new Scanner(System.in);
            System.out.println("Podaj liczbe graczy:");
            playerNumber = number.nextInt();
        }while(playerNumber < 2 || playerNumber > 4);

        for(int i = 0; i < playerNumber; i++){
            System.out.println("Podaj pseudonim gracza nr. " + (i + 1) + ":");
            Scanner name = new Scanner(System.in);
            playerName = name.nextLine();

            players.put(i, new Player(i, playerName, 0));
        }
    }

    public HashMap<Integer, ICard> getCards() {
        return cards;
    }

    public HashMap<Integer, IChance> getChance() {
        return chance;
    }

    public HashMap<Integer, IPlayer> getPlayers() {
        return players;
    }

    public HashMap<Integer, Integer[]> getPlayerPosition() {
        return playerPosition;
    }

    public void setCards(HashMap<Integer, ICard> cards){
        this.cards = cards;
    }

    public void setChance(HashMap<Integer, IChance> chance){
        this.chance = chance;
    }

    public void setPlayers(HashMap<Integer, IPlayer> players){
        this.players = players;
    }
}

