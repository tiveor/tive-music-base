package tive.music.base.models;

import java.io.Serializable;

import tive.music.base.constant.EOctavePitch;
import tive.music.base.constant.EPitch;

/**
 * @author Alvaro Orellana
 */
public class CPitch implements Serializable {

    private EPitch pitch;
    private EOctavePitch octave;

    public CPitch(EPitch pitch, EOctavePitch octave) {
        this.pitch = pitch;
        this.octave = octave;
    }

    public CPitch(CPitch pitch) {
        this.pitch = pitch.getPitch();
        this.octave = pitch.getOctave();
    }

    public EOctavePitch getOctave() {
        return octave;
    }

    public void setOctave(EOctavePitch octave) {
        this.octave = octave;
    }

    public EPitch getPitch() {
        return pitch;
    }

    public void setPitch(EPitch pitch) {
        this.pitch = pitch;
    }


    public boolean isMax() {
        return pitch == EPitch.B && octave == EOctavePitch.TEN;
    }

    public boolean isMin() {
        return pitch == EPitch.C && octave == EOctavePitch.ZERO;
    }

    public void next() {
        if (pitch == EPitch.B)
            octave = octave.next();

        pitch = pitch.next();
    }

    public void prev() {
        if (pitch == EPitch.C)
            octave = octave.prev();

        pitch = pitch.prev();
    }

    @Override
    public String toString() {
        return "CPitch{" +
                "pitch=" + pitch +
                ", octave=" + octave +
                '}';
    }
}