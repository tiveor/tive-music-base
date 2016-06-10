package tive.music.base.models;

import java.io.Serializable;

import tive.music.base.constant.ELine;
import tive.music.base.constant.EClef;

/**
 * @author Alvaro Orellana
 */
public class CClef implements Serializable {

    private EClef clef;
    private ELine line;

    public CClef(EClef clef) {
        this.clef = clef;

        switch (this.clef) {
            case G_CLEF:
                line = ELine.SECOND;
                break;
            case C_CLEF:
                line = ELine.THIRD;
                break;
            case F_CLEF:
                line = ELine.FORTH;
                break;
        }
    }

    public ELine getLine() {
        return line;
    }

    public void setLine(ELine line) {
        this.line = line;
    }

    public EClef getSign() {
        return clef;
    }

    public void setSign(EClef sign) {
        clef = sign;
    }
}
