package tive.music.base.models;

import java.util.ArrayList;
import java.io.Serializable;

import tive.music.base.constant.EInstrument;
import tive.music.base.constant.EKeyMeasure;

/**
 * @author Alvaro Orellana
 */
public class CPart implements Serializable {
    private int id;
    private String name;
    private ArrayList<CMeasure> measures;
    private EInstrument instrument;
    private int channel;
    private double tempo;

    public CPart(String name, int id, int channel, double tempo, EInstrument instrument) {
        this.name = name;
        this.id = id;
        this.instrument = instrument;
        this.measures = new ArrayList<CMeasure>();
        this.channel = channel;
        this.tempo = tempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CMeasure> getMeasures() {
        return measures;
    }

    public CMeasure addMeasure(CTimeMeasure time, EKeyMeasure key, CClef clef) {
        CMeasure measure = new CMeasure(time, key, clef);
        measure.setTempo(tempo);
        measures.add(measure);
        return measure;
    }

    public void setMeasures(ArrayList<CMeasure> measures) {
        this.measures = measures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EInstrument getInstrument() {
        return instrument;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int newChannel) {
        channel = newChannel;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CPart{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", measures=").append(measures);
        sb.append(", instrument=").append(instrument);
        sb.append(", channel=").append(channel);
        sb.append(", tempo=").append(tempo);
        sb.append('}');
        return sb.toString();
    }
}
