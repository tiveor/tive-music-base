package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum EFifthsKey {

    C_FLAT(EPitch.C, EAccidental.FLAT),
    G_FLAT(EPitch.G, EAccidental.FLAT),
    D_FLAT(EPitch.D, EAccidental.FLAT),
    A_FLAT(EPitch.A, EAccidental.FLAT),
    E_FLAT(EPitch.E, EAccidental.FLAT),
    B_FLAT(EPitch.B, EAccidental.FLAT),
    F(EPitch.F, EAccidental.NONE),
    C(EPitch.C, EAccidental.NONE),
    G(EPitch.G, EAccidental.NONE),
    D(EPitch.D, EAccidental.NONE),
    A(EPitch.A, EAccidental.NONE),
    E(EPitch.E, EAccidental.NONE),
    B(EPitch.B, EAccidental.NONE),
    F_SHARP(EPitch.F, EAccidental.SHARP),
    C_SHARP(EPitch.C, EAccidental.SHARP),
    G_SHARP(EPitch.G, EAccidental.SHARP),
    D_SHARP(EPitch.D, EAccidental.SHARP),
    A_SHARP(EPitch.A, EAccidental.SHARP);

    private final EPitch pitch;
    private final EAccidental accidental;

    EFifthsKey(EPitch pitch, EAccidental accidental) {
        this.pitch = pitch;
        this.accidental = accidental;
    }

    public EPitch getPitch() {
        return pitch;
    }

    public EAccidental getAccidental() {
        return accidental;
    }
}
