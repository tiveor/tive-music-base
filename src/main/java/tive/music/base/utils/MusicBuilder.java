package tive.music.base.utils;

import tive.music.base.constant.*;
import tive.music.base.models.CNote;
import tive.music.base.models.CPitch;
import tive.music.base.constant.EAccidental;

/**
 * @author Alvaro Orellana
 */
public class MusicBuilder {

    public static CNote createNote(EPitch step, EOctavePitch octave, EDuration type, EAccidental accidental) {
        if (type.isSilence()) {
            return new CNote(new CPitch(step, octave), type, EAccidental.NONE);
        } else {
            return new CNote(new CPitch(step, octave), type, accidental);
        }
    }

    public static CNote createNote(int midiPitch, double midiRhytm) {

        int step = 0;
        int octave = 0;
        EAccidental accidental = EAccidental.NONE;

        while (midiPitch >= 12) {
            midiPitch -= 12;
            octave++;
        }

        int[] steps = new int[]{0, 2, 4, 5, 7, 9, 11};//TODO: SAME AS CNOTE REFACTOR HERE

        for (int i = 0; i < steps.length - 1; i++) {
            if (midiPitch == steps[i]) {
                step = i;
                break;
            } else if (midiPitch == steps[i + 1]) {
                step = i + 1;
                break;
            } else if (midiPitch > steps[i] && midiPitch < steps[i + 1]) {
                step = i;
                accidental = EAccidental.SHARP;
                break;
            }
        }


        return new CNote(new CPitch(EPitch.toEStepPitch(step + 1),
                EOctavePitch.toOctavePitch(octave - 1)),
                EDuration.getTypeNoteByMidiValue((int) (midiRhytm * 10000)),
                accidental);

    }

    public static CNote createSilence(EClef clef, EDuration type) {

        ELinePosition elp = ELinePosition.SECOND_LINE;
        switch (type) {

            case silence_whole:
                elp = ELinePosition.FOURTH_LINE;
                break;
            case silence_half:
                elp = ELinePosition.FOURTH_SPACE;
                break;
            default:
                elp = ELinePosition.SECOND_LINE;
        }
        //TODO: FOR OTHER CLEFS BECAUSE IT DEPENS ON CLEF, JUST A PATCH
        return new CNote(Transformator.Transform(elp, clef), type, EAccidental.NONE);
    }
}
