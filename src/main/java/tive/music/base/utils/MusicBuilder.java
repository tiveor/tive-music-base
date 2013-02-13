package tive.music.base.utils;

import tive.music.base.CNote;
import tive.music.base.CPitch;
import tive.music.base.EAccidentalNote;
import tive.music.base.ELinePosition;
import tive.music.base.EOctavePitch;
import tive.music.base.ESignClef;
import tive.music.base.EStepPitch;
import tive.music.base.ETypeNote;

public class MusicBuilder {

    public static CNote createNote(EStepPitch step, EOctavePitch octave, ETypeNote type, EAccidentalNote accidental) {
        if (type.isSilence()) {
            return new CNote(new CPitch(step, octave), type, EAccidentalNote.NONE);
        } else {
            return new CNote(new CPitch(step, octave), type, accidental);
        }
    }

    public static CNote createNote(int midiPitch, double midiRhytm) {

        int step = 0;
        int octave = 0;
        EAccidentalNote accidental = EAccidentalNote.NONE;

        while (midiPitch >= 12) {
            midiPitch -= 12;
            octave++;
        }

        int[] steps = new int[]{0, 2, 4, 5, 7, 9, 11};//lo mismo en CNote ver refactor FALTATIV

        for (int i = 0; i < steps.length - 1; i++) {
            if (midiPitch == steps[i]) {
                step = i;
                break;
            } else if (midiPitch == steps[i + 1]) {
                step = i + 1;
                break;
            } else if (midiPitch > steps[i] && midiPitch < steps[i + 1]) {
                step = i;
                accidental = EAccidentalNote.SHARP;
                break;
            }
        }


        return new CNote(new CPitch(EStepPitch.toEstepPitch(step + 1),
                EOctavePitch.toOctavePitch(octave - 1)),
                ETypeNote.getTypeNoteByMidiValue((int) (midiRhytm * 10000)),
                accidental);

    }

    public static CNote createSilence(ESignClef clef, ETypeNote type) {

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
        //faltativ para otras claves medio que esto es un parche.. refactorar
        return new CNote(Transformator.Transform(elp, clef), type, EAccidentalNote.NONE);
    }
}
