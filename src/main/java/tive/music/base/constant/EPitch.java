package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum EPitch {

    C(1, 2),
    D(2, 2),
    E(3, 1),
    F(4, 2),
    G(5, 2),
    A(6, 2),
    B(7, 1);

    private final int value;
    private final int nextSemitones;

    EPitch(int value, int nextPitchSemitones) {
        this.value = value;
        nextSemitones = nextPitchSemitones;
    }

    public int getValue() {
        return value;
    }

    public static EPitch random() {
        EPitch[] pitches = values();
        return pitches[(int) (Math.random() * pitches.length)];
    }

    public static EPitch toEStepPitch(int value) {
        switch (value) {
            case 1:
                return C;
            case 2:
                return D;
            case 3:
                return E;
            case 4:
                return F;
            case 5:
                return G;
            case 6:
                return A;
            case 7:
                return B;
            default:
                assert false;
                return C;
        }
    }

    public EPitch next() {
        if (this == EPitch.B)
            return EPitch.C;

        EPitch[] pitches = values();
        return pitches[(this.ordinal() + 1) % pitches.length];
    }

    public EPitch prev() {
        if (this == EPitch.C)
            return EPitch.B;

        EPitch[] pitches = values();
        return pitches[(this.ordinal() - 1) % pitches.length];
    }
}
