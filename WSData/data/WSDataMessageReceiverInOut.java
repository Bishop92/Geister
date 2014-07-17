
/**
 * WSDataMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package data;

        /**
        *  WSDataMessageReceiverInOut message receiver
        */

        public class WSDataMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        WSDataSkeleton skel = (WSDataSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("getListaAmici".equals(methodName)){
                
                data.GetListaAmiciResponse getListaAmiciResponse1 = null;
	                        data.GetListaAmici wrappedParam =
                                                             (data.GetListaAmici)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetListaAmici.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getListaAmiciResponse1 =
                                                   
                                                   
                                                         skel.getListaAmici(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getListaAmiciResponse1, false, new javax.xml.namespace.QName("http://data",
                                                    "getListaAmici"));
                                    } else 

            if("getUtentePerse".equals(methodName)){
                
                data.GetUtentePerseResponse getUtentePerseResponse3 = null;
	                        data.GetUtentePerse wrappedParam =
                                                             (data.GetUtentePerse)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtentePerse.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtentePerseResponse3 =
                                                   
                                                   
                                                         skel.getUtentePerse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtentePerseResponse3, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtentePerse"));
                                    } else 

            if("getUtenteNome".equals(methodName)){
                
                data.GetUtenteNomeResponse getUtenteNomeResponse5 = null;
	                        data.GetUtenteNome wrappedParam =
                                                             (data.GetUtenteNome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteNome.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteNomeResponse5 =
                                                   
                                                   
                                                         skel.getUtenteNome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteNomeResponse5, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteNome"));
                                    } else 

            if("setUtentePareggiate".equals(methodName)){
                
                data.SetUtentePareggiateResponse setUtentePareggiateResponse7 = null;
	                        data.SetUtentePareggiate wrappedParam =
                                                             (data.SetUtentePareggiate)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtentePareggiate.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtentePareggiateResponse7 =
                                                   
                                                   
                                                         skel.setUtentePareggiate(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtentePareggiateResponse7, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtentePareggiate"));
                                    } else 

            if("insertPartita".equals(methodName)){
                
                data.InsertPartitaResponse insertPartitaResponse9 = null;
	                        data.InsertPartita wrappedParam =
                                                             (data.InsertPartita)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.InsertPartita.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               insertPartitaResponse9 =
                                                   
                                                   
                                                         skel.insertPartita(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), insertPartitaResponse9, false, new javax.xml.namespace.QName("http://data",
                                                    "insertPartita"));
                                    } else 

            if("getListaUtentiOnline".equals(methodName)){
                
                data.GetListaUtentiOnlineResponse getListaUtentiOnlineResponse11 = null;
	                        data.GetListaUtentiOnline wrappedParam =
                                                             (data.GetListaUtentiOnline)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetListaUtentiOnline.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getListaUtentiOnlineResponse11 =
                                                   
                                                   
                                                         skel.getListaUtentiOnline(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getListaUtentiOnlineResponse11, false, new javax.xml.namespace.QName("http://data",
                                                    "getListaUtentiOnline"));
                                    } else 

            if("nuovoAmico".equals(methodName)){
                
                data.NuovoAmicoResponse nuovoAmicoResponse13 = null;
	                        data.NuovoAmico wrappedParam =
                                                             (data.NuovoAmico)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.NuovoAmico.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               nuovoAmicoResponse13 =
                                                   
                                                   
                                                         skel.nuovoAmico(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), nuovoAmicoResponse13, false, new javax.xml.namespace.QName("http://data",
                                                    "nuovoAmico"));
                                    } else 

            if("insertPosizioneIniziale".equals(methodName)){
                
                data.InsertPosizioneInizialeResponse insertPosizioneInizialeResponse15 = null;
	                        data.InsertPosizioneIniziale wrappedParam =
                                                             (data.InsertPosizioneIniziale)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.InsertPosizioneIniziale.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               insertPosizioneInizialeResponse15 =
                                                   
                                                   
                                                         skel.insertPosizioneIniziale(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), insertPosizioneInizialeResponse15, false, new javax.xml.namespace.QName("http://data",
                                                    "insertPosizioneIniziale"));
                                    } else 

            if("insertMossa".equals(methodName)){
                
                data.InsertMossaResponse insertMossaResponse17 = null;
	                        data.InsertMossa wrappedParam =
                                                             (data.InsertMossa)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.InsertMossa.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               insertMossaResponse17 =
                                                   
                                                   
                                                         skel.insertMossa(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), insertMossaResponse17, false, new javax.xml.namespace.QName("http://data",
                                                    "insertMossa"));
                                    } else 

            if("getUtenteIA".equals(methodName)){
                
                data.GetUtenteIAResponse getUtenteIAResponse19 = null;
	                        data.GetUtenteIA wrappedParam =
                                                             (data.GetUtenteIA)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteIA.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteIAResponse19 =
                                                   
                                                   
                                                         skel.getUtenteIA(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteIAResponse19, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteIA"));
                                    } else 

            if("getPartite".equals(methodName)){
                
                data.GetPartiteResponse getPartiteResponse21 = null;
	                        data.GetPartite wrappedParam =
                                                             (data.GetPartite)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetPartite.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPartiteResponse21 =
                                                   
                                                   
                                                         skel.getPartite(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPartiteResponse21, false, new javax.xml.namespace.QName("http://data",
                                                    "getPartite"));
                                    } else 

            if("updateTipo".equals(methodName)){
                
                data.UpdateTipoResponse updateTipoResponse23 = null;
	                        data.UpdateTipo wrappedParam =
                                                             (data.UpdateTipo)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.UpdateTipo.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               updateTipoResponse23 =
                                                   
                                                   
                                                         skel.updateTipo(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), updateTipoResponse23, false, new javax.xml.namespace.QName("http://data",
                                                    "updateTipo"));
                                    } else 

            if("getUtente".equals(methodName)){
                
                data.GetUtenteResponse getUtenteResponse25 = null;
	                        data.GetUtente wrappedParam =
                                                             (data.GetUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtente.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteResponse25 =
                                                   
                                                   
                                                         skel.getUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteResponse25, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtente"));
                                    } else 

            if("setUtenteVinte".equals(methodName)){
                
                data.SetUtenteVinteResponse setUtenteVinteResponse27 = null;
	                        data.SetUtenteVinte wrappedParam =
                                                             (data.SetUtenteVinte)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteVinte.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteVinteResponse27 =
                                                   
                                                   
                                                         skel.setUtenteVinte(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteVinteResponse27, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteVinte"));
                                    } else 

            if("setUtentePerse".equals(methodName)){
                
                data.SetUtentePerseResponse setUtentePerseResponse29 = null;
	                        data.SetUtentePerse wrappedParam =
                                                             (data.SetUtentePerse)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtentePerse.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtentePerseResponse29 =
                                                   
                                                   
                                                         skel.setUtentePerse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtentePerseResponse29, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtentePerse"));
                                    } else 

            if("setUtenteAdmin".equals(methodName)){
                
                data.SetUtenteAdminResponse setUtenteAdminResponse31 = null;
	                        data.SetUtenteAdmin wrappedParam =
                                                             (data.SetUtenteAdmin)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteAdmin.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteAdminResponse31 =
                                                   
                                                   
                                                         skel.setUtenteAdmin(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteAdminResponse31, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteAdmin"));
                                    } else 

            if("getUtenteOnline".equals(methodName)){
                
                data.GetUtenteOnlineResponse getUtenteOnlineResponse33 = null;
	                        data.GetUtenteOnline wrappedParam =
                                                             (data.GetUtenteOnline)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteOnline.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteOnlineResponse33 =
                                                   
                                                   
                                                         skel.getUtenteOnline(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteOnlineResponse33, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteOnline"));
                                    } else 

            if("getNomePartita".equals(methodName)){
                
                data.GetNomePartitaResponse getNomePartitaResponse35 = null;
	                        data.GetNomePartita wrappedParam =
                                                             (data.GetNomePartita)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetNomePartita.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getNomePartitaResponse35 =
                                                   
                                                   
                                                         skel.getNomePartita(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getNomePartitaResponse35, false, new javax.xml.namespace.QName("http://data",
                                                    "getNomePartita"));
                                    } else 

            if("updatePartita".equals(methodName)){
                
                data.UpdatePartitaResponse updatePartitaResponse37 = null;
	                        data.UpdatePartita wrappedParam =
                                                             (data.UpdatePartita)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.UpdatePartita.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               updatePartitaResponse37 =
                                                   
                                                   
                                                         skel.updatePartita(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), updatePartitaResponse37, false, new javax.xml.namespace.QName("http://data",
                                                    "updatePartita"));
                                    } else 

            if("setUtenteOnline".equals(methodName)){
                
                data.SetUtenteOnlineResponse setUtenteOnlineResponse39 = null;
	                        data.SetUtenteOnline wrappedParam =
                                                             (data.SetUtenteOnline)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteOnline.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteOnlineResponse39 =
                                                   
                                                   
                                                         skel.setUtenteOnline(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteOnlineResponse39, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteOnline"));
                                    } else 

            if("setUtenteIA".equals(methodName)){
                
                data.SetUtenteIAResponse setUtenteIAResponse41 = null;
	                        data.SetUtenteIA wrappedParam =
                                                             (data.SetUtenteIA)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteIA.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteIAResponse41 =
                                                   
                                                   
                                                         skel.setUtenteIA(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteIAResponse41, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteIA"));
                                    } else 

            if("setUtenteEmail".equals(methodName)){
                
                data.SetUtenteEmailResponse setUtenteEmailResponse43 = null;
	                        data.SetUtenteEmail wrappedParam =
                                                             (data.SetUtenteEmail)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteEmail.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteEmailResponse43 =
                                                   
                                                   
                                                         skel.setUtenteEmail(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteEmailResponse43, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteEmail"));
                                    } else 

            if("getMosse".equals(methodName)){
                
                data.GetMosseResponse getMosseResponse45 = null;
	                        data.GetMosse wrappedParam =
                                                             (data.GetMosse)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetMosse.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMosseResponse45 =
                                                   
                                                   
                                                         skel.getMosse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMosseResponse45, false, new javax.xml.namespace.QName("http://data",
                                                    "getMosse"));
                                    } else 

            if("getPosizioniIniziali".equals(methodName)){
                
                data.GetPosizioniInizialiResponse getPosizioniInizialiResponse47 = null;
	                        data.GetPosizioniIniziali wrappedParam =
                                                             (data.GetPosizioniIniziali)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetPosizioniIniziali.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPosizioniInizialiResponse47 =
                                                   
                                                   
                                                         skel.getPosizioniIniziali(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPosizioniInizialiResponse47, false, new javax.xml.namespace.QName("http://data",
                                                    "getPosizioniIniziali"));
                                    } else 

            if("isUtenteIniziale".equals(methodName)){
                
                data.IsUtenteInizialeResponse isUtenteInizialeResponse49 = null;
	                        data.IsUtenteIniziale wrappedParam =
                                                             (data.IsUtenteIniziale)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.IsUtenteIniziale.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               isUtenteInizialeResponse49 =
                                                   
                                                   
                                                         skel.isUtenteIniziale(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), isUtenteInizialeResponse49, false, new javax.xml.namespace.QName("http://data",
                                                    "isUtenteIniziale"));
                                    } else 

            if("cancellaUtente".equals(methodName)){
                
                data.CancellaUtenteResponse cancellaUtenteResponse51 = null;
	                        data.CancellaUtente wrappedParam =
                                                             (data.CancellaUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.CancellaUtente.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancellaUtenteResponse51 =
                                                   
                                                   
                                                         skel.cancellaUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancellaUtenteResponse51, false, new javax.xml.namespace.QName("http://data",
                                                    "cancellaUtente"));
                                    } else 

            if("setUtenteCognome".equals(methodName)){
                
                data.SetUtenteCognomeResponse setUtenteCognomeResponse53 = null;
	                        data.SetUtenteCognome wrappedParam =
                                                             (data.SetUtenteCognome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteCognome.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteCognomeResponse53 =
                                                   
                                                   
                                                         skel.setUtenteCognome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteCognomeResponse53, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteCognome"));
                                    } else 

            if("cancellaAmico".equals(methodName)){
                
                data.CancellaAmicoResponse cancellaAmicoResponse55 = null;
	                        data.CancellaAmico wrappedParam =
                                                             (data.CancellaAmico)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.CancellaAmico.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancellaAmicoResponse55 =
                                                   
                                                   
                                                         skel.cancellaAmico(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancellaAmicoResponse55, false, new javax.xml.namespace.QName("http://data",
                                                    "cancellaAmico"));
                                    } else 

            if("getUtenteVinte".equals(methodName)){
                
                data.GetUtenteVinteResponse getUtenteVinteResponse57 = null;
	                        data.GetUtenteVinte wrappedParam =
                                                             (data.GetUtenteVinte)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteVinte.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteVinteResponse57 =
                                                   
                                                   
                                                         skel.getUtenteVinte(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteVinteResponse57, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteVinte"));
                                    } else 

            if("setUtentePassword".equals(methodName)){
                
                data.SetUtentePasswordResponse setUtentePasswordResponse59 = null;
	                        data.SetUtentePassword wrappedParam =
                                                             (data.SetUtentePassword)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtentePassword.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtentePasswordResponse59 =
                                                   
                                                   
                                                         skel.setUtentePassword(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtentePasswordResponse59, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtentePassword"));
                                    } else 

            if("getIdtoken".equals(methodName)){
                
                data.GetIdtokenResponse getIdtokenResponse61 = null;
	                        data.GetIdtoken wrappedParam =
                                                             (data.GetIdtoken)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetIdtoken.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getIdtokenResponse61 =
                                                   
                                                   
                                                         skel.getIdtoken(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getIdtokenResponse61, false, new javax.xml.namespace.QName("http://data",
                                                    "getIdtoken"));
                                    } else 

            if("nuovoUtente".equals(methodName)){
                
                data.NuovoUtenteResponse nuovoUtenteResponse63 = null;
	                        data.NuovoUtente wrappedParam =
                                                             (data.NuovoUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.NuovoUtente.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               nuovoUtenteResponse63 =
                                                   
                                                   
                                                         skel.nuovoUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), nuovoUtenteResponse63, false, new javax.xml.namespace.QName("http://data",
                                                    "nuovoUtente"));
                                    } else 

            if("setUtenteNome".equals(methodName)){
                
                data.SetUtenteNomeResponse setUtenteNomeResponse65 = null;
	                        data.SetUtenteNome wrappedParam =
                                                             (data.SetUtenteNome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.SetUtenteNome.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               setUtenteNomeResponse65 =
                                                   
                                                   
                                                         skel.setUtenteNome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setUtenteNomeResponse65, false, new javax.xml.namespace.QName("http://data",
                                                    "setUtenteNome"));
                                    } else 

            if("insertLOG".equals(methodName)){
                
                data.InsertLOGResponse insertLOGResponse67 = null;
	                        data.InsertLOG wrappedParam =
                                                             (data.InsertLOG)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.InsertLOG.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               insertLOGResponse67 =
                                                   
                                                   
                                                         skel.insertLOG(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), insertLOGResponse67, false, new javax.xml.namespace.QName("http://data",
                                                    "insertLOG"));
                                    } else 

            if("getUtenteCognome".equals(methodName)){
                
                data.GetUtenteCognomeResponse getUtenteCognomeResponse69 = null;
	                        data.GetUtenteCognome wrappedParam =
                                                             (data.GetUtenteCognome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteCognome.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteCognomeResponse69 =
                                                   
                                                   
                                                         skel.getUtenteCognome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteCognomeResponse69, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteCognome"));
                                    } else 

            if("modificaUtente".equals(methodName)){
                
                data.ModificaUtenteResponse modificaUtenteResponse71 = null;
	                        data.ModificaUtente wrappedParam =
                                                             (data.ModificaUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.ModificaUtente.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               modificaUtenteResponse71 =
                                                   
                                                   
                                                         skel.modificaUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), modificaUtenteResponse71, false, new javax.xml.namespace.QName("http://data",
                                                    "modificaUtente"));
                                    } else 

            if("getUtentePareggiate".equals(methodName)){
                
                data.GetUtentePareggiateResponse getUtentePareggiateResponse73 = null;
	                        data.GetUtentePareggiate wrappedParam =
                                                             (data.GetUtentePareggiate)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtentePareggiate.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtentePareggiateResponse73 =
                                                   
                                                   
                                                         skel.getUtentePareggiate(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtentePareggiateResponse73, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtentePareggiate"));
                                    } else 

            if("getUtenteAdmin".equals(methodName)){
                
                data.GetUtenteAdminResponse getUtenteAdminResponse75 = null;
	                        data.GetUtenteAdmin wrappedParam =
                                                             (data.GetUtenteAdmin)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteAdmin.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteAdminResponse75 =
                                                   
                                                   
                                                         skel.getUtenteAdmin(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteAdminResponse75, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteAdmin"));
                                    } else 

            if("deletePartita".equals(methodName)){
                
                data.DeletePartitaResponse deletePartitaResponse77 = null;
	                        data.DeletePartita wrappedParam =
                                                             (data.DeletePartita)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.DeletePartita.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               deletePartitaResponse77 =
                                                   
                                                   
                                                         skel.deletePartita(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), deletePartitaResponse77, false, new javax.xml.namespace.QName("http://data",
                                                    "deletePartita"));
                                    } else 

            if("cancellaAmici".equals(methodName)){
                
                data.CancellaAmiciResponse cancellaAmiciResponse79 = null;
	                        data.CancellaAmici wrappedParam =
                                                             (data.CancellaAmici)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.CancellaAmici.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancellaAmiciResponse79 =
                                                   
                                                   
                                                         skel.cancellaAmici(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancellaAmiciResponse79, false, new javax.xml.namespace.QName("http://data",
                                                    "cancellaAmici"));
                                    } else 

            if("getUtenteEmail".equals(methodName)){
                
                data.GetUtenteEmailResponse getUtenteEmailResponse81 = null;
	                        data.GetUtenteEmail wrappedParam =
                                                             (data.GetUtenteEmail)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    data.GetUtenteEmail.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getUtenteEmailResponse81 =
                                                   
                                                   
                                                         skel.getUtenteEmail(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getUtenteEmailResponse81, false, new javax.xml.namespace.QName("http://data",
                                                    "getUtenteEmail"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(data.GetListaAmici param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetListaAmici.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetListaAmiciResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetListaAmiciResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtentePerse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtentePerse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtentePerseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtentePerseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteNome param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteNome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteNomeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteNomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtentePareggiate param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtentePareggiate.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtentePareggiateResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtentePareggiateResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertPartita param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertPartita.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertPartitaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertPartitaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetListaUtentiOnline param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetListaUtentiOnline.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetListaUtentiOnlineResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetListaUtentiOnlineResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.NuovoAmico param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.NuovoAmico.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.NuovoAmicoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.NuovoAmicoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertPosizioneIniziale param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertPosizioneIniziale.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertPosizioneInizialeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertPosizioneInizialeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertMossa param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertMossa.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertMossaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertMossaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteIA param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteIA.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteIAResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteIAResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetPartite param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetPartite.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetPartiteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetPartiteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.UpdateTipo param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.UpdateTipo.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.UpdateTipoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.UpdateTipoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtente param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteVinte param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteVinte.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteVinteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteVinteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtentePerse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtentePerse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtentePerseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtentePerseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteAdmin param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteAdmin.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteAdminResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteAdminResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteOnline param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteOnline.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteOnlineResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteOnlineResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetNomePartita param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetNomePartita.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetNomePartitaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetNomePartitaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.UpdatePartita param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.UpdatePartita.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.UpdatePartitaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.UpdatePartitaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteOnline param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteOnline.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteOnlineResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteOnlineResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteIA param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteIA.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteIAResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteIAResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteEmail param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteEmail.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteEmailResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteEmailResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetMosse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetMosse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetMosseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetMosseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetPosizioniIniziali param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetPosizioniIniziali.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetPosizioniInizialiResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetPosizioniInizialiResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.IsUtenteIniziale param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.IsUtenteIniziale.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.IsUtenteInizialeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.IsUtenteInizialeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.CancellaUtente param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.CancellaUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.CancellaUtenteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.CancellaUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteCognome param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteCognome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteCognomeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteCognomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.CancellaAmico param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.CancellaAmico.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.CancellaAmicoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.CancellaAmicoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteVinte param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteVinte.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteVinteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteVinteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtentePassword param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtentePassword.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtentePasswordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtentePasswordResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetIdtoken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetIdtoken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetIdtokenResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetIdtokenResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.NuovoUtente param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.NuovoUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.NuovoUtenteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.NuovoUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteNome param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteNome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.SetUtenteNomeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.SetUtenteNomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertLOG param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertLOG.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.InsertLOGResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.InsertLOGResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteCognome param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteCognome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteCognomeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteCognomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.ModificaUtente param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.ModificaUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.ModificaUtenteResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.ModificaUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtentePareggiate param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtentePareggiate.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtentePareggiateResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtentePareggiateResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteAdmin param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteAdmin.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteAdminResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteAdminResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.DeletePartita param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.DeletePartita.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.DeletePartitaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.DeletePartitaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.CancellaAmici param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.CancellaAmici.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.CancellaAmiciResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.CancellaAmiciResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteEmail param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteEmail.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(data.GetUtenteEmailResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(data.GetUtenteEmailResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetListaAmiciResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetListaAmiciResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetListaAmiciResponse wrapgetListaAmici(){
                                data.GetListaAmiciResponse wrappedElement = new data.GetListaAmiciResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtentePerseResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtentePerseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtentePerseResponse wrapgetUtentePerse(){
                                data.GetUtentePerseResponse wrappedElement = new data.GetUtentePerseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteNomeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteNomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteNomeResponse wrapgetUtenteNome(){
                                data.GetUtenteNomeResponse wrappedElement = new data.GetUtenteNomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtentePareggiateResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtentePareggiateResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtentePareggiateResponse wrapsetUtentePareggiate(){
                                data.SetUtentePareggiateResponse wrappedElement = new data.SetUtentePareggiateResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.InsertPartitaResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.InsertPartitaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.InsertPartitaResponse wrapinsertPartita(){
                                data.InsertPartitaResponse wrappedElement = new data.InsertPartitaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetListaUtentiOnlineResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetListaUtentiOnlineResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetListaUtentiOnlineResponse wrapgetListaUtentiOnline(){
                                data.GetListaUtentiOnlineResponse wrappedElement = new data.GetListaUtentiOnlineResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.NuovoAmicoResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.NuovoAmicoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.NuovoAmicoResponse wrapnuovoAmico(){
                                data.NuovoAmicoResponse wrappedElement = new data.NuovoAmicoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.InsertPosizioneInizialeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.InsertPosizioneInizialeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.InsertPosizioneInizialeResponse wrapinsertPosizioneIniziale(){
                                data.InsertPosizioneInizialeResponse wrappedElement = new data.InsertPosizioneInizialeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.InsertMossaResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.InsertMossaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.InsertMossaResponse wrapinsertMossa(){
                                data.InsertMossaResponse wrappedElement = new data.InsertMossaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteIAResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteIAResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteIAResponse wrapgetUtenteIA(){
                                data.GetUtenteIAResponse wrappedElement = new data.GetUtenteIAResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetPartiteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetPartiteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetPartiteResponse wrapgetPartite(){
                                data.GetPartiteResponse wrappedElement = new data.GetPartiteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.UpdateTipoResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.UpdateTipoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.UpdateTipoResponse wrapupdateTipo(){
                                data.UpdateTipoResponse wrappedElement = new data.UpdateTipoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteResponse wrapgetUtente(){
                                data.GetUtenteResponse wrappedElement = new data.GetUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteVinteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteVinteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteVinteResponse wrapsetUtenteVinte(){
                                data.SetUtenteVinteResponse wrappedElement = new data.SetUtenteVinteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtentePerseResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtentePerseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtentePerseResponse wrapsetUtentePerse(){
                                data.SetUtentePerseResponse wrappedElement = new data.SetUtentePerseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteAdminResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteAdminResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteAdminResponse wrapsetUtenteAdmin(){
                                data.SetUtenteAdminResponse wrappedElement = new data.SetUtenteAdminResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteOnlineResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteOnlineResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteOnlineResponse wrapgetUtenteOnline(){
                                data.GetUtenteOnlineResponse wrappedElement = new data.GetUtenteOnlineResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetNomePartitaResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetNomePartitaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetNomePartitaResponse wrapgetNomePartita(){
                                data.GetNomePartitaResponse wrappedElement = new data.GetNomePartitaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.UpdatePartitaResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.UpdatePartitaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.UpdatePartitaResponse wrapupdatePartita(){
                                data.UpdatePartitaResponse wrappedElement = new data.UpdatePartitaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteOnlineResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteOnlineResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteOnlineResponse wrapsetUtenteOnline(){
                                data.SetUtenteOnlineResponse wrappedElement = new data.SetUtenteOnlineResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteIAResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteIAResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteIAResponse wrapsetUtenteIA(){
                                data.SetUtenteIAResponse wrappedElement = new data.SetUtenteIAResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteEmailResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteEmailResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteEmailResponse wrapsetUtenteEmail(){
                                data.SetUtenteEmailResponse wrappedElement = new data.SetUtenteEmailResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetMosseResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetMosseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetMosseResponse wrapgetMosse(){
                                data.GetMosseResponse wrappedElement = new data.GetMosseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetPosizioniInizialiResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetPosizioniInizialiResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetPosizioniInizialiResponse wrapgetPosizioniIniziali(){
                                data.GetPosizioniInizialiResponse wrappedElement = new data.GetPosizioniInizialiResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.IsUtenteInizialeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.IsUtenteInizialeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.IsUtenteInizialeResponse wrapisUtenteIniziale(){
                                data.IsUtenteInizialeResponse wrappedElement = new data.IsUtenteInizialeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.CancellaUtenteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.CancellaUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.CancellaUtenteResponse wrapcancellaUtente(){
                                data.CancellaUtenteResponse wrappedElement = new data.CancellaUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteCognomeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteCognomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteCognomeResponse wrapsetUtenteCognome(){
                                data.SetUtenteCognomeResponse wrappedElement = new data.SetUtenteCognomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.CancellaAmicoResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.CancellaAmicoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.CancellaAmicoResponse wrapcancellaAmico(){
                                data.CancellaAmicoResponse wrappedElement = new data.CancellaAmicoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteVinteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteVinteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteVinteResponse wrapgetUtenteVinte(){
                                data.GetUtenteVinteResponse wrappedElement = new data.GetUtenteVinteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtentePasswordResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtentePasswordResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtentePasswordResponse wrapsetUtentePassword(){
                                data.SetUtentePasswordResponse wrappedElement = new data.SetUtentePasswordResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetIdtokenResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetIdtokenResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetIdtokenResponse wrapgetIdtoken(){
                                data.GetIdtokenResponse wrappedElement = new data.GetIdtokenResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.NuovoUtenteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.NuovoUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.NuovoUtenteResponse wrapnuovoUtente(){
                                data.NuovoUtenteResponse wrappedElement = new data.NuovoUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.SetUtenteNomeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.SetUtenteNomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.SetUtenteNomeResponse wrapsetUtenteNome(){
                                data.SetUtenteNomeResponse wrappedElement = new data.SetUtenteNomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.InsertLOGResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.InsertLOGResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.InsertLOGResponse wrapinsertLOG(){
                                data.InsertLOGResponse wrappedElement = new data.InsertLOGResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteCognomeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteCognomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteCognomeResponse wrapgetUtenteCognome(){
                                data.GetUtenteCognomeResponse wrappedElement = new data.GetUtenteCognomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.ModificaUtenteResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.ModificaUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.ModificaUtenteResponse wrapmodificaUtente(){
                                data.ModificaUtenteResponse wrappedElement = new data.ModificaUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtentePareggiateResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtentePareggiateResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtentePareggiateResponse wrapgetUtentePareggiate(){
                                data.GetUtentePareggiateResponse wrappedElement = new data.GetUtentePareggiateResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteAdminResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteAdminResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteAdminResponse wrapgetUtenteAdmin(){
                                data.GetUtenteAdminResponse wrappedElement = new data.GetUtenteAdminResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.DeletePartitaResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.DeletePartitaResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.DeletePartitaResponse wrapdeletePartita(){
                                data.DeletePartitaResponse wrappedElement = new data.DeletePartitaResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.CancellaAmiciResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.CancellaAmiciResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.CancellaAmiciResponse wrapcancellaAmici(){
                                data.CancellaAmiciResponse wrappedElement = new data.CancellaAmiciResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, data.GetUtenteEmailResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(data.GetUtenteEmailResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private data.GetUtenteEmailResponse wrapgetUtenteEmail(){
                                data.GetUtenteEmailResponse wrappedElement = new data.GetUtenteEmailResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (data.GetListaAmici.class.equals(type)){
                
                           return data.GetListaAmici.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetListaAmiciResponse.class.equals(type)){
                
                           return data.GetListaAmiciResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtentePerse.class.equals(type)){
                
                           return data.GetUtentePerse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtentePerseResponse.class.equals(type)){
                
                           return data.GetUtentePerseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteNome.class.equals(type)){
                
                           return data.GetUtenteNome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteNomeResponse.class.equals(type)){
                
                           return data.GetUtenteNomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtentePareggiate.class.equals(type)){
                
                           return data.SetUtentePareggiate.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtentePareggiateResponse.class.equals(type)){
                
                           return data.SetUtentePareggiateResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertPartita.class.equals(type)){
                
                           return data.InsertPartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertPartitaResponse.class.equals(type)){
                
                           return data.InsertPartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetListaUtentiOnline.class.equals(type)){
                
                           return data.GetListaUtentiOnline.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetListaUtentiOnlineResponse.class.equals(type)){
                
                           return data.GetListaUtentiOnlineResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.NuovoAmico.class.equals(type)){
                
                           return data.NuovoAmico.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.NuovoAmicoResponse.class.equals(type)){
                
                           return data.NuovoAmicoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertPosizioneIniziale.class.equals(type)){
                
                           return data.InsertPosizioneIniziale.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertPosizioneInizialeResponse.class.equals(type)){
                
                           return data.InsertPosizioneInizialeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertMossa.class.equals(type)){
                
                           return data.InsertMossa.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertMossaResponse.class.equals(type)){
                
                           return data.InsertMossaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteIA.class.equals(type)){
                
                           return data.GetUtenteIA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteIAResponse.class.equals(type)){
                
                           return data.GetUtenteIAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetPartite.class.equals(type)){
                
                           return data.GetPartite.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetPartiteResponse.class.equals(type)){
                
                           return data.GetPartiteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.UpdateTipo.class.equals(type)){
                
                           return data.UpdateTipo.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.UpdateTipoResponse.class.equals(type)){
                
                           return data.UpdateTipoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtente.class.equals(type)){
                
                           return data.GetUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteResponse.class.equals(type)){
                
                           return data.GetUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteVinte.class.equals(type)){
                
                           return data.SetUtenteVinte.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteVinteResponse.class.equals(type)){
                
                           return data.SetUtenteVinteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtentePerse.class.equals(type)){
                
                           return data.SetUtentePerse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtentePerseResponse.class.equals(type)){
                
                           return data.SetUtentePerseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteAdmin.class.equals(type)){
                
                           return data.SetUtenteAdmin.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteAdminResponse.class.equals(type)){
                
                           return data.SetUtenteAdminResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteOnline.class.equals(type)){
                
                           return data.GetUtenteOnline.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteOnlineResponse.class.equals(type)){
                
                           return data.GetUtenteOnlineResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetNomePartita.class.equals(type)){
                
                           return data.GetNomePartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetNomePartitaResponse.class.equals(type)){
                
                           return data.GetNomePartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.UpdatePartita.class.equals(type)){
                
                           return data.UpdatePartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.UpdatePartitaResponse.class.equals(type)){
                
                           return data.UpdatePartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteOnline.class.equals(type)){
                
                           return data.SetUtenteOnline.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteOnlineResponse.class.equals(type)){
                
                           return data.SetUtenteOnlineResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteIA.class.equals(type)){
                
                           return data.SetUtenteIA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteIAResponse.class.equals(type)){
                
                           return data.SetUtenteIAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteEmail.class.equals(type)){
                
                           return data.SetUtenteEmail.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteEmailResponse.class.equals(type)){
                
                           return data.SetUtenteEmailResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetMosse.class.equals(type)){
                
                           return data.GetMosse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetMosseResponse.class.equals(type)){
                
                           return data.GetMosseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetPosizioniIniziali.class.equals(type)){
                
                           return data.GetPosizioniIniziali.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetPosizioniInizialiResponse.class.equals(type)){
                
                           return data.GetPosizioniInizialiResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.IsUtenteIniziale.class.equals(type)){
                
                           return data.IsUtenteIniziale.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.IsUtenteInizialeResponse.class.equals(type)){
                
                           return data.IsUtenteInizialeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.CancellaUtente.class.equals(type)){
                
                           return data.CancellaUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.CancellaUtenteResponse.class.equals(type)){
                
                           return data.CancellaUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteCognome.class.equals(type)){
                
                           return data.SetUtenteCognome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteCognomeResponse.class.equals(type)){
                
                           return data.SetUtenteCognomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.CancellaAmico.class.equals(type)){
                
                           return data.CancellaAmico.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.CancellaAmicoResponse.class.equals(type)){
                
                           return data.CancellaAmicoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteVinte.class.equals(type)){
                
                           return data.GetUtenteVinte.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteVinteResponse.class.equals(type)){
                
                           return data.GetUtenteVinteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtentePassword.class.equals(type)){
                
                           return data.SetUtentePassword.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtentePasswordResponse.class.equals(type)){
                
                           return data.SetUtentePasswordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetIdtoken.class.equals(type)){
                
                           return data.GetIdtoken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetIdtokenResponse.class.equals(type)){
                
                           return data.GetIdtokenResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.NuovoUtente.class.equals(type)){
                
                           return data.NuovoUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.NuovoUtenteResponse.class.equals(type)){
                
                           return data.NuovoUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteNome.class.equals(type)){
                
                           return data.SetUtenteNome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.SetUtenteNomeResponse.class.equals(type)){
                
                           return data.SetUtenteNomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertLOG.class.equals(type)){
                
                           return data.InsertLOG.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.InsertLOGResponse.class.equals(type)){
                
                           return data.InsertLOGResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteCognome.class.equals(type)){
                
                           return data.GetUtenteCognome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteCognomeResponse.class.equals(type)){
                
                           return data.GetUtenteCognomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.ModificaUtente.class.equals(type)){
                
                           return data.ModificaUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.ModificaUtenteResponse.class.equals(type)){
                
                           return data.ModificaUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtentePareggiate.class.equals(type)){
                
                           return data.GetUtentePareggiate.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtentePareggiateResponse.class.equals(type)){
                
                           return data.GetUtentePareggiateResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteAdmin.class.equals(type)){
                
                           return data.GetUtenteAdmin.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteAdminResponse.class.equals(type)){
                
                           return data.GetUtenteAdminResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.DeletePartita.class.equals(type)){
                
                           return data.DeletePartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.DeletePartitaResponse.class.equals(type)){
                
                           return data.DeletePartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.CancellaAmici.class.equals(type)){
                
                           return data.CancellaAmici.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.CancellaAmiciResponse.class.equals(type)){
                
                           return data.CancellaAmiciResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteEmail.class.equals(type)){
                
                           return data.GetUtenteEmail.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (data.GetUtenteEmailResponse.class.equals(type)){
                
                           return data.GetUtenteEmailResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    