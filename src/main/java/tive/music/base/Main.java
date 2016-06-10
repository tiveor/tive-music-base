package tive.music.base;

import tive.music.base.constant.EDuration;
import tive.music.base.constant.EOctavePitch;
import tive.music.base.constant.EPitch;
import tive.music.base.models.CNote;

/**
 * @author Alvaro Orellana
 */
public class Main {

    public static void main(String args[]) {
        CNote noteDo = new CNote(EPitch.C, EOctavePitch.CENTRAL, EDuration.eighth);

    }
}
