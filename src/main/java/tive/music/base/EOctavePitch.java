/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tive.music.base;

/**
 *
 * @author Administrador
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
    private final int mValue;

    EOctavePitch(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
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

    public EOctavePitch Next() {
        boolean next = false;
        for (EOctavePitch typeNote : values())//mas lento pero mas facil de hacer faltativ
        {
            if (next) {
                return typeNote;
            }

            if (typeNote == this) {
                next = true;
            }
        }

        return this;

    }

    public EOctavePitch Previous() {

        boolean next = false;
        EOctavePitch[] types = values();

        for (int i = types.length - 1; i >= 0; i--)//mas lento pero mas facil de hacer faltativ
        {
            if (next) {
                return types[i];
            }

            if (types[i] == this) {
                next = true;
            }
        }

        return this;
    }
}
    
