package tive.music.base.models;

import java.util.ArrayList;
import java.io.Serializable;

import tive.music.base.INote;
import tive.music.base.constant.EKeyMeasure;
import tive.music.base.utils.Transformator;

/**
 * @author Alvaro Orellana (TODO: still refactoring)
 */
public class CMeasure implements Serializable {

    private ArrayList<INote> mNotes;
    private ArrayList<CNote> mNotesAutoCompleted;
    private double tempo;//<sound tempo =''>
    private double mCurrentValue;
    private CMeasureAttributes mAttributes;
    private int mMinValueDuration;

    public CMeasure(CTimeMeasure time, EKeyMeasure key, CClef clef) {
        mNotes = new ArrayList<INote>();
        mNotesAutoCompleted = new ArrayList<CNote>();
        mCurrentValue = 0.0;//start clean
        mAttributes = new CMeasureAttributes(time, key, clef);
        mMinValueDuration = Integer.MIN_VALUE;
        tempo = 120.0;
    }

    public CMeasure(CMeasure measure) {
        this(measure.getTime(), measure.getKey(), measure.getClef());
        for (INote note : measure.getNotes()) {
            mNotes.add(note);
        }
        autoCompleteWithSilences();
    }

    public CMeasureAttributes getAttributes() {
        return mAttributes;
    }

    public void setAttributes(CMeasureAttributes attributes) {
        mAttributes = attributes;
    }

    public ArrayList<INote> getNotes() {
        return mNotes;
    }

    public INote getLastNote() {
        if (mNotes.size() > 0) {
            return mNotes.get(mNotes.size() - 1);
        } else {
            return null;
        }
    }

    public ArrayList<CNote> autoCompleteWithSilences() {
        ArrayList<CNote> notes = Transformator.toMaxSilence(mAttributes.getClef().getSign(), mCurrentValue, mAttributes.getTime());

        for (CNote cNote : notes) {
            addNote(cNote);
            mNotesAutoCompleted.add(cNote);
        }
        return notes;
    }

    public double normalizeAutoCompleted() {
        double sum = 0.0;
        for (CNote note : mNotesAutoCompleted) {
            sum = normalizeValue(note);
        }
        return sum;
    }

    public double normalizeValue(CNote note) {
        double num = mAttributes.getTime().getBeatType().getValue();
        double den = (double) (note.getType().getValue());

        if (note.isHasDot()) {
            return (num / den) * 1.5;
        } else if (note.isTriplet()) {
            return (num / den) * (2.0 / 3.0);
        } else {
            return (num / den);
        }
    }

    public double hasSpaceForThisNote(CNote note) {

        double normalize = normalizeValue(note);
        double sum = mCurrentValue + normalize;

        if (sum <= mAttributes.getTime().getBeats()) {
            return sum;
        }

        return -1.0;
    }

    public boolean addNote(CNote note) {

        removeAutoCompletedNote();

        boolean result = false;
        double sum = hasSpaceForThisNote(note);

        if (sum > 0) {
            mNotes.add(note);
            mCurrentValue = sum;

            int value = note.getType().getValue();//TODO: VERIFY WHEN GIVE NOTE
            if (value > mMinValueDuration) {
                mMinValueDuration = value;
            }

            result = true;
        }
        return result;
    }

    /*public boolean insertChord(int index, CChord chord) {
    removeAutoCompletedNote();
    boolean result = false;

    double sum = hasSpaceForThisNote(chord.getNotes().get(0));// le mandamos solo la primera para que cosito

    if (sum > 0) {
    mNotes.add(index, chord);
    mCurrentValue = sum;
    result = true;
    }
    return result;
    }

    public boolean addChord(CChord chord) {
    return insertChord(mNotes.size(), chord);
    }*/
    public boolean addChord(CChord chord) {
        removeAutoCompletedNote();
        boolean result = false;

        CNote first = chord.getNotes().get(0);
        double sum = hasSpaceForThisNote(first);// TODO: SENDING JUST FIRST

        if (sum > 0) {
            mNotes.add(chord);
            mCurrentValue = sum;

            int value = first.getType().getValue();//TODO: VERIFY WHEN GIVE NOTE
            if (value > mMinValueDuration) {
                mMinValueDuration = value;
            }

            result = true;
        }
        return result;
    }

    public void removeAll() {
        removeAutoCompletedNote();
        mNotes.clear();
        mCurrentValue = 0.0;
    }

    public int removeNoteWithContent(CNote note) {
        int index = mNotes.indexOf(note);
        removeNote(note);
        return index;
    }

    private void removeNote(INote note) {
        if (note instanceof CNote) {
            removeNote((CNote) note);
        } else {
            removeNote((CChord) note);
        }
    }

    private void removeNote(CNote note) {
        mCurrentValue = mCurrentValue - normalizeValue(note);
        mNotes.remove(note);
    }

    private void removeNote(CChord chord) {
        CNote firstNote = chord.getNotes().get(0);
        mCurrentValue = mCurrentValue - normalizeValue(firstNote);
        mNotes.remove(firstNote);
    }

    public void removeAutoCompletedNote() {

        for (CNote cNote : mNotesAutoCompleted) {
            removeNote(cNote);
        }
        mNotesAutoCompleted.clear();
    }

    public void setNotes(ArrayList<INote> notes) {
        mNotes = notes;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double Tempo) {
        tempo = Tempo;
    }

    public double getCurrentValue() {
        return mCurrentValue - normalizeAutoCompleted();
        //TODO: TOO SLOW NORMALIZE ALL NOTES AUTOCOMPLETED
    }

    public double getDurationNormalized() {
        return (mAttributes.getTime().getDivision() * 4.0);
    }

    public void setCurrentValue(double value) {
        mCurrentValue = value;
    }

    public EKeyMeasure getKey() {
        return mAttributes.getKey();
    }

    public void setKey(EKeyMeasure key) {
        mAttributes.setKey(key);
    }

    public CClef getClef() {
        return mAttributes.getClef();
    }

    public void setClef(CClef clef) {
        mAttributes.setClef(clef);
    }

    public CTimeMeasure getTime() {
        return mAttributes.getTime();
    }

    public void setTime(CTimeMeasure time) {
        mAttributes.setTime(time);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Measure:\n");

        for (int i = 0; i < mNotes.size(); i++)
            sb.append(mNotes.get(i).toString() + "\n");

        return sb.toString();
    }

    public int getMinValueDuration() {
        return mMinValueDuration;
    }
}
