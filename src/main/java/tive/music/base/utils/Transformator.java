package tive.music.base.utils;

import java.util.ArrayList;

import tive.music.base.constant.ELinePosition;
import tive.music.base.models.CNote;
import tive.music.base.models.CPitch;
import tive.music.base.models.CTimeMeasure;
import tive.music.base.constant.EOctavePitch;
import tive.music.base.constant.EClef;
import tive.music.base.constant.EPitch;
import tive.music.base.constant.EDuration;

/**
 * @author Alvaro Orellana
 */
public class Transformator {

    private final static int SIZE_OCTAVE = 7;

    private static ELinePosition Transform(EPitch step, EOctavePitch octave, EClef clef) {
        int diffStep = (clef.getStepPitch()).getValue() - step.getValue();
        int diffOctave = (clef.getOctavePitch()).getValue() - octave.getValue();

        int posClef = (clef.getPosition()).getValue();

        ELinePosition[] values = ELinePosition.values();
        int pos = posClef + diffStep + SIZE_OCTAVE * diffOctave;

        if (pos < 0 || pos >= values.length) {
            pos = 0;
        }

        return values[pos];
    }

    public static ELinePosition Transform(CPitch step, EClef clef) {
        return Transform(step.getPitch(), step.getOctave(), clef);
    }

    public static CPitch Transform(ELinePosition line, EClef clef) {
        int difflines = line.getValue() - clef.getPosition().getValue();
        int diffTo = clef.getStepPitch().getValue() - difflines;
        int diffOctave = clef.getOctavePitch().getValue();
        //TODO: IF SI # IN FA CLEF IS NOT DRAWING GOOD, CHECK WHY?


        int sign = 1;

        if (diffTo > 0) {
            sign = -1;
        }

        while (diffTo > SIZE_OCTAVE || diffTo < 0) {
            diffTo = diffTo + sign * SIZE_OCTAVE;
            diffOctave = diffOctave + sign * -1;
        }
        return new CPitch(EPitch.toEStepPitch(diffTo), (EOctavePitch.toOctavePitch(diffOctave)));
    }

    public static ArrayList<CNote> toMaxSilence(EClef clef, double currentValue, CTimeMeasure time) {

        ArrayList<CNote> notes = new ArrayList<CNote>();

        double maxSpace = time.getBeats() * (1.0 / time.getBeatType().getValue());
        double currentSpace = currentValue / (time.getBeatType().getValue());

        EDuration[] types = EDuration.values();

        int i = 0;
        while (i < types.length) {

            if (!types[i].isSilence()) {
                i++;
                continue;
            } else {

                double val = 0.0;

                do {
                    val = currentSpace + (1.0 / types[i].getValue());

                    if (val <= maxSpace) {
                        currentSpace = val;
                        notes.add(MusicBuilder.createSilence(clef, types[i]));
                    }

                } while (val < maxSpace);
            }
            i++;
        }

        return notes;
    }
}
