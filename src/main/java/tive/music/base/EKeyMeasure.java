package tive.music.base;

import java.util.ArrayList;

public enum EKeyMeasure {

    C_FLAT_MAJOR(EFifthsKey.C_FLAT, EModeKey.MAJOR, EAccidentalNote.FLAT, 7),
    G_FLAT_MAJOR(EFifthsKey.G_FLAT, EModeKey.MAJOR, EAccidentalNote.FLAT, 6),
    D_FLAT_MAJOR(EFifthsKey.D_FLAT, EModeKey.MAJOR, EAccidentalNote.FLAT, 5),
    A_FLAT_MAJOR(EFifthsKey.A_FLAT, EModeKey.MAJOR, EAccidentalNote.FLAT, 4),
    E_FLAT_MAJOR(EFifthsKey.E_FLAT, EModeKey.MAJOR, EAccidentalNote.FLAT, 3),
    B_FLAT_MAJOR(EFifthsKey.B_FLAT, EModeKey.MAJOR, EAccidentalNote.FLAT, 2),
    F_MAJOR(EFifthsKey.F, EModeKey.MAJOR, EAccidentalNote.FLAT, 1),
    C_MAJOR(EFifthsKey.C, EModeKey.MAJOR, EAccidentalNote.NONE, 0),
    G_MAJOR(EFifthsKey.G, EModeKey.MAJOR, EAccidentalNote.SHARP, 1),
    D_MAJOR(EFifthsKey.D, EModeKey.MAJOR, EAccidentalNote.SHARP, 2),
    A_MAJOR(EFifthsKey.A, EModeKey.MAJOR, EAccidentalNote.SHARP, 3),
    E_MAJOR(EFifthsKey.E, EModeKey.MAJOR, EAccidentalNote.SHARP, 4),
    B_MAJOR(EFifthsKey.B, EModeKey.MAJOR, EAccidentalNote.SHARP, 5),
    F_SHARP_MAJOR(EFifthsKey.F_SHARP, EModeKey.MAJOR, EAccidentalNote.SHARP, 6),
    C_SHARP_MAJOR(EFifthsKey.C_SHARP, EModeKey.MAJOR, EAccidentalNote.SHARP, 7),
    A_FLAT_MINOR(EFifthsKey.A_FLAT, EModeKey.MINOR, EAccidentalNote.FLAT, 7),
    E_FLAT_MINOR(EFifthsKey.E_FLAT, EModeKey.MINOR, EAccidentalNote.FLAT, 6),
    B_FLAT_MINOR(EFifthsKey.B_FLAT, EModeKey.MINOR, EAccidentalNote.FLAT, 5),
    F_MINOR(EFifthsKey.F, EModeKey.MINOR, EAccidentalNote.FLAT, 4),
    C_MINOR(EFifthsKey.C, EModeKey.MINOR, EAccidentalNote.FLAT, 3),
    G_MINOR(EFifthsKey.G, EModeKey.MINOR, EAccidentalNote.FLAT, 2),
    D_MINOR(EFifthsKey.D, EModeKey.MINOR, EAccidentalNote.FLAT, 1),
    A_MINOR(EFifthsKey.A, EModeKey.MINOR, EAccidentalNote.NONE, 0),
    E_MINOR(EFifthsKey.E, EModeKey.MINOR, EAccidentalNote.SHARP, 1),
    B_MINOR(EFifthsKey.B, EModeKey.MINOR, EAccidentalNote.SHARP, 2),
    F_SHARP_MINOR(EFifthsKey.F_SHARP, EModeKey.MINOR, EAccidentalNote.SHARP, 3),
    C_SHARP_MINOR(EFifthsKey.C_SHARP, EModeKey.MINOR, EAccidentalNote.SHARP, 4),
    G_SHARP_MINOR(EFifthsKey.G_SHARP, EModeKey.MINOR, EAccidentalNote.SHARP, 5),
    D_SHARP_MINOR(EFifthsKey.D_SHARP, EModeKey.MINOR, EAccidentalNote.SHARP, 6),
    A_SHARP_MINOR(EFifthsKey.A_SHARP, EModeKey.MINOR, EAccidentalNote.SHARP, 7);
    private final EFifthsKey mFifths;
    private final EModeKey mMode;
    private final int mAccidentalsCount;
    private final EAccidentalNote mType;

