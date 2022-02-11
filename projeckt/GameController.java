package lab.projeckt;

import lab.projeckt.chance.IChance;
import lab.projeckt.field.Card;
import lab.projeckt.field.ICard;
import lab.projeckt.player.IPlayer;

import static lab.projeckt.Board.game;

import java.util.Random;
import java.util.Scanner;


public class GameController{
    private IGameInitialization gameInitialization;
    private Stan saveGame = new Stan();
    private Boolean gamePlay = true;
    private Integer playerKey = 0;
    private Integer playerBreak = -1;

    public GameController(){
        gameInitialization = Singleton.getInstance();
        game(gameInitialization);
        while (gamePlay){
            for (Integer playerNumber: gameInitialization.getPlayers().keySet()) {
                if (playerNumber != playerBreak){
                    playerKey = playerNumber;
                    menu(playerNumber);
                    if(gameInitialization.getPlayers().get(playerNumber).getWallet() <= 0){
                        System.out.println("\nGracz nr: "
                                + (gameInitialization.getPlayers().get(playerNumber).getNumber() + 1)
                                + " - "
                                + gameInitialization.getPlayers().get(playerNumber).getName());
                        System.out.println("Zbankrutowal");
                        gamePlay = false;
                    }
                }
                playerBreak = -1;
            }
        }
        System.out.println("koniec");
    }

    public void menu(Integer player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("/////////////////////////////////////");
        System.out.println("\nGracz nr: "
                + (gameInitialization.getPlayers().get(player).getNumber() + 1)
                + " - "
                + gameInitialization.getPlayers().get(player).getName()
                + " - "
                + gameInitialization.getPlayers().get(player).getWallet()
                + " zl");

        cardInfo(gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()));
        if(!gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getOwner().equals("free")
                && !gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getOwner().equals(gameInitialization.getPlayers().get(player).getName())){
            taxes(gameInitialization.getPlayers().get(player).getPosition() , gameInitialization.getPlayers().get(player).getNumber());
        } else if (gameInitialization.getPlayers().get(player).getPosition().equals(30)){
            playerGoBrake(player);
        }


        System.out.println("1 - rzut koscia");
        System.out.println("2 - kup pozycje");
        System.out.println("3 - sprawdz posiadane pola");
        System.out.println("4 - kup dom");
        System.out.println("5 - zapisz stan gry");

