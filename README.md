# 🧪 Phase 2 - Run without Dockerfile

This document is part of the containerization process for the **Microservices.Docker.Products.Service** in .NET 9. In this first phase, we explore how to run the service without creating a custom Dockerfile, using the official .NET runtime images.

---

## 🎯 Goal

- Run the service directly from a container using the official .NET image.
- Mount the local project directory into the container.
- Manipulate files inside the container volume.
- Validate that the service is working properly by accessing endpoints from the host.

---

## 🔧 Steps


### 1. Dockerizar My Sql

```bash
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0 dotnet
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0 dotnet --info
```


server:
   port: 9090
spring:
  application:
    name: ms-negocio-gestion-usuarios

  datasource: 
    url: jdbc:mysql://localhost:3310/db_ms_usuarios?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
    username: userdev
    password: Test@123
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa: 
    hibernate: 
      ddl-auto: create
    show-sql: true
---

### 1. Dockerizar microservicio spring

```bash
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0 dotnet
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0 dotnet --info
```

---


### 1. Test the official .NET 9 runtime image

```bash
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0 dotnet
docker run --rm -it mcr.microsoft.com/dotnet/runtime:9.0 dotnet --info
```

---

### 2. Mount a volume and manipulate a file

You can mount your current folder as a volume and test file access inside the container.

```bash
docker run --rm -it -v ${PWD}:/app mcr.microsoft.com/dotnet/runtime:9.0
```

Inside the container:

```bash
cd /app
echo HELLO > hello.txt
cat hello.txt
rm hello.txt
exit
```

This confirms that the volume is mounted correctly and files are accessible from within the container.

---

### 3. Run the API from a mounted volume

```bash
# Navigate to the root directory of the project:
cd Microservices.Docker.Products.Service

# Publish the project (Release mode)
dotnet publish -c Release

# Run from container with volume mounted
docker run --rm -it --name products.service -v ${PWD}:/app mcr.microsoft.com/dotnet/aspnet:9.0
```

Inside the container:
```bash
cd /app
dotnet ./bin/Release/net9.0/publish/Microservices.Docker.Products.Service.dll
```

#### 🧪 Test from another terminal

In a new terminal window, run:

```bash
docker exec -it products.service /bin/bash
```

Inside the container:

```bash
apt update && apt install -y curl jq
curl -s http://localhost:8080/products | jq
exit
```

---

### 4. Expose the service to the host for external access

```bash
docker run --rm -it --name products.service -v ${PWD}:/app -p 8085:8080 mcr.microsoft.com/dotnet/aspnet:9.0
```

Inside the container:

```bash
cd /app
export ASPNETCORE_URLS=http://+:8080
dotnet ./bin/Release/net9.0/publish/Microservices.Docker.Products.Service.dll
```

Open your browser and visit:

```
http://localhost:8085/products
http://localhost:8085/scalar/v1
```

---

### 5. Validate running container

In another terminal, you can check if the container is running by name:

```bash
docker ps
```

To inspect the container and review important details like:
- Mounted volumes
- Port mappings
- Environment variables
- Entry point and command

Use:

```bash
docker inspect products.service
```

#### 🔍 Filter specific details

Mounted volumes:
```bash
docker inspect products.service --format '{{ json .Mounts }}' | jq
```

Port mappings:
```bash
docker inspect products.service --format '{{ json .NetworkSettings.Ports }}' | jq
```

Environment variables:
```bash
docker inspect products.service --format '{{ json .Config.Env }}' | jq
```

Entrypoint and command:
```bash
docker inspect products.service --format '{{ .Config.Entrypoint }} {{ .Config.Cmd }}'
```

---

## 📦 Appendix: Install `jq` on Windows

If you're using Windows and do not have `jq` installed, you can install it using the following methods:

### ▶️ Option 1: Using Chocolatey

```bash
choco install jq
```

> Requires having [Chocolatey](https://chocolatey.org/install) installed.

### ▶️ Option 2: Manual installation

1. Download the Windows binary from:
   https://stedolan.github.io/jq/download/

2. Extract it and rename the binary to `jq.exe`.
3. Move it to a folder included in your system `PATH`.

You can test if it's available by running:

```bash
jq --version
```

---

## ✅ Expected result

The product service should run inside a container based on the .NET 9 runtime image without the need to build a custom image. You should be able to access the endpoints via browser or curl to verify functionality before moving to formal containerization using a Dockerfile.

---
