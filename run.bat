@echo off
cd /d %~dp0
javac -cp ".;lib/json-simple-1.1.1.java.jar" src\*.java 2>nul
if %errorlevel% neq 0 pause & exit /b
java -cp ".;lib/json-simple-1.1.1.java.jar;src" QuizGame
pause
