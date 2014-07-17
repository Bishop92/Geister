
/**
 * WSGameSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package game;

import skeleton.MySkeleton;

/**
 * WSGameSkeleton java skeleton for the axisService
 */
public class WSGameSkeleton {

    MySkeleton mySkeleton = new MySkeleton();

    /**
     * Auto generated method signature
     *
     * @param listaMosse
     * @return listaMosseResponse
     */

    public game.ListaMosseResponse listaMosse(game.ListaMosse listaMosse) {
        return mySkeleton.listaMosse(listaMosse);
    }


    /**
     * Auto generated method signature
     *
     * @param getTurno
     * @return getTurnoResponse
     */

    public game.GetTurnoResponse getTurno(game.GetTurno getTurno) {
        return mySkeleton.getTurno(getTurno);
    }


    /**
     * Auto generated method signature
     *
     * @param listaPartite
     * @return listaPartiteResponse
     */

    public game.ListaPartiteResponse listaPartite(game.ListaPartite listaPartite) {
        return mySkeleton.listaPartite(listaPartite);
    }


    /**
     * Auto generated method signature
     *
     * @param cancellaPartita
     * @return cancellaPartitaResponse
     */

    public game.CancellaPartitaResponse cancellaPartita(game.CancellaPartita cancellaPartita) {
        return mySkeleton.cancellaPartita(cancellaPartita);
    }


    /**
     * Auto generated method signature
     *
     * @param listaPosizioniIniziali
     * @return listaPosizioniInizialiResponse
     */

    public game.ListaPosizioniInizialiResponse listaPosizioniIniziali(game.ListaPosizioniIniziali listaPosizioniIniziali) {
        return mySkeleton.listaPosizioniIniziali(listaPosizioniIniziali);
    }


    /**
     * Auto generated method signature
     *
     * @param getNomePartita
     * @return getNomePartitaResponse
     */

    public game.GetNomePartitaResponse getNomePartita(game.GetNomePartita getNomePartita) {
        return mySkeleton.getNomePartita(getNomePartita);
    }


    /**
     * Auto generated method signature
     *
     * @param nuovaPartita
     * @return nuovaPartitaResponse
     */

    public game.NuovaPartitaResponse nuovaPartita(game.NuovaPartita nuovaPartita) {
        return mySkeleton.nuovaPartita(nuovaPartita);
    }


    /**
     * Auto generated method signature
     *
     * @param nuovaPosizioneIniziale
     * @return nuovaPosizioneInizialeResponse
     */

    public game.NuovaPosizioneInizialeResponse nuovaPosizioneIniziale(game.NuovaPosizioneIniziale nuovaPosizioneIniziale) {
        return mySkeleton.nuovaPosizioneIniziale(nuovaPosizioneIniziale);
    }


    /**
     * Auto generated method signature
     *
     * @param generaMossaIA
     * @return generaMossaIAResponse
     */

    public game.GeneraMossaIAResponse generaMossaIA(game.GeneraMossaIA generaMossaIA) {
        return mySkeleton.generaMossaIA(generaMossaIA);
    }


    /**
     * Auto generated method signature
     *
     * @param modificaPartita
     * @return modificaPartitaResponse
     */

    public game.ModificaPartitaResponse modificaPartita(game.ModificaPartita modificaPartita) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#modificaPartita");
    }


    /**
     * Auto generated method signature
     *
     * @param modificaTipo
     * @return modificaTipoResponse
     */

    public game.ModificaTipoResponse modificaTipo(game.ModificaTipo modificaTipo) {
        return mySkeleton.modificaTipo(modificaTipo);
    }


    /**
     * Auto generated method signature
     *
     * @param eseguiMossa
     * @return eseguiMossaResponse
     */

    public game.EseguiMossaResponse eseguiMossa(game.EseguiMossa eseguiMossa) {
        return mySkeleton.eseguiMossa(eseguiMossa);
    }

}
    