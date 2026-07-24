# Usa una imagen base oficial con JDK 17 (Temurin - recomendada por Adoptium)
# Contiene el runtime necesario para ejecutar aplicaciones Java
FROM eclipse-temurin:17-jdk

# Metadatos del contenedor (no afectan ejecución, pero útiles para trazabilidad)
LABEL name="ms gestion productos"
LABEL version="1.0"
LABEL description="Microservicio de gestion de productos"

# Define un volumen temporal dentro del contenedor
# Spring Boot usa /tmp para archivos temporales (ej: Tomcat, uploads, logs temporales)
# Permite desacoplar almacenamiento temporal del contenedor
VOLUME /tmp

# Copia el JAR generado por Gradle desde tu máquina local al contenedor
# Origen: carpeta build/libs (resultado de "gradlew build")
# Destino: archivo app.jar dentro del contenedor
COPY build/libs/ms-negocio-gestion-productos*.jar ms-negocio-gestion-productos.jar

# Expone el puerto 8080 (solo informativo)
# Indica que la aplicación Spring Boot escuchará en ese puerto
# No publica el puerto, eso se hace en docker run o docker-compose
EXPOSE 8191

# Comando que se ejecuta al iniciar el contenedor
# Ejecuta el JAR usando la JVM
# Forma "exec" (array JSON) → mejor manejo de señales y procesos
ENTRYPOINT ["java","-jar","/ms-negocio-gestion-productos.jar"]