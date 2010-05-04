#!/bin/sh




scp  -r /media/disk/workspace/dasbroker fs0.das3.cs.vu.nl:/home/skoulouz/Joinc/

ssh -X fs0.das3.cs.vu.nl "ant -f /home/skoulouz/Joinc/dasbroker/build.xml clean"
ssh -X fs0.das3.cs.vu.nl "ant -f /home/skoulouz/Joinc/dasbroker/build.xml build"

ssh -X fs0.das3.cs.vu.nl "mv /home/skoulouz/Joinc/dasbroker/jar/DASResourceBrokerAdaptor.jar /home/skoulouz/Joinc/DasBroker"

