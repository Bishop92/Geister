package IA.euristiche;

import logica.Tavolo;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.Weight;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.learning.MomentumBackpropagation;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Stefano on 24/07/2014.
 */
public class NNEuristica implements LearningHeuristic {

    /**
     * Memorizza le varie valutazioni delle euristiche per ogni partita
     */
    private Map<String, DataSet> dataSets = new HashMap<String, DataSet>();

    /**
     * La rete di neuroni che apprende l'euristica da altre euristiche
     */
    private NeuralNetwork<MomentumBackpropagation> neuralNetwork = new NeuralNetwork<MomentumBackpropagation>();

    public NNEuristica() {

        //imposto i neuroni che costituiscono un input
        Neuron[] inputNeurons = {new Neuron(), new Neuron()};
        neuralNetwork.setInputNeurons(inputNeurons);
        //imposto i layer intermedi e stabilisco le connessioni tra i livelli intermedi e l'input
        //imposto i neuroni che costituiscono l'output e stabilisco la connessione con il livello intermedio
        Neuron[] outputNeurons = {new Neuron()};
        neuralNetwork.setOutputNeurons(outputNeurons);

        //ottengo il neurone
        Neuron neuron = new Neuron();
        //ottengo i pesi del neurone
        Weight[] weights = neuron.getWeights();
        //inizializzo i pesi del neurone a quello che ho letto da database
        weights[0].setValue(0);
    }

    @Override
    public double valuta(Tavolo tavolo, byte giocatore, String partita) {
        //ottengo le euristiche selezionate
        Vector<Euristica> euristiche = selezionaEuristiche();
        //ottengo i neuroni in di input
        Neuron[] inputNeurons = neuralNetwork.getInputNeurons();
        //ottengo i vari valori dalle euristiche e li introduco come input nella rete di neuroni
        for (int i = 0; i < euristiche.size(); ++i)
            inputNeurons[i].setInput(euristiche.get(i).valuta(tavolo, giocatore, partita));
        //eseguo il calcolo dell'output e lo fornisco
        neuralNetwork.calculate();
        return neuralNetwork.getOutput()[0];
    }

    @Override
    public void learn(String partita, double esito) {
        //ottengo i training set memorizzati per la partita richiesta
        DataSet dataSet = dataSets.get(partita);
        if (dataSet != null) {
            //per ogni input fornisco l'output che è rappresentato dall'esito della partita
            for (DataSetRow row : dataSet.getRows()) {
                double[] output = {esito};
                row.setDesiredOutput(output);
            }
            //avvio l'apprendimento del training set
            neuralNetwork.learn(dataSet);
        }
        //elimino il training set in quanto già utilizzato
        dataSets.remove(partita);
    }

    @Override
    public void addValutazioneAlTrainingSet(String partita, byte giocatore, Tavolo tavolo) {
        //ottengo le euristiche selezionate
        Vector<Euristica> euristiche = selezionaEuristiche();
        //ottengo i neuroni in di input
        double[] inputs = new double[euristiche.size()];
        for (int i = 0; i < euristiche.size(); ++i)
            inputs[i] = euristiche.get(i).valuta(tavolo, giocatore, partita);
        //imposto gli input ottenuti nel dataset per fornire poi una valutazione dell'euristica
        DataSet dataSet = dataSets.get(partita);
        if (dataSet == null) {
            dataSet = new DataSet(euristiche.size());
            dataSets.put(partita, dataSet);
        }
        dataSet.addRow(inputs);
    }

    /**
     * Fornisce le euristiche selezionate per essere introdotte come input nella rete di neuroni
     * @return Le euristiche selezionate
     */
    private Vector<Euristica> selezionaEuristiche() {
        //ottengo tutte le euristiche implementate
        EuristicheFactory euristicheFactory = EuristicheFactory.getInstance();
        Vector<Euristica> euristiche = new Vector<Euristica>();
        euristiche.addAll(euristicheFactory.getEuristiche());
        //rimuovo le euristiche di cui non sono interessato
        euristiche.remove(euristicheFactory.getEuristica(EuristicheFactory.EURISTICHE.NNEURISTICA));
        return euristiche;
    }
}
