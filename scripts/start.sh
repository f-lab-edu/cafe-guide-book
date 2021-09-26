#!/bin/bash

LOG_PATH=/home/ec2-user/cafeguidebook/deploy.log

JAR_NAME=$(ls /home/ec2-user/cafeguidebook/*jar)

CURRENT_PID=$(pgrep -f $JAR_NAME)

echo "> 현재 실행중인 애플리케이션 pid 확인" > $LOG_PATH
CURRENT_PID=$(pgrep -f $JAR_NAME)

if [ -z $CURRENT_PID ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다." >> $LOG_PATH
else
    sudo kill -15 $CURRENT_PID
    sleep 5
fi


nohup $JAVA_HOME/bin/java -jar $JAR_NAME --spring.profiles.active=release > /dev/null 2>&1 &
