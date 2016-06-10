package tive.music.base.constant;

/**
 * @author Alvaro Orellana
 */
public enum EClef {

    G_CLEF(71, "G", EPitch.G, EOctavePitch.CENTRAL, ELinePosition.SECOND_LINE),
    F_CLEF(63, "F", EPitch.F, EOctavePitch.THREE, ELinePosition.FOURTH_LINE),
    C_CLEF(256, "C", EPitch.C, EOctavePitch.CENTRAL, ELinePosition.THIRD_LINE);

    private final int charValue;
    private final String value;
    private final EPitch pitch;
    private final EOctavePitch octavePitch;
    private final ELinePosition linePosition;

    EClef(int charValue, String value, EPitch pitch, EOctavePitch octavePitch, ELinePosition linePosition) {
        this.charValue = charValue;
        this.value = value;
        this.pitch = pitch;
        this.octavePitch = octavePitch;
        this.linePosition = linePosition;
    }

    public EPitch getStepPitch() {
        return pitch;
    }

    public EOctavePitch getOctavePitch() {
        return octavePitch;
    }

    public ELinePosition getPosition() {
        return linePosition;
    }

    public static EClef getFromName(String name) {
        for (EClef clef : EClef.values()) {
            if (name.equalsIgnoreCase(clef.value)) {
                return clef;
            }
        }
        return EClef.G_CLEF;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return ((char) charValue) + "";
    }
}
