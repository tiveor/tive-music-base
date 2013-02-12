package tive.music.base;

import java.io.Serializable;
import java.util.ArrayList;

public class CChord implements INote, Serializable {

    private ArrayList<CNote> mNotes;

    public CChord() {
        mNotes = new ArrayList<CNote>();
    }

    public void addNote(CNote note) {
        mNotes.add(note);
    }

    public ArrayList<CNote> getNotes() {
        return mNotes;
    }

    public String toRhythmicMotif() {
        if (mNotes.size() > 0) {
            return mNotes.get(0).toRhythmicMotif();//todos son igual
        } else {
            return "Chord(no notes)";
        }
    }

    public void transpose(int notes, int semitones, boolean up) {
        ;//FALTATIV ME QUEDE AQUI
    }

    public String toString() {
        String res = "";
        for (CNote note : mNotes) {
            res += note.toString() + " | ";
        }
        return res;
    }
}
