package tive.music.base;

import java.io.Serializable;

/**
 *
 * asdoaisdnoai dnaodiajsdoi jasdoij
 *
 * @author tive
 * @version 1.0
 */
public class CPitch implements Serializable {

    private EStepPitch mStep;
    private EOctavePitch mOctave;//Four is the central octave

    public CPitch(EStepPitch step, EOctavePitch octave) {
        mStep = step;
        mOctave = octave;
    }

    public CPitch(CPitch pitch) {
        mStep = pitch.getStep();
        mOctave = pitch.getOctave();
    }

    public EOctavePitch getOctave() {
        return mOctave;
    }

    public void setOctave(EOctavePitch octave) {
        this.mOctave = octave;
    }

    public EStepPitch getStep() {
        return mStep;
    }

    public void setStep(EStepPitch step) {
        this.mStep = step;
    }

    @Override
    public String toString() {
        return "Pitch: " + mStep + "-" + mOctave;

    }

    public boolean isMax() {
        return mStep == EStepPitch.B && mOctave == EOctavePitch.TEN;
    }

    public boolean isMin() {
        return mStep == EStepPitch.C && mOctave == EOctavePitch.ZERO;
    }

    public void Next() {

        if (mStep == EStepPitch.B) {
            mOctave = mOctave.Next();
        }

        mStep = mStep.next();
    }

    public void Previous() {
        if (mStep == EStepPitch.C) {
            mOctave = mOctave.Previous();
        }

        mStep = mStep.previous();
    }
}