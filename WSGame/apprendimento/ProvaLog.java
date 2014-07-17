package apprendimento;

import java.util.Vector;

import apprendimento.features.MosseAvanti;
import apprendimento.learner.*;

public class ProvaLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//GestisceLogPartita gl = new GestisceLogPartita(1);
		FeatureCollector fc = new FeatureCollector();
		for(int i=0;i<18;i++){
			fc.addFeature(new MosseAvanti());
		}
		Learner media=new MediaVettori(fc);
		Learner media2=new MediaVettori2(fc);
		LearnerExecutor l1=new LearnerExecutor();
		l1.aggiungiLearner(media);
		l1.aggiungiLearner(media2);
		l1.execute();
		
		//System.out.println("Vettore buoni "+l1.getBuoni());
		//System.out.println("Vettore cattivi "+l1.getCattivi());
		
		/*
		System.out.print("VETTORE CATTIVI [");
		for(int i=0;i<17;i++){
			System.out.print(l1.getCattivi().get(i));
			if(i!=16)
				System.out.print(", ");
		}
		System.out.println("]");
		*/
	}

}
