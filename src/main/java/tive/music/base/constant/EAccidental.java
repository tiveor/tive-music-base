package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum EAccidental {

    DOUBLE_FLAT(208, -2),
    FLAT(98, -1),
    NATURAL(189, 0),
    NONE(32, 0),
    SHARP(66, 1),
    DOUBLE_SHARP(88, 2);

    private final int charValue;
    private final int semitones;

    EAccidental(int charValue, int semitones) {
        this.charValue = charValue;
        this.semitones = semitones;
    }

    public static EAccidental random() {
        EAccidental[] accidentals = values();
        return accidentals[(int) (Math.random() * accidentals.length)];
    }

    public int getCharValue() {
        return charValue;
    }

    public String getValue() {
        return ((char) charValue) + "";
    }

    public int getSemitones() {
        return semitones;
    }

    public static EAccidental getAccidentalBySemitones(int semitones) {
        for (EAccidental accidental : EAccidental.values()) {
            if (accidental == EAccidental.NATURAL) {
                continue;
            }

            if (accidental.getSemitones() == semitones) {
                return accidental;
            }
        }
        return EAccidental.NONE;
    }
}
