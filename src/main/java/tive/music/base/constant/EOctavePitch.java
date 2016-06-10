package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum EOctavePitch {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    CENTRAL(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);
    private final int value;

    EOctavePitch(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EOctavePitch toOctavePitch(int value) {
        switch (value) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return CENTRAL;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            case 10:
                return TEN;
            default:
                return CENTRAL;
        }
    }

    public EOctavePitch next() {
        if (this == EOctavePitch.TEN)
            return EOctavePitch.TEN;

        EOctavePitch[] octavePitches = values();
        return octavePitches[(this.ordinal() + 1) % octavePitches.length];
    }

    public EOctavePitch prev() {

        if (this == EOctavePitch.ZERO)
            return EOctavePitch.ZERO;

        EOctavePitch[] octavePitches = values();
        return octavePitches[(this.ordinal() - 1) % octavePitches.length];
    }
}
    
