package tive.music.base;

public enum ELine {

    FIRST(1),
    SECOND(2),
    THIRD(3),
    FORTH(4),
    FIFTH(5);
    private final int mValue;

    ELine(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public static ELine getByString(String text) {
        ELine res = ELine.FIRST;

        int value = 0;
        try {
            value = Integer.parseInt(text);
        } catch (Exception e) {
        }

        switch (value) {
            case 1:
                res = ELine.FIRST;
                break;
            case 2:
                res = ELine.SECOND;
                break;
            case 3:
                res = ELine.THIRD;
                break;
            case 4:
                res = ELine.FORTH;
                break;
            case 5:
                res = ELine.FIFTH;
                break;
        }
        return res;
    }
}
