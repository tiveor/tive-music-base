package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum ELinePosition {

    FIFTH_SPACE_UP(0, 5),
    FIFTH_ADITIONAL_UP(1, 5),
    FOURTH_SPACE_UP(2, 4),
    FOURTH_ADITIONAL_UP(3, 4),
    THIRD_SPACE_UP(4, 3),
    THIRD_ADITIONAL_UP(5, 3),
    SECOND_SPACE_UP(6, 2),
    SECOND_ADITIONAL_UP(7, 2),
    FIRST_SPACE_UP(8, 1),
    FIRST_ADITIONAL_UP(9, 1),
    SIX_SPACE(10, 0),
    FIFTH_LINE(11, 0),
    FIVE_SPACE(12, 0),
    FOURTH_LINE(13, 0),
    FOURTH_SPACE(14, 0),
    THIRD_LINE(15, 0),
    THIRD_SPACE(16, 0),
    SECOND_LINE(17, 0),
    SECOND_SPACE(18, 0),
    FIRST_LINE(19, 0),
    FIRST_SPACE(20, 0),
    FIRST_ADITIONAL_DOWN(21, -1),
    FIRST_SPACE_DOWN(22, -1),
    SECOND_ADTIONAL_DOWN(23, -2),
    SECOND_SPACE_DOWN(24, -2),
    THIRD_ADITIONAL_DOWN(25, -3),
    THIRD_SPACE_DOWN(26, -3),
    FOURTH_ADITIONAL_DOWN(27, -4),
    FOURTH_SPACE_DOWN(28, -4),
    FIFTH_ADITIONAL_DOWN(29, -5),
    FIFTH_SPACE_DOWN(30, -5),
    SIX_ADITIONAL_DOWN(31, -6);

    private final int value;
    private final int aditionalLines;

    ELinePosition(int value, int aditionalLines) {
        this.value = value;
        this.aditionalLines = aditionalLines;
    }

    public int getValue() {
        return value;
    }

    public int getAditionalLines() {
        return aditionalLines;
    }

    public boolean isAditional() {
        return value < 10 || value > 20;
    }
}
