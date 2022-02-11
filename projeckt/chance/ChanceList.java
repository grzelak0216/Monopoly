package lab.projeckt.chance;

public enum ChanceList {
    CHANCE_1 (1,"Wracasz na start",  400, 0),
    CHANCE_2 (2,"Cofasz sie o 3 pola",  0, -3),
    CHANCE_3 (3,"Zostales zlapany na plagiacie",  0, 10),
    CHANCE_4 (4,"Wygrales konkurs naukowy",  200, null),
    CHANCE_5 (5,"Rektor wyplaca ci nalezne odsetki",  300, null),
    CHANCE_6 (6,"Spales na wykladach",  -50, null),
    CHANCE_7 (7,"Pacisz na budowe nowego budynku",  -400, null),
    CHANCE_8 (8,"Prezent urodzinowy",  100, null),
    CHANCE_9 (9,"Kasjer pomylil sie na twoja korzysc",  30, null),
    CHANCE_10 (10,"Kasjer pomylil sie na twoja niekorzysc",  -30, null),
    CHANCE_11 (11,"Otrzymujesz dofinansowanie unijne",  200, null),
    CHANCE_12 (12,"Placisz za leczenie",  -50, null),
    CHANCE_13 (13,"Placisz za ubezpieczenie",  -150, null),
    CHANCE_14 (14,"Zostales zlapany na plagiacie",  0, 10),
    CHANCE_15 (15,"Wracasz na start",  400, 0),
    CHANCE_16 (16,"Otrzymujesz roczna rete",  200, null),
    CHANCE_17 (17,"Idziesz na ARCHITEKTURE",  0, 39),
    CHANCE_18 (18,"Cofasz sie o 5 pol",  0, -5),
    CHANCE_19 (19,"Idziesz na BIOTECHNOLOGIE",  0, 21),
    CHANCE_20 (20,"Idziesz na INFORMATYKE",  0, 34),
    CHANCE_21 (21,"Idziesz na STUDENCKIE KOLO ESPORTOWE",  0, 25),
    CHANCE_22 (22,"Wychodzisz do KLUBU KWADRAT",  -100, 12),
    CHANCE_23 (23,"Idziesz na GEOINFORMATYKA",  0, 6),
    CHANCE_24 (24,"Kontrola z Sanepidu",  -300, null),
    CHANCE_25 (25,"Wygrales turniej szachowy",  100, null),
    CHANCE_26 (26,"Cofasz sie o jedno pole",  0, -1),
    CHANCE_27 (27,"Mandat za szybka jazde",  -100, null),
    CHANCE_28 (28,"Miasto postanawia cie dofinansowac",  250, null),
    CHANCE_29 (29,"Uczelnia wyplaca ci prezent",  100, null),
    CHANCE_30 (30,"Uczelnia podnosi oplaty",  -150, null),
    CHANCE_31 (31,"Dostajesz kupon rabatowy",  50, null),
    CHANCE_32 (32,"Dostajesz przelew od rodzicow",  300, null),
    CHANCE_33 (33,"Znajomy zwraca pozyczke",  100, null),
    CHANCE_34 (34,"Dostajesz przelew od pracodawcy",  200, null),
    CHANCE_35 (35,"Popelniles blad w PIT",  -300, null),;

    private final Integer cardNumber;
    private final String contents;
    private final Integer money;
    private final Integer move;

    ChanceList(Integer cardNumber, String contents, Integer money, Integer move) {
        this.cardNumber = cardNumber;
        this.contents = contents;
        this.money = money;
        this.move = move;
    }

    public Integer getCardNumber() {
        return cardNumber;
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
