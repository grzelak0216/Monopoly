package lab.projeckt.field;

public enum CardList {
    BUDOWNICTWO ("Budownictwo", 120, 1, false),
    TRANSPORT ("Transport", 130, 3, false),
    AKADEMICKI_ZWIAZEK_SPORTOWY ("Akademicki Zwiacek Akademicki", 400, 5, false),
    GEOINFORMATYKA ("Geoinformatyka", 200, 6, false),
    INZYNIERIA_SRODOWISKOWA ("Inzynieria Srodowiskowa", 220, 8, false),
    ENERGETYKA ("Energetyka", 240, 9, false),

    INZYNIERIA_PRODUKCJI ("Inzynieria Produkcji", 280, 11, false),
    KLUB_KWADRAT ("Klub Kwadrat", 300, 12, false),
    AUTOMATYKA_I_ROBOTYKA ("Automatyka I Robotyka", 300, 13, false),
    INFORMATYKA_STOSOWANA ("Informatyka Stosowana", 320, 14, false),
    ERASMUS_STUDENT_NETWORK ("Erasmus Student Network", 400, 15, false),
    NANOTECHNOLOGIE_I_NANOMATERIALY ("Nanotechnologie I Nanomaterialy", 360, 16, false),
    INZYNIERIA_MATERIALOWA ("Inzynieria Materialowa", 380, 18, false),
    FIZYKA_STOSOWANA ("Fizyka Stosowana", 400, 19, false),

    BIOTECHNOLOGIA ("Biotechnologia", 440, 21, false),
    INZYNIERIA_CHEMICZNA ("Inzynieria Chemiczna", 460, 23, false),
    TECHNOLOGIA_CHEMICZNA ("Technologia Chemiczna", 480, 24, false),
    STUDENCKIE_KOLO_ESPORTOWE ("Studenckie Kolo Esportowe", 400, 25, false),
    AUTOMATYKA ("Automatyka", 520, 26, false),
    ELEKTROTECHNIKA ("Elektrotechnika", 540, 27, false),
    OSIEDLE_AKADEMICKIE ("Osiedle Akademickie", 300, 28, false),
    INFORMATYKA_INZYNIERI_KOMPUTEROWEJ ("Informatyka Inzynieri Komputerowej", 560, 29, false),

    MATEMATYKA_STOSOWANA ("Matematyka Stosowana", 600, 31, false),
    MATEMATYKA ("Matematyka", 620, 32, false),
    INFORMATYKA ("Informatyka", 640, 34, false),
    NIEZALEZNE_ZRZESZENIE_STUDENTOW ("Niezalezne Zrzeszenie Studentow", 400, 35, false),
    ARCHITEKTURA_KRAJOBRAZU ("Architektura Krajobrazu", 700, 37, false),
    ARCHITEKTURA ("Architektura", 800, 39, false),

    CHANCE_CARD1 ("Karta szansy", 0, 2, true),
    CHANCE_CARD2 ("Karta szansy", 0, 7, true),
    CHANCE_CARD3 ("Karta szansy", 0, 17, true),
    CHANCE_CARD4 ("Karta szansy", 0, 22, true),
    CHANCE_CARD5 ("Karta szansy", 0, 33, true),
    CHANCE_CARD6 ("Karta szansy", 0, 36, true),

    JUWENALIA ("Juwenalia", -400, 4, true),
    WYJSCIE_NA_MIASTO ("Wyjscie na miasto", -200, 38, true),

    INAUGURACJA ("Inauguracja", 400, 0, true),
    DZIEKANKA ("Dziekanka", 0, 10, true),
    STYPENDIUM ("Stypendium", 800, 20, true),
    PALGIAT ("Plagiat", 0, 30, true);

    private final String name;
    private final Integer price;
    private final Integer number;
    private final Boolean special;

    private CardList(String name, Integer price, Integer number, Boolean special) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNumber() {
        return number;
    }

    public Boolean getSpecial() {
        return special;
    }
}
