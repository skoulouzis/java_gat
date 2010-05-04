#!/bin/sh


USER=`id -un`
ME=skoulouz

JAR=/media/disk/workspace/Joinc0.0.3/dist/Joinc0.0.3.jar

if [ $USER == $ME ]
then
    scp  $JAR fs0.das3.cs.vu.nl:/home/skoulouz/Joinc/dist
else
	scp $JAR skoulouz@sremote.science.uva.nl:/home/skoulouz/workspace/Joinc/dist
	ssh skoulouz@sremote.science.uva.nl 'scp /home/skoulouz/workspace//Joinc/dist/Joinc0.0.3.jar fs0.das3.cs.vu.nl:/home/skoulouz/Joinc/dist'
fi