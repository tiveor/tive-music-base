package tive.music.base;

/**
 * @author Alvaro Orellana (TODO: still refactoring)
 */
public interface INote {

    public String toRhythmicMotif();

    public void transpose(int notes, int semitones, boolean up);
}
