package tive.music.base;
import java.io.Serializable;

public class CMeasureAttributes implements Serializable
{
    private int mDivisions;//<divisions> value </divisions>?
    private EKeyMeasure mKey;
    private CTimeMeasure mTime;
    private CClef mClef;
    
    public CMeasureAttributes(CTimeMeasure time, EKeyMeasure key, CClef clef)//default contructor
    {
        mTime = time;
        mKey = key;
        mClef = clef;
    }

    public CClef getClef() {
        return mClef;
    }

    public void setClef(CClef clef) {
        mClef = clef;
    }

    public int getDivisions() {
        return mDivisions;
    }

    public void setDivisions(int divisions) {
        mDivisions = divisions;
    }

    public EKeyMeasure getKey() {
        return mKey;
    }

    public void setKey(EKeyMeasure key) {
        mKey = key;
    }

    public CTimeMeasure getTime() {
        return mTime;
    }
    public void setTime(CTimeMeasure time) {
        mTime = time;
    }

}
