package tive.music.base;

import java.io.Serializable;
import java.util.ArrayList;

public class CScore implements Serializable {

    private String mTitle;
    private String mComposer;
    private String mRights;
    private double mTempo;
    private ArrayList<CPart> mParts;

    public CScore(String title, String composer, String rights) {
        mTitle = title;
        mComposer = composer;
        mRights = rights;
        mParts = new ArrayList<CPart>();
        mTempo = 120.0;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getComposer() {
        return mComposer;
    }

    public String getRights() {
        return mRights;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setComposer(String composer) {
        mComposer = composer;
    }

    public void setRights(String rights) {
        mRights = rights;
    }

    public CPart addPart(String name, int channel, double tempo, EInstrument instrument) {
        CPart part = new CPart(name, mParts.size() + 1, channel, tempo, instrument);
        mParts.add(part);
        return part;
    }

    //FALTATIV
    public ArrayList<CPart> getParts() {
        return mParts;
    }

    /*public void setParts(ArrayList<CPart> parts) {
    mParts = parts;
    }*/
    @Override
    public String toString() {
        String res = "\n------------------\n";
        res += mComposer + "" + mRights + "\n";
        res += "-----------------";

        for (int i = 0; i < mParts.size(); i++) {
            res += "Part" + i + mParts.get(i).toString() + "\n";
        }

        return res;
    }

    public double getTempo() {
        return mTempo;
    }

    public void setTempo(double tempo) {
        if (mTempo != tempo) {
            mTempo = tempo;
            for (CPart part : mParts) {
                part.setTempo(tempo);
                for (CMeasure measure : part.getMeasures()) {
                    measure.setTempo(tempo);
                }
            }
        }
    }

    @Override
    protected void finalize() {
        System.out.println("Me borran CScore:" + this.mTitle);
    }
}
