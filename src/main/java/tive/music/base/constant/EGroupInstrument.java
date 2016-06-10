package tive.music.base.constant;

/**
 * @author Alvaro Orellana
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

    private final int id;
    private final String name;

    EGroupInstrument(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}