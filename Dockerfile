FROM openjdk

COPY . /usr/src/ide

WORKDIR /usr/src/ide

CMD ["java", "-jar", "dist/ProyectoMP.jar"]