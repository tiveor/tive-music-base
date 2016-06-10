package tive.music.base.models;

import java.io.Serializable;

import tive.music.base.constant.EDuration;

/**
 * @author Alvaro Orellana
 */
public class CTimeMeasure implements Serializable {

    private int mBeats;
    private EDuration mBeatType;

    public CTimeMeasure(int beats, EDuration duration) {
        mBeats = beats;
        mBeatType = duration;
    }

    public EDuration getBeatType() {
        return mBeatType;
    }

    public void setBeatType(EDuration beatType) {
        this.mBeatType = beatType;
    }

    public int getBeats() {
        return mBeats;
    }

    public void setBeats(int beats) {
        this.mBeats = beats;
    }

    public int getNumDig() {
        return Math.max((mBeatType.getValue() + "").length(), (mBeats + "").length());
    }

    public double getDivision() {
        return (mBeats * 1.0) / (mBeatType.getValue() * 1.0);
    }

    public String getTMN() {
        return mBeats + "." + mBeatType.getValue();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CTimeMeasure{");
        sb.append("mBeats=").append(mBeats);
        sb.append(", mBeatType=").append(mBeatType);
        sb.append('}');
        return sb.toString();
    }
}
