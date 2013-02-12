package tive.music.base;

import java.awt.Point;

/**
 *
 * @author tive
 * @version 1.0
 */
public enum ETypeNote {

    whole(2, 0, 33, -28, 90, 1, 1, 40000, 119, false),
    half(1, 0, 25, -28, 110, 2, 2, 20000, 104, false),
    quarter(1, 0, 25, -28, 110, 3, 4, 10000, 113, false),
    eighth(1, 0, 44, -28, 110, 4, 8, 5000, 101, false),
    sixteenth(1, 0, 44, -28, 110, 5, 16, 2500, 115, false),
    thirtysecond(9, 0, 62, -28, 110, 6, 32, 1250, 113, false),//a partir de la negra
    sixtyfour(9, 0, 62, -28, 110, 7, 64, 625, 113, false),//a partir de la negra

    silence_whole(-10, 153, 32, 0, 110, 1, 1, 40000, 257, true),
    silence_half(-10, 163, 32, -15, 110, 2, 2, 20000, 257, true),
    silence_quarter(1, 180, 18, 0, 110, 3, 4, 10000, 81, true),
    silence_eighth(1, 174, 20, 0, 85, 4, 8, 5000, 69, true),
    silence_sixteenth(1, 180, 24, 0, 110, 5, 16, 2500, 83, true),
    silence_thirtysecond(19, 78, 82, 0, 110, 6, 32, 1250, 83, true),//a partir de la negra
    silence_sixtyfour(19, 78, 82, 0, 110, 7, 64, 625, 83, true);//a partir de la negra
    private final int mWidth;
    private final Point mStringPoint;
    private final int mSizeFont;
    private final int mValue;
    private final int mTMN;
    private final int mPosAccidentalOrPosAbsolute;
    private final int mMidiValue;
    private final int mCharValue;
    private final boolean mIsSilence;

    ETypeNote(int xString, int yString, int width, int posAccidentalOrPosAbsolute,
            int sizeFont, int tmn, int value, int midiValue, int valueChar, boolean isSilence) {
        mStringPoint = new Point(xString, yString);
        mWidth = width;
        mSizeFont = sizeFont;
        mPosAccidentalOrPosAbsolute = posAccidentalOrPosAbsolute;
        mTMN = tmn;
        mValue = value;
        mMidiValue = midiValue;
        mCharValue = valueChar;
        mIsSilence = isSilence;
    }

    public int getValue() {
        return mValue;
    }

    public int getTMN() {
        return mTMN;
    }

    public int getMidiValue() {
        return mMidiValue;
    }

    public int getXString() {
        return (int) mStringPoint.getX();
    }

    public int getYString() {
        return (int) mStringPoint.getY();
    }

    public int getWidth() {
        return mWidth;
    }

    public int getSizeFont() {
        return mSizeFont;
    }

    public static ETypeNote Random() {
        ETypeNote[] mType = values();

        return mType[(int) (Math.random() * (mType.length - 1))];
    }

    public static ETypeNote getTypeNote(int position) {
        ETypeNote[] notes = values();

        assert position >= 0 && position < notes.length;

        return notes[position - 1];
    }

    public static ETypeNote getTypeNoteByValue(int value) {
        for (ETypeNote note : values()) {
            if (note.getValue() == value) {
                return note;
            }
        }
        assert false;
        return null;
    }

    private static boolean isEqual(int evaluate, int value) {

        int tolerance = 1000;
        int rx1 = value + tolerance;
        int rx2 = value - tolerance;

        return (evaluate >= rx2 && evaluate <= rx1);

    }

    public static ETypeNote getTypeSilenceByMidiValue(int midiValue) {
        for (ETypeNote note : values()) {
            if (isEqual(midiValue, note.getMidiValue()) && note.isSilence()) {
                return note;
            }
        }

        return ETypeNote.silence_eighth; //parchado
        /*assert false;
        return null;*/
    }

    public static ETypeNote getTypeNoteByMidiValue(int midiValue) {
        for (ETypeNote note : values()) {
            if (note.isSilence()) {
                continue;
            }

            if (isEqual(midiValue, note.getMidiValue())) {
                return note;
            }

            if (note.getMidiValue() < midiValue) {
                return note;
            }
        }

        return ETypeNote.eighth; //parchado
        /*assert false;
        return null;*/
    }

    @Override
    public String toString() {
        return ((char) mCharValue) + "";
    }

    public int getPosAccidental() {
        return mPosAccidentalOrPosAbsolute;
    }

    public boolean isSilence() {
        return mIsSilence;
    }

    public ETypeNote next() {
        boolean next = false;
        for (ETypeNote typeNote : values())//mas lento pero mas facil de hacer faltativ
        {
            if (next) {
                return typeNote;
            }

            if (typeNote == this) {
                next = true;
            }
        }

        return this;


        /*switch(this)
        {
        case whole          : return half;
        case half           : return quarter;
        case eighth         : return sixteenth;
        case sixteenth      : return thirtysecond;
        case thirtysecond   : return sixtyfour;
        case sixtyfour      : return sixtyfour;

        case silence_whole          : return silence_half;
        case silence_half           : return silence_quarter;
        case silence_quarter        : return silence_sixteenth;
        case silence_sixteenth      : return silence_thirtysecond;
        case silence_thirtysecond   : return silence_sixtyfour;
        case silence_sixtyfour      : return silence_sixtyfour;
        }*/
    }

    public ETypeNote previous() {

        boolean next = false;
        ETypeNote[] types = values();

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

        /*switch(this)
        {
        case whole          : return half;
        case half           : return quarter;
        case eighth         : return sixteenth;
        case sixteenth      : return thirtysecond;
        case thirtysecond   : return sixtyfour;
        case sixtyfour      : return sixtyfour;
        }*/

    }

    public ETypeNote toSilence() {
        if (mIsSilence) {
            return this;
        } else {

            switch (this) {
                case whole:
                    return silence_whole;
                case half:
                    return silence_half;
                case quarter:
                    return silence_quarter;
                case eighth:
                    return silence_eighth;
                case sixteenth:
                    return silence_sixteenth;
                case thirtysecond:
                    return silence_thirtysecond;
                case sixtyfour:
                    return silence_sixtyfour;
                default:
                    return null;
            }
        }
    }

    public int getDurationForMusicXML() {
        return (64 / mValue);//CONSIDERANDO DIVISIONS  == 1
    }

    public String getTpeForMusicXML() {
        switch (this) {
            case whole:
            case half:
            case quarter:
            case eighth:
                return this.name().toLowerCase();

            case silence_whole:
            case silence_half:
            case silence_quarter:
            case silence_eighth:
                return this.name().replaceAll("silence_", "").toLowerCase();


            case sixteenth:
            case silence_sixteenth:
                return "16th";
            case thirtysecond:
            case silence_thirtysecond:
                return "32th";
            case sixtyfour:
            case silence_sixtyfour:
                return "32th";

            default:
                return "error";
        }
    }
}
