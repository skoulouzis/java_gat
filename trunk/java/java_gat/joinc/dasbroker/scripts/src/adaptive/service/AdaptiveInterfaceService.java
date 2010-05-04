/**
 * AdaptiveInterfaceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package adaptive.service;

public interface AdaptiveInterfaceService extends javax.xml.rpc.Service {
    public java.lang.String getAdaptiveAddress();

    public adaptive.service.AdaptiveInterface getAdaptive() throws javax.xml.rpc.ServiceException;

    public adaptive.service.AdaptiveInterface getAdaptive(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
