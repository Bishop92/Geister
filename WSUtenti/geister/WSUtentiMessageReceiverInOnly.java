

/**
 * WSUtentiMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package geister;

import java.util.HashMap;

/**
        *  WSUtentiMessageReceiverInOnly message receiver
        */

        class WSUtentiMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractInMessageReceiver{

        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext inMessage) throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(inMessage);

        WSUtentiSkeleton skel = (WSUtentiSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = inMessage.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        
            if("setCognome".equals(methodName)){
            
            geister.SetCognome wrappedParam = (geister.SetCognome)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        geister.SetCognome.class
            );
                                            
                                                     skel.setCognome(wrappedParam);
                                                } else 
            if("setEmail".equals(methodName)){
            
            geister.SetEmail wrappedParam = (geister.SetEmail)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        geister.SetEmail.class
            );
                                            
                                                     skel.setEmail(wrappedParam);
                                                } else 
            if("setNome".equals(methodName)){
            
            geister.SetNome wrappedParam = (geister.SetNome)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        geister.SetNome.class
            );
                                            
                                                     skel.setNome(wrappedParam);
                                                
                } else {
                  throw new java.lang.RuntimeException("method not found");
                }
            

        }
        } catch (java.lang.Exception e) {
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
        
            private  org.apache.axiom.om.OMElement  toOM(SetNome param)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(geister.SetNome.MY_QNAME,
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
           
                if (geister.CancellaAmico.class.equals(type)){
                
                           return geister.CancellaAmico.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (geister.CancellaAmicoResponse.class.equals(type)){
                
                           return geister.CancellaAmicoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (geister.SetNome.class.equals(type)){
                
                           return geister.SetNome.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
        java.util.Map returnMap = new TraspositionTable();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }



        }//end of class

    