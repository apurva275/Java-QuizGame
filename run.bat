@echo off
cd /d %~dp0
javac -cp ".;lib/json-simple-1.1.jar" src\*.java
if %errorlevel% neq 0 pause & exit /b
java -cp ".;lib/json-simple-1.1.jar;src" QuizGame
pause
