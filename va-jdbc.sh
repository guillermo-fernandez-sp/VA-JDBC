#!/bin/bash

IP=192.168.188.33
PORT=3306
USER=sailpoint
PASS=S@ilp0int
JAR_PATH=/home/sailpoint
JAR_NAME=va-jdbc.jar

tb java -jar "$JAR_PATH"/"$JAR_NAME" $IP $PORT $USER $PASS
