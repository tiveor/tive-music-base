package tive.music.base;

import java.io.Serializable;

public class CTimeMeasure implements Serializable {

    private int mBeats;
    private ETypeNote mBeatType;

    public CTimeMeasure(int beats, ETypeNote beatType) {
        mBeats = beats;
        mBeatType = beatType;
    }

    public ETypeNote getBeatType() {
        return mBeatType;
    }

    public void setBeatType(ETypeNote beatType) {
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
}
