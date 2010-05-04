#!/bin/sh

USER=`id -un`
ME="skoulouz"

JAR=/media/disk/workspace/dasbroker/jar/DASResourceBrokerAdaptor.jar

if [  $USER == $ME ]
then
	echo $USER "==" $ME
	scp $JAR fs0.das3.cs.vu.nl:/home/skoulouz/Joinc/DasBroker
else
	echo $USER "!=" $ME 
	scp  $JAR skoulouz@sremote.science.uva.nl:/home/skoulouz/workspace/Joinc
	ssh skoulouz@sremote.science.uva.nl 'scp /home/skoulouz/workspace/Joinc/DASResourceBrokerAdaptor.jar fs0.das3.cs.vu.nl:/home/skoulouz/Joinc/DasBroker'
fi
