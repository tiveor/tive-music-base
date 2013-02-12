package tive.music.base;

/**
 *
 * @author tive
 * @version 1.0
 */
public enum EInstrument {

    ACOUSTIC_GRAND_PIANO(EGroupInstrument.GRP_PIANO, "Acoustic Grand Piano", 1),
    BRIGHT_ACOUSTIC_PIANO(EGroupInstrument.GRP_PIANO, "Bright Acoustic Piano", 2),
    ELECTRIC_GRAND_PIANO(EGroupInstrument.GRP_PIANO, "Electric Grand Piano", 3),
    HONKY_TONK_PIANO(EGroupInstrument.GRP_PIANO, "Honky-tonk Piano", 4),
    ELECTRIC_PIANO_1(EGroupInstrument.GRP_PIANO, "Electric Piano 1", 5),
    ELECTRIC_PIANO_2(EGroupInstrument.GRP_PIANO, "Electric Piano 2", 6),
    HARPSICHORD(EGroupInstrument.GRP_PIANO, "Harpsichord", 7),
    CLAVINET(EGroupInstrument.GRP_PIANO, "Clavinet", 8),
    CELESTA(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Celesta", 9),
    GLOCKENSPIEL(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Glockenspiel", 10),
    MUSIC_BOX(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Music Box", 11),
    VIBRAPHONE(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Vibraphone", 12),
    MARIMBA(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Marimba", 13),
    XYLOPHONE(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Xylophone", 14),
    TUBULAR_BELLS(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Tubular Bells", 15),
    DULCIMER(EGroupInstrument.GRP_CHROMATIC_PERCUSSION, "Dulcimer", 16),
    DRAWBAR_ORGAN(EGroupInstrument.GRP_ORGAN, "Drawbar Organ", 17),
    PRECUSSIVE_ORGAN(EGroupInstrument.GRP_ORGAN, "Percussive Organ", 18),
    ROCK_ORGAN(EGroupInstrument.GRP_ORGAN, "Rock Organ", 19),
    CHURCH_ORGAN(EGroupInstrument.GRP_ORGAN, "Church Organ", 20),
    REED_ORGAN(EGroupInstrument.GRP_ORGAN, "Reed Organ", 21),
    ACCORDION(EGroupInstrument.GRP_ORGAN, "Accordion", 22),
    HARMONICA(EGroupInstrument.GRP_ORGAN, "Harmonica", 23),
    TANGO_ACCORDION(EGroupInstrument.GRP_ORGAN, "Tango Accordion", 24),
    ACOUSTIC_GUITAR_NYLON(EGroupInstrument.GRP_GUITAR, "Acoustic Guitar (nylon)", 25),
    ACOUSTIC_GUITAR_STEEL(EGroupInstrument.GRP_GUITAR, "Acoustic Guitar (steel)", 26),
    ELECTRIC_GUITAR_JAZZ(EGroupInstrument.GRP_GUITAR, "Electric Guitar (jazz)", 27),
    ELECTRIC_GUITAR_CLEAN(EGroupInstrument.GRP_GUITAR, "Electric Guitar (clean)", 28),
    ELECTRIC_GUITAR_MUTED(EGroupInstrument.GRP_GUITAR, "Electric Guitar (muted)", 29),
    OVERDRIVEN_GUITAR(EGroupInstrument.GRP_GUITAR, "Overdriven Guitar", 30),
    DISTORTION_GUITAR(EGroupInstrument.GRP_GUITAR, "Distortion Guitar", 31),
    GUITAR_HARMONICS(EGroupInstrument.GRP_GUITAR, "Guitar harmonics", 32),
    ACOUSTIC_BASS(EGroupInstrument.GRP_BASS, "Acoustic Bass", 33),
    ELECTRIC_BASS_FINGER(EGroupInstrument.GRP_BASS, "Electric Bass (finger)", 34),
    ELECTRIC_BASS_PICK(EGroupInstrument.GRP_BASS, "Electric Bass (pick)", 35),
    FRETLESS_BASS(EGroupInstrument.GRP_BASS, "Fretless Bass", 36),
    SLAP_BASS_1(EGroupInstrument.GRP_BASS, "Slap Bass 1", 37),
    SLAP_BASS_2(EGroupInstrument.GRP_BASS, "Slap Bass 2", 38),
    SYNTH_BASS_1(EGroupInstrument.GRP_BASS, "Synth Bass 1", 39),
    SYNTH_BASS_2(EGroupInstrument.GRP_BASS, "Synth Bass 2", 40),
    VIOLIN(EGroupInstrument.GRP_STRINGS_I, "Violin", 41),
    VIOLA(EGroupInstrument.GRP_STRINGS_I, "Viola", 42),
    CELLO(EGroupInstrument.GRP_STRINGS_I, "Cello", 43),
    CONTRABASS(EGroupInstrument.GRP_STRINGS_I, "Contrabass", 44),
    TREMOLO_STRINGS(EGroupInstrument.GRP_STRINGS_I, "Tremolo Strings", 45),
    PIZZICATO_STRINGS(EGroupInstrument.GRP_STRINGS_I, "Pizzicato Strings", 46),
    ORCHESTRAL_HARP(EGroupInstrument.GRP_STRINGS_I, "Orchestral Harp", 47),
    TIMPANI(EGroupInstrument.GRP_STRINGS_I, "Timpani", 48),
    STRING_ENSEMBLE_1(EGroupInstrument.GRP_STRINGS_II, "String Ensemble 1", 49),
    STRING_ENSEMBLE_2(EGroupInstrument.GRP_STRINGS_II, "String Ensemble 2", 50),
    SYNTH_STRINGS_1(EGroupInstrument.GRP_STRINGS_II, "Synth Strings 1", 51),
    SYNTH_STRINGS_2(EGroupInstrument.GRP_STRINGS_II, "Synth Strings 2", 52),
    CHOIR_AAHS(EGroupInstrument.GRP_STRINGS_II, "Choir Aahs", 53),
    VOICE_OOHS(EGroupInstrument.GRP_STRINGS_II, "Voice Oohs", 54),
    SYNTH_VOICE(EGroupInstrument.GRP_STRINGS_II, "Synth Voice", 55),
    ORCHESTRA_HIT(EGroupInstrument.GRP_STRINGS_II, "Orchestra Hit", 56),
    TRUMPET(EGroupInstrument.GRP_BRASS, "Trumpet", 57),
    TROMBONE(EGroupInstrument.GRP_BRASS, "Trombone", 58),
    TUBA(EGroupInstrument.GRP_BRASS, "Tuba", 59),
    MUTED_TRUMPET(EGroupInstrument.GRP_BRASS, "Muted Trumpet", 60),
    FRENCH_HORN(EGroupInstrument.GRP_BRASS, "French Horn", 61),
    BRASS_SECTION(EGroupInstrument.GRP_BRASS, "Brass Section", 62),
    SYNTH_BRASS_1(EGroupInstrument.GRP_BRASS, "Synth Brass 1", 63),
    SYNTH_BRASS_2(EGroupInstrument.GRP_BRASS, "Synth Brass 2", 64),
    SOPRANO_SAX(EGroupInstrument.GRP_REED, "Soprano Sax", 65),
    ALTO_SAX(EGroupInstrument.GRP_REED, "Alto Sax", 66),
    TENOR_SAX(EGroupInstrument.GRP_REED, "Tenor Sax", 67),
    BARITONE_SAX(EGroupInstrument.GRP_REED, "Baritone Sax", 68),
    OBOE(EGroupInstrument.GRP_REED, "Oboe", 69),
    ENGLISH_HORN(EGroupInstrument.GRP_REED, "English Horn", 70),
    BASSON(EGroupInstrument.GRP_REED, "Basson", 71),
    CLARINET(EGroupInstrument.GRP_REED, "Clarinet", 72),
    PICCOLO(EGroupInstrument.GRP_PIPE, "Piccolo", 73),
    FLUTE(EGroupInstrument.GRP_PIPE, "Flute", 74),
    RECORDER(EGroupInstrument.GRP_PIPE, "Recorder", 75),
    PAN_FLUTE(EGroupInstrument.GRP_PIPE, "Pan Flute", 76),
    BLOWN_BOTTLE(EGroupInstrument.GRP_PIPE, "Blown Bottle", 77),
    SHAKUHACHI(EGroupInstrument.GRP_PIPE, "Shakuhachi", 78),
    WHISTLE(EGroupInstrument.GRP_PIPE, "Whistle", 79),
    LEAD_1_SQUARE(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 1 (square)", 81),
    LEAD_2_SAWTOOTH(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 2 (sawtooth)", 82),
    LEAD_3_CALLIOPE(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 3 (calliope)", 83),
    LEAD_4_CHIFF(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 4 (chiff)", 84),
    LEAD_5_CHARANG(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 5 (charang)", 85),
    LEAD_6_VOICE(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 6 (voice)", 86),
    LEAD_7_FIFTHS(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 7 (fifths)", 87),
    LEAD_8_BASS_LEAD(EGroupInstrument.GRP_SYNTH_LEAD, "Lead 8 (bass + lead)", 88),
    PAD_1_NEW_AGE(EGroupInstrument.GRP_SYNTH_PAD, "Pad 1 (new age)", 89),
    PAD_2_WARM(EGroupInstrument.GRP_SYNTH_PAD, "Pad 2 (warm)", 90),
    PAD_3_POLYSYNTH(EGroupInstrument.GRP_SYNTH_PAD, "Pad 3 (polysynth)", 91),
    PAD_4_CHOIR(EGroupInstrument.GRP_SYNTH_PAD, "Pad 4 (choir)", 92),
    PAD_5_BOWED(EGroupInstrument.GRP_SYNTH_PAD, "Pad 5 (bowed)", 93),
    PAD_6_METALLIC(EGroupInstrument.GRP_SYNTH_PAD, "Pad 6 (metallic)", 94),
    PAD_7_HALO(EGroupInstrument.GRP_SYNTH_PAD, "Pad 7 (halo)", 95),
    PAD_8_SWEEP(EGroupInstrument.GRP_SYNTH_PAD, "Pad 8 (sweep)", 96),
    FX_1_RAIN(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 1 (rain)", 97),
    FX_2_SOUNDTRACK(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 2 (soundtrack)", 98),
    FX_3_CRYSTAL(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 3 (crystal)", 99),
    FX_4_ATMOSPHERE(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 4 (atmosphere)", 100),
    FX_5_BRIGHTNESS(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 5 (brightness)", 101),
    FX_6_GOBLINS(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 6 (goblins)", 102),
    FX_7_ECHOES(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 7 (echoes)", 103),
    FX_8_SCI_FI(EGroupInstrument.GRP_SYNTH_EFFECTS, "FX 8 (sci-fi)", 104),
    SITAR(EGroupInstrument.GRP_ETHNIC, "Sitar", 105),
    BANJO(EGroupInstrument.GRP_ETHNIC, "Banjo", 106),
    SHAMISEN(EGroupInstrument.GRP_ETHNIC, "Shamisen", 107),
    KOTO(EGroupInstrument.GRP_ETHNIC, "Koto", 108),
    KALIMBA(EGroupInstrument.GRP_ETHNIC, "Kalimba", 109),
    BAG_PIPE(EGroupInstrument.GRP_ETHNIC, "Bag pipe", 110),
    FIDDLE(EGroupInstrument.GRP_ETHNIC, "Fiddle", 111),
    SHANAI(EGroupInstrument.GRP_ETHNIC, "Shanai", 112),
    TINKLE_BELL(EGroupInstrument.GRP_PERCUSSIVE, "Tinkle Bell", 113),
    AGOGO(EGroupInstrument.GRP_PERCUSSIVE, "Agogo", 114),
    STEEL_DRUMS(EGroupInstrument.GRP_PERCUSSIVE, "Steel Drums", 115),
    WOODBLOCK(EGroupInstrument.GRP_PERCUSSIVE, "Woodblock", 116),
    TAIKO_DRUM(EGroupInstrument.GRP_PERCUSSIVE, "Taiko Drum", 117),
    MELODIC_TOM(EGroupInstrument.GRP_PERCUSSIVE, "Melodic Tom", 118),
    SYNTH_DRUM(EGroupInstrument.GRP_PERCUSSIVE, "Synth Drum", 119),
    REVERSE_CYMBAL(EGroupInstrument.GRP_SOUND_EFFECTS, "Reverse Cymbal", 120),
    GUITAR_FRET_NOISE(EGroupInstrument.GRP_SOUND_EFFECTS, "Guitar Fret Noise", 121),
    BREATH_NOISE(EGroupInstrument.GRP_SOUND_EFFECTS, "Breath Noise", 122),
    SEASHORE(EGroupInstrument.GRP_SOUND_EFFECTS, "Seashore", 123),
    BIRD_TWEET(EGroupInstrument.GRP_SOUND_EFFECTS, "Bird Tweet", 124),
    TELEPHONE_RING(EGroupInstrument.GRP_SOUND_EFFECTS, "Telephone Ring", 125),
    HELICOPTER(EGroupInstrument.GRP_SOUND_EFFECTS, "Helicopter", 126),
    APPLAUSE(EGroupInstrument.GRP_SOUND_EFFECTS, "Applause", 127),
    Gunshot(EGroupInstrument.GRP_SOUND_EFFECTS, "Gunshot", 128);
    private final EGroupInstrument mGroup;
    private final String mName;
    private final int mMidiValue;

    EInstrument(EGroupInstrument group, String name, int midiValue) {
        mGroup = group;
        mName = name;
        mMidiValue = midiValue;
    }

    public EGroupInstrument getGroup() {
        return mGroup;
    }

    public String getName() {
        return mName;
    }

    public int getMidiValue() {
        return mMidiValue;
    }

    public static EInstrument getValue(int midiValue) {

        for (EInstrument ins : values()) {
            if (ins.getMidiValue() == midiValue) {
                return ins;
            }
        }
        return EInstrument.ACOUSTIC_GRAND_PIANO;
    }

    @Override
    public String toString() {
        return mName;
    }
}
