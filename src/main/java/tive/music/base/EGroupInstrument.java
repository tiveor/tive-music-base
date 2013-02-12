package tive.music.base;

/**
 *
 * @author tive
 * @version 1.0
 */
public enum EGroupInstrument {

    GRP_PIANO(1, "Piano"),
    GRP_CHROMATIC_PERCUSSION(2, "Chromatic Percussion"),
    GRP_ORGAN(3, "Organ"),
    GRP_GUITAR(4, "Guitar"),
    GRP_BASS(5, "Bass"),
    GRP_STRINGS_I(6, "Strings I"),
    GRP_STRINGS_II(7, "Strings II"),
    GRP_BRASS(8, "Brass"),
    GRP_REED(9, "Reed"),
    GRP_PIPE(10, "Pipe"),
    GRP_SYNTH_LEAD(11, "Synth Lead"),
    GRP_SYNTH_PAD(12, "Synth Pad"),
    GRP_SYNTH_EFFECTS(13, "Synth Effects"),
    GRP_ETHNIC(14, "Ethnic"),
    GRP_PERCUSSIVE(15, "Percussive"),
    GRP_SOUND_EFFECTS(16, "Sound Effects");

    private final int mID;
    private final String mName;

    EGroupInstrument(int id, String name){
        mID = id;
        mName = name;
    }

    public int getID(){
        return mID;
    }

    public String getName(){
        return mName;
    }

    @Override
    public String toString(){
        return mName;
    }
}