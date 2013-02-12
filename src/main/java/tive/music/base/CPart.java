package tive.music.base;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author tive
 */

public class CPart implements Serializable        
{
    private int mID;
    private String mName;
    private ArrayList<CMeasure> mMeasures;
    private EInstrument mInstrument;
    private int mChannel;
    private double mTempo;

    public CPart(String name, int id, int channel, double tempo, EInstrument instrument) {
        mName = name;
        mID = id;
        mInstrument = instrument;
        mMeasures = new ArrayList<CMeasure>();
        mChannel = channel;
        mTempo = tempo;
    }

    public int getId() {
        return mID;
    }

    public void setId(int id) {
        this.mID = id;
    }

    public ArrayList<CMeasure> getMeasures() {
        return mMeasures;
    }

    public CMeasure addMeasure(CTimeMeasure time, EKeyMeasure key, CClef clef) {
        CMeasure measure = new CMeasure(time, key, clef);
        measure.setTempo(mTempo);
        mMeasures.add(measure);
        return measure;
    }

    public void setMeasures(ArrayList<CMeasure> measures) {
        mMeasures = measures;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public EInstrument getInstrument() {
        return mInstrument;
    }

    public int getChannel() {
        return mChannel;
    }

    public void setChannel(int newChannel) {
        mChannel = newChannel;
    }

    public double getTempo() {
        return mTempo;
    }

    public void setTempo(double tempo) {
        mTempo = tempo;
    }

    @Override
    public String toString() {
        String res = mID + ") " + mName;

        for (int i = 0; i < mMeasures.size(); i++) {
            res += "Measure" + i + " => " + mMeasures.get(i).toString() + "\n";
        }
        return res;
    }
}
