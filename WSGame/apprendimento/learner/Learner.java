package apprendimento.learner;

import java.util.Vector;

import apprendimento.features.FeatureCollector;
import apprendimento.LogPartita;

/**
 * Classe astratta rappresentante un generico algoritmo di apprendimento del profilo
 */
public abstract class Learner {

    private String nome;
    private int giocatore;
    FeatureCollector featureCollector;

    Learner(String nome, FeatureCollector fCollector) {
        this.nome = nome;
        featureCollector = fCollector;
    }

    /**
     * Fornisce il profilo del giocatore
     *
     * @param partite Le partite giocate dal giocatore
     * @return Il profilo del giocatore
     */
    public String getProfilo(Vector<LogPartita> partite) {
        return nome + ":" + buildProfilo(partite);
    }

    /**
     * Fornisce il profilo, costruito dal particolare algoritmo di profilazione, del giocatore
     *
     * @param partite Le partite giocate dal giocatore
     * @return Il profilo del giocatore
     */
    protected abstract StringBuilder buildProfilo(Vector<LogPartita> partite);

    public String getNome() {
        return nome;
    }

    public void setGiocatore(int giocatore) {
        this.giocatore = giocatore;
    }

    FeatureCollector.FeaturePezzi getFeatures(LogPartita partita) {
        return featureCollector.analizzaMosse(giocatore, partita, 0);
    }
}
