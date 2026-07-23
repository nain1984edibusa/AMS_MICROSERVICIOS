# AMS Microservicios — Agent Guide

# AMS_MICROSERVICIOS

## Objetivo

Sistema desarrollado bajo arquitectura de microservicios utilizando Spring Boot y Spring Cloud.

Cada microservicio representa un contexto de negocio independiente y debe ser desplegable de forma autónoma.

## Stack Tecnológico

- Java 21
- Spring Boot
- Spring Cloud
- Gradle
- Docker
- SQL Server
- Eureka Server
- Spring Cloud Gateway
- Config Server
- Spring Security (si aplica)
- OpenFeign / WebClient
- Actuator

## Architecture

6 independent Gradle projects (no root build). Java 17, Spring Boot.

| Service | Boot | Cloud | Port | DB | Config source |
|---|---|---|---|---|---|
| `ms-administracion-server-config` | 3.2.3 | 2023.0.0 | 8888 | — | native `classpath:/config` |
| `ms-administracion-server-registry` | 3.2.3 | 2023.0.0 | 8889 | — | Config Server @ `localhost:8888` |
| `ms-negocio-gestion-usuarios` | 3.2.2 | — | 8093 | MySQL :3310 | local `application.yml` |
| `ms-negocio-gestion-clientes` | 3.5.16 | 2025.0.2 | 8190 | MySQL :3308 | Config Server |
| `ms-negocio-gestion-productos` | 3.5.16 | 2025.0.2 | 8191 | MySQL :3309 | Config Server |
| `ms-negocio-gestion-pedidos` | 3.5.16 | 2025.0.2 | 8193 | SQL Server :1433 | Config Server |

## Startup order

1. MySQL + SQL Server containers (docker compose)
2. `server-config` (port 8888)
3. `eureka-server` (port 8889) — standalone, `register-with-eureka: false`
4. Business microservices

## Commands

```bash
# Build & run a single service (each has its own gradlew)
./gradlew bootRun

# Full local infra (DBs + config + registry + all services)
docker compose up -d

# Each service can also be built into a Docker image:
docker compose build <service>
```

## Key quirks

- **No root aggregate build** — each module is independent. Run `gradlew` per project directory.
- **Central config** lives inside `ms-administracion-server-config/src/main/resources/config/`. The `config-repo/` directory at root is **empty** (not used).
- Each module has its own `settings.gradle` + `gradlew` wrapper.
- The README.md is stale (mentions .NET 9 / Docker experiments, not the actual Spring Boot code).
- `ms-negocio-gestion-pedidos` has **no Dockerfile**.
- DB credentials in config (userdev/Test@123, sa/P@ssword1234) are dev-only hardcoded values.
- All config YMLs contain commented-out Docker-network alternatives (hostnames like `mysql_clientes_dev`, `eureka-server`). Uncomment those for Docker mode.
- Central config files for `api-gateway`, `server-admin`, `autenticacion-jwt`, `parametrizacion` listed in port reference (`lista de microservicios y puertos.txt`) but **not present** in this repo.
- `hibernate.ddl-auto: create` on clientes & productos (drops tables on restart). Pedidos uses `ddl-auto: none`.

## Code style

- Lombok (`@Data`, `@Builder`, `@Slf4j`) used throughout
- Package conventions: `com.ebustillos.ms.negocio.gestion<dominio>` (business) / `com.ebustillos.ms.administracion.server<funcion>` (infra)
- Tests use JUnit 5 Platform (`useJUnitPlatform()` in Gradle)
