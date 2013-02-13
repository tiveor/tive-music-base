package tive.music.base.utils;

import java.util.ArrayList;

import tive.music.base.ELinePosition;
import tive.music.base.CNote;
import tive.music.base.CPitch;
import tive.music.base.CTimeMeasure;
import tive.music.base.EOctavePitch;
import tive.music.base.ESignClef;
import tive.music.base.EStepPitch;
import tive.music.base.ETypeNote;

/**
 *
 * @author tive
 * @version 1.0
 */
public class Transformator {

    private final static int SIZE_OCTAVE = 7;

    private static ELinePosition Transform(EStepPitch step, EOctavePitch octave, ESignClef clef) {
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

    public static ELinePosition Transform(CPitch step, ESignClef clef) {
        return Transform(step.getStep(), step.getOctave(), clef);
    }

    public static CPitch Transform(ELinePosition line, ESignClef clef) {
        int difflines = line.getValue() - clef.getPosition().getValue();
        int diffTo = clef.getStepPitch().getValue() - difflines;
        int diffOctave = clef.getOctavePitch().getValue();
        //FALTATIV AQUI ME QUEDE EL SI # EN CLAVE DE FA NO SE DIBUJA BIEN VER POR QUE

        int sign = 1;

        if (diffTo > 0) {
            sign = -1;
        }

        while (diffTo > SIZE_OCTAVE || diffTo < 0) {

            diffTo = diffTo + sign * SIZE_OCTAVE;
            diffOctave = diffOctave + sign * -1;
        }
        return new CPitch(EStepPitch.toEstepPitch(diffTo), (EOctavePitch.toOctavePitch(diffOctave)));
    }

    public static int getYNote(CNote note, ESignClef clef) {
        if (note.getIsSilence()) {
            return note.getType().getYString();
        }
        ELinePosition pos = Transformator.Transform(note.getPitch(), clef);
        return pos.getValue() * 10;
    }

    public static ArrayList<CNote> toMaxSilence(ESignClef clef, double currentValue, CTimeMeasure time) {

        ArrayList<CNote> notes = new ArrayList<CNote>();

        double maxSpace = time.getBeats() * (1.0 / time.getBeatType().getValue());
        double currentSpace = currentValue / (time.getBeatType().getValue());

        ETypeNote[] types = ETypeNote.values();

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
