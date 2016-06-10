package tive.music.base.models;

import java.io.Serializable;

import tive.music.base.INote;
import tive.music.base.constant.*;

/**
 * @author Alvaro Orellana (TODO: Still refactoring)
 */
public class CNote implements INote, Serializable {

    private CPitch pitch;
    private EDuration duration;
    private EAccidental accidental;
    private int voice;//1-4 same instrument
    private boolean hasDot;
    private boolean isTriplet;
    private int pitchMidiValue;
    private double rhythmMidiValue;

    public CNote(EPitch pitch, EOctavePitch octavePitch, EDuration duration) {
        this(new CPitch(pitch, octavePitch), duration);
    }

    public CNote(CPitch pitch, EDuration duration) {
        this(pitch, duration, EAccidental.NONE);
    }

    public CNote(CPitch pitch, EDuration duration, EAccidental accidental) {
        this.pitch = pitch;
        this.duration = duration;
        this.accidental = accidental;//EAccidental.NONE
        this.voice = 1;
        hasDot = false;
        isTriplet = false;
        pitchMidiValue = -1;
        rhythmMidiValue = -1.0;
    }

    public boolean isHasDot() {
        return hasDot;
    }

    public boolean isTriplet() {
        return isTriplet;
    }

    public void setTriplet(boolean triplet) {
        isTriplet = triplet;
    }

    public void setHasDot(boolean value) {
        hasDot = value;
    }

    public boolean getIsSilence() {
        return duration.isSilence();
    }

    public EAccidental getAccidental() {
        return accidental;
    }

    public void setAccidental(EAccidental accidental) {
        this.accidental = accidental;
    }

    public CPitch getPitch() {
        return pitch;
    }

    public void setPitch(CPitch pitch) {
        this.pitch = pitch;
    }

    public EDuration getType() {
        return duration;
    }

    public void setType(EDuration type) {
        this.duration = type;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getPitchMidiValue() {
        if (pitchMidiValue == -1) {

            int[] toneSpaces = new int[]{0, 2, 4, 5, 7, 9, 11};
            int value = (pitch.getOctave().getValue() + 1) * 12;
            value += toneSpaces[pitch.getPitch().getValue() - 1];
            value += accidental.getSemitones();
            pitchMidiValue = value;
        }
        return pitchMidiValue;
    }

    public double getRhytmicMidiValue() {

        if (rhythmMidiValue == -1.0) {
            rhythmMidiValue = duration.getMidiValue() / 10000.0;
            if (hasDot) {
                rhythmMidiValue = rhythmMidiValue * 1.5;
            } else if (isTriplet) {
                rhythmMidiValue = rhythmMidiValue * (2.0 / 3.0);
            }

        }
        return rhythmMidiValue;
    }

    public String toFirstMelodicMotif(EKeyMeasure keyMeasure) {

        int pitchValue = 8 - keyMeasure.getFifthsKey().getPitch().getValue();
        pitchValue += pitch.getPitch().getValue();

        if (pitchValue > 7)
            pitchValue -= 7;

        int semitones = accidental.getSemitones();

        String res = pitchValue + "." + pitch.getOctave().getValue();

        if (semitones != 0)
            res = res + "." + semitones;

        return res;
    }

    public String toRhythmicMotif() {
        String result = duration.getTMN() + "";

        if (duration.isSilence())
            result += ".s";

        if (hasDot)
            result += ".p";

        if (isTriplet)
            result += ".t";

        return result;
    }

    public void nextPitch() {
        pitch.next();
    }

    public void transpose(int notes, int semitones, boolean up) {
        throw new UnsupportedOperationException("Not supported yet.");//TODO: NOT IMPLEMENTED
    }

    @Override
    public String toString() {
        return "CNote{" +
                "pitch=" + pitch +
                ", duration=" + duration +
                ", accidental=" + accidental +
                ", voice=" + voice +
                ", hasDot=" + hasDot +
                ", isTriplet=" + isTriplet +
                ", pitchMidiValue=" + pitchMidiValue +
                ", rhythmMidiValue=" + rhythmMidiValue +
                '}';
    }
}
