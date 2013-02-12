package tive.music.base;

import java.io.Serializable;

/*
 *
 * @author tive
 * @version 1.0
 * @see 
 */
public class CNote implements INote, Serializable {

    private CPitch mPitch;
    private int mVoice;//del 1 al 4 dentro del mismo instrumento
    private ETypeNote mType;
    private EAccidentalNote mAccidental;
    private boolean mHasDot;
    private boolean mIsTresillo;
    private int mPitchMidiValue;
    private double mRhytmMidiValue;

    public CNote(CPitch pitch, ETypeNote type, EAccidentalNote accidental) {
        mPitch = pitch;
        mType = type;
        mHasDot = false;
        mIsTresillo = false;
        //mAccidental = EAccidentalNote.None;//faltativ
        mAccidental = accidental; //faltativ
        mPitchMidiValue = -1;
        mRhytmMidiValue = -1.0;
    }

    public boolean getHasDot() {
        return mHasDot;
    }

    public boolean getIsSilence() {
        return mType.isSilence();
    }

    public boolean getIsTresillo() {
        return mIsTresillo;
    }

    public void setHasDot(boolean value) {
        mHasDot = value;
    }

    public void setIsTresillo(boolean tresillo) {
        mIsTresillo = tresillo;
    }

    public EAccidentalNote getAccidental() {
        return mAccidental;
    }

    public void setAccidental(EAccidentalNote accidental) {
        this.mAccidental = accidental;
    }

    public CPitch getPitch() {
        return mPitch;
    }

    public void setPitch(CPitch pitch) {
        this.mPitch = pitch;
    }

    public ETypeNote getType() {
        return mType;
    }

    public void setType(ETypeNote type) {
        this.mType = type;
    }

    public int getVoice() {
        return mVoice;
    }

    public void setVoice(int voice) {
        this.mVoice = voice;
    }

    public int getPitchMidiValue() {
        if (mPitchMidiValue == -1) {

            int[] tonos = new int[]{0, 2, 4, 5, 7, 9, 11};
            int value = (mPitch.getOctave().getValue() + 1) * 12;
            value += tonos[mPitch.getStep().getValue() - 1];
            value += mAccidental.getSemitones();
            mPitchMidiValue = value;
        }
        return mPitchMidiValue;
    }

    public double getRhytmicMidiValue() {

        if (mRhytmMidiValue == -1.0) {
            mRhytmMidiValue = mType.getMidiValue() / 10000.0;
            if (mHasDot) {
                mRhytmMidiValue = mRhytmMidiValue * 1.5;
            } else if (mIsTresillo) {
                mRhytmMidiValue = mRhytmMidiValue * (2.0 / 3.0);
            }

        }
        return mRhytmMidiValue;
    }

    public String toFirstMelodicMotif(EKeyMeasure keyMeasure) {
        String resStr = "";

        int res = 8 - keyMeasure.getFifths().getStep().getValue();
        res += mPitch.getStep().getValue();

        if (res > 7) {
            res -= 7;
        }

        int semi = mAccidental.getSemitones();

        resStr = res + "." + mPitch.getOctave().getValue();

        if (semi != 0) {
            resStr = resStr + "." + semi;
        }

        return resStr;
    }

    public String toRhythmicMotif() {
        String result = mType.getTMN() + "";

        if (mType.isSilence()) {
            result += ".s";
        }

        if (mHasDot) {
            result += ".p";
        }

        if (mIsTresillo) {
            result += ".t";
        }

        return result;
    }

    public void NextPitch() {
        mPitch.Next();
    }

    @Override
    public String toString() {
        return "Type[" + mType + "," + mPitch.toString() + "], Accidental[" + mAccidental.toString() + "], MidiValue[" + getPitchMidiValue() + "]";
    }

    public void transpose(int notes, int semitones, boolean up) {
        throw new UnsupportedOperationException("Not supported yet.");//FALTATIV
    }
}
