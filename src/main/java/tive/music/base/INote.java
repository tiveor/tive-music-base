package tive.music.base;

/**
 *
 * @author tive
 */
public interface INote {

    public String toRhythmicMotif();

    public void transpose(int notes, int semitones, boolean up);
}
