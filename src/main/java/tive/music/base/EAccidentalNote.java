package tive.music.base;

import java.awt.*;

public enum EAccidentalNote {

    DOUBLE_FLAT(new Rectangle(0, 0, 41, 60), 140, 208, -2),
    FLAT(new Rectangle(0, 0, 20, 47), 140, 98, -1),
    NATURAL(new Rectangle(0, 0, 13, 47), 140, 189, 0),
    NONE(new Rectangle(0, 0, 0, 47), 140, 32, 0),
    SHARP(new Rectangle(0, 0, 20, 47), 140, 66, 1),
    DOUBLE_SHARP(new Rectangle(0, 0, 22, 47), 140, 88, 2);
    private final Rectangle mBounds;
    private final int mSizeFont;
    private final int mCharValue;
    private final int mSemitones;

    EAccidentalNote(Rectangle Bounds, int sizeFont, int valueChar, int semitones) {
        mBounds = Bounds;
        mSizeFont = sizeFont;
        mCharValue = valueChar;
        mSemitones = semitones;
    }

    public static EAccidentalNote Random() {
        EAccidentalNote[] accidentals = values();

        return accidentals[(int) (Math.random() * accidentals.length)];
    }

    public String getValue() {
        return ((char) mCharValue) + "";
    }

    public Rectangle getBounds() {
        return mBounds;
    }

    public int getWidth() {
        return (int) mBounds.getWidth();
    }

    public int getHeight() {
        return (int) mBounds.getHeight();
    }

    public int getSemitones() {
        return mSemitones;
    }

    public static EAccidentalNote getAccidentalFromSemitones(int semitones) {
        for (EAccidentalNote accidental : EAccidentalNote.values()) {
            if (accidental == EAccidentalNote.NATURAL) {
                continue;//OJO
            }
            
            if (accidental.getSemitones() == semitones) {
                return accidental;
            }
        }
        return EAccidentalNote.NONE;
    }
}
