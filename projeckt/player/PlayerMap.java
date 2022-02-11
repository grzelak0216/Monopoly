package lab.projeckt.player;

public enum PlayerMap {
    Field_0 (0, 526, 545),

    Field_1 (1, 475, 545),
    Field_2 (2, 426, 545),
    Field_3 (3, 377, 545),
    Field_4 (4, 328, 545),
    Field_5 (5, 279, 545),
    Field_6 (6, 230, 545),
    Field_7 (7, 181, 545),
    Field_8 (8, 132, 545),
    Field_9 (9, 83, 545),

    Field_10 (10, 5, 545),

    Field_11 (11, 5, 473),
    Field_12 (12, 5, 429),
    Field_13 (13, 5, 380),
    Field_14 (14, 5, 331),
    Field_15 (15, 5, 282),
    Field_16 (16, 5, 233),
    Field_17 (17, 5, 184),
    Field_18 (18, 5, 135),
    Field_19 (19, 5, 86),

    Field_20 (20, 5, 5),

    Field_21 (21, 83, 5),
    Field_22 (22, 132, 5),
    Field_23 (23, 181, 5),
    Field_24 (24, 230, 5),
    Field_25 (25, 279, 5),
    Field_26 (26, 328, 5),
    Field_27 (27, 377, 5),
    Field_28 (28, 426, 5),
    Field_29 (29, 475, 5),

    Field_30 (30, 526, 5),

    Field_31 (31, 545, 86),
    Field_32 (32, 545, 135),
    Field_33 (33, 545, 184),
    Field_34 (34, 545, 233),
    Field_35 (35, 545, 282),
    Field_36 (36, 545, 331),
    Field_37 (37, 545, 380),
    Field_38 (38, 545, 429),
    Field_39 (39, 545, 473),;

    private final Integer cardNumber;
    private final Integer positionX;
    private final Integer positionY;

    PlayerMap(Integer cardNumber, Integer positionX, Integer positionY) {
        this.cardNumber = cardNumber;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }
}
