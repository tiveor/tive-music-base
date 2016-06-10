package tive.music.base.models;

import tive.music.base.INote;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Alvaro Orellana
 */
public class CChord implements INote, Serializable {

    private ArrayList<CNote> notes;

    public CChord() {
        notes = new ArrayList<>();
    }

    public void addNote(CNote note) {
        notes.add(note);
    }

    public ArrayList<CNote> getNotes() {
        return notes;
    }

    public String toRhythmicMotif() {
        if (notes.size() > 0) {
            return notes.get(0).toRhythmicMotif();//TODO: all will be the same note
        } else {
            return "Chord(no notes)";
        }
    }

    public void transpose(int notes, int semitones, boolean asc) {
        //TODO: Implement transpose
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CNote note : notes) {
            sb.append(note.toString());
            sb.append(" | ");
        }
        return sb.toString();
    }
}
