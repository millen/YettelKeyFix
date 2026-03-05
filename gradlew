#!/usr/bin/env sh
##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

if [ -z "$JAVA_HOME" ]; then
  JAVACMD="java"
else
  JAVACMD="$JAVA_HOME/bin/java"
fi

DIRNAME="$(cd "$(dirname "$0")" && pwd)"
GRADLE_HOME="$DIRNAME/gradle"

CLASSPATH="$GRADLE_HOME/wrapper/gradle-wrapper.jar"
DEFAULT_JVM_OPTS=""

exec "$JAVACMD" $DEFAULT_JVM_OPTS -cp "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
