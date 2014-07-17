
/**
 * NuovaPartita.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */


package game;


/**
 * NuovaPartita bean class
 */
@SuppressWarnings({"unchecked", "unused"})

public class NuovaPartita
        implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
            "http://game",
            "nuovaPartita",
            "ns2");


    /**
     * field for Idtoken
     */


    protected java.lang.String localIdtoken;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localIdtokenTracker = false;

    public boolean isIdtokenSpecified() {
        return localIdtokenTracker;
    }


    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getIdtoken() {
        return localIdtoken;
    }


    /**
     * Auto generated setter method
     *
     * @param param Idtoken
     */
    public void setIdtoken(java.lang.String param) {
        localIdtokenTracker = true;

        this.localIdtoken = param;


    }


    /**
     * field for NomePartita
     */


    protected java.lang.String localNomePartita;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localNomePartitaTracker = false;

    public boolean isNomePartitaSpecified() {
        return localNomePartitaTracker;
    }


    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getNomePartita() {
        return localNomePartita;
    }


    /**
     * Auto generated setter method
     *
     * @param param NomePartita
     */
    public void setNomePartita(java.lang.String param) {
        localNomePartitaTracker = true;

        this.localNomePartita = param;


    }


    /**
     * field for GiocatoreInizio
     */


    protected byte localGiocatoreInizio;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localGiocatoreInizioTracker = false;

    public boolean isGiocatoreInizioSpecified() {
        return localGiocatoreInizioTracker;
    }


    /**
     * Auto generated getter method
     *
     * @return byte
     */
    public byte getGiocatoreInizio() {
        return localGiocatoreInizio;
    }


    /**
     * Auto generated setter method
     *
     * @param param GiocatoreInizio
     */
    public void setGiocatoreInizio(byte param) {
        localGiocatoreInizioTracker = true;

        this.localGiocatoreInizio = param;


    }


    /**
     * field for Username
     */


    protected java.lang.String localUsername;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localUsernameTracker = false;

    public boolean isUsernameSpecified() {
        return localUsernameTracker;
    }


    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getUsername() {
        return localUsername;
    }


    /**
     * Auto generated setter method
     *
     * @param param Username
     */
    public void setUsername(java.lang.String param) {
        localUsernameTracker = true;

        this.localUsername = param;


    }


    /**
     * field for Username_sfidato
     */


    protected java.lang.String localUsername_sfidato;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localUsername_sfidatoTracker = false;

    public boolean isUsername_sfidatoSpecified() {
        return localUsername_sfidatoTracker;
    }


    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getUsername_sfidato() {
        return localUsername_sfidato;
    }


    /**
     * Auto generated setter method
     *
     * @param param Username_sfidato
     */
    public void setUsername_sfidato(java.lang.String param) {
        localUsername_sfidatoTracker = true;

        this.localUsername_sfidato = param;


    }


    /**
     * field for Livello1
     */


    protected double localLivello1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localLivello1Tracker = false;

    public boolean isLivello1Specified() {
        return localLivello1Tracker;
    }


    /**
     * Auto generated getter method
     *
     * @return double
     */
    public double getLivello1() {
        return localLivello1;
    }


    /**
     * Auto generated setter method
     *
     * @param param Livello1
     */
    public void setLivello1(double param) {

        // setting primitive attribute tracker to true
        localLivello1Tracker =
                !java.lang.Double.isNaN(param);

        this.localLivello1 = param;


    }


    /**
     * field for Livello2
     */


    protected double localLivello2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localLivello2Tracker = false;

    public boolean isLivello2Specified() {
        return localLivello2Tracker;
    }


    /**
     * Auto generated getter method
     *
     * @return double
     */
    public double getLivello2() {
        return localLivello2;
    }


    /**
     * Auto generated setter method
     *
     * @param param Livello2
     */
    public void setLivello2(double param) {

        // setting primitive attribute tracker to true
        localLivello2Tracker =
                !java.lang.Double.isNaN(param);

        this.localLivello2 = param;


    }


    /**
     * field for Allenamento1
     */


    protected boolean localAllenamento1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localAllenamento1Tracker = false;

    public boolean isAllenamento1Specified() {
        return localAllenamento1Tracker;
    }


    /**
     * Auto generated getter method
     *
     * @return boolean
     */
    public boolean getAllenamento1() {
        return localAllenamento1;
    }


    /**
     * Auto generated setter method
     *
     * @param param Allenamento1
     */
    public void setAllenamento1(boolean param) {

        // setting primitive attribute tracker to true
        localAllenamento1Tracker =
                true;

        this.localAllenamento1 = param;


    }


    /**
     * field for Allenamento2
     */


    protected boolean localAllenamento2;

    /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean localAllenamento2Tracker = false;

    public boolean isAllenamento2Specified() {
        return localAllenamento2Tracker;
    }


    /**
     * Auto generated getter method
     *
     * @return boolean
     */
    public boolean getAllenamento2() {
        return localAllenamento2;
    }


    /**
     * Auto generated setter method
     *
     * @param param Allenamento2
     */
    public void setAllenamento2(boolean param) {

        // setting primitive attribute tracker to true
        localAllenamento2Tracker =
                true;

        this.localAllenamento2 = param;


    }


    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


        org.apache.axiom.om.OMDataSource dataSource =
                new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
        return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
                          javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
                          javax.xml.stream.XMLStreamWriter xmlWriter,
                          boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


        java.lang.String prefix = null;
        java.lang.String namespace = null;


        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

        if (serializeType) {


            java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://game");
            if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":nuovaPartita",
                        xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "nuovaPartita",
                        xmlWriter);
            }


        }
        if (localIdtokenTracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "idtoken", xmlWriter);


            if (localIdtoken == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localIdtoken);

            }

            xmlWriter.writeEndElement();
        }
        if (localNomePartitaTracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "nomePartita", xmlWriter);


            if (localNomePartita == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localNomePartita);

            }

            xmlWriter.writeEndElement();
        }
        if (localGiocatoreInizioTracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "giocatoreInizio", xmlWriter);

            if (localGiocatoreInizio == java.lang.Byte.MIN_VALUE) {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGiocatoreInizio));
            }

            xmlWriter.writeEndElement();
        }
        if (localUsernameTracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "username", xmlWriter);


            if (localUsername == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localUsername);

            }

            xmlWriter.writeEndElement();
        }
        if (localUsername_sfidatoTracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "username_sfidato", xmlWriter);


            if (localUsername_sfidato == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localUsername_sfidato);

            }

            xmlWriter.writeEndElement();
        }
        if (localLivello1Tracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "livello1", xmlWriter);

            if (java.lang.Double.isNaN(localLivello1)) {

                throw new org.apache.axis2.databinding.ADBException("livello1 cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLivello1));
            }

            xmlWriter.writeEndElement();
        }
        if (localLivello2Tracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "livello2", xmlWriter);

            if (java.lang.Double.isNaN(localLivello2)) {

                throw new org.apache.axis2.databinding.ADBException("livello2 cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLivello2));
            }

            xmlWriter.writeEndElement();
        }
        if (localAllenamento1Tracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "allenamento1", xmlWriter);

            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAllenamento1));

            xmlWriter.writeEndElement();
        }
        if (localAllenamento2Tracker) {
            namespace = "http://game";
            writeStartElement(null, namespace, "allenamento2", xmlWriter);

            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAllenamento2));

            xmlWriter.writeEndElement();
        }
        xmlWriter.writeEndElement();


    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://game")) {
            return "ns2";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                   javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
        if (writerPrefix != null) {
            xmlWriter.writeStartElement(namespace, localPart);
        } else {
            if (namespace.length() == 0) {
                prefix = "";
            } else if (prefix == null) {
                prefix = generatePrefix(namespace);
            }

            xmlWriter.writeStartElement(prefix, localPart, namespace);
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }


    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                     javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }
        java.lang.String attributeValue;
        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
                            javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
                             javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            StringBuilder stringToWrite = new StringBuilder();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                }
            }
            xmlWriter.writeCharacters(stringToWrite.toString());
        }

    }


    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);
        if (prefix == null) {
            prefix = generatePrefix(namespace);
            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
            while (true) {
                java.lang.String uri = nsContext.getNamespaceURI(prefix);
                if (uri == null || uri.length() == 0) {
                    break;
                }
                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        return prefix;
    }


    /**
     * databinding method to get an XML representation of this object
     */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {


        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        if (localIdtokenTracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "idtoken"));

            elementList.add(localIdtoken == null ? null :
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdtoken));
        }
        if (localNomePartitaTracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "nomePartita"));

            elementList.add(localNomePartita == null ? null :
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNomePartita));
        }
        if (localGiocatoreInizioTracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "giocatoreInizio"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGiocatoreInizio));
        }
        if (localUsernameTracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "username"));

            elementList.add(localUsername == null ? null :
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUsername));
        }
        if (localUsername_sfidatoTracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "username_sfidato"));

            elementList.add(localUsername_sfidato == null ? null :
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUsername_sfidato));
        }
        if (localLivello1Tracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "livello1"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLivello1));
        }
        if (localLivello2Tracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "livello2"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLivello2));
        }
        if (localAllenamento1Tracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "allenamento1"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAllenamento1));
        }
        if (localAllenamento2Tracker) {
            elementList.add(new javax.xml.namespace.QName("http://game",
                    "allenamento2"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAllenamento2));
        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


    }


    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {


        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         * If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static NuovaPartita parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            NuovaPartita object =
                    new NuovaPartita();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");
                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;
                        if (fullTypeName.contains(":")) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                        if (!"nuovaPartita".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (NuovaPartita) game.ExtensionMapper.getTypeObject(
                                    nsUri, type, reader);
                        }


                    }


                }


                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();


                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "idtoken").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setIdtoken(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "nomePartita").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setNomePartita(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }
                (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "giocatoreInizio").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setGiocatoreInizio(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte(content));

                    } else {


                        object.setGiocatoreInizio(java.lang.Byte.MIN_VALUE);

                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setGiocatoreInizio(java.lang.Byte.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "username").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setUsername(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while&&!reader.isEndElement())reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "username_sfidato").equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

                        java.lang.String content = reader.getElementText();

                        object.setUsername_sfidato(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement()))reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "livello1").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setLivello1(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setLivello1(java.lang.Double.NaN);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "livello2").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setLivello2(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setLivello2(java.lang.Double.NaN);

                }


                while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "allenamento1").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setAllenamento1(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement(
                if (reader.isStartElement() && new javax.xml.namespace.QName("http://game", "allenamento2").equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setAllenamento2(
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement())
                    // A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }//end of factory class


}
           
    