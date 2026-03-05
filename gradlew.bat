@echo off
setlocal
set DIRNAME=%~dp0
set GRADLE_HOME=%DIRNAME%gradle
set CLASSPATH=%GRADLE_HOME%\wrapper\gradle-wrapper.jar

java -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
