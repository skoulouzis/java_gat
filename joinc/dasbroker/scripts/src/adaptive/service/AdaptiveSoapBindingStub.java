/**
 * AdaptiveSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package adaptive.service;

public class AdaptiveSoapBindingStub extends org.apache.axis.client.Stub implements adaptive.service.AdaptiveInterface {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[21];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getServiceDescription");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getServiceDescriptionReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMetric");
        oper.addParameter(new javax.xml.namespace.QName("", "metric"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "parameters"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"));
        oper.setReturnClass(java.util.HashMap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMetricReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateNetworkMetric");
        oper.addParameter(new javax.xml.namespace.QName("", "srcHostName"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "destHostName"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "metric"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "operation"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_DoubleMeasurement"));
        oper.setReturnClass(adaptive.beans.DoubleMeasurement[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateNetworkMetricReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateNetworkMetricMatrix");
        oper.addParameter(new javax.xml.namespace.QName("", "hostNames"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "metric"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "operation"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOfArrayOfArrayOf_tns2_DoubleMeasurement"));
        oper.setReturnClass(adaptive.beans.DoubleMeasurement[][][].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateNetworkMetricMatrixReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("rankResources");
        oper.addParameter(new javax.xml.namespace.QName("", "resources"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_ResourceInfo"), adaptive.beans.ResourceInfo[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "app"), new javax.xml.namespace.QName("http://beans.adaptive", "ApplicationInfo"), adaptive.beans.ApplicationInfo.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_ResourceInfo"));
        oper.setReturnClass(adaptive.beans.ResourceInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "rankResourcesReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateTcpOptions");
        oper.addParameter(new javax.xml.namespace.QName("", "src"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dest"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "transferMethod"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "maxTcpStreams"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.adaptive", "TcpOptions"));
        oper.setReturnClass(adaptive.beans.TcpOptions.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateTcpOptionsReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateTransferTimeOneToMany");
        oper.addParameter(new javax.xml.namespace.QName("", "substractLoggedTraffic"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "sourceResource"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "destinationResources"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "transferMethod"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_double"));
        oper.setReturnClass(double[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateTransferTimeOneToManyReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReplicaTransferTime");
        oper.addParameter(new javax.xml.namespace.QName("", "substractLoggedTraffic"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "sourceURIs"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "destinationURI"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_double"));
        oper.setReturnClass(double[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getReplicaTransferTimeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateTransferTimeManyToOne");
        oper.addParameter(new javax.xml.namespace.QName("", "substractLoggedTraffic"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "sourceResources"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "destinationResource"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "transferMethod"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_double"));
        oper.setReturnClass(double[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateTransferTimeManyToOneReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateTransferTime");
        oper.addParameter(new javax.xml.namespace.QName("", "substractLoggedTraffic"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "src"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dest"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "transferMethod"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateTransferTimeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[9] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateTransferTimeManyToMany");
        oper.addParameter(new javax.xml.namespace.QName("", "substractLoggedTraffic"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "sourceResources"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "destinationResources"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "transferMethod"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOfArrayOf_xsd_double"));
        oper.setReturnClass(double[][].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateTransferTimeManyToManyReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logDataTransfer");
        oper.addParameter(new javax.xml.namespace.QName("", "source"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "destination"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "dataSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "transferMethod"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "options"), new javax.xml.namespace.QName("http://beans.adaptive", "TcpOptions"), adaptive.beans.TcpOptions.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateNetworkGraph");
        oper.addParameter(new javax.xml.namespace.QName("", "resources"), new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "operation"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.adaptive", "NetworkGraph"));
        oper.setReturnClass(adaptive.beans.NetworkGraph.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateNetworkGraphReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("estimateNetworkPath");
        oper.addParameter(new javax.xml.namespace.QName("", "from"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "to"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "operation"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "estimateNetworkPathReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getActiveSites");
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getActiveSitesReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("knownMetrics");
        oper.addParameter(new javax.xml.namespace.QName("", "hostName"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_MetricDescription"));
        oper.setReturnClass(adaptive.beans.MetricDescription[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "knownMetricsReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getQueues");
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_Queue"));
        oper.setReturnClass(adaptive.beans.Queue[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getQueuesReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getQueueInfo");
        oper.addParameter(new javax.xml.namespace.QName("", "queue"), new javax.xml.namespace.QName("http://beans.adaptive", "Queue"), adaptive.beans.Queue.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "jobSize"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.adaptive", "QueueInfo"));
        oper.setReturnClass(adaptive.beans.QueueInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getQueueInfoReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getQueueConf");
        oper.addParameter(new javax.xml.namespace.QName("", "queue"), new javax.xml.namespace.QName("http://beans.adaptive", "Queue"), adaptive.beans.Queue.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.adaptive", "QueueConf"));
        oper.setReturnClass(adaptive.beans.QueueConf.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getQueueConfReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getResourceUtilization");
        oper.addParameter(new javax.xml.namespace.QName("", "queue"), new javax.xml.namespace.QName("http://beans.adaptive", "Queue"), adaptive.beans.Queue.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.adaptive", "ResourceUtilization"));
        oper.setReturnClass(adaptive.beans.ResourceUtilization.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getResourceUtilizationReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[19] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLogs");
        oper.addParameter(new javax.xml.namespace.QName("", "service"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "component"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "origin"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "severity"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "startTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "endTime"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getLogsReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "fault"),
                      "nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException",
                      new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException"), 
                      true
                     ));
        _operations[20] = oper;

    }

    public AdaptiveSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AdaptiveSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AdaptiveSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://beans.adaptive", "ResourceUtilization");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.ResourceUtilization.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "Queue");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.Queue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_Queue");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.Queue[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "KeyValue");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.KeyValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "NetworkGraph");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.NetworkGraph.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "MetricDescription");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.MetricDescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "AdaptiveServiceException");
            cachedSerQNames.add(qName);
            cls = nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOfArrayOf_xsd_double");
            cachedSerQNames.add(qName);
            cls = double[][].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "QueueInfo");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.QueueInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOfArrayOfArrayOf_tns2_DoubleMeasurement");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.DoubleMeasurement[][][].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_MetricDescription");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.MetricDescription[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://fs0.das3.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_KeyValue");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.KeyValue[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_DoubleMeasurement");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.DoubleMeasurement[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "DoubleMeasurement");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.DoubleMeasurement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_double");
            cachedSerQNames.add(qName);
            cls = double[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_ResourceInfo");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.ResourceInfo[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_xsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://fs0.das3.cs.vu.nl:8765/axis/services/Adaptive", "ArrayOf_tns2_MetricOption");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.MetricOption[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "ResourceInfo");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.ResourceInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "TcpOptions");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.TcpOptions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "QueueConf");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.QueueConf.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "MetricOption");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.MetricOption.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.adaptive", "ApplicationInfo");
            cachedSerQNames.add(qName);
            cls = adaptive.beans.ApplicationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public java.lang.String getServiceDescription() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getServiceDescription"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
    }

    public java.util.HashMap getMetric(java.lang.String metric, java.util.HashMap parameters) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getMetric"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {metric, parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.util.HashMap) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.util.HashMap) org.apache.axis.utils.JavaUtils.convert(_resp, java.util.HashMap.class);
            }
        }
    }

    public adaptive.beans.DoubleMeasurement[] estimateNetworkMetric(java.lang.String srcHostName, java.lang.String destHostName, java.lang.String metric, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateNetworkMetric"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {srcHostName, destHostName, metric, operation, startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.DoubleMeasurement[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.DoubleMeasurement[]) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.DoubleMeasurement[].class);
            }
        }
    }

    public adaptive.beans.DoubleMeasurement[][][] estimateNetworkMetricMatrix(java.lang.String[] hostNames, java.lang.String metric, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateNetworkMetricMatrix"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostNames, metric, operation, startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.DoubleMeasurement[][][]) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.DoubleMeasurement[][][]) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.DoubleMeasurement[][][].class);
            }
        }
    }

    public adaptive.beans.ResourceInfo[] rankResources(adaptive.beans.ResourceInfo[] resources, adaptive.beans.ApplicationInfo app) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "rankResources"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {resources, app});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.ResourceInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.ResourceInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.ResourceInfo[].class);
            }
        }
    }

    public adaptive.beans.TcpOptions estimateTcpOptions(java.lang.String src, java.lang.String dest, long dataSize, java.lang.String transferMethod, int maxTcpStreams, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateTcpOptions"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {src, dest, new java.lang.Long(dataSize), transferMethod, new java.lang.Integer(maxTcpStreams), startTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.TcpOptions) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.TcpOptions) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.TcpOptions.class);
            }
        }
    }

    public double[] estimateTransferTimeOneToMany(boolean substractLoggedTraffic, java.lang.String sourceResource, java.lang.String[] destinationResources, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateTransferTimeOneToMany"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(substractLoggedTraffic), sourceResource, destinationResources, new java.lang.Long(dataSize), transferMethod, startTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (double[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (double[]) org.apache.axis.utils.JavaUtils.convert(_resp, double[].class);
            }
        }
    }

    public double[] getReplicaTransferTime(boolean substractLoggedTraffic, java.lang.String[] sourceURIs, java.lang.String destinationURI, long dataSize, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getReplicaTransferTime"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(substractLoggedTraffic), sourceURIs, destinationURI, new java.lang.Long(dataSize), startTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (double[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (double[]) org.apache.axis.utils.JavaUtils.convert(_resp, double[].class);
            }
        }
    }

    public double[] estimateTransferTimeManyToOne(boolean substractLoggedTraffic, java.lang.String[] sourceResources, java.lang.String destinationResource, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateTransferTimeManyToOne"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(substractLoggedTraffic), sourceResources, destinationResource, new java.lang.Long(dataSize), transferMethod, startTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (double[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (double[]) org.apache.axis.utils.JavaUtils.convert(_resp, double[].class);
            }
        }
    }

    public double estimateTransferTime(boolean substractLoggedTraffic, java.lang.String src, java.lang.String dest, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateTransferTime"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(substractLoggedTraffic), src, dest, new java.lang.Long(dataSize), transferMethod, startTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Double) _resp).doubleValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Double) org.apache.axis.utils.JavaUtils.convert(_resp, double.class)).doubleValue();
            }
        }
    }

    public double[][] estimateTransferTimeManyToMany(boolean substractLoggedTraffic, java.lang.String[] sourceResources, java.lang.String[] destinationResources, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateTransferTimeManyToMany"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Boolean(substractLoggedTraffic), sourceResources, destinationResources, new java.lang.Long(dataSize), transferMethod, startTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (double[][]) _resp;
            } catch (java.lang.Exception _exception) {
                return (double[][]) org.apache.axis.utils.JavaUtils.convert(_resp, double[][].class);
            }
        }
    }

    public void logDataTransfer(java.lang.String source, java.lang.String destination, long dataSize, java.lang.String transferMethod, adaptive.beans.TcpOptions options, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "logDataTransfer"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {source, destination, new java.lang.Long(dataSize), transferMethod, options, startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public adaptive.beans.NetworkGraph estimateNetworkGraph(java.lang.String[] resources, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateNetworkGraph"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {resources, operation, startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.NetworkGraph) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.NetworkGraph) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.NetworkGraph.class);
            }
        }
    }

    public java.lang.String[] estimateNetworkPath(java.lang.String from, java.lang.String to, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "estimateNetworkPath"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {from, to, operation, startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
    }

    public java.lang.String[] getActiveSites() throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getActiveSites"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
    }

    public adaptive.beans.MetricDescription[] knownMetrics(java.lang.String hostName) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "knownMetrics"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.MetricDescription[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.MetricDescription[]) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.MetricDescription[].class);
            }
        }
    }

    public adaptive.beans.Queue[] getQueues() throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getQueues"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.Queue[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.Queue[]) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.Queue[].class);
            }
        }
    }

    public adaptive.beans.QueueInfo getQueueInfo(adaptive.beans.Queue queue, int jobSize, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getQueueInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queue, new java.lang.Integer(jobSize), startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.QueueInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.QueueInfo) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.QueueInfo.class);
            }
        }
    }

    public adaptive.beans.QueueConf getQueueConf(adaptive.beans.Queue queue) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getQueueConf"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queue});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.QueueConf) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.QueueConf) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.QueueConf.class);
            }
        }
    }

    public adaptive.beans.ResourceUtilization getResourceUtilization(adaptive.beans.Queue queue, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getResourceUtilization"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {queue, startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (adaptive.beans.ResourceUtilization) _resp;
            } catch (java.lang.Exception _exception) {
                return (adaptive.beans.ResourceUtilization) org.apache.axis.utils.JavaUtils.convert(_resp, adaptive.beans.ResourceUtilization.class);
            }
        }
    }

    public java.lang.String[] getLogs(java.lang.String service, java.lang.String component, java.lang.String origin, int severity, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://fs0.das2.cs.vu.nl:8765/axis/services/Adaptive", "getLogs"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {service, component, origin, new java.lang.Integer(severity), startTime, endTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
    }

}
