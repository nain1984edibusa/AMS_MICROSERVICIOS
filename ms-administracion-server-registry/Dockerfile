# Usa una imagen base oficial con JDK 17 (Temurin - recomendada por Adoptium)
# Contiene el runtime necesario para ejecutar aplicaciones Java
FROM eclipse-temurin:17-jdk

# Metadatos del contenedor (no afectan ejecución, pero útiles para trazabilidad)
LABEL name="MS Gestión Usuarios"
LABEL version="1.0"
LABEL description="Microservicio de server registry"

VOLUME /tmp

COPY build/libs/ms-administracion-server-registry*.jar ms-administracion-server-registry.jar

EXPOSE 8889

ENTRYPOINT ["java","-jar","/ms-administracion-server-registry.jar"]