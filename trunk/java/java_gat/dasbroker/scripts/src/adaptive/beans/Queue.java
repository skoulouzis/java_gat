/**
 * Queue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package adaptive.beans;

public class Queue  implements java.io.Serializable {
    private java.lang.String hostname;
    private java.lang.String jobmanager;
    private java.lang.String queueName;

    public Queue() {
    }

    public java.lang.String getHostname() {
        return hostname;
    }

    public void setHostname(java.lang.String hostname) {
        this.hostname = hostname;
    }

    public java.lang.String getJobmanager() {
        return jobmanager;
    }

    public void setJobmanager(java.lang.String jobmanager) {
        this.jobmanager = jobmanager;
    }

    public java.lang.String getQueueName() {
        return queueName;
    }

    public void setQueueName(java.lang.String queueName) {
        this.queueName = queueName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Queue)) return false;
        Queue other = (Queue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hostname==null && other.getHostname()==null) || 
             (this.hostname!=null &&
              this.hostname.equals(other.getHostname()))) &&
            ((this.jobmanager==null && other.getJobmanager()==null) || 
             (this.jobmanager!=null &&
              this.jobmanager.equals(other.getJobmanager()))) &&
            ((this.queueName==null && other.getQueueName()==null) || 
             (this.queueName!=null &&
              this.queueName.equals(other.getQueueName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHostname() != null) {
            _hashCode += getHostname().hashCode();
        }
        if (getJobmanager() != null) {
            _hashCode += getJobmanager().hashCode();
        }
        if (getQueueName() != null) {
            _hashCode += getQueueName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Queue.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://beans.adaptive", "Queue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobmanager");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobmanager"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queueName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "queueName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
