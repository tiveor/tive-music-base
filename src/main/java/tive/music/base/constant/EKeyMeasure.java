package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */

import java.util.ArrayList;

import tive.music.base.models.CNote;
import tive.music.base.models.CPitch;

public enum EKeyMeasure {

    C_FLAT_MAJOR(EFifthsKey.C_FLAT, EModeKey.MAJOR, EAccidental.FLAT, 7),
    G_FLAT_MAJOR(EFifthsKey.G_FLAT, EModeKey.MAJOR, EAccidental.FLAT, 6),
    D_FLAT_MAJOR(EFifthsKey.D_FLAT, EModeKey.MAJOR, EAccidental.FLAT, 5),
    A_FLAT_MAJOR(EFifthsKey.A_FLAT, EModeKey.MAJOR, EAccidental.FLAT, 4),
    E_FLAT_MAJOR(EFifthsKey.E_FLAT, EModeKey.MAJOR, EAccidental.FLAT, 3),
    B_FLAT_MAJOR(EFifthsKey.B_FLAT, EModeKey.MAJOR, EAccidental.FLAT, 2),
    F_MAJOR(EFifthsKey.F, EModeKey.MAJOR, EAccidental.FLAT, 1),
    C_MAJOR(EFifthsKey.C, EModeKey.MAJOR, EAccidental.NONE, 0),
    G_MAJOR(EFifthsKey.G, EModeKey.MAJOR, EAccidental.SHARP, 1),
    D_MAJOR(EFifthsKey.D, EModeKey.MAJOR, EAccidental.SHARP, 2),
    A_MAJOR(EFifthsKey.A, EModeKey.MAJOR, EAccidental.SHARP, 3),
    E_MAJOR(EFifthsKey.E, EModeKey.MAJOR, EAccidental.SHARP, 4),
    B_MAJOR(EFifthsKey.B, EModeKey.MAJOR, EAccidental.SHARP, 5),
    F_SHARP_MAJOR(EFifthsKey.F_SHARP, EModeKey.MAJOR, EAccidental.SHARP, 6),
    C_SHARP_MAJOR(EFifthsKey.C_SHARP, EModeKey.MAJOR, EAccidental.SHARP, 7),
    A_FLAT_MINOR(EFifthsKey.A_FLAT, EModeKey.MINOR, EAccidental.FLAT, 7),
    E_FLAT_MINOR(EFifthsKey.E_FLAT, EModeKey.MINOR, EAccidental.FLAT, 6),
    B_FLAT_MINOR(EFifthsKey.B_FLAT, EModeKey.MINOR, EAccidental.FLAT, 5),
    F_MINOR(EFifthsKey.F, EModeKey.MINOR, EAccidental.FLAT, 4),
    C_MINOR(EFifthsKey.C, EModeKey.MINOR, EAccidental.FLAT, 3),
    G_MINOR(EFifthsKey.G, EModeKey.MINOR, EAccidental.FLAT, 2),
    D_MINOR(EFifthsKey.D, EModeKey.MINOR, EAccidental.FLAT, 1),
    A_MINOR(EFifthsKey.A, EModeKey.MINOR, EAccidental.NONE, 0),
    E_MINOR(EFifthsKey.E, EModeKey.MINOR, EAccidental.SHARP, 1),
    B_MINOR(EFifthsKey.B, EModeKey.MINOR, EAccidental.SHARP, 2),
    F_SHARP_MINOR(EFifthsKey.F_SHARP, EModeKey.MINOR, EAccidental.SHARP, 3),
    C_SHARP_MINOR(EFifthsKey.C_SHARP, EModeKey.MINOR, EAccidental.SHARP, 4),
    G_SHARP_MINOR(EFifthsKey.G_SHARP, EModeKey.MINOR, EAccidental.SHARP, 5),
    D_SHARP_MINOR(EFifthsKey.D_SHARP, EModeKey.MINOR, EAccidental.SHARP, 6),
    A_SHARP_MINOR(EFifthsKey.A_SHARP, EModeKey.MINOR, EAccidental.SHARP, 7);

    private final EFifthsKey fifthsKey;
    private final EModeKey mode;
    private final int accidentals;
    private final EAccidental accidental;

    EKeyMeasure(EFifthsKey fifthsKey, EModeKey mode, EAccidental accidental, int accidentals) {
        this.fifthsKey = fifthsKey;
        this.mode = mode;
        this.accidental = accidental;
        this.accidentals = accidentals;
    }

    public EFifthsKey getFifthsKey() {
        return fifthsKey;
    }

    public EModeKey getMode() {
        return mode;
    }

