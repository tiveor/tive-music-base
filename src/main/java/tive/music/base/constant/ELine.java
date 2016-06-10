package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum ELine {

    FIRST(1),
    SECOND(2),
    THIRD(3),
    FORTH(4),
    FIFTH(5);

    private final int value;

    ELine(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ELine getByString(String text) {
        int value = 0;
        try {
            value = Integer.parseInt(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getByValue(value);
    }

    public static ELine getByValue(int value) {
        switch (value) {
            case 1:
                return ELine.FIRST;
            case 2:
                return ELine.SECOND;
            case 3:
                return ELine.THIRD;
            case 4:
                return ELine.FORTH;
            case 5:
                return ELine.FIFTH;
            default:
                return ELine.FIRST;
        }
    }
}