    EKeyMeasure(EFifthsKey fifthsKey, EModeKey modeKey, EAccidentalNote type, int accidentals) {
        mFifths = fifthsKey;
        mMode = modeKey;
        mType = type;
        mAccidentalsCount = accidentals;
    }

    public EFifthsKey getFifths() {
        return mFifths;
    }

    public EModeKey getMode() {
        return mMode;
    }

    private ArrayList<CNote> getAccidentalFlat(ESignClef clef, int count) {
        ArrayList<CNote> list = new ArrayList<CNote>();

        EStepPitch[] pitches = new EStepPitch[]{EStepPitch.B, EStepPitch.E, EStepPitch.A, EStepPitch.D,
            EStepPitch.G, EStepPitch.C, EStepPitch.F};

        switch (clef) {
            case G_CLEF: {
                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.CENTRAL, EOctavePitch.FIVE, EOctavePitch.CENTRAL,
                    EOctavePitch.FIVE, EOctavePitch.CENTRAL, EOctavePitch.FIVE, EOctavePitch.CENTRAL};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(pitches[i], octaves[i]), ETypeNote.quarter, EAccidentalNote.FLAT));
                }
            }
            break;
            case F_CLEF: {

                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.TWO, EOctavePitch.THREE, EOctavePitch.TWO,
                    EOctavePitch.THREE, EOctavePitch.TWO, EOctavePitch.THREE, EOctavePitch.THREE};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(pitches[i], octaves[i]), ETypeNote.quarter, EAccidentalNote.FLAT));
                }
            }
            break;
            case C_CLEF: {
                //FALTATIV
            }

        }
        return list;
    }

    private ArrayList<CNote> getAccidentalSharp(ESignClef clef, int count) {
        ArrayList<CNote> list = new ArrayList<CNote>();

        EStepPitch[] all = new EStepPitch[]{EStepPitch.F, EStepPitch.C, EStepPitch.G, EStepPitch.D,
            EStepPitch.A, EStepPitch.E, EStepPitch.B};

        switch (clef) {
            case G_CLEF: {
                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.FIVE, EOctavePitch.FIVE, EOctavePitch.FIVE, EOctavePitch.FIVE,
                    EOctavePitch.CENTRAL, EOctavePitch.FIVE, EOctavePitch.CENTRAL};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(all[i], octaves[i]), ETypeNote.quarter, EAccidentalNote.SHARP));
                }
            }
            break;

            case F_CLEF: {
                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.THREE, EOctavePitch.THREE, EOctavePitch.THREE, EOctavePitch.THREE,
                    EOctavePitch.TWO, EOctavePitch.THREE, EOctavePitch.TWO};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(all[i], octaves[i]), ETypeNote.quarter, EAccidentalNote.SHARP));
                }
            }
            break;
            case C_CLEF: {
                //FALTATIV
            }
        }
        return list;
    }

    private ArrayList<CNote> getAccidentalMajor(ESignClef clef) {
        switch (mFifths) {
            case C_FLAT:
                return getAccidentalFlat(clef, 7);
            case G_FLAT:
                return getAccidentalFlat(clef, 6);
            case D_FLAT:
                return getAccidentalFlat(clef, 5);
            case A_FLAT:
                return getAccidentalFlat(clef, 4);
            case E_FLAT:
                return getAccidentalFlat(clef, 3);
            case B_FLAT:
                return getAccidentalFlat(clef, 2);
            case F:
                return getAccidentalFlat(clef, 1);
            case C:
                return new ArrayList<CNote>();
            case G:
                return getAccidentalSharp(clef, 1);
            case D:
                return getAccidentalSharp(clef, 2);
            case A:
                return getAccidentalSharp(clef, 3);
            case E:
                return getAccidentalSharp(clef, 4);
            case B:
                return getAccidentalSharp(clef, 5);
            case F_SHARP:
                return getAccidentalSharp(clef, 6);
            case C_SHARP:
                return getAccidentalSharp(clef, 7);
            default:
                return new ArrayList<CNote>();//assert error faltativ
        }
    }

    private ArrayList<CNote> getAccidentalMinor(ESignClef clef) {
        switch (mFifths) {
            case A_FLAT:
                return getAccidentalFlat(clef, 7);
            case E_FLAT:
                return getAccidentalFlat(clef, 6);
            case B_FLAT:
                return getAccidentalFlat(clef, 5);
            case F:
                return getAccidentalFlat(clef, 4);
            case C:
                return getAccidentalFlat(clef, 3);
            case G:
                return getAccidentalFlat(clef, 2);
            case D:
                return getAccidentalFlat(clef, 1);
            case A:
                return new ArrayList<CNote>();
            case E:
                return getAccidentalSharp(clef, 1);
            case B:
                return getAccidentalSharp(clef, 2);
            case F_SHARP:
                return getAccidentalSharp(clef, 3);
            case C_SHARP:
                return getAccidentalSharp(clef, 4);
            case G_SHARP:
                return getAccidentalSharp(clef, 5);
            case D_SHARP:
                return getAccidentalSharp(clef, 6);
            case A_SHARP:
                return getAccidentalSharp(clef, 7);
            default:
                return new ArrayList<CNote>();//assert error faltativ
        }
    }

    public ArrayList<CNote> getAccidentals(ESignClef clef) {
        if (mMode == EModeKey.MAJOR) {
            return getAccidentalMajor(clef);
        } else {
            return getAccidentalMinor(clef);
        }
    }

    public ArrayList<EStepPitch> getAccidentalsSharp() {
        EStepPitch[] all = new EStepPitch[]{EStepPitch.F, EStepPitch.C, EStepPitch.G, EStepPitch.D,
            EStepPitch.A, EStepPitch.E, EStepPitch.B};

        ArrayList<EStepPitch> sharps = new ArrayList<EStepPitch>();
        for (int i = 0; i < mAccidentalsCount; i++) {
            sharps.add(all[i]);
        }
        return sharps;
    }

    public ArrayList<EStepPitch> getAccidentalsFlat() {
        EStepPitch[] all = new EStepPitch[]{EStepPitch.B, EStepPitch.E, EStepPitch.A, EStepPitch.D,
            EStepPitch.G, EStepPitch.C, EStepPitch.F};

        ArrayList<EStepPitch> flats = new ArrayList<EStepPitch>();
        for (int i = 0; i < mAccidentalsCount; i++) {
            flats.add(all[i]);
        }
        return flats;
    }

    public boolean isSharp(EStepPitch pitch) {

        if (mType != EAccidentalNote.SHARP) {
            return false;
        }

        EStepPitch[] all = new EStepPitch[]{EStepPitch.F, EStepPitch.C, EStepPitch.G, EStepPitch.D,
            EStepPitch.A, EStepPitch.E, EStepPitch.B};

        for (int i = 0; i < mAccidentalsCount; i++) {
            if (all[i] == pitch) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlat(EStepPitch pitch) {
        if (mType != EAccidentalNote.FLAT) {
            return false;
        }

        EStepPitch[] all = new EStepPitch[]{EStepPitch.B, EStepPitch.E, EStepPitch.A, EStepPitch.D,
            EStepPitch.G, EStepPitch.C, EStepPitch.F};

        for (int i = 0; i < mAccidentalsCount; i++) {
            if (all[i] == pitch) {
                return true;
            }
        }
        return false;
    }

    public EStepPitch getNameStep() {
        return mFifths.getStep();
    }

    public EAccidentalNote getNameAccidental() {
        return mFifths.getAccidental();
    }

    public int getAccidentalsCount() {
        return mAccidentalsCount;
    }

    public EAccidentalNote getType() {
        return mType;
    }

    public static EKeyMeasure getKeyFromMusicXML(int fifhts, String mode) {

        int accidentals = Math.abs(fifhts);

        EAccidentalNote type = EAccidentalNote.NONE;
        if (fifhts > 0) {
            type = EAccidentalNote.SHARP;
        } else if (fifhts < 0) {
            type = EAccidentalNote.FLAT;
        }

        for (EKeyMeasure key : EKeyMeasure.values()) {
            if (key.getAccidentalsCount() == accidentals
                    && key.getType() == type
                    && EModeKey.valueOf(mode.toUpperCase()) == key.getMode()) {
                return key;
            }
        }

        return EKeyMeasure.C_MAJOR;
    }

    public int getFifthsToMusicXML() {
        int res = mAccidentalsCount;

        if (mType == EAccidentalNote.FLAT) {
            res *= -1;
        }

        return res;
    }

    public static EKeyMeasure getKey(EKeyMeasure key, int initial, boolean isMayor){

        //return new EKeyMeasure(key.getFifths(), key.getMode(), key.getType(), initial);
        return null;
    }
}
