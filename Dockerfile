# Usar a imagem oficial do OpenJDK como base
FROM openjdk:17-jdk-slim

# Diretório de trabalho na imagem
WORKDIR /app

# Copiar o arquivo JAR gerado pela aplicação para a imagem
COPY target/cadastro-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pela aplicação
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
