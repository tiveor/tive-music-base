package tive.music.base;

/**
 *
 * @author tive
 * @version 1.0
 */
public enum ESignClef {

    G_CLEF(71, "G", EStepPitch.G, EOctavePitch.CENTRAL, ELinePosition.SECOND_LINE, 184, 120),
    F_CLEF(63, "F", EStepPitch.F, EOctavePitch.THREE, ELinePosition.FOURTH_LINE, 168, 95),
    C_CLEF(256, "C", EStepPitch.C, EOctavePitch.CENTRAL, ELinePosition.THIRD_LINE, 175, 100);
    private final int mCharValue;
    private final String mValue;
    private final EStepPitch mStepPitch;
    private final EOctavePitch mOctavePitch;
    private final ELinePosition mLinePosition;
    private final int mY;
    private final int mFontSize;

    ESignClef(int charValue, String value, EStepPitch stepPitch, EOctavePitch octavePitch, ELinePosition linePosition, int y, int fontSize) {
        mCharValue = charValue;
        mValue = value;
        mStepPitch = stepPitch;
        mOctavePitch = octavePitch;
        mLinePosition = linePosition;
        mY = y;
        mFontSize = fontSize;
    }

    public EStepPitch getStepPitch() {
        return mStepPitch;
    }

    public EOctavePitch getOctavePitch() {
        return mOctavePitch;
    }

    public ELinePosition getPosition() {
        return mLinePosition;
    }

    public int getY() {
        return mY;
    }

    public int getFontSize() {
        return mFontSize;
    }

    public static ESignClef getFromName(String name) {
        for (ESignClef clef : ESignClef.values()) {
            if (name.equalsIgnoreCase(clef.mValue)) {
                return clef;
            }
        }
        return ESignClef.G_CLEF;
    }

    public String getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return ((char) mCharValue) + "";
    }
}
