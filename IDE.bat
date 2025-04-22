@echo off
echo Iniciando la aplicación Java con los parámetros necesarios...
java --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED -jar ProyectoMP.jar
pause
