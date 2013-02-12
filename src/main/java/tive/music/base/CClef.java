package tive.music.base;

import java.io.Serializable;

public class CClef implements Serializable {

    private ESignClef mSign;
    private ELine mLine;

    public CClef(ESignClef sign) {
        mSign = sign;
        switch (mSign) {
            case G_CLEF:
                mLine = ELine.SECOND;
                break;
            case C_CLEF:
                mLine = ELine.THIRD;
                break;
            case F_CLEF:
                mLine = ELine.FORTH;
                break;
        }
    }

    public ELine getLine() {
        return mLine;
    }

    public void setLine(ELine line) {
        mLine = line;
    }

    public ESignClef getSign() {
        return mSign;
    }

    public void setSign(ESignClef sign) {
        mSign = sign;
    }
}
