package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum EDuration {

    whole(1, 1, 40000, 119, false),
    half(2, 2, 20000, 104, false),
    quarter(3, 4, 10000, 113, false),
    eighth(4, 8, 5000, 101, false),
    sixteenth(5, 16, 2500, 115, false),
    thirtysecond(6, 32, 1250, 113, false),//a partir de la negra
    sixtyfour(7, 64, 625, 113, false),//a partir de la negra

    silence_whole(1, 1, 40000, 257, true),
    silence_half(2, 2, 20000, 257, true),
    silence_quarter(3, 4, 10000, 81, true),
    silence_eighth(4, 8, 5000, 69, true),
    silence_sixteenth(5, 16, 2500, 83, true),
    silence_thirtysecond(6, 32, 1250, 83, true),//a partir de la negra
    silence_sixtyfour(7, 64, 625, 83, true);//a partir de la negra

    private final int value;
    private final int tmn;
    private final int midiValue;
    private final int charValue;
    private final boolean isSilence;

    EDuration(int tmn, int value, int midiValue, int charValue, boolean isSilence) {
        this.tmn = tmn;
        this.value = value;
        this.midiValue = midiValue;
        this.charValue = charValue;
        this.isSilence = isSilence;
    }

    public int getValue() {
        return value;
    }

    public int getTMN() {
        return tmn;
    }

    public int getMidiValue() {
        return midiValue;
    }


    public static EDuration random() {
        EDuration[] mType = values();
        return mType[(int) (Math.random() * (mType.length - 1))];
    }

    public static EDuration getDuration(int position) {
        EDuration[] notes = values();

        assert position >= 0 && position < notes.length;

        return notes[position - 1];
    }

    public static EDuration getDurationByValue(int value) {
        for (EDuration note : values()) {
            if (note.getValue() == value)
                return note;
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

    public static EDuration getTypeSilenceByMidiValue(int midiValue) {
        for (EDuration note : values()) {
            if (isEqual(midiValue, note.getMidiValue()) && note.isSilence()) {
                return note;
            }
        }

        return EDuration.silence_eighth; //parchado
        /*assert false;
        return null;*/
    }

    public static EDuration getTypeNoteByMidiValue(int midiValue) {
        for (EDuration note : values()) {
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

        return EDuration.eighth; //parchado
        /*assert false;
        return null;*/
    }

    @Override
    public String toString() {
        return ((char) charValue) + "";
    }

    public boolean isSilence() {
        return isSilence;
    }

    public EDuration next() {
        if (this == sixtyfour)
            return sixtyfour;

        EDuration[] durations = values();
        return durations[(this.ordinal() + 1) % durations.length];
    }

    public EDuration previous() {

        if (this == whole)
            return whole;

        EDuration[] durations = values();
        return durations[(this.ordinal() - 1) % durations.length];
    }

    public EDuration toSilence() {
        if (isSilence)
            return this;

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
                return this;
        }
    }

    public int getDurationForMusicXML() {
        return (64 / value);//TODO MUSICXML: Consider DIVISIONS  == 1
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
