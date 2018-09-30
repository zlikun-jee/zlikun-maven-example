#!/bin/bash

# resolve links - $0 may be a softlink
PRG="$0"

while [ -h "$PRG" ]; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done

# bin home
PRG_DIR=`dirname "$PRG"`

# app home
[ -z "$APP_HOME" ] && APP_HOME=`cd "$PRG_DIR/.." >/dev/null; pwd`

# java opts
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError"

# classpath
APP_CLASSPATH=${APP_HOME}/conf
for j in ${APP_HOME}/lib/*.jar; do
    APP_CLASSPATH=${APP_CLASSPATH}:${j}
done
echo "APP_CLASSPATH => $APP_CLASSPATH"

# start
echo "start application ..."
java ${JAVA_OPTS} -classpath ${APP_CLASSPATH} com.zlikun.jee.Main