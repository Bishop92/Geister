
/**
 * WSUtentiMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package geister;

import java.util.HashMap;

/**
        *  WSUtentiMessageReceiverInOut message receiver
        */

        class WSUtentiMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        WSUtentiSkeleton skel = (WSUtentiSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("getNome".equals(methodName)){
                
                geister.GetNomeResponse getNomeResponse1 = null;
	                        geister.GetNome wrappedParam =
                                                             (geister.GetNome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.GetNome.class
                                                             );
                                                
                                               getNomeResponse1 =
                                                   
                                                   
                                                         skel.getNome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getNomeResponse1);
                                    } else 

            if("nuovoUtente".equals(methodName)){
                
                geister.NuovoUtenteResponse nuovoUtenteResponse3 = null;
	                        geister.NuovoUtente wrappedParam =
                                                             (geister.NuovoUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.NuovoUtente.class
                                                             );
                                                
                                               nuovoUtenteResponse3 =
                                                   
                                                   
                                                         skel.nuovoUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), nuovoUtenteResponse3);
                                    } else 

            if("getCognome".equals(methodName)){
                
                geister.GetCognomeResponse getCognomeResponse5 = null;
	                        geister.GetCognome wrappedParam =
                                                             (geister.GetCognome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.GetCognome.class
                                                             );
                                                
                                               getCognomeResponse5 =
                                                   
                                                   
                                                         skel.getCognome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getCognomeResponse5);
                                    } else 

            if("getEmail".equals(methodName)){
                
                geister.GetEmailResponse getEmailResponse7 = null;
	                        geister.GetEmail wrappedParam =
                                                             (geister.GetEmail)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.GetEmail.class
                                                             );
                                                
                                               getEmailResponse7 =
                                                   
                                                   
                                                         skel.getEmail(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getEmailResponse7);
                                    } else 

            if("setCognome".equals(methodName)){
                
                geister.SetCognomeResponse setCognomeResponse9 = null;
	                        geister.SetCognome wrappedParam =
                                                             (geister.SetCognome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetCognome.class
                                                             );
                                                
                                               setCognomeResponse9 =
                                                   
                                                   
                                                         skel.setCognome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setCognomeResponse9);
                                    } else 

            if("login".equals(methodName)){
                
                geister.LoginResponse loginResponse11 = null;
	                        geister.Login wrappedParam =
                                                             (geister.Login)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.Login.class
                                                             );
                                                
                                               loginResponse11 =
                                                   
                                                   
                                                         skel.login(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), loginResponse11);
                                    } else 

            if("setPassword".equals(methodName)){
                
                geister.SetPasswordResponse setPasswordResponse13 = null;
	                        geister.SetPassword wrappedParam =
                                                             (geister.SetPassword)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetPassword.class
                                                             );
                                                
                                               setPasswordResponse13 =
                                                   
                                                   
                                                         skel.setPassword(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setPasswordResponse13);
                                    } else 

            if("cancellaUtente".equals(methodName)){
                
                geister.CancellaUtenteResponse cancellaUtenteResponse15 = null;
	                        geister.CancellaUtente wrappedParam =
                                                             (geister.CancellaUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.CancellaUtente.class
                                                             );
                                                
                                               cancellaUtenteResponse15 =
                                                   
                                                   
                                                         skel.cancellaUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancellaUtenteResponse15);
                                    } else 

            if("isPlaying".equals(methodName)){
                
                geister.IsPlayingResponse isPlayingResponse17 = null;
	                        geister.IsPlaying wrappedParam =
                                                             (geister.IsPlaying)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.IsPlaying.class
                                                             );
                                                
                                               isPlayingResponse17 =
                                                   
                                                   
                                                         skel.isPlaying(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), isPlayingResponse17);
                                    } else 

            if("setIA".equals(methodName)){
                
                geister.SetIAResponse setIAResponse19 = null;
	                        geister.SetIA wrappedParam =
                                                             (geister.SetIA)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetIA.class
                                                             );
                                                
                                               setIAResponse19 =
                                                   
                                                   
                                                         skel.setIA(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setIAResponse19);
                                    } else 

            if("cancellaAmico".equals(methodName)){
                
                geister.CancellaAmicoResponse cancellaAmicoResponse21 = null;
	                        geister.CancellaAmico wrappedParam =
                                                             (geister.CancellaAmico)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.CancellaAmico.class
                                                             );
                                                
                                               cancellaAmicoResponse21 =
                                                   
                                                   
                                                         skel.cancellaAmico(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancellaAmicoResponse21);
                                    } else 

            if("modificaUtente".equals(methodName)){
                
                geister.ModificaUtenteResponse modificaUtenteResponse23 = null;
	                        geister.ModificaUtente wrappedParam =
                                                             (geister.ModificaUtente)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.ModificaUtente.class
                                                             );
                                                
                                               modificaUtenteResponse23 =
                                                   
                                                   
                                                         skel.modificaUtente(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), modificaUtenteResponse23);
                                    } else 

            if("cancellaAmici".equals(methodName)){
                
                geister.CancellaAmiciResponse cancellaAmiciResponse25 = null;
	                        geister.CancellaAmici wrappedParam =
                                                             (geister.CancellaAmici)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.CancellaAmici.class
                                                             );
                                                
                                               cancellaAmiciResponse25 =
                                                   
                                                   
                                                         skel.cancellaAmici(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancellaAmiciResponse25);
                                    } else 

            if("getListaAmici".equals(methodName)){
                
                geister.GetListaAmiciResponse getListaAmiciResponse27 = null;
	                        geister.GetListaAmici wrappedParam =
                                                             (geister.GetListaAmici)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.GetListaAmici.class
                                                             );
                                                
                                               getListaAmiciResponse27 =
                                                   
                                                   
                                                         skel.getListaAmici(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getListaAmiciResponse27);
                                    } else 

            if("nuovoAmico".equals(methodName)){
                
                geister.NuovoAmicoResponse nuovoAmicoResponse29 = null;
	                        geister.NuovoAmico wrappedParam =
                                                             (geister.NuovoAmico)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.NuovoAmico.class
                                                             );
                                                
                                               nuovoAmicoResponse29 =
                                                   
                                                   
                                                         skel.nuovoAmico(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), nuovoAmicoResponse29);
                                    } else 

            if("isOnline".equals(methodName)){
                
                geister.IsOnlineResponse isOnlineResponse31 = null;
	                        geister.IsOnline wrappedParam =
                                                             (geister.IsOnline)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.IsOnline.class
                                                             );
                                                
                                               isOnlineResponse31 =
                                                   
                                                   
                                                         skel.isOnline(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), isOnlineResponse31);
                                    } else 

            if("setPlaying".equals(methodName)){
                
                geister.SetPlayingResponse setPlayingResponse33 = null;
	                        geister.SetPlaying wrappedParam =
                                                             (geister.SetPlaying)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetPlaying.class
                                                             );
                                                
                                               setPlayingResponse33 =
                                                   
                                                   
                                                         skel.setPlaying(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setPlayingResponse33);
                                    } else 

            if("setOnline".equals(methodName)){
                
                geister.SetOnlineResponse setOnlineResponse35 = null;
	                        geister.SetOnline wrappedParam =
                                                             (geister.SetOnline)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetOnline.class
                                                             );
                                                
                                               setOnlineResponse35 =
                                                   
                                                   
                                                         skel.setOnline(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setOnlineResponse35);
                                    } else 

            if("isAmico".equals(methodName)){
                
                geister.IsAmicoResponse isAmicoResponse37 = null;
	                        geister.IsAmico wrappedParam =
                                                             (geister.IsAmico)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.IsAmico.class
                                                             );
                                                
                                               isAmicoResponse37 =
                                                   
                                                   
                                                         skel.isAmico(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), isAmicoResponse37);
                                    } else 

            if("isIA".equals(methodName)){
                
                geister.IsIAResponse isIAResponse39 = null;
	                        geister.IsIA wrappedParam =
                                                             (geister.IsIA)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.IsIA.class
                                                             );
                                                
                                               isIAResponse39 =
                                                   
                                                   
                                                         skel.isIA(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), isIAResponse39);
                                    } else 

            if("setEmail".equals(methodName)){
                
                geister.SetEmailResponse setEmailResponse41 = null;
	                        geister.SetEmail wrappedParam =
                                                             (geister.SetEmail)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetEmail.class
                                                             );
                                                
                                               setEmailResponse41 =
                                                   
                                                   
                                                         skel.setEmail(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setEmailResponse41);
                                    } else 

            if("setNome".equals(methodName)){
                
                geister.SetNomeResponse setNomeResponse43 = null;
	                        geister.SetNome wrappedParam =
                                                             (geister.SetNome)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    geister.SetNome.class
                                                             );
                                                
                                               setNomeResponse43 =
                                                   
                                                   
                                                         skel.setNome(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), setNomeResponse43);
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(GetNome param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetNome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetNomeResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetNomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(NuovoUtente param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.NuovoUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(NuovoUtenteResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.NuovoUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetCognome param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetCognome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetCognomeResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetCognomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetEmail param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetEmail.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetEmailResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetEmailResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetCognome param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetCognome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetCognomeResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetCognomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(Login param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.Login.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(LoginResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.LoginResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetPassword param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetPassword.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetPasswordResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetPasswordResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(CancellaUtente param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.CancellaUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(CancellaUtenteResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.CancellaUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsPlaying param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsPlaying.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsPlayingResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsPlayingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetIA param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetIA.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetIAResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetIAResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(CancellaAmico param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.CancellaAmico.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(CancellaAmicoResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.CancellaAmicoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(ModificaUtente param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.ModificaUtente.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(ModificaUtenteResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.ModificaUtenteResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(CancellaAmici param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.CancellaAmici.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(CancellaAmiciResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.CancellaAmiciResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetListaAmici param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetListaAmici.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(GetListaAmiciResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.GetListaAmiciResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(NuovoAmico param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.NuovoAmico.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(NuovoAmicoResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.NuovoAmicoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsOnline param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsOnline.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsOnlineResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsOnlineResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetPlaying param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetPlaying.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetPlayingResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetPlayingResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetOnline param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetOnline.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetOnlineResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetOnlineResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsAmico param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsAmico.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsAmicoResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsAmicoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsIA param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsIA.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(IsIAResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.IsIAResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetEmail param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetEmail.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetEmailResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetEmailResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetNome param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetNome.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(SetNomeResponse param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetNomeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GetNomeResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.GetNomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.GetNomeResponse wrapgetNome(){
                                geister.GetNomeResponse wrappedElement = new geister.GetNomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, NuovoUtenteResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.NuovoUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.NuovoUtenteResponse wrapnuovoUtente(){
                                geister.NuovoUtenteResponse wrappedElement = new geister.NuovoUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GetCognomeResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.GetCognomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.GetCognomeResponse wrapgetCognome(){
                                geister.GetCognomeResponse wrappedElement = new geister.GetCognomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GetEmailResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.GetEmailResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.GetEmailResponse wrapgetEmail(){
                                geister.GetEmailResponse wrappedElement = new geister.GetEmailResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetCognomeResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetCognomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetCognomeResponse wrapsetCognome(){
                                geister.SetCognomeResponse wrappedElement = new geister.SetCognomeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, LoginResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.LoginResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.LoginResponse wraplogin(){
                                geister.LoginResponse wrappedElement = new geister.LoginResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetPasswordResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetPasswordResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetPasswordResponse wrapsetPassword(){
                                geister.SetPasswordResponse wrappedElement = new geister.SetPasswordResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, CancellaUtenteResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.CancellaUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.CancellaUtenteResponse wrapcancellaUtente(){
                                geister.CancellaUtenteResponse wrappedElement = new geister.CancellaUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, IsPlayingResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.IsPlayingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.IsPlayingResponse wrapisPlaying(){
                                geister.IsPlayingResponse wrappedElement = new geister.IsPlayingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetIAResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetIAResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetIAResponse wrapsetIA(){
                                geister.SetIAResponse wrappedElement = new geister.SetIAResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, CancellaAmicoResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.CancellaAmicoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.CancellaAmicoResponse wrapcancellaAmico(){
                                geister.CancellaAmicoResponse wrappedElement = new geister.CancellaAmicoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, ModificaUtenteResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.ModificaUtenteResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.ModificaUtenteResponse wrapmodificaUtente(){
                                geister.ModificaUtenteResponse wrappedElement = new geister.ModificaUtenteResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, CancellaAmiciResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.CancellaAmiciResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.CancellaAmiciResponse wrapcancellaAmici(){
                                geister.CancellaAmiciResponse wrappedElement = new geister.CancellaAmiciResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, GetListaAmiciResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.GetListaAmiciResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.GetListaAmiciResponse wrapgetListaAmici(){
                                geister.GetListaAmiciResponse wrappedElement = new geister.GetListaAmiciResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, NuovoAmicoResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.NuovoAmicoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.NuovoAmicoResponse wrapnuovoAmico(){
                                geister.NuovoAmicoResponse wrappedElement = new geister.NuovoAmicoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, IsOnlineResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.IsOnlineResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.IsOnlineResponse wrapisOnline(){
                                geister.IsOnlineResponse wrappedElement = new geister.IsOnlineResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetPlayingResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetPlayingResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetPlayingResponse wrapsetPlaying(){
                                geister.SetPlayingResponse wrappedElement = new geister.SetPlayingResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetOnlineResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetOnlineResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetOnlineResponse wrapsetOnline(){
                                geister.SetOnlineResponse wrappedElement = new geister.SetOnlineResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, IsAmicoResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.IsAmicoResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.IsAmicoResponse wrapisAmico(){
                                geister.IsAmicoResponse wrappedElement = new geister.IsAmicoResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, IsIAResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.IsIAResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.IsIAResponse wrapisIA(){
                                geister.IsIAResponse wrappedElement = new geister.IsIAResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetEmailResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetEmailResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetEmailResponse wrapsetEmail(){
                                geister.SetEmailResponse wrappedElement = new geister.SetEmailResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, SetNomeResponse param)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(geister.SetNomeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private geister.SetNomeResponse wrapsetNome(){
                                geister.SetNomeResponse wrappedElement = new geister.SetNomeResponse();
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
                Class type) throws org.apache.axis2.AxisFault{

        try {
        
                if (geister.GetNome.class.equals(type)){
                
                           return geister.GetNome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetNomeResponse.class.equals(type)){
                
                           return geister.GetNomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.NuovoUtente.class.equals(type)){
                
                           return geister.NuovoUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.NuovoUtenteResponse.class.equals(type)){
                
                           return geister.NuovoUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetCognome.class.equals(type)){
                
                           return geister.GetCognome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetCognomeResponse.class.equals(type)){
                
                           return geister.GetCognomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetEmail.class.equals(type)){
                
                           return geister.GetEmail.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetEmailResponse.class.equals(type)){
                
                           return geister.GetEmailResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetCognome.class.equals(type)){
                
                           return geister.SetCognome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetCognomeResponse.class.equals(type)){
                
                           return geister.SetCognomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.Login.class.equals(type)){
                
                           return geister.Login.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.LoginResponse.class.equals(type)){
                
                           return geister.LoginResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetPassword.class.equals(type)){
                
                           return geister.SetPassword.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetPasswordResponse.class.equals(type)){
                
                           return geister.SetPasswordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaUtente.class.equals(type)){
                
                           return geister.CancellaUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaUtenteResponse.class.equals(type)){
                
                           return geister.CancellaUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsPlaying.class.equals(type)){
                
                           return geister.IsPlaying.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsPlayingResponse.class.equals(type)){
                
                           return geister.IsPlayingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetIA.class.equals(type)){
                
                           return geister.SetIA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetIAResponse.class.equals(type)){
                
                           return geister.SetIAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaAmico.class.equals(type)){
                
                           return geister.CancellaAmico.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaAmicoResponse.class.equals(type)){
                
                           return geister.CancellaAmicoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.ModificaUtente.class.equals(type)){
                
                           return geister.ModificaUtente.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.ModificaUtenteResponse.class.equals(type)){
                
                           return geister.ModificaUtenteResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaAmici.class.equals(type)){
                
                           return geister.CancellaAmici.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaAmiciResponse.class.equals(type)){
                
                           return geister.CancellaAmiciResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetListaAmici.class.equals(type)){
                
                           return geister.GetListaAmici.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.GetListaAmiciResponse.class.equals(type)){
                
                           return geister.GetListaAmiciResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.NuovoAmico.class.equals(type)){
                
                           return geister.NuovoAmico.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.NuovoAmicoResponse.class.equals(type)){
                
                           return geister.NuovoAmicoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsOnline.class.equals(type)){
                
                           return geister.IsOnline.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsOnlineResponse.class.equals(type)){
                
                           return geister.IsOnlineResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetPlaying.class.equals(type)){
                
                           return geister.SetPlaying.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetPlayingResponse.class.equals(type)){
                
                           return geister.SetPlayingResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetOnline.class.equals(type)){
                
                           return geister.SetOnline.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetOnlineResponse.class.equals(type)){
                
                           return geister.SetOnlineResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsAmico.class.equals(type)){
                
                           return geister.IsAmico.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsAmicoResponse.class.equals(type)){
                
                           return geister.IsAmicoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsIA.class.equals(type)){
                
                           return geister.IsIA.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.IsIAResponse.class.equals(type)){
                
                           return geister.IsIAResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetEmail.class.equals(type)){
                
                           return geister.SetEmail.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetEmailResponse.class.equals(type)){
                
                           return geister.SetEmailResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetNome.class.equals(type)){
                
                           return geister.SetNome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.SetNomeResponse.class.equals(type)){
                
                           return geister.SetNomeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
        java.util.Map returnMap = new HashMap();
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
    