    private ArrayList<CNote> getAccidentalFlat(EClef clef, int count) {
        ArrayList<CNote> list = new ArrayList<CNote>();

        EPitch[] pitches = new EPitch[]{EPitch.B, EPitch.E, EPitch.A, EPitch.D,
                EPitch.G, EPitch.C, EPitch.F};

        switch (clef) {
            case G_CLEF: {
                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.CENTRAL, EOctavePitch.FIVE, EOctavePitch.CENTRAL,
                        EOctavePitch.FIVE, EOctavePitch.CENTRAL, EOctavePitch.FIVE, EOctavePitch.CENTRAL};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(pitches[i], octaves[i]), EDuration.quarter, EAccidental.FLAT));
                }
            }
            break;
            case F_CLEF: {

                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.TWO, EOctavePitch.THREE, EOctavePitch.TWO,
                        EOctavePitch.THREE, EOctavePitch.TWO, EOctavePitch.THREE, EOctavePitch.THREE};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(pitches[i], octaves[i]), EDuration.quarter, EAccidental.FLAT));
                }
            }
            break;
            case C_CLEF: {
                //TODO: IMPLEMENT IT
            }

        }
        return list;
    }

    private ArrayList<CNote> getAccidentalSharp(EClef clef, int count) {
        ArrayList<CNote> list = new ArrayList<CNote>();

        EPitch[] all = new EPitch[]{EPitch.F, EPitch.C, EPitch.G, EPitch.D,
                EPitch.A, EPitch.E, EPitch.B};

        switch (clef) {
            case G_CLEF: {
                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.FIVE, EOctavePitch.FIVE, EOctavePitch.FIVE, EOctavePitch.FIVE,
                        EOctavePitch.CENTRAL, EOctavePitch.FIVE, EOctavePitch.CENTRAL};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(all[i], octaves[i]), EDuration.quarter, EAccidental.SHARP));
                }
            }
            break;

            case F_CLEF: {
                EOctavePitch[] octaves = new EOctavePitch[]{EOctavePitch.THREE, EOctavePitch.THREE, EOctavePitch.THREE, EOctavePitch.THREE,
                        EOctavePitch.TWO, EOctavePitch.THREE, EOctavePitch.TWO};

                for (int i = 0; i < count; i++) {
                    list.add(new CNote(new CPitch(all[i], octaves[i]), EDuration.quarter, EAccidental.SHARP));
                }
            }
            break;
            case C_CLEF: {
                //TODO: IMPLEMENT IT
            }
        }
        return list;
    }

    private ArrayList<CNote> getAccidentalMajor(EClef clef) {
        switch (fifthsKey) {
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
                return new ArrayList<CNote>();//assert error TODO: HANDLE ERROR
        }
    }

    private ArrayList<CNote> getAccidentalMinor(EClef clef) {
        switch (fifthsKey) {
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
                return new ArrayList<CNote>();//assert error TODO: HANDLE ERROR
        }
    }

    public ArrayList<CNote> getAccidentals(EClef clef) {
        if (mode == EModeKey.MAJOR) {
            return getAccidentalMajor(clef);
        } else {
            return getAccidentalMinor(clef);
        }
    }

    public ArrayList<EPitch> getAccidentalsSharp() {
        EPitch[] all = new EPitch[]{EPitch.F, EPitch.C, EPitch.G, EPitch.D,
                EPitch.A, EPitch.E, EPitch.B};

        ArrayList<EPitch> sharps = new ArrayList<EPitch>();
        for (int i = 0; i < accidentals; i++) {
            sharps.add(all[i]);
        }
        return sharps;
    }

    public ArrayList<EPitch> getAccidentalsFlat() {
        EPitch[] all = new EPitch[]{EPitch.B, EPitch.E, EPitch.A, EPitch.D,
                EPitch.G, EPitch.C, EPitch.F};

        ArrayList<EPitch> flats = new ArrayList<EPitch>();
        for (int i = 0; i < accidentals; i++) {
            flats.add(all[i]);
        }
        return flats;
    }

    public boolean isSharp(EPitch pitch) {

        if (accidental != EAccidental.SHARP) {
            return false;
        }

        EPitch[] all = new EPitch[]{EPitch.F, EPitch.C, EPitch.G, EPitch.D,
                EPitch.A, EPitch.E, EPitch.B};

        for (int i = 0; i < accidentals; i++) {
            if (all[i] == pitch) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlat(EPitch pitch) {
        if (accidental != EAccidental.FLAT) {
            return false;
        }

        EPitch[] all = new EPitch[]{EPitch.B, EPitch.E, EPitch.A, EPitch.D,
                EPitch.G, EPitch.C, EPitch.F};

        for (int i = 0; i < accidentals; i++) {
            if (all[i] == pitch) {
                return true;
            }
        }
        return false;
    }

    public EPitch getNameStep() {
        return fifthsKey.getPitch();
    }

    public EAccidental getNameAccidental() {
        return fifthsKey.getAccidental();
    }

    public int getAccidentalsCount() {
        return accidentals;
    }

    public EAccidental getType() {
        return accidental;
    }

    public static EKeyMeasure getKeyFromMusicXML(int fifhts, String mode) {

        int accidentals = Math.abs(fifhts);

        EAccidental type = EAccidental.NONE;
        if (fifhts > 0) {
            type = EAccidental.SHARP;
        } else if (fifhts < 0) {
            type = EAccidental.FLAT;
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
        int res = accidentals;

        if (accidental == EAccidental.FLAT) {
            res *= -1;
        }

        return res;
    }

    public static EKeyMeasure getKey(EKeyMeasure key, int initial, boolean isMayor) {

        //return new EKeyMeasure(key.getFifthsKey(), key.getMode(), key.getType(), initial);
        return null;
    }
}