        Integer option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("\n1 - rzut koscia");
                gameInitialization.getPlayers().get(player).movePlayer(rollDice());
                menu2(player);
                break;
            case 2:
                System.out.println("2 - kup pozycje");
                if (gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getOwner() == "free" &&
                        !gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getSpecial()){

                    gameInitialization.getPlayers().get(player).addProperty((Card) gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()));
                    gameInitialization.getPlayers().get(player).setWallet(-gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getCardPrice());
                    gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).setOwner(gameInitialization.getPlayers().get(player).getName());

                    System.out.println("kupiono");
                } else {
                    System.out.println("Pozycja nie dostepna");
                }
                menu(player);
                break;
            case 3:
                System.out.println("3 - sprawdz posiadane pola");
                if(gameInitialization.getPlayers().get(player).getPropertyList().isEmpty()){
                    System.out.println("\nGracz: " +
                            gameInitialization.getPlayers().get(player).getName() +
                            " - brak pol");
                } else {
                    for (ICard card: gameInitialization.getPlayers().get(player).getPropertyList()) {
                        cardInfo(card);
                    }
                }
                menu(player);
                break;
            case 4:
                System.out.println("4 - kup dom");
                if ( gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getOwner().equals(gameInitialization.getPlayers().get(player).getName())){
                    gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).buyHouse();
                    System.out.println("kupiono dom");
                } else {
                    System.out.println("nie mozna kupic domu");
                }
                menu(player);
                break;
            case 5:
                saveGame.saveGame(gameInitialization);
                System.out.println("zapisano");
                menu(player);
                break;
            default:
                System.out.println("Nieznana opcja");
                menu(player);
        }
    }

    public void menu2(Integer player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nGracz nr: "
                + (gameInitialization.getPlayers().get(player).getNumber() + 1)
                + " - "
                + gameInitialization.getPlayers().get(player).getName()
                + " - "
                + gameInitialization.getPlayers().get(player).getWallet()
                + " zl");

        Boolean show = cardInfo(gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()));

        if(!show){
            pay(gameInitialization.getPlayers().get(player).getPosition() , player);
        } else {
            System.out.println("  ");
            System.out.println("2 - kup pozycje");
            System.out.println("3 - sprawdz posiadane pola");
            System.out.println("4 - kup dom");
            System.out.println("5 - koniec rundy");
            System.out.println("6 - wczytaj ostatni stan");

            Integer option = scanner.nextInt();

            switch (option) {
                case 2:
                    System.out.println("2 - kup pozycje");
                    if (gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getOwner() == "free" &&
                            !gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getSpecial()){

                        gameInitialization.getPlayers().get(player).addProperty((Card) gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()));
                        gameInitialization.getPlayers().get(player).setWallet(-gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getCardPrice());
                        gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).setOwner(gameInitialization.getPlayers().get(player).getName());

                        System.out.println("kupiono");
                    } else {
                        System.out.println("Pozycja nie dostepna");
                    }
                    menu2(player);
                    break;
                case 3:
                    System.out.println("3 - sprawdz posiadane pola");
                    if(gameInitialization.getPlayers().get(player).getPropertyList().isEmpty()){
                        System.out.println("\nGracz: " +
                                gameInitialization.getPlayers().get(player).getName() +
                                " - brak pol");
                    } else {
                        for (ICard card: gameInitialization.getPlayers().get(player).getPropertyList()) {
                            cardInfo(card);
                        }
                    }
                    menu2(player);
                    break;
                case 4:
                    System.out.println("4 - kup dom");
                    if ( gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).getOwner().equals(gameInitialization.getPlayers().get(player).getName())){
                        gameInitialization.getCards().get(gameInitialization.getPlayers().get(player).getPosition()).buyHouse();
                        System.out.println("kupiono dom");
                    } else {
                        System.out.println("nie mozna kupic domu");
                    }
                    break;
                case 5:
                    System.out.println("5 - koniec rundy");
                    break;
                case 6:
                    saveGame.loadGame(gameInitialization);

                    System.out.println("wczytano ostatni zapis");
                    break;
                default:
                    System.out.println("Nieznana opcja");
                    menu2(player);
            }
        }
    }

    public Boolean cardInfo(ICard card){
        if(!card.getSpecial()){
            System.out.println("\nPole nr: " + card.getCardNumber());
            System.out.println("Nazwa: " + card.getCardName());
            System.out.println("Cena: " + card.getCardPrice());
            System.out.println("Oplata z bez domow: " + card.getPayment(0));
            System.out.println("Oplata z 1 domem: " + card.getPayment(1));
            System.out.println("Oplata z 2 domow: " + card.getPayment(2));
            System.out.println("Oplata z 3 domow: " + card.getPayment(3));
            System.out.println("Oplata z 4 domow: " + card.getPayment(4));

            if(card.getOwner().equals("free")){
                System.out.println("Brak wlasciciela");
            }else {
                System.out.println("Wlasciciel: " + card.getOwner());
                System.out.println("Liczba domow: "+ card.getHouseNumber());
                System.out.println("Opłata: " + card.getPayment(card.getHouseNumber()));
            }

        } else if(card.getCardNumber()%10 != 0 && card.getCardPrice() < 0){
            System.out.println("OJOJ: " + card.getCardName());
            System.out.println("Wydajesz: " + (card.getCardPrice() * -1));
            return false;
        } else if(card.getCardNumber()%10 == 0){
            if(card.getCardNumber() == 0){
                System.out.println("Inauguracja dostajesz: 400 zl");
            } else if (card.getCardNumber() == 10){
                System.out.println("Odwiedzasz znajomych na dziekance");
            } else if (card.getCardNumber() == 20){
                System.out.println("Dostajesz stypendium: 800 zl");
            } else if (card.getCardNumber() == 30){
                System.out.println("Zlapali ci na plagiacie - idziesz na dziekanke");
            }
            return false;
        } else if (card.getCardName().equals("Karta szansy")){
            chanceInfo();
        }
        return true;
    }

    public void chanceInfo(){
        Random random = new Random();
        IChance chance = gameInitialization.getChance().get(random.nextInt(34)+1);
        IPlayer player = gameInitialization.getPlayers().get(playerKey);
        System.out.println("Szansa nr: " + (chance.getChanceCardNumber() + 1));
        if (!chance.getMoney().equals(0)){
            System.out.println(chance.getContents() + " : " + chance.getMoney());
        } else {
            System.out.println(chance.getContents());
        }

        player.setWallet(chance.getMoney());
        if (chance.getMove() != null){
            if (chance.getMove() < 0){
                player.movePlayer(chance.getMove());
            } else {
                player.setPosition(chance.getMove());
            }
        }
    }

    public Integer rollDice(){
        Random rand = new Random();
        Integer move = rand.nextInt(6) + 1;
        System.out.println("KOSTKA - przemieszczesz się o " + move + " pol");
        return move;
    }

    public void playerGoBrake(Integer player){
        playerBreak = player;
        gameInitialization.getPlayers().get(playerKey).setPosition(10);
        System.out.println("Dziekanka :(");
    }

    public void taxes (Integer cardNumber, Integer playerNumber){
        gameInitialization.getPlayers().get(playerNumber).setWallet(-gameInitialization.getCards().get(cardNumber).getPayment());
        System.out.println(gameInitialization.getPlayers().get(playerNumber).getName() + " zaplacil: " + gameInitialization.getCards().get(cardNumber).getPayment() + " zl podatku");
        for (Integer playerFind: gameInitialization.getPlayers().keySet()) {
            if(gameInitialization.getPlayers().get(playerFind).getName().equals(gameInitialization.getCards().get(cardNumber).getOwner())){
                gameInitialization.getPlayers().get(playerFind).setWallet(gameInitialization.getCards().get(cardNumber).getPayment());
                System.out.println(gameInitialization.getPlayers().get(playerNumber).getName() + " dostal: " + gameInitialization.getCards().get(cardNumber).getPayment() + " zl");
            }
        }
    }

    public void pay(Integer cardNumber, Integer playerNumber){
        gameInitialization.getPlayers().get(playerNumber).setWallet(gameInitialization.getCards().get(cardNumber).getCardPrice());
    }


}
