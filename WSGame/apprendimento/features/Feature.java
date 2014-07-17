package apprendimento.features;

interface Feature {

    /**
     * Controlla se la mossa porta a memorizzare la feature e in tal caso la memorizza
     *
     * @param numMossa  Il numero della mossa
     * @param mossa     La mossa da controllare
     * @param pezzo     Il pezzo relativo alla mossa
     * @param giocatore Il giocatore che ha eseguito la mossa
     */
    public void resolve(int numMossa, String mossa, int pezzo, int giocatore);

    /**
     * Fornisce la feature corrispondente al pezzo indicato
     *
     * @param pezzo Il pezzo di cui si vuole conoscere la feature
     * @return La feature corrispondente
     */
    public Double getFeature(int pezzo);
}
