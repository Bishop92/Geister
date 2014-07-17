package apprendimento.learner;

import java.util.Vector;

import apprendimento.FeatureCollector;
import apprendimento.GestisceLogPartita;
import apprendimento.LogPartita;

public abstract class Learner {

	String nome;
	int giocatore;
	String profilo;
	Vector<LogPartita> partite;
	FeatureCollector feature_collector;
	
	public Learner(String nome, FeatureCollector fc){
		this.nome=nome;
		profilo=nome+":";
		partite=new Vector<LogPartita>();
		feature_collector=fc;
	}
	
	public abstract String getProfilo(Vector<LogPartita> partite);
	
	public String getNome(){
		return nome;
	}
	
	public void addGiocatore(int giocatore){
		this.giocatore=giocatore;
	}
	
	public int getDimIntestazione(){
		//intestazione salvata nel costruttore come "nome_learner:"
		return nome.length()+1;
	}
	
	public FeatureCollector.Struttura getFeatures(LogPartita partita){
		return feature_collector.analizzaMosse(giocatore, partita, 0);
	}
}
