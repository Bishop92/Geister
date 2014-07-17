package apprendimento.features;

public class MosseAvanti extends Feature{

	public int resolve(String mossa, int valorePrecedente){
		int mosseAvanti = valorePrecedente;
		if((Integer.parseInt(mossa.substring(0,1)) < Integer.parseInt(mossa.substring(3,4))))
			mosseAvanti++;
		return mosseAvanti;
	}
}
