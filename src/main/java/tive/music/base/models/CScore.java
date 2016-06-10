package tive.music.base.models;

import java.io.Serializable;
import java.util.ArrayList;

import tive.music.base.constant.Constants;
import tive.music.base.constant.EInstrument;

/**
 * @author Alvaro Orellana
 */
public class CScore implements Serializable {

    private String title;
    private String composer;
    private String rights;
    private double tempo;
    private ArrayList<CPart> parts;

    public CScore(String title, String composer, String rights) {
        this.title = title;
        this.composer = composer;
        this.rights = rights;
        parts = new ArrayList<CPart>();
        tempo = Constants.DEFAULT_TEMPO;
    }

    public String getTitle() {
        return title;
    }

    public String getComposer() {
        return composer;
    }

    public String getRights() {
        return rights;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public CPart addPart(String name, int channel, double tempo, EInstrument instrument) {
        CPart part = new CPart(name, parts.size() + 1, channel, tempo, instrument);
        parts.add(part);
        return part;
    }

    //TODO: NOT IMPLEMENT getParts
    public ArrayList<CPart> getParts() {
        return parts;
    }


    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        if (this.tempo != tempo) {
            this.tempo = tempo;
            for (CPart part : parts) {
                part.setTempo(tempo);
                for (CMeasure measure : part.getMeasures()) {
                    measure.setTempo(tempo);
                }
            }
        }
    }

    @Override
    protected void finalize() {
        System.out.println("Bye!!, CScore:" + this.title);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CScore{");
        sb.append("title='").append(title).append('\'');
        sb.append(", composer='").append(composer).append('\'');
        sb.append(", rights='").append(rights).append('\'');
        sb.append(", tempo=").append(tempo);
        sb.append(", parts=").append(parts);
        sb.append('}');
        return sb.toString();
    }
}
