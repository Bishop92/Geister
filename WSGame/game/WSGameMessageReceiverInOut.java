
/**
 * WSGameMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package game;

/**
 * WSGameMessageReceiverInOut message receiver
 */

class WSGameMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {


    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            WSGameSkeleton skel = (WSGameSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)) {


                if ("listaMosse".equals(methodName)) {

                    game.ListaMosseResponse listaMosseResponse1 = null;
                    game.ListaMosse wrappedParam =
                            (game.ListaMosse) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.ListaMosse.class
                            );

                    listaMosseResponse1 =


                            skel.listaMosse(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), listaMosseResponse1);
                } else if ("getTurno".equals(methodName)) {

                    game.GetTurnoResponse getTurnoResponse3 = null;
                    game.GetTurno wrappedParam =
                            (game.GetTurno) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.GetTurno.class
                            );

                    getTurnoResponse3 =


                            skel.getTurno(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), getTurnoResponse3);
                } else if ("listaPartite".equals(methodName)) {

                    game.ListaPartiteResponse listaPartiteResponse5 = null;
                    game.ListaPartite wrappedParam =
                            (game.ListaPartite) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.ListaPartite.class
                            );

                    listaPartiteResponse5 =


                            skel.listaPartite(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), listaPartiteResponse5);
                } else if ("cancellaPartita".equals(methodName)) {

                    game.CancellaPartitaResponse cancellaPartitaResponse7 = null;
                    game.CancellaPartita wrappedParam =
                            (game.CancellaPartita) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.CancellaPartita.class
                            );

                    cancellaPartitaResponse7 =


                            skel.cancellaPartita(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), cancellaPartitaResponse7);
                } else if ("listaPosizioniIniziali".equals(methodName)) {

                    game.ListaPosizioniInizialiResponse listaPosizioniInizialiResponse9 = null;
                    game.ListaPosizioniIniziali wrappedParam =
                            (game.ListaPosizioniIniziali) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.ListaPosizioniIniziali.class
                            );

                    listaPosizioniInizialiResponse9 =


                            skel.listaPosizioniIniziali(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), listaPosizioniInizialiResponse9);
                } else if ("getNomePartita".equals(methodName)) {

                    game.GetNomePartitaResponse getNomePartitaResponse11 = null;
                    game.GetNomePartita wrappedParam =
                            (game.GetNomePartita) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.GetNomePartita.class
                            );

                    getNomePartitaResponse11 =


                            skel.getNomePartita(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), getNomePartitaResponse11);
                } else if ("nuovaPartita".equals(methodName)) {

                    game.NuovaPartitaResponse nuovaPartitaResponse13 = null;
                    game.NuovaPartita wrappedParam =
                            (game.NuovaPartita) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.NuovaPartita.class
                            );

                    nuovaPartitaResponse13 =


                            skel.nuovaPartita(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), nuovaPartitaResponse13);
                } else if ("nuovaPosizioneIniziale".equals(methodName)) {

                    game.NuovaPosizioneInizialeResponse nuovaPosizioneInizialeResponse15 = null;
                    game.NuovaPosizioneIniziale wrappedParam =
                            (game.NuovaPosizioneIniziale) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.NuovaPosizioneIniziale.class
                            );

                    nuovaPosizioneInizialeResponse15 =


                            skel.nuovaPosizioneIniziale(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), nuovaPosizioneInizialeResponse15);
                } else if ("generaMossaIA".equals(methodName)) {

                    game.GeneraMossaIAResponse generaMossaIAResponse17 = null;
                    game.GeneraMossaIA wrappedParam =
                            (game.GeneraMossaIA) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.GeneraMossaIA.class
                            );

                    generaMossaIAResponse17 =


                            skel.generaMossaIA(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), generaMossaIAResponse17);
                } else if ("modificaPartita".equals(methodName)) {

                    game.ModificaPartitaResponse modificaPartitaResponse19 = null;
                    game.ModificaPartita wrappedParam =
                            (game.ModificaPartita) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.ModificaPartita.class
                            );

                    modificaPartitaResponse19 =


                            skel.modificaPartita()
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), modificaPartitaResponse19);
                } else if ("modificaTipo".equals(methodName)) {

                    game.ModificaTipoResponse modificaTipoResponse21 = null;
                    game.ModificaTipo wrappedParam =
                            (game.ModificaTipo) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.ModificaTipo.class
                            );

                    modificaTipoResponse21 =


                            skel.modificaTipo(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), modificaTipoResponse21);
                } else if ("eseguiMossa".equals(methodName)) {

                    game.EseguiMossaResponse eseguiMossaResponse23 = null;
                    game.EseguiMossa wrappedParam =
                            (game.EseguiMossa) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    game.EseguiMossa.class
                            );

                    eseguiMossaResponse23 =


                            skel.eseguiMossa(wrappedParam)
                    ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), eseguiMossaResponse23);

                } else {
                    throw new java.lang.RuntimeException("method not found");
                }


                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(ListaMosse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ListaMosse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ListaMosseResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ListaMosseResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(GetTurno param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.GetTurno.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(GetTurnoResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.GetTurnoResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ListaPartite param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ListaPartite.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ListaPartiteResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ListaPartiteResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(CancellaPartita param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.CancellaPartita.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(CancellaPartitaResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.CancellaPartitaResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ListaPosizioniIniziali param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ListaPosizioniIniziali.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ListaPosizioniInizialiResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ListaPosizioniInizialiResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(GetNomePartita param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.GetNomePartita.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(GetNomePartitaResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.GetNomePartitaResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(NuovaPartita param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.NuovaPartita.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(NuovaPartitaResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.NuovaPartitaResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(NuovaPosizioneIniziale param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.NuovaPosizioneIniziale.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(NuovaPosizioneInizialeResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.NuovaPosizioneInizialeResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(GeneraMossaIA param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.GeneraMossaIA.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(GeneraMossaIAResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.GeneraMossaIAResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ModificaPartita param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ModificaPartita.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ModificaPartitaResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ModificaPartitaResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ModificaTipo param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ModificaTipo.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(ModificaTipoResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.ModificaTipoResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(EseguiMossa param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.EseguiMossa.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(EseguiMossaResponse param)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(game.EseguiMossaResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ListaMosseResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.ListaMosseResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.ListaMosseResponse wraplistaMosse() {
        game.ListaMosseResponse wrappedElement = new game.ListaMosseResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GetTurnoResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.GetTurnoResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.GetTurnoResponse wrapgetTurno() {
        game.GetTurnoResponse wrappedElement = new game.GetTurnoResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ListaPartiteResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.ListaPartiteResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.ListaPartiteResponse wraplistaPartite() {
        game.ListaPartiteResponse wrappedElement = new game.ListaPartiteResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, CancellaPartitaResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.CancellaPartitaResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.CancellaPartitaResponse wrapcancellaPartita() {
        game.CancellaPartitaResponse wrappedElement = new game.CancellaPartitaResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ListaPosizioniInizialiResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.ListaPosizioniInizialiResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.ListaPosizioniInizialiResponse wraplistaPosizioniIniziali() {
        game.ListaPosizioniInizialiResponse wrappedElement = new game.ListaPosizioniInizialiResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GetNomePartitaResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.GetNomePartitaResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.GetNomePartitaResponse wrapgetNomePartita() {
        game.GetNomePartitaResponse wrappedElement = new game.GetNomePartitaResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, NuovaPartitaResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.NuovaPartitaResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.NuovaPartitaResponse wrapnuovaPartita() {
        game.NuovaPartitaResponse wrappedElement = new game.NuovaPartitaResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, NuovaPosizioneInizialeResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.NuovaPosizioneInizialeResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.NuovaPosizioneInizialeResponse wrapnuovaPosizioneIniziale() {
        game.NuovaPosizioneInizialeResponse wrappedElement = new game.NuovaPosizioneInizialeResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GeneraMossaIAResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.GeneraMossaIAResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.GeneraMossaIAResponse wrapgeneraMossaIA() {
        game.GeneraMossaIAResponse wrappedElement = new game.GeneraMossaIAResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ModificaPartitaResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.ModificaPartitaResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.ModificaPartitaResponse wrapmodificaPartita() {
        game.ModificaPartitaResponse wrappedElement = new game.ModificaPartitaResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ModificaTipoResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.ModificaTipoResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.ModificaTipoResponse wrapmodificaTipo() {
        game.ModificaTipoResponse wrappedElement = new game.ModificaTipoResponse();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, EseguiMossaResponse param)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(game.EseguiMossaResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private game.EseguiMossaResponse wrapeseguiMossa() {
        game.EseguiMossaResponse wrappedElement = new game.EseguiMossaResponse();
        return wrappedElement;
    }


    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }


    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            Class type) throws org.apache.axis2.AxisFault {

        try {

            if (game.ListaMosse.class.equals(type)) {

                return game.ListaMosse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ListaMosseResponse.class.equals(type)) {

                return game.ListaMosseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.GetTurno.class.equals(type)) {

                return game.GetTurno.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.GetTurnoResponse.class.equals(type)) {

                return game.GetTurnoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ListaPartite.class.equals(type)) {

                return game.ListaPartite.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ListaPartiteResponse.class.equals(type)) {

                return game.ListaPartiteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.CancellaPartita.class.equals(type)) {

                return game.CancellaPartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.CancellaPartitaResponse.class.equals(type)) {

                return game.CancellaPartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ListaPosizioniIniziali.class.equals(type)) {

                return game.ListaPosizioniIniziali.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ListaPosizioniInizialiResponse.class.equals(type)) {

                return game.ListaPosizioniInizialiResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.GetNomePartita.class.equals(type)) {

                return game.GetNomePartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.GetNomePartitaResponse.class.equals(type)) {

                return game.GetNomePartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.NuovaPartita.class.equals(type)) {

                return game.NuovaPartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.NuovaPartitaResponse.class.equals(type)) {

                return game.NuovaPartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.NuovaPosizioneIniziale.class.equals(type)) {

                return game.NuovaPosizioneIniziale.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.NuovaPosizioneInizialeResponse.class.equals(type)) {

                return game.NuovaPosizioneInizialeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.GeneraMossaIA.class.equals(type)) {

                return game.GeneraMossaIA.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.GeneraMossaIAResponse.class.equals(type)) {

                return game.GeneraMossaIAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ModificaPartita.class.equals(type)) {

                return game.ModificaPartita.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ModificaPartitaResponse.class.equals(type)) {

                return game.ModificaPartitaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ModificaTipo.class.equals(type)) {

                return game.ModificaTipo.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.ModificaTipoResponse.class.equals(type)) {

                return game.ModificaTipoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.EseguiMossa.class.equals(type)) {

                return game.EseguiMossa.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (game.EseguiMossaResponse.class.equals(type)) {

                return game.EseguiMossaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }


    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
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
    