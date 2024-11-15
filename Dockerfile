# Etapa 1: Build
FROM openjdk:17-jdk-slim AS builder

# Instalar o Maven manualmente
RUN apt-get update && \
    apt-get install -y maven

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o código-fonte
COPY src ./src

# Compilar o projeto
RUN mvn clean package

# Etapa 2: Rodar a aplicação
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar o .jar gerado da etapa de build
COPY --from=builder /app/target/house-of-books-0.0.1-SNAPSHOT.jar /app/house-of-books.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/house-of-books.jar"]
