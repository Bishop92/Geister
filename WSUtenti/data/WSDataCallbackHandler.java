
/**
 * WSDataCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package data;

    /**
     *  WSDataCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WSDataCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WSDataCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WSDataCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getListaAmici method
            * override this method for handling normal response from getListaAmici operation
            */
           public void receiveResultgetListaAmici(
                    data.WSDataStub.GetListaAmiciResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getListaAmici operation
           */
            public void receiveErrorgetListaAmici(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtentePerse method
            * override this method for handling normal response from getUtentePerse operation
            */
           public void receiveResultgetUtentePerse(
                    data.WSDataStub.GetUtentePerseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtentePerse operation
           */
            public void receiveErrorgetUtentePerse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteNome method
            * override this method for handling normal response from getUtenteNome operation
            */
           public void receiveResultgetUtenteNome(
                    data.WSDataStub.GetUtenteNomeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteNome operation
           */
            public void receiveErrorgetUtenteNome(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtentePareggiate method
            * override this method for handling normal response from setUtentePareggiate operation
            */
           public void receiveResultsetUtentePareggiate(
                    data.WSDataStub.SetUtentePareggiateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtentePareggiate operation
           */
            public void receiveErrorsetUtentePareggiate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertPartita method
            * override this method for handling normal response from insertPartita operation
            */
           public void receiveResultinsertPartita(
                    data.WSDataStub.InsertPartitaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertPartita operation
           */
            public void receiveErrorinsertPartita(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getListaUtentiOnline method
            * override this method for handling normal response from getListaUtentiOnline operation
            */
           public void receiveResultgetListaUtentiOnline(
                    data.WSDataStub.GetListaUtentiOnlineResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getListaUtentiOnline operation
           */
            public void receiveErrorgetListaUtentiOnline(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for nuovoAmico method
            * override this method for handling normal response from nuovoAmico operation
            */
           public void receiveResultnuovoAmico(
                    data.WSDataStub.NuovoAmicoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nuovoAmico operation
           */
            public void receiveErrornuovoAmico(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertPosizioneIniziale method
            * override this method for handling normal response from insertPosizioneIniziale operation
            */
           public void receiveResultinsertPosizioneIniziale(
                    data.WSDataStub.InsertPosizioneInizialeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertPosizioneIniziale operation
           */
            public void receiveErrorinsertPosizioneIniziale(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertMossa method
            * override this method for handling normal response from insertMossa operation
            */
           public void receiveResultinsertMossa(
                    data.WSDataStub.InsertMossaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertMossa operation
           */
            public void receiveErrorinsertMossa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteIA method
            * override this method for handling normal response from getUtenteIA operation
            */
           public void receiveResultgetUtenteIA(
                    data.WSDataStub.GetUtenteIAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteIA operation
           */
            public void receiveErrorgetUtenteIA(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtente method
            * override this method for handling normal response from getUtente operation
            */
           public void receiveResultgetUtente(
                    data.WSDataStub.GetUtenteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtente operation
           */
            public void receiveErrorgetUtente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteVinte method
            * override this method for handling normal response from setUtenteVinte operation
            */
           public void receiveResultsetUtenteVinte(
                    data.WSDataStub.SetUtenteVinteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteVinte operation
           */
            public void receiveErrorsetUtenteVinte(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtentePerse method
            * override this method for handling normal response from setUtentePerse operation
            */
           public void receiveResultsetUtentePerse(
                    data.WSDataStub.SetUtentePerseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtentePerse operation
           */
            public void receiveErrorsetUtentePerse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteAdmin method
            * override this method for handling normal response from setUtenteAdmin operation
            */
           public void receiveResultsetUtenteAdmin(
                    data.WSDataStub.SetUtenteAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteAdmin operation
           */
            public void receiveErrorsetUtenteAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteOnline method
            * override this method for handling normal response from getUtenteOnline operation
            */
           public void receiveResultgetUtenteOnline(
                    data.WSDataStub.GetUtenteOnlineResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteOnline operation
           */
            public void receiveErrorgetUtenteOnline(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNomePartita method
            * override this method for handling normal response from getNomePartita operation
            */
           public void receiveResultgetNomePartita(
                    data.WSDataStub.GetNomePartitaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNomePartita operation
           */
            public void receiveErrorgetNomePartita(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updatePartita method
            * override this method for handling normal response from updatePartita operation
            */
           public void receiveResultupdatePartita(
                    data.WSDataStub.UpdatePartitaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updatePartita operation
           */
            public void receiveErrorupdatePartita(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteOnline method
            * override this method for handling normal response from setUtenteOnline operation
            */
           public void receiveResultsetUtenteOnline(
                    data.WSDataStub.SetUtenteOnlineResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteOnline operation
           */
            public void receiveErrorsetUtenteOnline(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteIA method
            * override this method for handling normal response from setUtenteIA operation
            */
           public void receiveResultsetUtenteIA(
                    data.WSDataStub.SetUtenteIAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteIA operation
           */
            public void receiveErrorsetUtenteIA(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteEmail method
            * override this method for handling normal response from setUtenteEmail operation
            */
           public void receiveResultsetUtenteEmail(
                    data.WSDataStub.SetUtenteEmailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteEmail operation
           */
            public void receiveErrorsetUtenteEmail(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMosse method
            * override this method for handling normal response from getMosse operation
            */
           public void receiveResultgetMosse(
                    data.WSDataStub.GetMosseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMosse operation
           */
            public void receiveErrorgetMosse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPosizioniIniziali method
            * override this method for handling normal response from getPosizioniIniziali operation
            */
           public void receiveResultgetPosizioniIniziali(
                    data.WSDataStub.GetPosizioniInizialiResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPosizioniIniziali operation
           */
            public void receiveErrorgetPosizioniIniziali(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isUtenteIniziale method
            * override this method for handling normal response from isUtenteIniziale operation
            */
           public void receiveResultisUtenteIniziale(
                    data.WSDataStub.IsUtenteInizialeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isUtenteIniziale operation
           */
            public void receiveErrorisUtenteIniziale(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancellaUtente method
            * override this method for handling normal response from cancellaUtente operation
            */
           public void receiveResultcancellaUtente(
                    data.WSDataStub.CancellaUtenteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancellaUtente operation
           */
            public void receiveErrorcancellaUtente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteCognome method
            * override this method for handling normal response from setUtenteCognome operation
            */
           public void receiveResultsetUtenteCognome(
                    data.WSDataStub.SetUtenteCognomeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteCognome operation
           */
            public void receiveErrorsetUtenteCognome(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancellaAmico method
            * override this method for handling normal response from cancellaAmico operation
            */
           public void receiveResultcancellaAmico(
                    data.WSDataStub.CancellaAmicoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancellaAmico operation
           */
            public void receiveErrorcancellaAmico(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteVinte method
            * override this method for handling normal response from getUtenteVinte operation
            */
           public void receiveResultgetUtenteVinte(
                    data.WSDataStub.GetUtenteVinteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteVinte operation
           */
            public void receiveErrorgetUtenteVinte(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtentePassword method
            * override this method for handling normal response from setUtentePassword operation
            */
           public void receiveResultsetUtentePassword(
                    data.WSDataStub.SetUtentePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtentePassword operation
           */
            public void receiveErrorsetUtentePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIdtoken method
            * override this method for handling normal response from getIdtoken operation
            */
           public void receiveResultgetIdtoken(
                    data.WSDataStub.GetIdtokenResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIdtoken operation
           */
            public void receiveErrorgetIdtoken(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for nuovoUtente method
            * override this method for handling normal response from nuovoUtente operation
            */
           public void receiveResultnuovoUtente(
                    data.WSDataStub.NuovoUtenteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nuovoUtente operation
           */
            public void receiveErrornuovoUtente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteNome method
            * override this method for handling normal response from setUtenteNome operation
            */
           public void receiveResultsetUtenteNome(
                    data.WSDataStub.SetUtenteNomeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteNome operation
           */
            public void receiveErrorsetUtenteNome(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertLOG method
            * override this method for handling normal response from insertLOG operation
            */
           public void receiveResultinsertLOG(
                    data.WSDataStub.InsertLOGResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertLOG operation
           */
            public void receiveErrorinsertLOG(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteCognome method
            * override this method for handling normal response from getUtenteCognome operation
            */
           public void receiveResultgetUtenteCognome(
                    data.WSDataStub.GetUtenteCognomeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteCognome operation
           */
            public void receiveErrorgetUtenteCognome(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modificaUtente method
            * override this method for handling normal response from modificaUtente operation
            */
           public void receiveResultmodificaUtente(
                    data.WSDataStub.ModificaUtenteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modificaUtente operation
           */
            public void receiveErrormodificaUtente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtentePareggiate method
            * override this method for handling normal response from getUtentePareggiate operation
            */
           public void receiveResultgetUtentePareggiate(
                    data.WSDataStub.GetUtentePareggiateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtentePareggiate operation
           */
            public void receiveErrorgetUtentePareggiate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteAdmin method
            * override this method for handling normal response from getUtenteAdmin operation
            */
           public void receiveResultgetUtenteAdmin(
                    data.WSDataStub.GetUtenteAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteAdmin operation
           */
            public void receiveErrorgetUtenteAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deletePartita method
            * override this method for handling normal response from deletePartita operation
            */
           public void receiveResultdeletePartita(
                    data.WSDataStub.DeletePartitaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deletePartita operation
           */
            public void receiveErrordeletePartita(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancellaAmici method
            * override this method for handling normal response from cancellaAmici operation
            */
           public void receiveResultcancellaAmici(
                    data.WSDataStub.CancellaAmiciResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancellaAmici operation
           */
            public void receiveErrorcancellaAmici(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteEmail method
            * override this method for handling normal response from getUtenteEmail operation
            */
           public void receiveResultgetUtenteEmail(
                    data.WSDataStub.GetUtenteEmailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteEmail operation
           */
            public void receiveErrorgetUtenteEmail(java.lang.Exception e) {
            }
                


    }
    