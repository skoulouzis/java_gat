/**
 * QueueInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package adaptive.beans;

public class QueueInfo  implements java.io.Serializable {
    private float avgJobWaitingTime;
    private float avgWaitingJobs;
    private float sdJobWaitingTime;

    public QueueInfo() {
    }

    public float getAvgJobWaitingTime() {
        return avgJobWaitingTime;
    }

    public void setAvgJobWaitingTime(float avgJobWaitingTime) {
        this.avgJobWaitingTime = avgJobWaitingTime;
    }

    public float getAvgWaitingJobs() {
        return avgWaitingJobs;
    }

    public void setAvgWaitingJobs(float avgWaitingJobs) {
        this.avgWaitingJobs = avgWaitingJobs;
    }

    public float getSdJobWaitingTime() {
        return sdJobWaitingTime;
    }

    public void setSdJobWaitingTime(float sdJobWaitingTime) {
        this.sdJobWaitingTime = sdJobWaitingTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueueInfo)) return false;
        QueueInfo other = (QueueInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.avgJobWaitingTime == other.getAvgJobWaitingTime() &&
            this.avgWaitingJobs == other.getAvgWaitingJobs() &&
            this.sdJobWaitingTime == other.getSdJobWaitingTime();
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
        _hashCode += new Float(getAvgJobWaitingTime()).hashCode();
        _hashCode += new Float(getAvgWaitingJobs()).hashCode();
        _hashCode += new Float(getSdJobWaitingTime()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueueInfo.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://beans.adaptive", "QueueInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avgJobWaitingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avgJobWaitingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avgWaitingJobs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avgWaitingJobs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sdJobWaitingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sdJobWaitingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
