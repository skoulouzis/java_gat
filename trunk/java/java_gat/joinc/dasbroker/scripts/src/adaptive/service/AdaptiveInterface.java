/**
 * AdaptiveInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package adaptive.service;

public interface AdaptiveInterface extends java.rmi.Remote {
    public java.lang.String getServiceDescription() throws java.rmi.RemoteException;
    public java.util.HashMap getMetric(java.lang.String metric, java.util.HashMap parameters) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.DoubleMeasurement[] estimateNetworkMetric(java.lang.String srcHostName, java.lang.String destHostName, java.lang.String metric, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.DoubleMeasurement[][][] estimateNetworkMetricMatrix(java.lang.String[] hostNames, java.lang.String metric, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.ResourceInfo[] rankResources(adaptive.beans.ResourceInfo[] resources, adaptive.beans.ApplicationInfo app) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.TcpOptions estimateTcpOptions(java.lang.String src, java.lang.String dest, long dataSize, java.lang.String transferMethod, int maxTcpStreams, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public double[] estimateTransferTimeOneToMany(boolean substractLoggedTraffic, java.lang.String sourceResource, java.lang.String[] destinationResources, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public double[] getReplicaTransferTime(boolean substractLoggedTraffic, java.lang.String[] sourceURIs, java.lang.String destinationURI, long dataSize, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public double[] estimateTransferTimeManyToOne(boolean substractLoggedTraffic, java.lang.String[] sourceResources, java.lang.String destinationResource, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public double estimateTransferTime(boolean substractLoggedTraffic, java.lang.String src, java.lang.String dest, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public double[][] estimateTransferTimeManyToMany(boolean substractLoggedTraffic, java.lang.String[] sourceResources, java.lang.String[] destinationResources, long dataSize, java.lang.String transferMethod, java.util.Calendar startTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public void logDataTransfer(java.lang.String source, java.lang.String destination, long dataSize, java.lang.String transferMethod, adaptive.beans.TcpOptions options, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException;
    public adaptive.beans.NetworkGraph estimateNetworkGraph(java.lang.String[] resources, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public java.lang.String[] estimateNetworkPath(java.lang.String from, java.lang.String to, java.lang.String operation, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public java.lang.String[] getActiveSites() throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.MetricDescription[] knownMetrics(java.lang.String hostName) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.Queue[] getQueues() throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.QueueInfo getQueueInfo(adaptive.beans.Queue queue, int jobSize, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.QueueConf getQueueConf(adaptive.beans.Queue queue) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public adaptive.beans.ResourceUtilization getResourceUtilization(adaptive.beans.Queue queue, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
    public java.lang.String[] getLogs(java.lang.String service, java.lang.String component, java.lang.String origin, int severity, java.util.Calendar startTime, java.util.Calendar endTime) throws java.rmi.RemoteException, nl.vu.cs.das2.fs0.axis.services.Adaptive.AdaptiveServiceException;
}
