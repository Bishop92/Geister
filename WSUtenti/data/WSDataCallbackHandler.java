
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
    abstract class WSDataCallbackHandler{



    private Object clientData;

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
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getListaAmici operation
           */
            public void receiveErrorgetListaAmici() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtentePerse method
            * override this method for handling normal response from getUtentePerse operation
            */
           public void receiveResultgetUtentePerse(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtentePerse operation
           */
            public void receiveErrorgetUtentePerse() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteNome method
            * override this method for handling normal response from getUtenteNome operation
            */
           public void receiveResultgetUtenteNome(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteNome operation
           */
            public void receiveErrorgetUtenteNome() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtentePareggiate method
            * override this method for handling normal response from setUtentePareggiate operation
            */
           public void receiveResultsetUtentePareggiate(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtentePareggiate operation
           */
            public void receiveErrorsetUtentePareggiate() {
            }
                
           /**
            * auto generated Axis2 call back method for insertPartita method
            * override this method for handling normal response from insertPartita operation
            */
           public void receiveResultinsertPartita(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertPartita operation
           */
            public void receiveErrorinsertPartita() {
            }
                
           /**
            * auto generated Axis2 call back method for getListaUtentiOnline method
            * override this method for handling normal response from getListaUtentiOnline operation
            */
           public void receiveResultgetListaUtentiOnline(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getListaUtentiOnline operation
           */
            public void receiveErrorgetListaUtentiOnline() {
            }
                
           /**
            * auto generated Axis2 call back method for nuovoAmico method
            * override this method for handling normal response from nuovoAmico operation
            */
           public void receiveResultnuovoAmico(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nuovoAmico operation
           */
            public void receiveErrornuovoAmico() {
            }
                
           /**
            * auto generated Axis2 call back method for insertPosizioneIniziale method
            * override this method for handling normal response from insertPosizioneIniziale operation
            */
           public void receiveResultinsertPosizioneIniziale(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertPosizioneIniziale operation
           */
            public void receiveErrorinsertPosizioneIniziale() {
            }
                
           /**
            * auto generated Axis2 call back method for insertMossa method
            * override this method for handling normal response from insertMossa operation
            */
           public void receiveResultinsertMossa(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertMossa operation
           */
            public void receiveErrorinsertMossa() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteIA method
            * override this method for handling normal response from getUtenteIA operation
            */
           public void receiveResultgetUtenteIA(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteIA operation
           */
            public void receiveErrorgetUtenteIA() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtente method
            * override this method for handling normal response from getUtente operation
            */
           public void receiveResultgetUtente(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtente operation
           */
            public void receiveErrorgetUtente() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteVinte method
            * override this method for handling normal response from setUtenteVinte operation
            */
           public void receiveResultsetUtenteVinte(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteVinte operation
           */
            public void receiveErrorsetUtenteVinte() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtentePerse method
            * override this method for handling normal response from setUtentePerse operation
            */
           public void receiveResultsetUtentePerse(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtentePerse operation
           */
            public void receiveErrorsetUtentePerse() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteAdmin method
            * override this method for handling normal response from setUtenteAdmin operation
            */
           public void receiveResultsetUtenteAdmin(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteAdmin operation
           */
            public void receiveErrorsetUtenteAdmin() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteOnline method
            * override this method for handling normal response from getUtenteOnline operation
            */
           public void receiveResultgetUtenteOnline(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteOnline operation
           */
            public void receiveErrorgetUtenteOnline() {
            }
                
           /**
            * auto generated Axis2 call back method for getNomePartita method
            * override this method for handling normal response from getNomePartita operation
            */
           public void receiveResultgetNomePartita(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNomePartita operation
           */
            public void receiveErrorgetNomePartita() {
            }
                
           /**
            * auto generated Axis2 call back method for updatePartita method
            * override this method for handling normal response from updatePartita operation
            */
           public void receiveResultupdatePartita(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updatePartita operation
           */
            public void receiveErrorupdatePartita() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteOnline method
            * override this method for handling normal response from setUtenteOnline operation
            */
           public void receiveResultsetUtenteOnline(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteOnline operation
           */
            public void receiveErrorsetUtenteOnline() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteIA method
            * override this method for handling normal response from setUtenteIA operation
            */
           public void receiveResultsetUtenteIA(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteIA operation
           */
            public void receiveErrorsetUtenteIA() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteEmail method
            * override this method for handling normal response from setUtenteEmail operation
            */
           public void receiveResultsetUtenteEmail(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteEmail operation
           */
            public void receiveErrorsetUtenteEmail() {
            }
                
           /**
            * auto generated Axis2 call back method for getMosse method
            * override this method for handling normal response from getMosse operation
            */
           public void receiveResultgetMosse(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMosse operation
           */
            public void receiveErrorgetMosse() {
            }
                
           /**
            * auto generated Axis2 call back method for getPosizioniIniziali method
            * override this method for handling normal response from getPosizioniIniziali operation
            */
           public void receiveResultgetPosizioniIniziali(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPosizioniIniziali operation
           */
            public void receiveErrorgetPosizioniIniziali() {
            }
                
           /**
            * auto generated Axis2 call back method for isUtenteIniziale method
            * override this method for handling normal response from isUtenteIniziale operation
            */
           public void receiveResultisUtenteIniziale(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isUtenteIniziale operation
           */
            public void receiveErrorisUtenteIniziale() {
            }
                
           /**
            * auto generated Axis2 call back method for cancellaUtente method
            * override this method for handling normal response from cancellaUtente operation
            */
           public void receiveResultcancellaUtente(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancellaUtente operation
           */
            public void receiveErrorcancellaUtente() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteCognome method
            * override this method for handling normal response from setUtenteCognome operation
            */
           public void receiveResultsetUtenteCognome(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteCognome operation
           */
            public void receiveErrorsetUtenteCognome() {
            }
                
           /**
            * auto generated Axis2 call back method for cancellaAmico method
            * override this method for handling normal response from cancellaAmico operation
            */
           public void receiveResultcancellaAmico(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancellaAmico operation
           */
            public void receiveErrorcancellaAmico() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteVinte method
            * override this method for handling normal response from getUtenteVinte operation
            */
           public void receiveResultgetUtenteVinte(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteVinte operation
           */
            public void receiveErrorgetUtenteVinte() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtentePassword method
            * override this method for handling normal response from setUtentePassword operation
            */
           public void receiveResultsetUtentePassword(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtentePassword operation
           */
            public void receiveErrorsetUtentePassword() {
            }
                
           /**
            * auto generated Axis2 call back method for getIdtoken method
            * override this method for handling normal response from getIdtoken operation
            */
           public void receiveResultgetIdtoken(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIdtoken operation
           */
            public void receiveErrorgetIdtoken() {
            }
                
           /**
            * auto generated Axis2 call back method for nuovoUtente method
            * override this method for handling normal response from nuovoUtente operation
            */
           public void receiveResultnuovoUtente(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nuovoUtente operation
           */
            public void receiveErrornuovoUtente() {
            }
                
           /**
            * auto generated Axis2 call back method for setUtenteNome method
            * override this method for handling normal response from setUtenteNome operation
            */
           public void receiveResultsetUtenteNome(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setUtenteNome operation
           */
            public void receiveErrorsetUtenteNome() {
            }
                
           /**
            * auto generated Axis2 call back method for insertLOG method
            * override this method for handling normal response from insertLOG operation
            */
           public void receiveResultinsertLOG(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertLOG operation
           */
            public void receiveErrorinsertLOG() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteCognome method
            * override this method for handling normal response from getUtenteCognome operation
            */
           public void receiveResultgetUtenteCognome(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteCognome operation
           */
            public void receiveErrorgetUtenteCognome() {
            }
                
           /**
            * auto generated Axis2 call back method for modificaUtente method
            * override this method for handling normal response from modificaUtente operation
            */
           public void receiveResultmodificaUtente(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modificaUtente operation
           */
            public void receiveErrormodificaUtente() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtentePareggiate method
            * override this method for handling normal response from getUtentePareggiate operation
            */
           public void receiveResultgetUtentePareggiate(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtentePareggiate operation
           */
            public void receiveErrorgetUtentePareggiate() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteAdmin method
            * override this method for handling normal response from getUtenteAdmin operation
            */
           public void receiveResultgetUtenteAdmin(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteAdmin operation
           */
            public void receiveErrorgetUtenteAdmin() {
            }
                
           /**
            * auto generated Axis2 call back method for deletePartita method
            * override this method for handling normal response from deletePartita operation
            */
           public void receiveResultdeletePartita(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deletePartita operation
           */
            public void receiveErrordeletePartita() {
            }
                
           /**
            * auto generated Axis2 call back method for cancellaAmici method
            * override this method for handling normal response from cancellaAmici operation
            */
           public void receiveResultcancellaAmici(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancellaAmici operation
           */
            public void receiveErrorcancellaAmici() {
            }
                
           /**
            * auto generated Axis2 call back method for getUtenteEmail method
            * override this method for handling normal response from getUtenteEmail operation
            */
           public void receiveResultgetUtenteEmail(
           ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUtenteEmail operation
           */
            public void receiveErrorgetUtenteEmail() {
            }
                


    }
    