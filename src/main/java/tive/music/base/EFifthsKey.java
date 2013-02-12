package tive.music.base;

public enum EFifthsKey {

    C_FLAT(EStepPitch.C, EAccidentalNote.FLAT),
    G_FLAT(EStepPitch.G, EAccidentalNote.FLAT),
    D_FLAT(EStepPitch.D, EAccidentalNote.FLAT),
    A_FLAT(EStepPitch.A, EAccidentalNote.FLAT),
    E_FLAT(EStepPitch.E, EAccidentalNote.FLAT),
    B_FLAT(EStepPitch.B, EAccidentalNote.FLAT),
    F(EStepPitch.F, EAccidentalNote.NONE),
    C(EStepPitch.C, EAccidentalNote.NONE),
    G(EStepPitch.G, EAccidentalNote.NONE),
    D(EStepPitch.D, EAccidentalNote.NONE),
    A(EStepPitch.A, EAccidentalNote.NONE),
    E(EStepPitch.E, EAccidentalNote.NONE),
    B(EStepPitch.B, EAccidentalNote.NONE),
    F_SHARP(EStepPitch.F, EAccidentalNote.SHARP),
    C_SHARP(EStepPitch.C, EAccidentalNote.SHARP),
    G_SHARP(EStepPitch.G, EAccidentalNote.SHARP),
    D_SHARP(EStepPitch.D, EAccidentalNote.SHARP),
    A_SHARP(EStepPitch.A, EAccidentalNote.SHARP);
    private final EStepPitch mStepPitch;
    private final EAccidentalNote mAccidental;

    private EFifthsKey(EStepPitch pitch, EAccidentalNote accidental) {
        mStepPitch = pitch;
        mAccidental = accidental;
    }

    public EStepPitch getStep() {
        return mStepPitch;
    }

    public EAccidentalNote getAccidental() {
        return mAccidental;
    }
}
